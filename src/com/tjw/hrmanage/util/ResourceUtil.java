package com.tjw.hrmanage.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ResourceUtil {
	private static ResourceBundle bundle = ResourceBundle.getBundle("properties.common");
	
	public static String getString(String key){
		String value=null;
		try {
			value= bundle.getString(key);
		}catch (MissingResourceException e) {
			//写日志
		}
		if(value==null){
			value="";
		}
		return value;
	}
	
	public static String getString(String key,String resourceBundle){
		ResourceBundle bundle = ResourceBundle.getBundle(resourceBundle);
		String value=null;
		try {
			value= bundle.getString(key);
		}catch (MissingResourceException e) {
			//写日志
		}
		if(value==null){
			value="";
		}
		return value;
	}
}
