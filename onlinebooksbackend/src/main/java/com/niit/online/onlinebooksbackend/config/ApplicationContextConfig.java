package com.niit.online.onlinebooksbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.online.onlinebooksbackend.dao.CategoryDAO;
import com.niit.online.onlinebooksbackend.dao.CategoryDAOImpl;
import com.niit.online.onlinebooksbackend.dao.ProductDAO;
import com.niit.online.onlinebooksbackend.dao.ProductDAOImpl;
import com.niit.online.onlinebooksbackend.dao.SupplierDAO;
import com.niit.online.onlinebooksbackend.dao.SupplierDAOImpl;
import com.niit.online.onlinebooksbackend.dao.UserDAO;
import com.niit.online.onlinebooksbackend.dao.UserDAOImpl;
import com.niit.online.onlinebooksbackend.model.Cart;
import com.niit.online.onlinebooksbackend.model.Category;
import com.niit.online.onlinebooksbackend.model.Product;
import com.niit.online.onlinebooksbackend.model.Supplier;
import com.niit.online.onlinebooksbackend.model.User;



@Configuration
@ComponentScan("com")
@EnableTransactionManagement

public class ApplicationContextConfig {

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:tcp://localhost/~/pavani"); 
	    dataSource.setUsername("sa");
	    dataSource.setPassword("");
	 System.out.println("data source");
	    return dataSource;
	}
	private Properties getHibernateProperties() {
	    Properties properties = new Properties();
	    properties.put("hibernate.show_sql", "true");
	    properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	    properties.put("hibernate.hbm2ddl.auto", "update");
	   // properties.put("hibernate.current_session_context_class", "thread");
	    System.out.println("Hibernate");
	    return properties;
	}
	@Autowired
	@Bean(name="sessionfactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		 
	    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	    sessionBuilder.addProperties(getHibernateProperties());
	 
	 sessionBuilder.addAnnotatedClasses(Category.class);
	 sessionBuilder.addAnnotatedClasses(Supplier.class);
	 sessionBuilder.addAnnotatedClasses(Product.class);
	   
	  sessionBuilder.addAnnotatedClasses(Cart.class);
	  //sessionBuilder.addAnnotatedClasses(CartItem.class);
	  // sessionBuilder.addAnnotatedClasses(Customer.class);
	   
	   
	    sessionBuilder.addAnnotatedClasses(User.class);
	    
	    System.out.println("session factory");
	    return sessionBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(
	        SessionFactory sessionFactory) {
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager(
	            sessionFactory);
	    System.out.println("Transaction");
	 
	    return transactionManager;
	}
	   @Autowired
		@Bean(name="categoryDAO")
		public CategoryDAO getCategoryDAO(SessionFactory sessionFactory) {
		    
		 
		    return new CategoryDAOImpl( sessionFactory);
		}
	    @Autowired
	    @Bean(name="category")
	    public Category getCategory()
	    {
	    	return new Category();
	    }

	    @Autowired
		@Bean(name="productDAO")
		public ProductDAO getProductDAO(SessionFactory sessionFactory) {
		    
		 
		    return new ProductDAOImpl(sessionFactory);
		}
	   @Autowired
	    @Bean(name="product")
	    public Product getProduct()
	    {
	    	return new Product();
	    }
	    @Autowired
		@Bean(name="supplierDAO")
		public SupplierDAO getSupplierDAO(SessionFactory sessionFactory) {
		    
	    	 System.out.println("supplierDAO");
		    return new SupplierDAOImpl(sessionFactory);
		}
	    @Autowired
	    @Bean(name="supplier")
	    public Supplier getSupplier()
	    {  
	    	System.out.println("Supplier");
	    	return new Supplier();
	    }
	   @Autowired
		@Bean(name="userDAO")
		public UserDAO getUserDetailsDAO(SessionFactory sessionFactory) {
		    
		   System.out.println("userDAO");
		    return new UserDAOImpl(sessionFactory);
		}
	    @Autowired
	    @Bean(name="user")
	    public User getUserDetails()
	    {
	    	 System.out.println("USER");
	    	return new User();
	    }
	    
}

