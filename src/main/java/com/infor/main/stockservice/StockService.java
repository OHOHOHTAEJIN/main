package com.infor.main.stockservice;
import com.infor.main.stockservice.entity.Stock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StockService
{

    private final RestTemplate restTemplate;
    private final StockRepository stockRepository;

    @Value("${stock.api.key}")
    private String apiKey;

    private static final String API_URL = "https://openapi.koreainvestment.com:9443/api/v1/stock/list?apikey=";

    public StockService(RestTemplateBuilder builder, StockRepository stockRepository) {
        this.restTemplate = builder.build();
        this.stockRepository = stockRepository;
    }

    // 주식 상승 종목 데이터를 가져오는 메서드
    public String getStockData() {
        String url = API_URL + apiKey;
        return restTemplate.getForObject(url, String.class);
    }

    // stock table에 있는 모든 정보 SELECT
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }
}
