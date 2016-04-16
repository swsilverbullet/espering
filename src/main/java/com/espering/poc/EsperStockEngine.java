package com.espering.poc;

import com.espering.poc.domain.Market;
import com.espering.poc.domain.StockTick;
import com.espering.poc.gen.StockTickGen;

public class EsperStockEngine {
	
	public static void main(String[] args) {
		StockFinder finder = new StockFinder();
		finder = new StockFinder();
		finder.setup();
		finder.setStockFoundListener(new StockFoundListener() {
			@Override
			public void found(StockTick stockTick) {
				System.out.println("found: " + stockTick);
			}
		});
		
		StockTickGen stockTickGen = new StockTickGen();
		
		while(true) {
			StockTick nyseTick = stockTickGen.sample(Market.NYSE);
			StockTick nasdaqTick = stockTickGen.sample(Market.NASDAQ);
			finder.sendStockTick(nyseTick);
			finder.sendStockTick(nasdaqTick);
		}
	}
}
