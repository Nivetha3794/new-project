/*package com.niit.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.Dao.BillingaddressDAO;
import com.niit.Dao.ProductDAO;
import com.niit.Dao.RoleDAO;
import com.niit.Dao.ShippingaddressDAO;
import com.niit.Dao.UserDAO;
import com.niit.Model.Billingaddress;
import com.niit.Model.Product;
import com.niit.Model.Role;
import com.niit.Model.Shippingaddress;
import com.niit.Model.User;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private ShippingaddressDAO shippingaddressDAO;
	@Autowired
	private BillingaddressDAO billingaddressDAO;
	
	@Autowired
	private ProductDAO productDAO;

	
	@Autowired
	private RoleDAO roleDAO;

	@Autowired
	private Role role;

	@RequestMapping("addNewUser")
	public String addUser(@ModelAttribute User user, @ModelAttribute Shippingaddress shippingaddress, @ModelAttribute Billingaddress billingaddress, Model model) {
		
		String message;
		
		if(userDAO.isAllReadyRegister(user.getEmailId(), true)){
			message = "Your emailId is Alread registered you have to login";
			
		}
		else{
			
		
		user.setEnabled(true);
		role.setEmailId(user.getEmailId());
		role.setRole("ROLE_USER");
		role.setUserName(user.getUserName());
		role.setContactNumber(user.getContactNumber());

		user.setRole(role);
		role.setUser(user);

		userDAO.saveOrUpdate(user);
		roleDAO.saveOrUpdate(role);
		
		shippingaddress.setUserId(user.getUserId());
		shippingaddressDAO.saveOrUpdate(shippingaddress);
		
		billingaddress.setUserId(user.getUserId());
		billingaddressDAO.saveOrUpdate(billingaddress);
		
		message = "You have Successfully Registered";
		}
		model.addAttribute("message", message);
		model.addAttribute("loginButtonClicked", true);
		return "home";

	}
	@RequestMapping("/afterlogin")
	public String loginProcess(Principal p, Model model){
		
		String email = p.getName();
		
		User user = userDAO.getByEmailId(email);
	
		Role role = roleDAO.getByEmailId(email);
		
		String role1 = role.getRole();
		
		if(role1.equals("ROLE_ADMIN")){
			
			return "AdminLogin";
		}
		else if(role1.equals("ROLE_USER")){
			List<Product> productList = productDAO.list();
			model.addAttribute("productList", productList);
			model.addAttribute("userLoggedIn", "true");
			return "UserLogin";
		}
		else{		
		
		return "NewLogin";
		}
	}
	}
*/