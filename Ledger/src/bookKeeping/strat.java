package bookKeeping;

import java.util.*;

public class strat{

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		function Date=new function();
		Scanner inPut=new Scanner(System.in);
		int par=0,tempInt=-1;
		double tempDouble=0;
		String temp=null,temp2=null;
		System.out.println("====欢迎使用记账系统====");
		while(true) {
			System.out.println(" ==请选择你要使用的功能==");
			System.out.println("1:\t添加记账");
			System.out.println("2:\t查找记账");
			System.out.println("3:\t更改记账");
			System.out.println("4:\t删除记账");
			System.out.println("5:\t退出");
			par=inPut.nextInt();
			switch (par) {
			case 1:
				System.out.println("请输入日期，格式为yyyy-mm-dd");
				temp=null;
				do {
					temp=inPut.nextLine();
				}while(temp.equals(""));
				System.out.println("请输入早餐消费");
				double bre=inPut.nextDouble();
				System.out.println("请输入午餐消费");
				double lun=inPut.nextDouble();
				System.out.println("请输入晚餐消费");
				double din=inPut.nextDouble();
				Date.create(new ledger(temp,bre,lun,din));
				break;
			case 2:
				System.out.println("请问是输出所有还是指定日期");
				System.out.println("所有请输入1,否则直接输入日期");
				temp=inPut.next();
				if(temp.equals("1")) {
					Date.readAll();
				}else{
					Date.read(temp);
				}
				break;
			case 3:
				System.out.println("请输入你要修改的日期");
				temp=inPut.next();
				System.out.println("请问你要修改哪个消费");
				System.out.println("输入早，中，晚即可");
				while(true) {
					temp2=inPut.next();
					if(temp2.equals("早")) {
						tempInt=0;
						break;
					}else if(temp2.equals("中")) {
						tempInt=1;
						break;
					}else if(temp2.equals("晚")) {
						tempInt=2;
						break;
					}else {
						System.out.println("输入有误，请重新输入");
					}
				}
				System.out.println("请输入你要修改的金额");
				tempDouble=inPut.nextDouble();
				Date.update(temp, tempDouble, tempInt);
				
				
				break;
			case 4:
				System.out.println("请问是删除所有还是指定日期");
				System.out.println("所有请输入1,否则直接输入日期");
				temp=inPut.next();
				if(temp.equals("1")) {
					Date.deleteAll();
				}else{
					Date.delete(temp);
				}
				break;
			case 5:
				System.out.println("程序即将退出");
				inPut.close();
				Date.close();
				System.exit(0);
				break;
			}
			
			temp=null;
			temp2=null;
			tempInt=-1;
			tempDouble=0.0;
		}
		
		
	}

}
