package com.douzone.bookmall.vo; // ok

public class CategoryVo { // 카테고리
	private Long no; // 번호
	private String name; // 이름
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", name=" + name + "]";
	}
}
