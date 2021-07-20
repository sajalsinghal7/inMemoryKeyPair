package com.sajal.inMemoryKeyPair.cache;

public class CacheObject	 {
	private Long objectCreatingTime = System.currentTimeMillis();
	private Integer value;
	public CacheObject(Integer obj) {
		// TODO Auto-generated constructor stub
		value = obj;
	}

	public Long getObjectCreatingTime() {
		return objectCreatingTime;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
	
	
}
