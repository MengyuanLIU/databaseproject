package com.tjw.hrmanage.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:26:42
 * 2016.4
 */

public class ChangeTimeType {
	/**
	 * 转换字符串为日期类型
	 * @return
	 */
	public static Date changeToDate(String str){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d=null;
		if(str==""||str==null){
			return null;
		}
		try {
			 d = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	public static void main(String[] args) {
		Date dd = ChangeTimeType.changeToDate("2008-05-11");
		System.out.println(dd);
		
	}
	/**
	 * 转换日期类型为字符串类型
	 * @return
	 */
	public static String changeToStr(Date d){
		return null;
	}
}
