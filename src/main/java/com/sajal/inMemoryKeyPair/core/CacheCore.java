package com.sajal.inMemoryKeyPair.core;

import org.apache.commons.jcs.access.CacheAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sajal.inMemoryKeyPair.cache.CacheObject;
import com.sajal.inMemoryKeyPair.cache.CacheUtils;
import com.sajal.inMemoryKeyPair.cache.JcsFactory;
import com.sajal.inMemoryKeyPair.utils.ExpiredCacheFactory;

@Service
public class CacheCore {
	public static final CacheAccess<String, CacheObject> cache = JcsFactory.getCache();
	public static Integer sum = 0;
	public static Integer counter = 0;
	@Autowired
	CacheUtils cacheUtils;
	
	public synchronized CacheObject getData(String key) {
		CacheObject result = cache.get(key);
		if(result !=null && isObjectExpired(result)) {
			counter--;
			sum -= result.getValue();
			persistExpired(key, result);
			evictFromCache(key);
			result = null;
		}
		return result;
	}
	public synchronized CacheObject putData(String key, Integer value) {
		CacheObject obj = new CacheObject(value);
		CacheObject ref = cache.get(key);
		if(ref != null) {
			counter--;
			sum -= ref.getValue();
			evictFromCache(key);
		}
		cache.put(key, obj);
		counter++;
		sum+=value;
		return obj;
	}
	public synchronized void evictFromCache(String key) {
		cache.remove(key);
	}
	public static synchronized int getAverage() {
		if(counter == 0) return 0;
		int result;
		result = sum/counter;
		return result;
	}
	public boolean isObjectExpired(CacheObject cacheObject) {
		Long currentTime = System.currentTimeMillis();
		Long threshold = cacheUtils.getThresholdTime();
		if(cacheObject.getObjectCreatingTime() + threshold <= currentTime) return true;
		return false;
	}
	public void persistExpired(String key, CacheObject cacheObject) {
		ExpiredCacheFactory factory = ExpiredCacheFactory.build("text");
		factory.append(key + ":" + cacheObject.getValue());
	}
}
