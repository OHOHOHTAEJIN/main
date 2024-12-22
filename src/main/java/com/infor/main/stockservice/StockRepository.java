package com.infor.main.stockservice;

import org.springframework.data.jpa.repository.JpaRepository;
import com.infor.main.stockservice.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, String> {
}