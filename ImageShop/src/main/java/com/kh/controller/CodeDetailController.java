package com.kh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.common.CodeLabelValue;
import com.kh.domain.CodeDetail;
import com.kh.service.CodeDetailService;
import com.kh.service.CodeService;

@Controller
@RequestMapping("/codedetail")
public class CodeDetailController {

	@Autowired
	private CodeDetailService codeDetailService;

	@Autowired
	private CodeService codeService;

	@GetMapping("/register")
	public void registerForm(Model model) throws Exception {
		CodeDetail codeDetail = new CodeDetail();
		model.addAttribute(codeDetail);
		List<CodeLabelValue> groupCodeList = codeService.getCodeGroupList();
		model.addAttribute("groupCodeList", groupCodeList);
	}

	@PostMapping("/register")
	public String register(CodeDetail codeDetail, RedirectAttributes rttr) throws Exception {
		codeDetailService.register(codeDetail);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/codedetail/list";
	}

	@GetMapping("/list")
	public void list(Model model) throws Exception {
		model.addAttribute("list", codeDetailService.list());
	}

	@GetMapping("/read")
	public void read(CodeDetail codeDetail, Model model) throws Exception {
		model.addAttribute(codeDetailService.read(codeDetail));
		// 그룹코드 목록을 조회하여 뷰에 전달
		List<CodeLabelValue> groupCodeList = codeService.getCodeGroupList();
		model.addAttribute("groupCodeList", groupCodeList);
	}

	@GetMapping("/modify")
	public void modifyForm(CodeDetail codeDetail, Model model) throws Exception {
		model.addAttribute(codeDetailService.read(codeDetail));
		List<CodeLabelValue> groupCodeList = codeService.getCodeGroupList();
		model.addAttribute("groupCodeList", groupCodeList);
	}

	@PostMapping("/modify")
	public String modify(CodeDetail codeDetail, RedirectAttributes rttr) throws Exception {
		codeDetailService.modify(codeDetail);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/codedetail/list";
	}

	@PostMapping("/remove")
	public String remove(CodeDetail codeDetail, RedirectAttributes rttr) throws Exception {
		codeDetailService.remove(codeDetail);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/codedetail/list";
	}
}