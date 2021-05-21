package com.douzone.bookmall.vo; // ok

public class OrdersVo { // 주문
	private Long no; // 번호
	private String order_no; // 주문 번호
	private Long payment_amount; // 결제 금액
	private String address; // 배송지
	private Long user_no; // 고객 번호
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public Long getPayment_amount() {
		return payment_amount;
	}
	public void setPayment_amount(Long payment_amount) {
		this.payment_amount = payment_amount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getUser_no() {
		return user_no;
	}
	public void setUser_no(Long user_no) {
		this.user_no = user_no;
	}
	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", order_no=" + order_no + ", payment_amount=" + payment_amount + ", address="
				+ address + ", user_no=" + user_no + "]";
	}
}
