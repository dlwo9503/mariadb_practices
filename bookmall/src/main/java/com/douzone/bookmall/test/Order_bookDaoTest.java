package com.douzone.bookmall.test;

import com.douzone.bookmall.dao.Order_bookDao;
import com.douzone.bookmall.vo.Order_bookVo;

public class Order_bookDaoTest {
	public static void main(String[] args) {
//		insertTest();
	}
	
	private static void insertTest() {
		Order_bookVo vo = null;
		
		vo = new Order_bookVo();
		vo.setQuantity(2L);
		vo.setPrice(20000L);
		vo.setBook_no(1L);
		vo.setOrder_no(1L);
		new Order_bookDao().insert(vo);
		
		vo = new Order_bookVo();
		vo.setQuantity(3L);
		vo.setPrice(50000L);
		vo.setBook_no(3L);
		vo.setOrder_no(2L);
		new Order_bookDao().insert(vo);
	}
}