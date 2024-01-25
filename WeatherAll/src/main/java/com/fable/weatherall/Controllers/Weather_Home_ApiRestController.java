package com.fable.weatherall.Controllers;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Weather_Home_ApiRestController {
	
	    @Value("${openweathermap.api.key}")
	    private String apiKey;

	    @Value("${openweathermap.api.url}")
	    private String apiUrl;

	    public String getApiKey() {
			return apiKey;
		}

		public void setApiKey(String apiKey) {
			this.apiKey = apiKey;
		}

		public String getApiUrl() {
			return apiUrl;
		}

		public void setApiUrl(String apiUrl) {
			this.apiUrl = apiUrl;
		}

		@GetMapping("/api/config")
	    public Map<String, String> getApiConfig() {
	    	
	        Map<String, String> config = new HashMap<>();
	        config.put("apiKey", apiKey);
	        config.put("apiUrl", apiUrl);
	        
	        return config;
	    }

}
