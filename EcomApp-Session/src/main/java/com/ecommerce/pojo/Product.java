package com.ecommerce.pojo;

public class Product 
{
	private int productId;
	private String productName;
	private String description;
	private double price;
	private int manufacturedYear;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getManufacturedYear() {
		return manufacturedYear;
	}
	public void setManufacturedYear(int manufacturedYear) {
		this.manufacturedYear = manufacturedYear;
	}	
}
