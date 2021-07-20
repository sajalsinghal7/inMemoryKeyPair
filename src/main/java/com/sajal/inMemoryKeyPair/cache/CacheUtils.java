package com.sajal.inMemoryKeyPair.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class CacheUtils {
	@Value("${sajal.cache.life.hours}")
	private Long lifeInHour;
	@Value("${sajal.cache.life.minutes}")
	private Long lifeInMin;
	@Value("${sajal.cache.life.seconds}")
	private Long lifeInSec;
	
	public long getThresholdTime() {
		long result = 0L;
		result += lifeInHour*60L*60L;
		result += lifeInMin*60L;
		result += lifeInSec;
		result *=1000;
		return result;
	}

	public Long getLifeInHour() {
		return lifeInHour;
	}

	public void setLifeInHour(Long lifeInHour) {
		this.lifeInHour = lifeInHour;
	}

	public Long getLifeInMin() {
		return lifeInMin;
	}

	public void setLifeInMin(Long lifeInMin) {
		this.lifeInMin = lifeInMin;
	}

	public Long getLifeInSec() {
		return lifeInSec;
	}

	public void setLifeInSec(Long lifeInSec) {
		this.lifeInSec = lifeInSec;
	}
	
	
}
