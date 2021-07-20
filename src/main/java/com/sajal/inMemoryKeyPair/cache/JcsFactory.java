package com.sajal.inMemoryKeyPair.cache;

import org.apache.commons.jcs.JCS;
import org.apache.commons.jcs.access.CacheAccess;

public class JcsFactory {
	private static CacheAccess<String, CacheObject> cache;
	private JcsFactory() {
		//NA
	}
	public static CacheAccess<String, CacheObject> getCache() {
		if(cache == null) {
			synchronized (JcsFactory.class) {
				cache = JCS.getInstance("sajalCache");
			}
		}
		return cache;
	}
}
