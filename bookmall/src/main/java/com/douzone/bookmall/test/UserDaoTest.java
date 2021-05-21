package com.douzone.bookmall.test;

import com.douzone.bookmall.dao.UserDao;
import com.douzone.bookmall.vo.UserVo;

public class UserDaoTest {

	public static void main(String[] args) {
		insertTest();
	}
	
	private static void insertTest() {
		UserVo vo = null;
		
		vo = new UserVo();
		vo.setName("이재성");
		vo.setPhone_no("010-1111-1111");
		vo.setEmail("dlwo9503@naver.com");
		vo.setPw("1111");
		new UserDao().insert(vo);
		
		vo = new UserVo();
		vo.setName("김재성");
		vo.setPhone_no("010-2222-2222");
		vo.setEmail("wotjd6816@naver.com");
		vo.setPw("2222");
		new UserDao().insert(vo);
	}
}