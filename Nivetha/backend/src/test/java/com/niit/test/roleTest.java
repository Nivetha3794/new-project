package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.RoleDao;
import com.niit.dao.UserDao;
import com.niit.model.Role;
import com.niit.model.User;

public class roleTest {
	public static void main (String[] args) {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		UserDao userDao = (UserDao) context.getBean("UserDAO");
		RoleDao roleDAO = (RoleDao) context.getBean("RoleDAO");
		User user = (User) context.getBean("user");
		Role role = (Role) context.getBean("role");
		user.setUserName("skfr");
		user.setUserName("sfdj");
		user.setEmailId("jhvd@gmail.com");
		user.setPassword("jfkd");
		
		user.setContactNumber(98765);
		user.setAddress("s12,sejkajdh");
		user.setZipcode(7542);
		userDao.saveOrUpdate(user);
		role.setUserName("kjgdffd");
		role.setEmailId("hgfshdghj");
		role.setContactNumber(6567);
		
		user.setRole(role);
		role.setUser(user);
		
		
		
		roleDAO.saveOrUpdate(role);
		
}
}
