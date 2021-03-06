package com.espering.poc.gen;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.junit.runner.RunWith;

import com.espering.poc.domain.Market;
import com.espering.poc.domain.StockTick;
import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class StockTickGenTest {

	@Property 
	public void hold(@InRange(min="0", max="9") int digit) {
		assertThat((0 <= digit && digit <= 9), is(true));
	}
	
	@Property 
	public void generate(@From(StockTickGen.class) StockTick tick) {
		assertThat(tick.getMarket(), isOneOf(Market.NYSE, Market.NASDAQ));
		assertThat(tick.getSymbol(), isOneOf("IBM", "BBY", "C", "GOOG", "APPL"));
		assertThat((10 <= tick.getPrice() && tick.getPrice() <= 12), is(true));
		assertThat((0 <= tick.getVolume() && tick.getVolume() <= 10000), is(true));
	}
}
