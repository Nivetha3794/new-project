package com.niit.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.dao.ProductDao;
import com.niit.dao.RoleDao;
import com.niit.dao.ShipmentDao;
import com.niit.dao.UserDao;
import com.niit.model.Product;
import com.niit.model.Role;
import com.niit.model.Shipment;
import com.niit.model.User;

@Controller
public class UserController {

	@Autowired
	private UserDao UserDAO;
	
	@Autowired
	private ProductDao ProductDao;
	
	@Autowired
	private RoleDao RoleDao;

	@Autowired
	private Role role;
	
	@Autowired
	ShipmentDao ShipmentDao;
	

	@RequestMapping("addNewUser")
	public String addUser(@ModelAttribute User user, @ModelAttribute Shipment ship, Model model) {
		 String message;
		 if (UserDAO.isAllReadyRegister(user.getEmailId(), true)) {
			message = "Your emailId is Already registered you have to login";

		} else {

			user.setEnabled(true);
			role.setEmailId(user.getEmailId());
			role.setRole("ROLE_USER");
			role.setUserName(user.getUserName());
			role.setContactNumber(user.getContactNumber());

			user.setRole(role);
			role.setUser(user);	

			UserDAO.saveOrUpdate(user);
			RoleDao.saveOrUpdate(role);
			
			ship.setUserId(user.getUserId());
			ShipmentDao.saveOrUpdate(ship);
			
			message = "You have Successfully Registered";
		}
		model.addAttribute("message", message);
		model.addAttribute("loginButtonClicked", true);
		return "home";

	}
	
 @RequestMapping("/afterlogin") public String loginProcess(Principal p,Model model){
	  
	  String email = p.getName();
	  
      System.out.println(email);
	  
	  User user =  UserDAO.getByEmailId(email);
	  
	  Role role = RoleDao.getByEmailId(email);
	  
	  String role1 = role.getRole();
	  
	  if(role1.equals("ROLE_ADMIN"))
	  {
	  
	  return "home"; 
	  }
	  else if(role1.equals("ROLE_USER")){
			List<Product> product = ProductDao.getByFeatured();
			model.addAttribute("product", product);
			model.addAttribute("userLoggedIn", "true");
			return "home";
		}
	  else {
	  
	  return "home";
	  }
	  }

}
