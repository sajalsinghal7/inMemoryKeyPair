package com.sajal.inMemoryKeyPair.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sajal.inMemoryKeyPair.cache.CacheObject;
import com.sajal.inMemoryKeyPair.core.CacheCore;
import com.sajal.inMemoryKeyPair.core.GetResponse;
import com.sajal.inMemoryKeyPair.core.PutRequest;

@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class CacheController {

	@Autowired
	CacheCore cacheCore;
	
	@RequestMapping(value = ControllerList.GET_CACHE_VALUE, method = RequestMethod.GET)
	public CacheObject getCacheData(@PathVariable String key) {
		CacheObject ref = cacheCore.getData(key);
		return ref;
	}
	

	@RequestMapping(value = ControllerList.GET_CACHE_AVERAGE, method = RequestMethod.GET)
	public Integer getCacheAverage() {
		Integer ref = CacheCore.getAverage();
		return ref;
	}
	

	@RequestMapping(value = ControllerList.CREATE_CACHE_OBJECT, method = RequestMethod.POST)
	public CacheObject createCacheObject(@Validated @RequestBody PutRequest req) {
		CacheObject ref = cacheCore.putData(req.getKey(), req.getValue());
		return ref;
	}
}
