package com.infor.main.stockcontroller;

import com.infor.main.stockservice.StockService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
public class StockController {

    private final StockService stockService;
    private static final Logger log = Logger.getLogger(String.valueOf(StockController.class));

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @RequestMapping("/stocks")
    public String getAllStocks(Model model)
    {
        log.info("Passing Check");
        System.out.println("stocks page Open!");
        model.addAttribute("stocks", stockService.getAllStocks());
        return "stock";  // stocks.html로 데이터를 전달
    }
}

