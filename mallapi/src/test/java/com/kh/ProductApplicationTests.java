package com.kh;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.kh.mallapi.MallapiApplication;
import com.kh.mallapi.domain.Product;
import com.kh.mallapi.dto.PageRequestDTO;
import com.kh.mallapi.dto.PageResponseDTO;
import com.kh.mallapi.dto.ProductDTO;
import com.kh.mallapi.repository.ProductRepository;
import com.kh.mallapi.service.ProductService;

import lombok.extern.log4j.Log4j2;

@SpringBootTest(classes = MallapiApplication.class)
@Log4j2
public class ProductApplicationTests {
	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductService productService;

	// @Test
	public void testInsert() {
		for (int i = 0; i < 10; i++) {
			Product product = Product.builder().pname("상품" + i).price(100 * i).pdesc("상품설명 " + i).build();
			product.addImageString(UUID.randomUUID().toString() + "-" + "IMAGE1.jpg");
			product.addImageString(UUID.randomUUID().toString() + "-" + "IMAGE2.jpg");
			productRepository.save(product);
			log.info(" ");
		}
	}

	// @Transactional
	// @Test
	public void testRead() {
		Long pno = 1L;
		Optional<Product> result = productRepository.findById(pno);
		Product product = result.orElseThrow();
		log.info(product);
		log.info(product.getImageList());
	}

	// @Test
	public void testRead2() {
		Long pno = 1L;
		Optional<Product> result = productRepository.selectOne(pno);
		Product product = result.orElseThrow();
		log.info(product);
		log.info(product.getImageList());
	}

	// @Transactional
	// @Commit
	// @Test
	public void testDelete() {
		Long pno = 2L;
		productRepository.updateToDelete(pno, true);

	}

	// @Test
	public void testUpdate() {
		Long pno = 10L;
		Product product = productRepository.selectOne(pno).get();
		product.changeName("10번 상품");
		product.changeDesc("10번 상품 설명입니다.");
		product.changePrice(5000);
		product.clearList();
		product.addImageString(UUID.randomUUID().toString() + "-" + "NEWIMAGE1.jpg");
		product.addImageString(UUID.randomUUID().toString() + "-" + "NEWIMAGE2.jpg");
		product.addImageString(UUID.randomUUID().toString() + "-" + "NEWIMAGE3.jpg");
		productRepository.save(product);
	}

	// @Test
	public void testList() {
		Pageable pageable = PageRequest.of(0, 10, Sort.by("pno").descending());
		Page<Object[]> result = productRepository.selectList(pageable);
		result.getContent().forEach(arr -> log.info(Arrays.toString(arr)));
	}

	// @Test
	public void testList2() {
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();
		PageResponseDTO<ProductDTO> result = productService.getList(pageRequestDTO);
		result.getDtoList().forEach(dto -> log.info(dto));
	}

	// @Test
	public void testRegister() {
		ProductDTO productDTO = ProductDTO.builder().pname("새로운 상품").pdesc("신규 추가 상품입니다.").price(1000).build();
		productDTO.setUploadFileNames(
				java.util.List.of(UUID.randomUUID() + "_" + "Test1.jpg", UUID.randomUUID() + "_" + "Test2.jpg"));
		productService.register(productDTO);
	}

	@Test
	public void testRead3() {
		Long pno = 152L;
		ProductDTO productDTO = productService.get(pno);
		log.info(productDTO);
		log.info(productDTO.getUploadFileNames());
	}
}