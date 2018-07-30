package com.sujiawei.java.core;

import com.sujiawei.java.bean.Stock;

public interface StockBo {
	
	void save(Stock stock);
	void update(Stock stock);
	void delete(Stock stock);
	Stock findByStockCode(String stockCode);
}