package com.montran.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Product {
	@Id
	private int product_id;
	private String product_name;
	private int quantity;
	private double price;
	@Temporal(TemporalType.DATE)
	private Date man_date;
	@Temporal(TemporalType.DATE)
	private Date exp_date;
	@ManyToOne
	Category ctg;
	public Product() {
		super();
	}
	public Product(int product_id, String product_name, int quantity, double price, Date man_date, Date exp_date,
			Category ctg) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.quantity = quantity;
		this.price = price;
		this.man_date = man_date;
		this.exp_date = exp_date;
		this.ctg = ctg;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getMan_date() {
		return man_date;
	}
	public void setMan_date(Date man_date) {
		this.man_date = man_date;
	}
	public Date getExp_date() {
		return exp_date;
	}
	public void setExp_date(Date exp_date) {
		this.exp_date = exp_date;
	}
	public Category getCtg() {
		return ctg;
	}
	public void setCtg(Category ctg) {
		this.ctg = ctg;
	}
	
}