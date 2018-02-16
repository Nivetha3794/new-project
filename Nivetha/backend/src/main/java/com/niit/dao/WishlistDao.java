package com.niit.dao;

import java.util.List;

import com.niit.model.Wishlist;

public interface WishlistDao {
	
	public List<Wishlist> list();
	
	public Wishlist getByProductName(String productname);		
	
	public Wishlist getByProductId(int productid);	
	
    public Wishlist getByPrice(String price);
	
	public void saveOrUpdate(Wishlist wishlist);
		
	public void delete(String Productname);

}