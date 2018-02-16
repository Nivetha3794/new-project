package com.niit.dao;

import java.util.List;

import com.niit.model.Role;

public interface RoleDao {
	
	public List<Role> list();	
	
	public Role getByUserName(String username);
	
	public Role getByEmailId(String emailid);
	
	public Role getByContactNumber(int contactnumber);
	
	public void saveOrUpdate(Role role);
		
    public void delete(String username);

	
}