package com.douzone.bookmall.vo; // ok

public class UserVo { // 고객
	private Long no; // 번호
	private String name; // 이름
	private String phone_no; // 전화번호
	private String email; // 이메일 
	private String pw; // 비밀번호 
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
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", name=" + name + ", phone_no=" + phone_no + ", email=" + email + ", pw=" + pw
				+ "]";
	}
}
