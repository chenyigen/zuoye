package shnu.sunfei.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import shnu.sunfei.demo.MoneyFormat;

public class Main {

	public static void main(String[] args) throws Exception {
	     System.out.print("请输入发票的开票金额：");
	     
	     BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
	     
	     String amountOfMoney =bufr.readLine();
	     if(Double.parseDouble(amountOfMoney)>=0&&(Double.parseDouble(amountOfMoney)<=99999.99)){
	    	 
	    	 MoneyFormat mf = new MoneyFormat();
	   
	    	 String result = mf.format(amountOfMoney);
	    	 
	    	 System.out.println(result); 
			 System.out.println("开票成功");
	     }else{
	    	 System.out.println("对不起，您的金额不在开票范围之内");
	     }     
	     
	}

}
