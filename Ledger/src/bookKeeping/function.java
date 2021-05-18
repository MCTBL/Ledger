package bookKeeping;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class function {
	ObjectInputStream in=null;
	ObjectOutputStream out=null;
	LinkedList<ledger> bookkeeping=null;
	final String DEFULTDIR="bookkeeping.txt";//为之后自定义文件保存写的
	File file=null;
	final DateFormat FORMAT=new SimpleDateFormat("yyyy-MM-dd");
	final DateFormat outFORMAT=new SimpleDateFormat("yyyy年MM月dd日");
	

	@SuppressWarnings("unchecked")
	public function() throws Exception{
		file=new File(DEFULTDIR);
		if(file.exists()==false) {
			file.createNewFile();
		}
		
		try {
			in=new ObjectInputStream(new FileInputStream(file));
			bookkeeping = (LinkedList<ledger>) in.readObject();
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
			if(bookkeeping==null) {
				bookkeeping=new LinkedList<ledger>();
			}
		}
		
	}
	
	
	//CRUD(Create, Read, Update and Delete)
	
	//C
	public void create(ledger newBook) {
		if(bookkeeping.size()==0) {
			bookkeeping.add(newBook);
		}else if(bookkeeping.getFirst().getDate().compareTo(newBook.getDate())>0) {
			bookkeeping.addFirst(newBook);
		}else if(bookkeeping.getLast().getDate().compareTo(newBook.getDate())<0) {
			bookkeeping.addLast(newBook);
		}else {//相等没处理
			for (ledger temp : bookkeeping) {
				if (temp.getDate().compareTo(newBook.getDate())==0) {
					System.out.println("该日期已有记账信息，如要修改请使用更改功能");
				}else if(temp.getDate().compareTo(newBook.getDate())>0) {
					int index = bookkeeping.indexOf(temp);
					bookkeeping.add(index, newBook);
				}
			}
		}
	}
	
	//R
	public void read(String date) {
		String temp=null;
		for(ledger i:bookkeeping) {
			temp=FORMAT.format(i.getDate());
			if(temp.equals(date)) {
				System.out.print(i);
				return;
			}
		}
		System.out.println("未查找到该日期的记账，请检查");
	}
	public void readAll() {
		for(ledger i:bookkeeping) {
			System.out.print(i);
		}
		System.out.println("输出完毕");
	}
	
	//U
	public void update(String date,double value,int v) {
		String temp=null;
		for(ledger i:bookkeeping) {
			temp=FORMAT.format(i.getDate());
			if(temp.equals(date)) {
				switch(v){
					case 0:
						i.setBreakfast(value);
						break;
					case 1:
						i.setLunch(value);
						break;
					case 2:
						i.setDinner(value);
						break;
				}
				System.out.println("信息已更新");
				return;
			}
		}
	}
	
	//D
	public void delete(String date) {
		String temp=null;
		for(ledger i:bookkeeping) {
			temp=FORMAT.format(i.getDate());
			if(temp.equals(date)) {
				bookkeeping.remove(bookkeeping.indexOf(i));
				System.out.println("已删除该日期的记账");
				return;
			}
		}
		System.out.println("未查找到该日期的记账，请检查");
	}
	public void deleteAll() {
		bookkeeping.removeAll(bookkeeping);
		System.out.println("已删除");
	}
	
	public void close() {
		try {
			out=new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(bookkeeping);
			System.out.println("保存完毕");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
