package com.example.taxBoisson.service.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Date constructDate(int trim,int annee) {
		Date date = new Date();
		date.setDate(1);
		date.setYear(annee-1900);
		if(trim==1) {
			date.setMonth(3);
		}else if(trim==2) {
			date.setMonth(6);
		}
		else if(trim==3) {
			date.setMonth(9);
		}
		else if(trim==4) {
			date.setYear(date.getYear()+1);
			date.setMonth(0);
		}
		return date;
	}
	
	public static int calcDiffMois(int trim,int annee,Date date) {
		Date dateFinTrim=constructDate(trim, annee);
		return (int)((date.getTime()-dateFinTrim.getTime())/1000/60/60/24/30);
	}   

	public static int getDiff(int trimMin , int trimMax, int anneeMin, int anneeMax) {
		if(anneeMin == anneeMax) {
			return trimMax-trimMin;
		}else {
			return (trimMax+ (anneeMax-anneeMin)*12)-trimMin;
		}
	}
	public static int getAnneeFromDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);
	
	}
	public static int getTrimFormDate(Date date) {
		int month = date.getMonth();
		if(month<3 && month>0) {
			return 1;
		}else if(month<6 && month>3) {
			return 2;
		}else if(month<9 && month>6) {
			return 3;
		}else {
			return 4;
		}
	}
}
