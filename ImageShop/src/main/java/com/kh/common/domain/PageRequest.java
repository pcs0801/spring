package com.kh.common.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageRequest {
	// 현재페이지
	private int page;
	// 한페이지당 사이즈
	private int sizePerPage;

	public PageRequest() {
		this.page = 1;
		this.sizePerPage = 10;
	}

	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}

	public void setSizePerPage(int size) {
		if (size <= 0 || size > 100) {
			this.sizePerPage = 10;
			return;
		}
		this.sizePerPage = size;
	}

	public int getPage() {
		return page;
	}

	// 마이바티스 SQL 매퍼를 위한 메서드
	public int getPageStart() {
		return (this.page - 1) * sizePerPage;
	}

	// 마이바티스 SQL 매퍼를 위한 메서드
	public int getSizePerPage() {
		return this.sizePerPage;
	}

	// 멤버 변수를 활용하여 다양한 형태의 쿼리파라미터를 생성한다.
	public String toUriString() {
		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", this.page)
				.queryParam("sizePerPage", this.sizePerPage).build();
		return uriComponents.toUriString();
	}
}