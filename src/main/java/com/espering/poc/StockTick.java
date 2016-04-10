package com.espering.poc;

public class StockTick {

	private String name;
	private String code;
	private double price;
	
	public StockTick(String name, String code, double price) {
		this.name = name;
		this.code = code;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "StockTick [name=" + name + ", code=" + code + ", price=" + price + "]";
	}
}
