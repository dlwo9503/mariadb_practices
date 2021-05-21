package com.douzone.bookmall.test;

import com.douzone.bookmall.dao.CategoryDao;
import com.douzone.bookmall.vo.CategoryVo;

public class CategoryDaoTest {
	public static void main(String[] args) {
//		insertTest();
	}
	
	private static void insertTest() {
		CategoryVo vo = null;
		
		vo = new CategoryVo();
		vo.setName("소설");
		new CategoryDao().insert(vo);
		
		vo = new CategoryVo();
		vo.setName("수필");
		new CategoryDao().insert(vo);
		
		vo = new CategoryVo();
		vo.setName("컴퓨터/IT");
		new CategoryDao().insert(vo);
	}
}
