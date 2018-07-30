package com.sujiawei.java.core.impl;

import com.sujiawei.java.bean.Stock;
import com.sujiawei.java.core.StockBo;
import com.sujiawei.java.dao.StockDao;

public class StockBoImpl implements StockBo {
	
	StockDao stockDao;
	
	public void setStockDao(StockDao stockDao) {
		this.stockDao = stockDao;
	}

	public void save(Stock stock){
		stockDao.save(stock);
	}
	
	public void update(Stock stock){
		stockDao.update(stock);
	}
	
	public void delete(Stock stock){
		stockDao.delete(stock);
	}
	
	public Stock findByStockCode(String stockCode){
		return stockDao.findByStockCode(stockCode);
	}
}