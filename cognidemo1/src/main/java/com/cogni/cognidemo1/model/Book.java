package com.cogni.cognidemo1.model;

public class Book {
	
	private int bid;
	private String bookName;
	private double price;
	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Book(int bid, String bookName, double price) {
		super();
		this.bid = bid;
		this.bookName = bookName;
		this.price = price;
	}


	public int getBid() {
		return bid;
	}


	public void setBid(int bid) {
		this.bid = bid;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
	

}
