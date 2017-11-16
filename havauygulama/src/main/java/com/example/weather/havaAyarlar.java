package com.example.weather;

import java.util.Arrays;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@ConfigurationProperties("app.hava")
public class havaAyarlar {

	@Valid
	private final Api api = new Api();

	private List<String> locations = Arrays.asList("UK/London", "Istanbul/Turkey");

	public Api getApi() {
		return this.api;
	}

	public static class Api {


		@NotNull
		private String key;

		public String getKey() {
			return this.key;
		}

		public void setKey(String key) {
			this.key = key;
		}

	}

}
