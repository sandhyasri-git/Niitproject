package com.niit.online.onlinebooksbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Cart {
        
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int id;
	    private int quantity;
	    private int price;
	    
	    //user id//
	    @ManyToOne
	    @JoinColumn(name = "id" , insertable = false, updatable = false)
	    private User cartuser;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public User getCartuser() {
			return cartuser;
		}
		public void setCartuser(User cartuser) {
			this.cartuser = cartuser;
		}
		
		// product id //
		@ManyToOne
	    @JoinColumn(name = "productid" , insertable = false, updatable = false)
		private Product cartproduct;
		private int productid;
		public Product getCartproduct() {
			return cartproduct;
		}
		public void setCartproduct(Product cartproduct) {
			this.cartproduct = cartproduct;
		}
		public int getProductid() {
			return productid;
		}
		public void setProductid(int productid) {
			this.productid = productid;
		}
		
	    
	    
	    
	    
}
