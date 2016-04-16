package com.espering.poc;

import com.espering.poc.domain.StockTick;
import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class StockFinder {
	private EPServiceProvider epServiceProvider;
	private EPStatement epStatement;
	private StockFoundListener stockFoundListener;
	
	public void setup() {
		Configuration config = new Configuration();
		config.addEventType("StockTick", StockTick.class);
		
		this.epServiceProvider = EPServiceProviderManager.getProvider("StockTick", config);
		this.epStatement = epServiceProvider.getEPAdministrator().createEPL("select * from StockTick t where t.volume >= 1000");
		this.epStatement.addListener(new UpdateListener() {
			@Override
			public void update(EventBean[] newEvents, EventBean[] oldEvents) {
				StockTick stockTick = (StockTick) newEvents[0].getUnderlying();
				if (stockFoundListener != null)
					stockFoundListener.found(stockTick);
			}
		});
	}
	
	public void setStockFoundListener(StockFoundListener stockFoundListener) {
		this.stockFoundListener = stockFoundListener;
	}
	
	public void sendStockTick(StockTick stockTick) {
		this.epServiceProvider.getEPRuntime().sendEvent(stockTick);
	}
}
