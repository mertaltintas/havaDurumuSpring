package com.example.weather.web;

import com.example.weather.hava.ows.Hava;
import com.example.weather.hava.ows.TahminiHava;
import com.example.weather.hava.ows.HavaServis;


@RequestMapping("/api/weather")
public class ApiHava {

	private final HavaServis havaServis;

	public ApiHava(HavaServis havaServis) {
		this.havaServis = havaServis;
	}

	@RequestMapping("/now/{country}/{city}")
	public Hava getWeather(@PathVariable String country,
						   @PathVariable String city) {
		return this.havaServis.getWeather(country, city);
	}

	@RequestMapping("/weekly/{country}/{city}")
	public TahminiHava getWeatherForecast(@PathVariable String country,
										  @PathVariable String city) {
		return this.havaServis.getWeatherForecast(country, city);
	}

}
