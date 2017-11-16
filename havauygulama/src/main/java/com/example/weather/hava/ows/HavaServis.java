package com.example.weather.hava.ows;

import java.net.URI;

import com.example.weather.havaAyarlar;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

@Service
public class HavaServis {

	private static final String HAVA_URL =
			"http://api.openweathermap.org/data/2.5/weather?q={city},{country}&APPID={key}";

	private static final String TAHMIN_URL =
			"http://api.openweathermap.org/data/2.5/forecast?q={city},{country}&APPID={key}";

	private static final Logger logger = LoggerFactory.getLogger(HavaServis.class);

	private final String apiKey;

	public HavaServis(RestTemplateBuilder restTemplateBuilder,
					  havaAyarlar properties) {
		this.restTemplate = restTemplateBuilder.build();
		this.apiKey = properties.getApi().getKey();
	}

	@Cacheable("hava")
	public Hava getWeather(String country, String city) {
		logger.info("Requesting current weather for {}/{}", country, city);
		URI url = new UriTemplate(WEATHER_URL).expand(city, country, this.apiKey);
		return invoke(url, Hava.class);
	}

	@Cacheable("tahmin")
	public TahminiHava getWeatherForecast(String country, String city) {

		URI url = new UriTemplate(FORECAST_URL).expand(city, country, this.apiKey);
		return invoke(url, TahminiHava.class);
	}

}
