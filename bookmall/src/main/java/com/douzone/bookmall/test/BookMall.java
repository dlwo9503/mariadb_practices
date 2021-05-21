package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.BookDao;
import com.douzone.bookmall.dao.CartDao;
import com.douzone.bookmall.dao.CategoryDao;
import com.douzone.bookmall.dao.Order_bookDao;
import com.douzone.bookmall.dao.OrdersDao;
import com.douzone.bookmall.dao.UserDao;
import com.douzone.bookmall.vo.BookVo;
import com.douzone.bookmall.vo.CartVo;
import com.douzone.bookmall.vo.CategoryVo;
import com.douzone.bookmall.vo.Order_bookVo;
import com.douzone.bookmall.vo.OrdersVo;
import com.douzone.bookmall.vo.UserVo;

public class BookMall {

	public static void main(String[] args) {
		
		CategoryVo vo2 = null; // 카테고리
		
		vo2 = new CategoryVo();
		vo2.setName("소설");
		new CategoryDao().insert(vo2);
		
		vo2 = new CategoryVo();
		vo2.setName("수필");
		new CategoryDao().insert(vo2);
		
		vo2 = new CategoryVo();
		vo2.setName("컴퓨터/IT");
		new CategoryDao().insert(vo2);
		
		BookVo vo3 = null; // 서적
		
		vo3 = new BookVo();
		vo3.setTitle("트와일라잇");
		vo3.setPrice(20000L);
		vo3.setCategory_no(1L);
		new BookDao().insert(vo3);
		
		vo3 = new BookVo();
		vo3.setTitle("이것이 자바다");
		vo3.setPrice(25000L);
		vo3.setCategory_no(2L);
		new BookDao().insert(vo3);
		
		vo3 = new BookVo();
		vo3.setTitle("자바스크립트 완벽 가이드");
		vo3.setPrice(50000L);
		vo3.setCategory_no(2L);
		new BookDao().insert(vo3);
		
		UserVo vo1 = null; // 유저
		
		vo1 = new UserVo();
		vo1.setName("이재성");
		vo1.setPhone_no("010-1111-1111");
		vo1.setEmail("dlwo9503@naver.com");
		vo1.setPw("1111");
		new UserDao().insert(vo1);
		
		vo1 = new UserVo();
		vo1.setName("김재성");
		vo1.setPhone_no("010-2222-2222");
		vo1.setEmail("wotjd6816@naver.com");
		vo1.setPw("2222");
		new UserDao().insert(vo1);
		
		CartVo vo4 = null; // 카트
		
		vo4 = new CartVo();
		vo4.setName("트와일라잇");
		vo4.setPrice(20000L);
		vo4.setQuantity(2L);
		vo4.setUser_no(1L);
		vo4.setBook_no(1L);
		new CartDao().insert(vo4);
		
		vo4 = new CartVo();
		vo4.setName("자바스크립트 완벽 가이드");
		vo4.setPrice(50000L);
		vo4.setQuantity(3L);
		vo4.setUser_no(1L);
		vo4.setBook_no(3L);
		new CartDao().insert(vo4);
		
		OrdersVo vo5 = null;
		
		vo5 = new OrdersVo();
		vo5.setOrder_no("123");
		vo5.setPayment_amount(100000L);
		vo5.setAddress("해운대구");
		vo5.setUser_no(1L);
		new OrdersDao().insert(vo5);
		
		Order_bookVo vo6 = null;
		
		vo6 = new Order_bookVo();
		vo6.setQuantity(2L);
		vo6.setPrice(20000L);
		vo6.setBook_no(1L);
		vo6.setOrder_no(1L);
		new Order_bookDao().insert(vo6);
		
		vo6 = new Order_bookVo();
		vo6.setQuantity(3L);
		vo6.setPrice(50000L);
		vo6.setBook_no(3L);
		vo6.setOrder_no(1L);
		new Order_bookDao().insert(vo6);
		
		System.out.println("========= 회원 =========");
		List<UserVo> list = new UserDao().findAll();
		for(UserVo vo : list) {
			System.out.println("번호 : " + vo.getNo() + " 이름 : " + vo.getName() + " 전화번호 : " + vo.getPhone_no()
			 + " 이메일 : " + vo.getEmail() + " 비밀번호 : " + vo.getPw());
		}
		
		System.out.println("========= 카테고리 =========");
		List<CategoryVo> list2 = new CategoryDao().findAll();
		for(CategoryVo vo : list2) {
			System.out.println("카테고리 번호 : " + vo.getNo() + " 이름 : " + vo.getName());
		}
		
		System.out.println("========= 상품 리스트 =========");
		List<BookVo> list3 = new BookDao().findAll();
		for(BookVo vo : list3) {
			System.out.println("도서 번호 : " + vo.getNo() + " 제목 : " + vo.getTitle() + " 가격 : " + vo.getPrice()
			 + " 카테고리 번호 : " + vo.getCategory_no());
		}
		
		System.out.println("========= 카트 리스트 =========");
		List<CartVo> list4 = new CartDao().findAll();
		for(CartVo vo : list4) {
			System.out.println(" 제목 : " + vo.getName()
			+ " 가격 : " + vo.getPrice() + " 수량 : " + vo.getQuantity()); 
		}
		
		System.out.println("========= 주문 리스트 =========");
		List<OrdersVo> list5 = new OrdersDao().findAll();
		for(OrdersVo vo : list5) {
			System.out.println("번호 : " + vo.getNo() + " 주문 : " + vo.getOrder_no()
			+ " 결제 금액 : " + vo.getPayment_amount() + " 배송지 : " + vo.getAddress()
			 + " 배송지 : " + vo.getUser_no()); 
		}
		
		System.out.println("========= 주문도서 리스트 =========");
		List<Order_bookVo> list6 = new Order_bookDao().findAll();
		for(Order_bookVo vo : list6) {
			System.out.println("번호 : " + vo.getNo() + " 수량 : " + vo.getQuantity()
			+ " 가격 : " + vo.getPrice() + " 서적 번호 : " + vo.getBook_no()
			 + " 주문 번호 : " + vo.getOrder_no()); 
		}
	}
}
