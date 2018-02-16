package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.WishlistDao;
import com.niit.model.Category;
import com.niit.model.User;
import com.niit.model.Wishlist;

@Repository("WishlistDAO")
public class WishlistDaoImpl implements WishlistDao {
	
	public WishlistDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<Wishlist> list() {
		@SuppressWarnings({ "unchecked" })
		List<Wishlist> listWhishlist = (List<Wishlist>) sessionFactory.getCurrentSession().createCriteria(Wishlist.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listWhishlist;
	}


	@Transactional
	public Wishlist getByProductName(String productname) {
		String hql = "from Whishlist where ProductName ='" + productname + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Wishlist> listWhishlist = (List<Wishlist>) (query).list();

		if (listWhishlist != null && !listWhishlist.isEmpty()) {
			return listWhishlist.get(0);
		}
		return null;
	}

	@Transactional
	public Wishlist getByProductId(int productid) {
		String hql = "from Whishlist where ProductId ='" + productid + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Wishlist> listWhishlist = (List<Wishlist>) (query).list();

		if (listWhishlist != null && !listWhishlist.isEmpty()) {
			return listWhishlist.get(0);
		}
		return null;
	}

	@Transactional
	public Wishlist getByPrice(String price) {
		String hql = "from Whishlist where Price ='" + price + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Wishlist> listWhishlist = (List<Wishlist>) (query).list();

		if (listWhishlist != null && !listWhishlist.isEmpty()) {
			return listWhishlist.get(0);
		}
		return null;
	}

	@Transactional
	public void saveOrUpdate(Wishlist wishlist) {
		sessionFactory.getCurrentSession().saveOrUpdate(wishlist);
		
	}

	@Transactional
	public void delete(String Productname) {
		Wishlist wishlistToDelete = new Wishlist();
		wishlistToDelete.setProductName(Productname);
		sessionFactory.getCurrentSession().delete(wishlistToDelete);
	}
		
}