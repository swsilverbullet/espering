package com.espering.poc.gen;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.espering.poc.domain.Market;
import com.espering.poc.domain.StockTick;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import static com.espering.poc.gen.GenUtils.*;

public class StockTickGen extends Generator<StockTick> {

	Generator<String> symbolGen = new SymbolGen();
	
	public StockTickGen() {
		super(StockTick.class);
	}
	
	@Override
	public StockTick generate(SourceOfRandomness random, GenerationStatus status) {
		return new StockTick(market(), symbol(), random.nextDouble(10, 12), random.nextInt(1, 10000));
	}
	
	public StockTick sample() {
		SourceOfRandomness random = new SourceOfRandomness(new Random());
		return new StockTick(market(), symbol(), random.nextDouble(10, 12), random.nextInt(1, 10000));
	}
	
	public StockTick sample(Market market) {
		switch(market) {
			case NYSE:
				return marketSample(Market.NYSE, nyseSymbol());
			case NASDAQ:
				return marketSample(Market.NASDAQ, nasdaqSymbol());
			default:
				throw new IllegalStateException("Invalid market: " + market);
		}
	}
	
	private StockTick marketSample(Market market, String symbol) {
		SourceOfRandomness random = new SourceOfRandomness(new Random());
		return new StockTick(market, symbol, random.nextDouble(10, 11), random.nextInt(1, 10000));
	}
	
	private Market market() {
		return oneOf(Arrays.asList(Market.values()));
	}
	
	private String symbol() {
		return oneOf(nyseSymbol(), nasdaqSymbol());
	}
	
	private String nyseSymbol() {
		return oneOf(Arrays.asList("IBM", "BBY", "C"));
	}
	
	private String nasdaqSymbol() {
		return oneOf(Arrays.asList("APPL", "GOOG"));
	}
}

class SymbolGen extends Generator<String> {
	
	private List<String> symbols = Arrays.asList("APPL", "GOOG");
	
	public SymbolGen() {
		super(String.class);
	}

	@Override
	public String generate(SourceOfRandomness random, GenerationStatus status) {
		return oneOf(symbols);
	}
	
	private <T> T oneOf(List<T> l) {
		int index = new Random().nextInt(l.size());
		return l.get(index);
	}
}