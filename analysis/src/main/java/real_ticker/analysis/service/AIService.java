package real_ticker.analysis.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AIService {

    private final String API_URL =
            "https://api-inference.huggingface.co/models/microsoft/DialoGPT-medium";

    private final String API_KEY = System.getenv("HF_API_KEY");
    public String analyzeStock(List<Double> history) {

        RestTemplate restTemplate = new RestTemplate();

        String prompt = "Analyze this stock data: " + history +
                ". Give Trend, Risk Level, Suggested Action.";

        HttpHeaders headers = new HttpHeaders();
        if (API_KEY != null && !API_KEY.isEmpty()) {
            headers.setBearerAuth(API_KEY);
        }
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> body = new HashMap<>();
        body.put("inputs", prompt);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<String> response =
                    restTemplate.postForEntity(API_URL, request, String.class);

            String result = response.getBody();

            if (result == null || result.contains("error")) {
                return generateFallback(history);
            }

            return result;

        } catch (Exception e) {

            return generateFallback(history);
        }
    }

    private String generateFallback(List<Double> history) {

        double first = history.get(0);
        double last = history.get(history.size() - 1);

        String trend;
        String risk;
        String suggestion;

        if (last > first) {
            trend = "Upward";
            risk = "Medium";
            suggestion = "Consider long-term investment";
        } else if (last < first) {
            trend = "Downward";
            risk = "High";
            suggestion = "Avoid or wait for stability";
        } else {
            trend = "Sideways";
            risk = "Low";
            suggestion = "Short-term watch";
        }

        return "{ \"trend\": \"" + trend + "\", " +
                "\"risk\": \"" + risk + "\", " +
                "\"suggestion\": \"" + suggestion + "\" }";
    }
}