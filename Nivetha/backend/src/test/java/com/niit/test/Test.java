package com.niit.test;


//import java.util.function.Supplier;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.model.User;
import com.niit.model.Wishlist;

import com.niit.dao.WishlistDao;
import com.niit.dao.ProductDao;
import com.niit.dao.RoleDao;
import com.niit.dao.ShippingaddressDao;
import com.niit.model.Product;
import com.niit.model.Role;
import com.niit.model.Shippingaddress;
import com.niit.model.Supplier;
import com.niit.dao.BillingaddressDao;
import com.niit.dao.CartDao;
import com.niit.dao.CategoryDao;
import com.niit.model.Billingaddress;
import com.niit.model.Cart;
import com.niit.model.Category;
import com.niit.dao.SupplierDao;
/*import com.niit.Dao.RoleDao;



import com.niit.Model.Role;

*/
import com.niit.dao.UserDao;


public class Test {

	public static void main (String[] args) {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		UserDao userDao = (UserDao) context.getBean("UserDAO");
		ProductDao productDAO = (ProductDao) context.getBean("ProductDAO");
		CategoryDao categoryDAO = (CategoryDao) context.getBean("CategoryDAO");
		SupplierDao supplierDAO = (SupplierDao) context.getBean("SupplierDAO");
		CartDao cartDAO = (CartDao) context.getBean("CartDAO");
		RoleDao roleDAO = (RoleDao) context.getBean("RoleDAO");
		BillingaddressDao billingaddressDAO = (BillingaddressDao) context.getBean("BillingaddressDAO");
		ShippingaddressDao shippingaddressDAO = (ShippingaddressDao) context.getBean("ShippingaddressDAO");
		
		WishlistDao wishlistDAO = (WishlistDao) context.getBean("WishlistDAO");
		
		
		
		
		
		
		User user = (User) context.getBean("user");
		Product product = (Product) context.getBean("product");
		Category category = (Category) context.getBean("category");
		Role role = (Role) context.getBean("role");
		Cart cart = (Cart) context.getBean("cart");
		Billingaddress billingaddress = (Billingaddress) context.getBean("billingaddress");
		Shippingaddress shippingaddress = (Shippingaddress) context.getBean("shippingaddress");
		Supplier supplier = (Supplier) context.getBean("supplier");
		Wishlist wishlist = (Wishlist) context.getBean("wishlist");
		
		category.setCategoryName("Laptops");
		
		categoryDAO.saveOrUpdate(category);
		
		cart.setProductName("dfhjj");
		cartDAO.saveOrUpdate(cart);
		
		user.setUserName("skfr");
		user.setUserName("sfdj");
		user.setEmailId("jhvd@gmail.com");
		user.setPassword("jfkd");
		
		user.setContactNumber(98765);
		user.setAddress("s12,sejkajdh");
		user.setZipcode(7542);
		userDao.saveOrUpdate(user);
		
		product.setProductName("fdknmfg");
		productDAO.saveOrUpdate(product);
		
		shippingaddress.setAddress("fdgfs");
		shippingaddress.setUserName("jkfgjd");
		shippingaddressDAO.saveOrUpdate(shippingaddress);
		
		role.setUserName("kjgdffd");
		role.setEmailId("hgfshdghj");
		role.setContactNumber(6567);
		
		user.setRole(role);
		role.setUser(user);
		
		
		
		roleDAO.saveOrUpdate(role);
		
		
		wishlist.setProductName("dhjf");
		wishlist.setPrice(87);
		wishlistDAO.saveOrUpdate(wishlist);
		
		billingaddress.setAddress("hfdjdufuinv");
		billingaddress.setContactNumber(897465);
		billingaddressDAO.saveOrUpdate(billingaddress);
		
		supplier.setSupplierName("hddsjk");
		supplier.setContactNumber(87968764);
		supplierDAO.saveOrUpdate(supplier);
		
		
}
}