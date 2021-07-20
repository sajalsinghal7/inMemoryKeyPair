package com.sajal.inMemoryKeyPair.utils;

public class ExpiredCacheFactory {
	public void append(String data) {
		// NA
	}
	public static ExpiredCacheFactory build(String type) {
		ExpiredCacheFactory res = null;
		switch (type) {
		case "text":
			res = new FileStorageUtil();
			break;
		case "db":
			// res = datasource
			break;
		default:
			res = new FileStorageUtil();
			break;
		}
		return res;
	}
}
