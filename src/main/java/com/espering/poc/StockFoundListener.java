package com.espering.poc;

import com.espering.poc.domain.StockTick;

public interface StockFoundListener {
	public void found(StockTick stockTick);
}
