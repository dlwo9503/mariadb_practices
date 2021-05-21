package com.douzone.bookmall.test;

import com.douzone.bookmall.dao.BookDao;
import com.douzone.bookmall.vo.BookVo;

public class BookDaoTest {
	public static void main(String[] args) {
//		insertTest();
	}
	
	private static void insertTest() {
		BookVo vo = null;
		
		vo = new BookVo();
		vo.setTitle("트와일라잇");
		vo.setPrice(20000L);
		vo.setCategory_no(1L);
		new BookDao().insert(vo);
		
		vo = new BookVo();
		vo.setTitle("이것이 자바다");
		vo.setPrice(25000L);
		vo.setCategory_no(2L);
		new BookDao().insert(vo);
		
		vo = new BookVo();
		vo.setTitle("자바스크립트 완벽 가이드");
		vo.setPrice(50000L);
		vo.setCategory_no(2L);
		new BookDao().insert(vo);
	}
}
