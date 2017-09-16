package com.lqyhmb.test;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {

	/**
	 * �ж�time�Ƿ���now��n��֮��(�ж�ĳ��ʱ���Ƿ���������ʱ���n��֮��)
	 * 
	 * @param time
	 *            ָ��ʱ��
	 * @param now
	 *            ��ǰʱ��
	 * @param n
	 *            ������ʾ������ʱ��n��֮�󣬸�����ʾ������ʱ��n��֮ǰ
	 * @return
	 */
	public static boolean beloongDate(Date time, Date now, int n) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance(); // �õ���������
		calendar.setTime(now); // �ѵ�ǰʱ�丳ֵ����������
		calendar.add(Calendar.DAY_OF_MONTH, n);
		Date beforeDays = calendar.getTime(); // �õ�nǰ��ʱ��
		if (beforeDays.getTime() < time.getTime()) {
			return true;
		} else {
			return false;
		}
		

		// ��ӡ����
		/*
		 * Date time = stringToDate("2017-3-13");//stringתΪdate Date now = new
		 * Date();//ֱ��new���󣬻�ȡ���ǵ�ǰʱ��2017-3-16
		 * System.out.println(belongDate(time,now,-2));//2��ǰ
		 * System.out.println(belongDate(time,now,2));//2���
		 * System.out.println(belongDate(time,now,-6));//6��ǰ
		 */
	}

	/**
	 * �ж�time�Ƿ���from��to֮��(�ж�ĳ��ʱ���Ƿ�������������ʼʱ�������ʱ��֮��)
	 * 
	 * @param time
	 *            ָ������
	 * @param from
	 *            ��ʼ����
	 * @param to
	 *            ��������
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
		 * //��ӡ���� Date time1 = stringToDate("2017-3-11"); Date time2 =
		 * stringToDate("2017-3-15"); Date time3 = stringToDate("2017-3-17"); Date from
		 * = stringToDate("2017-3-12"); Date to= stringToDate("2017-3-16");
		 * System.out.println(belongCalendar(time1,from,to));
		 * System.out.println(belongCalendar(time2,from,to));
		 * System.out.println(belongCalendar(time3,from,to));
		 */ 
	}

	// �жϸ���ʱ���뵱ǰʱ����������
	public static long getDistanceDays(String date) {
		DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		long days = 0;
		try {
			Date time = dFormat.parse(date); // StringתDate
			Date now = new Date(); // ��ȡ��ǰʱ��
			long time1 = time.getTime();
			long time2 = now.getTime();
			long diff = time1 - time2;
			days = diff / (1000 * 60 * 60 * 24);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return days;// ������ʾ�ڵ�ǰʱ��֮�󣬸�����ʾ�ڵ�ǰʱ��֮ǰ
	}

}
