package com.espering.poc.repository;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import com.espering.poc.domain.Market;
import com.espering.poc.domain.Stock;

public class InMemoryStockRepository implements StockRepository {
	
	private Map<Market, Set<Stock>> stockMap;
	
	public InMemoryStockRepository(Map<Market, Set<Stock>> stockMap) {
		this.stockMap = stockMap;
	}
	
	@Override
	public Set<Stock> getAll(Market market) {
		return stockMap.get(market);
	}

	@Override
	public Optional<Stock> get(Market market, String symbol) {
		return getAll(market).stream().filter(new Predicate<Stock>() {
			@Override public boolean test(Stock stock) {
				return stock.getSymbol().equals(symbol);
			}
		}).findFirst();
	}
}