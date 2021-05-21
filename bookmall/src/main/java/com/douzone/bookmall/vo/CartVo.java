package com.douzone.bookmall.vo; // ok

public class CartVo { // 카트
	private Long no; // 번호
	private String name; // 서적 제목
	private Long price; // 가격
	private Long quantity; // 수량
	private Long user_no; // 유저 번호
	private Long book_no; // 서적 번호
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
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getUser_no() {
		return user_no;
	}
	public void setUser_no(Long user_no) {
		this.user_no = user_no;
	}
	public Long getBook_no() {
		return book_no;
	}
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}
	@Override
	public String toString() {
		return "CartVo [no=" + no + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", user_no="
				+ user_no + ", book_no=" + book_no + "]";
	}

}
