package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.BillingaddressDao;
import com.niit.dao.CartDao;
import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.RoleDao;
import com.niit.dao.ShippingaddressDao;
import com.niit.dao.SupplierDao;
import com.niit.dao.UserDao;
import com.niit.dao.WishlistDao;
import com.niit.dao.ShipmentDao;
import com.niit.daoimpl.BillingaddressDaoImpl;
import com.niit.daoimpl.CartDaoImpl;
import com.niit.daoimpl.CategoryDaoImpl;
import com.niit.daoimpl.ProductDaoImpl;
import com.niit.daoimpl.RoleDaoImpl;
import com.niit.daoimpl.ShippingaddressDaoImpl;
import com.niit.daoimpl.SupplierDaoImpl;
import com.niit.daoimpl.UserDaoImpl;
import com.niit.daoimpl.WishlistDaoImpl;
import com.niit.daoimpl.ShipmentDaoImpl;
import com.niit.model.Billingaddress;
import com.niit.model.Cart;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Role;
import com.niit.model.Shippingaddress;
import com.niit.model.Supplier;
import com.niit.model.User;
import com.niit.model.Wishlist;
import com.niit.model.Shipment;

@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement
public class HiberConfig {

        @Bean(name = "dataSource")
        public DataSource getH2DataSource() {

                DriverManagerDataSource dataSource = new DriverManagerDataSource();

                dataSource.setUrl("jdbc:h2:tcp://localhost/~/Frontend");

                dataSource.setDriverClassName("org.h2.Driver");

                dataSource.setUsername("sa");
                dataSource.setPassword("");


                return dataSource;
        }

        private Properties getHibernateProperties() {
                Properties properties = new Properties();
                properties.put("hibernate.show_sql", "true");
                properties.put("hibernate.hbm2ddl.auto", "update");
                properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
                properties.put("hibernate.format_sql", "true");
                return properties;
        }
        @Autowired
        @Bean(name = "sessionFactory")
        public SessionFactory getSessionFactory(DataSource dataSource) {

                LocalSessionFactoryBuilder sessionBuilder = new
LocalSessionFactoryBuilder(dataSource);
                sessionBuilder.addProperties(getHibernateProperties());
                sessionBuilder.addAnnotatedClass(User.class);
                sessionBuilder.addAnnotatedClass(Role.class);
                sessionBuilder.addAnnotatedClass(Category.class);
                sessionBuilder.addAnnotatedClass(Product.class);
                sessionBuilder.addAnnotatedClass(Supplier.class);
                sessionBuilder.addAnnotatedClass(Shippingaddress.class);
                sessionBuilder.addAnnotatedClass(Billingaddress.class);
                sessionBuilder.addAnnotatedClass(Cart.class);
                sessionBuilder.addAnnotatedClass(Wishlist.class);
                sessionBuilder.addAnnotatedClass(Shipment.class);
                return sessionBuilder.buildSessionFactory();
        }
        @Autowired
        @Bean(name = "transactionManager")
        public HibernateTransactionManager
getTransactionManager(SessionFactory sessionFactory) {
                HibernateTransactionManager transactionManager = new
HibernateTransactionManager(sessionFactory);

                return transactionManager;
        }

        @Autowired(required = true)
        @Bean(name = "UserDao")
        public UserDao getUserDao(SessionFactory sessionFactory) {
                return new UserDaoImpl(sessionFactory);
        }

        @Autowired(required = true)
        @Bean(name = "RoleDao")
        public RoleDao getRoleDao(SessionFactory sessionFactory) {
                return new RoleDaoImpl(sessionFactory);
        }
        @Autowired(required = true)
        @Bean(name = "ProductDao")
        public ProductDao getProductDao(SessionFactory sessionFactory) {
                return new ProductDaoImpl(sessionFactory);
        }
        @Autowired(required = true)
        @Bean(name = "SupplierDao")
        public SupplierDao getSupplierDao(SessionFactory sessionFactory) {
                return new SupplierDaoImpl(sessionFactory);
        }
        @Autowired(required = true)
        @Bean(name = "CategoryDao")
        public CategoryDao getCategoryDao(SessionFactory sessionFactory) {
                return new CategoryDaoImpl(sessionFactory);
        }
        @Autowired(required = true)
        @Bean(name = "ShippingaddressDao")
        public ShippingaddressDao getShippingaddressDao(SessionFactory
sessionFactory) {
                return new ShippingaddressDaoImpl(sessionFactory);
        }
        @Autowired(required = true)
        @Bean(name = "BillingaddressDao")
        public BillingaddressDao getBillingaddressDao(SessionFactory sessionFactory) {
                return new BillingaddressDaoImpl(sessionFactory);
        }
        @Autowired(required = true)
        @Bean(name = "CartDao")
        public CartDao getCartDao(SessionFactory sessionFactory) {
                return new CartDaoImpl(sessionFactory);
        }
        @Autowired(required = true)
        @Bean(name = "WishlistDao")
        public WishlistDao getWishlistDao(SessionFactory sessionFactory) {
                return new WishlistDaoImpl(sessionFactory);
        }
        @Autowired(required = true)
    	@Bean(name = "ShipmentDAO")
    	public ShipmentDao getShipmentDao(SessionFactory sessionFactory) {
    		return new ShipmentDaoImpl(sessionFactory);
    	}
}
