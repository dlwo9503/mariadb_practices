package com.douzone.bookmall.test;

import com.douzone.bookmall.dao.CartDao;
import com.douzone.bookmall.vo.CartVo;

public class CartDaoTest {
	public static void main(String[] args) {
// 		insertTest(); ok
	}
	
	private static void insertTest() {
		CartVo vo = null;
		
		vo = new CartVo();
		vo.setName("트와일라잇");
		vo.setPrice(20000L);
		vo.setQuantity(2L);
		vo.setUser_no(1L);
		vo.setBook_no(1L);
		new CartDao().insert(vo);
		
		vo = new CartVo();
		vo.setName("자바스크립트 완벽 가이드");
		vo.setPrice(50000L);
		vo.setQuantity(3L);
		vo.setUser_no(1L);
		vo.setBook_no(3L);
		new CartDao().insert(vo);
	}
}