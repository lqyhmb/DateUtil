package com.lqyhmb.test;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {

	/**
	 * 判断time是否在now的n天之内(判断某个时间是否是在条件时间的n天之内)
	 * 
	 * @param time
	 *            指定时间
	 * @param now
	 *            当前时间
	 * @param n
	 *            正数表示在条件时间n天之后，负数表示在条件时间n天之前
	 * @return
	 */
	public static boolean beloongDate(Date time, Date now, int n) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance(); // 得到日历对象
		calendar.setTime(now); // 把当前时间赋值给日历对象
		calendar.add(Calendar.DAY_OF_MONTH, n);
		Date beforeDays = calendar.getTime(); // 得到n前的时间
		if (beforeDays.getTime() < time.getTime()) {
			return true;
		} else {
			return false;
		}
		

		// 打印测试
		/*
		 * Date time = stringToDate("2017-3-13");//string转为date Date now = new
		 * Date();//直接new对象，获取的是当前时间2017-3-16
		 * System.out.println(belongDate(time,now,-2));//2天前
		 * System.out.println(belongDate(time,now,2));//2天后
		 * System.out.println(belongDate(time,now,-6));//6天前
		 */
	}

	/**
	 * 判断time是否在from，to之内(判断某个时间是否是在条件的起始时间与结束时间之内)
	 * 
	 * @param time
	 *            指定日期
	 * @param from
	 *            开始日期
	 * @param to
	 *            结束日期
	 * @return
	 */
	public static boolean beloongDate(Date time, Date from, Date to) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);

		Calendar after = Calendar.getInstance();
		after.setTime(from);

		Calendar berore = Calendar.getInstance();
		berore.setTime(to);

		if (calendar.after(after) && calendar.before(berore)) {
			return true;
		} else {
			return false;
		}

		/*
		 * //打印测试 Date time1 = stringToDate("2017-3-11"); Date time2 =
		 * stringToDate("2017-3-15"); Date time3 = stringToDate("2017-3-17"); Date from
		 * = stringToDate("2017-3-12"); Date to= stringToDate("2017-3-16");
		 * System.out.println(belongCalendar(time1,from,to));
		 * System.out.println(belongCalendar(time2,from,to));
		 * System.out.println(belongCalendar(time3,from,to));
		 */ 
	}

	// 判断给定时间与当前时间相差多少天
	public static long getDistanceDays(String date) {
		DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		long days = 0;
		try {
			Date time = dFormat.parse(date); // String转Date
			Date now = new Date(); // 获取当前时间
			long time1 = time.getTime();
			long time2 = now.getTime();
			long diff = time1 - time2;
			days = diff / (1000 * 60 * 60 * 24);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return days;// 正数表示在当前时间之后，负数表示在当前时间之前
	}

}
