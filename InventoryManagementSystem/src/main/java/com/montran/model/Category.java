package com.montran.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Category {
	@Id
	private int category_id;
	private String category_name;
	private String imgFileName;
	
	@OneToMany(mappedBy = "ctg", cascade = CascadeType.ALL)
	private List<Product> products;
	
	public Category() {
		super();
	}
	
	public Category(int category_id, String category_name, String imgFileName) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
		this.imgFileName = imgFileName;
	}

	public Category(int category_id, String category_name) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
	}

	public Category(int category_id, String category_name, String imgFileName, List<Product> products) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
		this.imgFileName = imgFileName;
		this.products = products;
	}

	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
