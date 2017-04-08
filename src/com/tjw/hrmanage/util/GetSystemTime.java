package com.tjw.hrmanage.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:26:51
 * 2016.4
 */
 
public class GetSystemTime {

	public  Calendar now = Calendar.getInstance();
	public  int year = now.get(Calendar.YEAR);
	public  int month = now.get(Calendar.MONTH) + 1;
	public  int day = now.get(Calendar.DAY_OF_MONTH);
	public  int week = now.get(Calendar.DAY_OF_WEEK)-1;
	
	//年月
	public  String getYearMonth() {
		String today = year + "-" + (month<10?("0"+month):month);
		return today;
	}
	//年月日
	public  String getYearMonthDay() {
		String today = year + "-" + (month<10?("0"+month):month) + "-" + (day<10?("0"+day):day);
		return today;
		
	}
	//星期转换
	private  String weekTurn(int w){
		String [] str={"日","一","二","三","四","五","六"};
		return str[w];
	}
	//年月日星期
	public  String getYearMonthDayWithWeek(){
		String today = getYearMonthDay()+"&nbsp;&nbsp;星期"+weekTurn(week);
		return today;
	}
	//时分秒
	public  String getCurrentTime(){
		SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss"); 
		String current = fmt.format(new Date());
		return current;
	}
	//年月日时分秒
	public  String getYearMonthDayAndTime(){
		SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss"); 
		String current = fmt.format(new Date());
		String today = getYearMonthDay()+
		" "+getCurrentTime();
		return today;
	}
	//年月日星期时分秒
	public  String getYearMonthDayWithWeekAndTime(){
		SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss"); 
		String current = fmt.format(new Date());
		String today = getYearMonthDay()+
		"&nbsp;&nbsp;星期"+weekTurn(week)+"&nbsp;&nbsp;"+getCurrentTime();
		return today;
	}
	public  Date getNow(){
		return now.getTime();
	}
	/**获取当前日期，Date类型*/
	public  Date getToday(){
		String today = year + "-" + (month<10?("0"+month):month) + "-" + (day<10?("0"+day):day);
		return format2Date(today);
	}
	/**
	 * 转换字符串为日期类型
	 */
	public  Date format2Date(String str){
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
	public static  void main(String[] args) {
		System.out.println(new GetSystemTime().getYearMonthDayAndTime());
		System.out.println(new GetSystemTime().getNow());
	}
	

}
