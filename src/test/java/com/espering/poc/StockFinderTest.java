package com.espering.poc;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import com.espering.poc.domain.Market;
import com.espering.poc.domain.StockTick;

public class StockFinderTest {
	private StockFinder sut = new StockFinder();
	private StockTick lastFound = null;
			
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
	public void testStockShouldBeFoundIfVolumeGreaterThanEqualTo1000() {
		StockTick tick1 = new StockTick(Market.NASDAQ, "APPL", 10, 999);
		this.sut.sendStockTick(tick1);
		assertThat(this.lastFound, nullValue());
		
		StockTick tick2 = new StockTick(Market.NASDAQ, "APPL", 11, 1000);
		this.sut.sendStockTick(tick2);
		assertThat(this.lastFound, is(tick2));
	}
}