package com.deloitte.localmemory;

import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LocalCache {
	
	private static LocalCache singleCopy= new LocalCache();
	
	ConcurrentMap<String,String> localCache = new ConcurrentHashMap<String,String>();
	
	private LocalCache(){
		
	}
	
	public static LocalCache getInstance()
	{
		return singleCopy;
	}
	
	public ConcurrentMap<String,String> setLocalCache(String encryptedName, String decryptedName){
		if(!(localCache.containsKey(encryptedName)))
		{
			localCache.put(encryptedName, decryptedName);
		}
		return localCache;
	}
	
	public String getDecryptedName(String nonEncryptedname)
	{
		return localCache.get(nonEncryptedname);
	}
	
	public String getEncryptedName(String encryptedName)
	{
		for (Entry<String, String> entry : localCache.entrySet()) {
	        if (Objects.equals(encryptedName, entry.getValue())) {
	            return entry.getKey();
	        }
	    }
		return null;
	}
	
	
	public boolean isPresent(String nonEncryptedName)
	{
		if(localCache.containsKey(nonEncryptedName)){
			return true;
		}
		return false;		
	}

}
