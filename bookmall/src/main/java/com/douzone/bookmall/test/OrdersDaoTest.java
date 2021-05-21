package com.douzone.bookmall.test;

import com.douzone.bookmall.dao.OrdersDao;
import com.douzone.bookmall.vo.OrdersVo;

public class OrdersDaoTest {
	public static void main(String[] args) {
 		insertTest();
	}
	
	private static void insertTest() {
		OrdersVo vo = null;
		
		vo = new OrdersVo();
		vo.setOrder_no("123");
		vo.setPayment_amount(100000L);
		vo.setAddress("해운대구");
		vo.setUser_no(1L);
		new OrdersDao().insert(vo);
	}
}