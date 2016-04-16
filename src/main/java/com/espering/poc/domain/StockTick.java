package com.espering.poc.domain;

public class StockTick {
	
	private Market market;
	private String symbol;
	private double price;
	private int volume;
	
	public StockTick(Market market, String symbol, double price, int volume) {
		this.market = market;
		this.symbol = symbol;
		this.price = price;
		this.volume = volume;
	}
	
	public Market getMarket() {
		return market;
	}

	public String getSymbol() {
		return symbol;
	}

	public double getPrice() {
		return price;
	}
	
	public int getVolume() {
		return volume;
	}

	@Override
	public String toString() {
		return "StockTick [market=" + market + ", symbol=" + symbol + ", price=" + price + ", volume=" + volume + "]";
	}
}
