package com.espering.poc.domain;

public interface Order {
	
	void placeOrder(Stock stock, int numberOfShares);
	
	enum OrderType {
		MarketOrder, LimitOrder
	}
}

class Buy implements Order {
	@Override
	public void placeOrder(Stock stock, int numberOfShares) {
	}
}

class Sell implements Order {
	@Override
	public void placeOrder(Stock stock, int numberOfShares) {
	}
}