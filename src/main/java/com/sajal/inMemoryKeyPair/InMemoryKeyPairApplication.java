package com.sajal.inMemoryKeyPair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sajal.inMemoryKeyPair.cache.CacheUtils;

@SpringBootApplication
public class InMemoryKeyPairApplication {

	public static void main(String[] args) {
		SpringApplication.run(InMemoryKeyPairApplication.class, args);
	}

	@Bean
	public CacheUtils getCacheUtils() {
		return new CacheUtils();
	}
}
