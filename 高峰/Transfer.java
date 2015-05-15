package breeze;
public class Transfer {
	private int fen,jiao,yuan,shi,bai,qian,wan,shiwan;
	private static int flag=0;
	String[] chinese =new String[]{"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"}; 
	String zhengshu[] = {"元", "拾", "佰", "仟", "万"};
	String xiaoshu[]={"分", "角"};
	/**
	 * 测试程序的可行性
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("\n--------将数字转换成中文金额的大写形式------------\n");
		Transfer t2r = new Transfer();
		String s = t2r.splitNum(t2r.getNum());
		// 如果转换过后是一个空串，则不输出屏幕
		if(!"".equals(s)) {
			if(flag==0)
			    System.out.println("您输入金额为：" + s);
			else
				{System.out.print("您输入金额为赤字：：");
				System.err.println( s);}                        //负值作为赤字，用红色字体显示
		}
	}

	/**	
	 * 从命令行接收一个数，在其中调用 checkNum() 方法对其进行
	 * 验证，并返回相应的值
	 * @return 如果输入合法，返回输入的这个数
	 */
	private String getNum() {
		String s = null;
		System.out.println("请输入一个数字：");
		// 从命令行输入这个浮点数
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		s = scanner.next();
		// 关闭这个Scanner
		scanner.close();
		// 判断用户输入是否合法
		// 若合法，返回这个值；若非法返回 "0"
		if(this.checkNum(s)) {
			return s;
		} else {
			return "";
		}
	}
	
	/**
	 * 判断用户输入的数据是否合法，用户只能输入大于零的数字，不能输入其它字符
	 * 
	 * @return 如果用户输入数据合法，返回 true，否则返回 false
	 */
	private boolean checkNum(String s) {
		// 如果用户输入的数里有非数字字符，则视为非法数据，返回 false
		try {
			double f = Double.valueOf(s);
			if(-99999.99<=f&&f<=-0.01) {
				flag = 1;	//记录输入的负值
				//System.out.println("flag为：" +flag);
				return true;				
			}
			else if(0.01<=f&&f<=99999.99)
			{
				return true;
			}
			else if(f==0){
				System.out.println("金额不能为0，请重新输入！");
				return false;				
			}
			else
			{
				System.out.println("金额超出发票最大限额，请重新输入！");
				return false;
			}
		} catch (NumberFormatException e) {
			System.out.println("非法数据，请检查！");
			return false;
		}	
	}
	
	/**
	 * 把用户输入的数以小数点为界分割开来，并调用 numFormat() 方法
	 * 进行相应的中文金额大写形式的转换
	 * @param s String
	 * @return 转换好的中文金额大写形式的字符串
	 */
	private String splitNum(String s) {
		// 如果传入的是空串则继续返回空串
		if("".equals(s)) {
			return "";
		}		
		double f = Double.parseDouble(s);
		if(flag == 1)
			f = -f;//如果输入的是负数，则转为正数
		s = new java.text.DecimalFormat("#0.00").format(f);
		// 以小数点为界分割这个字符串
				int index = s.indexOf(".");
				// 截取并转换这个数的整数部分
				//System.out.println("S为：" +s);
				String intOnly = s.substring(0, index);
				//System.out.println("整数部分为：" +intOnly);
				String part1 = this.numFormat(intOnly,zhengshu,1);
				
				// 截取并转换这个数的小数部分
				String smallOnly = s.substring(index + 1);
				//System.out.println("xiaoshu部分为：" +smallOnly);
				String part2 = this.numFormat(smallOnly,xiaoshu,0);
				
				// 把转换好了的整数部分和小数部分重新拼凑一个新的字符串
				String newS = part1 + part2;
				return newS;
				//return s;

	}
private String numFormat(String s,String s1[],int f) {
	// 货币大写形式
	String newS="";
	int sLength=s.length();
	if(f==1)
	{
		if(Integer.parseInt(s)!=0)
		{
	       if(s.charAt(sLength-1) - 48==0)
	          newS = s1[0]+newS;
	       else 
		      newS = chinese[s.charAt(sLength-1)-48] +  s1[0] + newS;	
	   	int k=0;
		//if(s.charAt(sLength-1) - 48==0&&s.charAt(sLength-2) - 48==0)
			   //k=1;//判断数字整数部分是否后两位（个位和十位）均为0
	       for(int i = sLength-2; i >= 0; i --)
	       {		
		       if(s.charAt(i) - 48!=0)			
		       newS = chinese[s.charAt(i)-48]+ s1[sLength - i - 1] + newS;
		       else if(s.charAt(i-1) - 48!=0&&s.charAt(i) - 48==0)
		    	   {
		    	   for(int j=sLength-1;j>=i;j--)	    	   
		    		   if(s.charAt(j) - 48!=0)
		    		    k=1;//判断此位到个位之间是否全为0
		    	   if(k==1)
		    	   newS = chinese[s.charAt(i)-48] + newS;
		    	   else newS = newS;
		    		   
	               }
		       else newS = newS;
	       }
	    }
		else newS =  newS;
	}
	else if(f==0)
	{
		for(int i = sLength-1; i >= 0; i --) {	
		if(s.charAt(i) - 48!=0)						
		newS = chinese[s.charAt(i)-48]+ s1[sLength - i - 1] + newS;
		newS =  newS;//去除小数部位为0的数字转换
		}
	}
	return newS;
}
}

/*
 * if(s.charAt(i) - 48==0)			
 
	newS =  newS;
newS = newS + chinese[s.charAt(i)-48]+ s1[sLength - i] ;
*/