package bookKeeping;

import java.io.Serializable;
import java.text.*;
import java.util.*;

@SuppressWarnings("serial")
public class ledger implements Serializable{
	private Date date=null;
	private double breakfast=0;
	private double lunch=0;
	private double dinner=0;
	final DateFormat FORMAT=new SimpleDateFormat("yyyy-MM-dd");
	final DateFormat outFORMAT=new SimpleDateFormat("yyyy年MM月dd日");
	
//	public book(String date) {
//		this.setDate(date);
//	}
	
	public ledger(String date,double bre,double lun,double din) {
		this.setDate(date);
		this.setBreakfast(bre);
		this.setLunch(lun);
		this.setDinner(din);
	}
	
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(String date) {
		try {
			this.date=FORMAT.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("输入日期有误，请重新输入，格式为yyyy-mm-dd");
		}
	}
	
	public double getBreakfast() {
		return breakfast;
	}
	
	public void setBreakfast(double breakfast) {
		this.breakfast = breakfast;
	}
	
	public double getLunch() {
		return lunch;
	}
	
	public void setLunch(double lunch) {
		this.lunch = lunch;
	}
	
	public double getDinner() {
		return dinner;
	}
	
	public void setDinner(double dinner) {
		this.dinner = dinner;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return (outFORMAT.format(this.date)+"\t早餐："+this.breakfast+"  午餐："+this.lunch+"  晚餐："+this.dinner+"\n");
	}
	
	
	
}
