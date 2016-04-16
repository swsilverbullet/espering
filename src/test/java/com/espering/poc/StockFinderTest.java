package com.espering.poc;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import com.espering.poc.domain.StockTick;

public class StockFinderTest {
	private StockFinder sut = new StockFinder();
	private StockTick lastFound = null;
//	private StockFoundListener stockFoundListener = new StockFoundListener() {
//		@Override
//		public void found(StockTick stockTick) {
//			lastFound = stockTick;
//		}
//	};
			
	@Before
	public void setUp() throws Exception {
		this.sut.setup();
		this.sut.setStockFoundListener(new StockFoundListener() {
			@Override
			public void found(StockTick stockTick) {
				lastFound = stockTick;
			}
		});
	}

	@Test
	public void testStockShouldBeFound() {
//		StockTick tick1 = new StockTick("Apple", "APPL", 99.8);
//		this.sut.sendStockTick(tick1);
//		assertThat(this.lastFound, nullValue());
//		
//		StockTick tick2 = new StockTick("Apple", "APPL", 100.1);
//		this.sut.sendStockTick(tick2);
//		assertThat(this.lastFound, equalTo(tick2));
	}
}
