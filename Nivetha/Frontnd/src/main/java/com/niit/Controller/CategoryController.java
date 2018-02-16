package com.niit.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CategoryDao;
import com.niit.model.Category;

@Controller
public class CategoryController {
	

	@Autowired
	private CategoryDao CategoryDAO;
	
	/*@Autowired
	private CartDao cartDao;*/
	
	@RequestMapping("Category")
	public String NewCategory(Model model)	{
		
		model.addAttribute("AddCategoryButtonClicked", true);
		return "Category";
		
	}
	
	@RequestMapping("addCategory")
	public String addCategory(@ModelAttribute Category category, Model model){
		CategoryDAO.saveOrUpdate(category);
		
		return "redirect:CategoryView";
	
	}
	@RequestMapping("CategoryView")
	public String ViewCategory(Model model){
		List<Category> categoryList = CategoryDAO.list();
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("ViewCategoryButtonClicked", true);
		return "Category";
	}
	@RequestMapping("DeleteCategory")
	public String deleteCategory(@RequestParam ("categoryId") int categoryId){
		
		CategoryDAO.delete(categoryId);
		
		return "redirect:CategoryView";
					
	}
	@RequestMapping("EditCategory")
	public String editCategory(@RequestParam ("categoryId") int categoryId, Model model){
		Category category = CategoryDAO.getByCategoryId(categoryId);
		model.addAttribute("category", category);
		model.addAttribute("EditCategoryClicked", true);
		return "Category";
		
	}
	@RequestMapping("categoryEdit")
	public String categoryEdited(@ModelAttribute Category category){
		
		CategoryDAO.saveOrUpdate(category);
		return "redirect:CategoryView";
	}

}