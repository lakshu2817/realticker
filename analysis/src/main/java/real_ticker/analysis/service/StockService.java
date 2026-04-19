package real_ticker.analysis.service;

import org.springframework.stereotype.Service;
import real_ticker.analysis.model.Stock;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {

        public List<Stock> getTopStocks() {
            List<Stock> stocks = new ArrayList<>();

            stocks.add(new Stock("AAPL", "Apple Inc", 185.40, 1.2, 78000000, generateHistory()));
            stocks.add(new Stock("MSFT", "Microsoft", 412.30, 0.8, 45000000, generateHistory()));
            stocks.add(new Stock("GOOGL", "Google", 135.20, 1.5, 32000000, generateHistory()));
            stocks.add(new Stock("AMZN", "Amazon", 145.60, -0.5, 29000000, generateHistory()));
            stocks.add(new Stock("TSLA", "Tesla", 250.10, 2.3, 60000000, generateHistory()));
            stocks.add(new Stock("META", "Meta", 310.45, 1.1, 27000000, generateHistory()));
            stocks.add(new Stock("NFLX", "Netflix", 390.70, -0.8, 15000000, generateHistory()));
            stocks.add(new Stock("NVDA", "Nvidia", 480.90, 3.2, 50000000, generateHistory()));
            stocks.add(new Stock("INTC", "Intel", 35.60, 0.4, 22000000, generateHistory()));
            stocks.add(new Stock("AMD", "AMD", 120.30, 1.9, 34000000, generateHistory()));

            return stocks;
        }

        public List<Double> getStockHistory(String ticker) {
            return generateHistory();
        }

        private List<Double> generateHistory() {
            List<Double> history = new ArrayList<>();
            for (int i = 0; i < 180; i++) {
                history.add(100 + Math.random() * 50);
            }
            return history;
        }
    }

