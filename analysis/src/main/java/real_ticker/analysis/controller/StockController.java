package real_ticker.analysis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import real_ticker.analysis.model.Stock;
import real_ticker.analysis.service.AIService;
import real_ticker.analysis.service.StockService;

import java.util.List;
@RestController
@RequestMapping("/api/stocks")
@CrossOrigin(origins = "*")

public class StockController {
        @Autowired
        private StockService stockService;

        @Autowired
        private AIService aiService;

        @GetMapping("/top10")
        public List<Stock> getTopStocks() {
            return stockService.getTopStocks();
        }

        @GetMapping("/{ticker}/history")
        public List<Double> getHistory(@PathVariable String ticker) {
            return stockService.getStockHistory(ticker);
        }

        @PostMapping("/{ticker}/analyze")
        public String analyzeStock(@PathVariable String ticker) {
            List<Double> history = stockService.getStockHistory(ticker);
            return aiService.analyzeStock(history);
        }
}
