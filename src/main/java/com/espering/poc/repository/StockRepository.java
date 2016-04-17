package com.espering.poc.repository;

import java.util.Optional;
import java.util.Set;

import com.espering.poc.domain.Market;
import com.espering.poc.domain.Stock;

public interface StockRepository {

	public Set<Stock> getAll(Market market);
	
	public Optional<Stock> get(Market market, final String symbol);
}