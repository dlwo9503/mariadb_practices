package com.douzone.bookmall.vo; // ok

public class Order_bookVo { // 주문 도서
	private Long no; // 번호
	private Long quantity; // 수량
	private Long price; // 가격
	private Long book_no; // 서적 번호
	private Long order_no; // 주문 번호
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
	@Override
	public String toString() {
		return "Order_bookVo [no=" + no + ", quantity=" + quantity + ", price=" + price + ", book_no=" + book_no
				+ ", order_no=" + order_no + "]";
	}
}
