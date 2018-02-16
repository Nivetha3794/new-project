package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDao;
import com.niit.model.User;

public class userTest {

	public static void main (String[] args) {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		UserDao userDao = (UserDao) context.getBean("UserDAO");
		User user = (User) context.getBean("user");
		user.setUserName("skfr");
		user.setUserName("sfdj");
		user.setEmailId("jhvd@gmail.com");
		user.setContactNumber(11356);
		user.setPassword("jfkd");
		user.setAddress("s12,sejkajdh");
		user.setZipcode(7542);
		userDao.saveOrUpdate(user);
}
}
