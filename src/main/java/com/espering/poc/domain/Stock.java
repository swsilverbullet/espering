package com.espering.poc.domain;

public class Stock {

	private String symbol;
	private String name;
	
	public Stock(String symbol, String name) {
		this.symbol = symbol;
		this.name = name;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Stock [symbol=" + symbol + ", name=" + name + "]";
	}
}
