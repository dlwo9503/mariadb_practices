package com.douzone.bookmall.vo; // ok

public class Order_bookVo { // 주문 도서
	private Long no; // 번호
	private Long quantity; // 수량
	private Long price; // 가격
	private Long book_no; // 서적 번호
	private Long order_no; // 주문 번호
	private String book_name; // 서적 제목
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getBook_no() {
		return book_no;
	}
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}
	public Long getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Long order_no) {
		this.order_no = order_no;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	@Override
	public String toString() {
		return "번호 : " + no + ", 도서번호 : " + book_no + ", 도서제목 : " + book_name + ", 수량 : " + quantity;
	}
}
