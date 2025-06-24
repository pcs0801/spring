package com.kh.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kh.domain.Item;
import com.kh.service.ItemMapperService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@MapperScan(basePackages = "com.kh.mapper")
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemMapperService itemService;

	@Value("${upload.path}")
	private String uploadPath;

	@GetMapping("/list")
	public String list(Model model) throws Exception {
		List<Item> itemList = itemService.list();
		model.addAttribute("itemList", itemList);
		return "item/list";
	}

	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("item", new Item());
		return "item/register";
	}

	@PostMapping("/register")
	public String register(Item item, Model model) throws Exception {
		MultipartFile file = item.getPicture();
		String createdFileName = uploadFile(file.getOriginalFilename(), file.getBytes());
		item.setPictureUrl(createdFileName);
		itemService.create(item);
		model.addAttribute("msg", "등록이 완료되었습니다.");
		return "item/success";
	}

	@GetMapping("/modify")
	public String modifyForm(Item item, Model model) throws Exception {
		model.addAttribute("item", itemService.read(item));
		return "item/modify";
	}

	@PostMapping("/modify")
	public String modify(Item item, Model model) throws Exception {
		MultipartFile file = item.getPicture();
		
		if (file != null && file.getSize() > 0) {
			Item oldItem = itemService.read(item);
			String oldPictureUrl = oldItem.getPictureUrl();
			deleteFile(oldPictureUrl);
			
			log.info("originalName: " + file.getOriginalFilename());
			log.info("size: " + file.getSize());
			log.info("contentType: " + file.getContentType());
			String createdFileName = uploadFile(file.getOriginalFilename(), file.getBytes());
			item.setPictureUrl(createdFileName);
		}
		itemService.update(item);
		model.addAttribute("msg", "수정이 완료되었습니다.");
		return "item/success";
	}

	@GetMapping("/remove")
	public String removeForm(Item item, Model model) throws Exception {
		model.addAttribute("item", itemService.read(item));
		return "item/remove";
	}

	@PostMapping("/remove")
	public String remove(Item item, Model model) throws Exception {
		Item oldItem = itemService.read(item);
		String oldPictureUrl = oldItem.getPictureUrl();
		boolean flag = deleteFile(oldPictureUrl);
		
		if(flag == true) {
			itemService.delete(item);
			model.addAttribute("msg", "삭제가 완료되었습니다.");
		} else {
			model.addAttribute("msg", "외부저장소 삭제 문제 발생");
		}
		return "item/success";
	}

	private String uploadFile(String originalName, byte[] fileData) throws Exception {
		UUID uid = UUID.randomUUID();
		String createdFileName = uid.toString() + "_" + originalName;
		File target = new File(uploadPath, createdFileName);
		FileCopyUtils.copy(fileData, target);
		return createdFileName;
	}

	private boolean deleteFile(String fileName) throws Exception {
		if (fileName.contains("..")) {
			throw new IllegalArgumentException("잘못된 경로입니다.");
		}
		File file = new File(uploadPath, fileName);
		if (file.exists()) {
			return file.delete();
		} else {
			return false;
		}
	}

	@ResponseBody
	@GetMapping("/display")
	public ResponseEntity<byte[]> displayFile(Item item) throws Exception {
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		Item _item = itemService.getPicture(item);
		String fileName = _item.getPictureUrl();
		log.info("FILE NAME: " + fileName);
		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
			MediaType mType = getMediaType(formatName);
			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream(uploadPath + File.separator + fileName);
			if (mType != null) {
				headers.setContentType(mType);
			}
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}

	private MediaType getMediaType(String formatName) {
		if (formatName != null) {
			if (formatName.equals("JPG")) {
				return MediaType.IMAGE_JPEG;
			}
			if (formatName.equals("GIF")) {
				return MediaType.IMAGE_GIF;
			}
			if (formatName.equals("PNG")) {
				return MediaType.IMAGE_PNG;
			}
		}
		return null;
	}
}
