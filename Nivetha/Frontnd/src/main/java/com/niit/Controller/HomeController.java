package com.niit.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.ProductDao;
import com.niit.model.Product;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@Autowired
	private ProductDao ProductDao;
	@RequestMapping("/")
	public String indexPage(Model model) {
		List<Product> product = ProductDao.getByFeatured();
		model.addAttribute("product", product);
		return "home";
		
	}
	@RequestMapping("/home")
	public String IndexPage(Model model) {
		List<Product> product = ProductDao.getByFeatured();
		model.addAttribute("product", product);
		return "home";
		
	}
	
	@RequestMapping("/login1")
	public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,Model model) {
		ModelAndView mv = new ModelAndView("login1");

		if (error != null) {
			model.addAttribute("error", "Mail Id or Password Incorrect");
		}

		if (logout != null) {
			model.addAttribute("logout", "Logged out Successfully");
		}

		mv.addObject("loginButtonClicked", true);
		return mv;
	}
	
	@RequestMapping("/Signup")
	public String signupPage(Model model) {

		return "Signup";
	}
	@RequestMapping("/About")
	public String aboutPage(Model model) {

		return "About";
	}
}