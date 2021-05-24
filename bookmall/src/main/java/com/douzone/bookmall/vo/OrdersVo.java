package com.douzone.bookmall.vo; // ok

public class OrdersVo { // 주문
	private Long no; // 번호
	private String order_no; // 주문 번호
	private Long payment_amount; // 결제 금액
	private String address; // 배송지
	private Long user_no; // 고객 번호
	private String user_name; // 고객 이름
	private String user_email; // 고객 이메일

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

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	@Override
//	public String toString() {
//		return "OrdersVo [no=" + no + ", order_no=" + order_no + ", payment_amount=" + payment_amount + ", address="
//				+ address + ", user_no=" + user_no + ", user_name=" + user_name + ", user_email=" + user_email + "]";
//	}
	public String toString() {
		return "번호 : " + no + ", 주문번호 : " + order_no + ", 고객 이름 : " + user_name + ", 고객 이메일 : " + user_email
				+ ", 결제금액 : " + payment_amount + ", 배송지 : " + address;
	}
}
