package com.niit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.SupplierDao;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;

@Controller
public class ProductController {

	@Autowired
	private ProductDao ProductDAO;
	@Autowired
	private CategoryDao CategoryDAO;
	
	@Autowired
	private SupplierDao SupplierDAO;
	
	@RequestMapping("ViewProduct")
	public String ViewProduct(){
		
		return "ViewProduct";
	}
	@RequestMapping("Product")
	public ModelAndView newProduct(){
		
		ModelAndView mv = new ModelAndView("Product");
		List<Category> categoryList = CategoryDAO.list();
		List<Supplier> supplierList = SupplierDAO.list();
		mv.addObject("supplierList", supplierList);
		mv.addObject("categoryList", categoryList);
		mv.addObject("AddProductButtonClicked", true);
		return mv;
	}
	@RequestMapping("addProduct")
	public String addProduct(@ModelAttribute Product product, @RequestParam("file") MultipartFile file ,Model model){
		ProductDAO.saveOrUpdate(product);
		
		String path = "D://Nivetha/Frontnd/src/main/webapp/WEB-INF/resources/Product/";
		FileUtil.upload(path, file, product.getProductId()+".jpg");
		
		model.addAttribute("ViewProductButtonClicked", true);
		
		return "redirect:viewProduct";
		
	}
	@RequestMapping("viewProduct")
	public String viewProducts(Model model){
		
		List<Product> productList = ProductDAO.list();
		model.addAttribute("productList", productList);
		model.addAttribute("ViewProductButtonClicked", true);
		return "Product";
		
		
	}
	
	@RequestMapping("deleteProduct")
	public String deleteProducts(@RequestParam("productId") int productid, Model model){
		
		ProductDAO.delete(productid);
		return "redirect:viewProduct";
	}
	
	@RequestMapping("editProduct")
	public ModelAndView editProduct(@RequestParam ("productId") int productId, Model model){
		ModelAndView mv = new ModelAndView("Product");
		List<Category> categoryList = CategoryDAO.list();
		List<Supplier> supplierList = SupplierDAO.list();
		Product product = ProductDAO.getByProductId(productId);
		model.addAttribute("product", product);
		mv.addObject("supplierList", supplierList);
		mv.addObject("categoryList", categoryList);
		model.addAttribute("editProductClicked", true);
		return mv;
	}
	@RequestMapping("productEdited")
	public String productEdited(@ModelAttribute Product product){
		
		ProductDAO.saveOrUpdate(product);
		return "redirect:viewProduct";
	}
	
	@RequestMapping("productdescription")
	public String ProductDescription(@RequestParam ("productId") int productId, Model model){
		Product product = ProductDAO.getByProductId(productId);
		model.addAttribute("product", product);
		if(product.getStock() == 0)
		{
			model.addAttribute("OutofStock", true);
		}
		return "productdescription";
	}
	
	@RequestMapping("displayproduct")
	public String ProductDisplay(@RequestParam ("suppliername") String suppliername, Model model){
		List<Product> product = ProductDAO.getBySupplierName(suppliername);
		model.addAttribute("product", product);
		return "displayproduct";
	}
	
	@RequestMapping("featured")
	 	public String featured( Model model){
	 		List<Product> product = ProductDAO.getByFeatured();
	 		model.addAttribute("product", product);
	 		model.addAttribute("DisplayByFeatured", true);
	 		return "displayproduct";
	 	}
	@RequestMapping("albums")
	public String albums( Model model){
		List<Product> product = ProductDAO.list();
		model.addAttribute("product", product);
		return "displayproduct";
	}
	
	/*@RequestMapping("search")
	public ModelAndView search(@RequestParam ("searchTerm") String search, Model model){
		ModelAndView mv = new ModelAndView("search");
		List<Product> album = productDao.getByAlbumName(search);
		List<Product> product = productDao.getBySupplierName(search);
		mv.addObject("album", album);
		mv.addObject("product", product);
		return mv;
	}*/
}