package com.infor.main.stockservice;

import com.infor.main.stockservice.entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class StockScheduler {


    private StockService stockService;

    @Autowired
    private StockRepository stockRepository;

    // 1분마다 주식 데이터를 조회하여 DB에 저장
    @Scheduled(fixedRate = 60000)
    public void fetchAndSaveStockData() {
        String stockData = stockService.getStockData();  // 실시간 주식 데이터 가져오기

        // 주식 데이터 파싱 후, Stock 엔티티로 변환 (JSON 파싱을 위한 예시 코드)
        // 예를 들어 JSON 파싱을 통해 주식 정보를 가져와서 저장합니다.
        Stock stock = new Stock();
        stock.setSymbol("MSFT");  // 예시
        stock.setPrice(300.0);     // 예시
        stock.setChangePercent(1.2); // 예시

        stockRepository.save(stock);  // DB에 저장
    }
}
