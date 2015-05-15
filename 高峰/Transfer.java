package breeze;
public class Transfer {
	private int fen,jiao,yuan,shi,bai,qian,wan,shiwan;
	private static int flag=0;
	String[] chinese =new String[]{"��", "Ҽ", "��", "��", "��", "��", "½", "��", "��", "��"}; 
	String zhengshu[] = {"Ԫ", "ʰ", "��", "Ǫ", "��"};
	String xiaoshu[]={"��", "��"};
	/**
	 * ���Գ���Ŀ�����
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("\n--------������ת�������Ľ��Ĵ�д��ʽ------------\n");
		Transfer t2r = new Transfer();
		String s = t2r.splitNum(t2r.getNum());
		// ���ת��������һ���մ����������Ļ
		if(!"".equals(s)) {
			if(flag==0)
			    System.out.println("��������Ϊ��" + s);
			else
				{System.out.print("��������Ϊ���֣���");
				System.err.println( s);}                        //��ֵ��Ϊ���֣��ú�ɫ������ʾ
		}
	}

	/**	
	 * �������н���һ�����������е��� checkNum() �����������
	 * ��֤����������Ӧ��ֵ
	 * @return �������Ϸ�����������������
	 */
	private String getNum() {
		String s = null;
		System.out.println("������һ�����֣�");
		// ���������������������
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		s = scanner.next();
		// �ر����Scanner
		scanner.close();
		// �ж��û������Ƿ�Ϸ�
		// ���Ϸ����������ֵ�����Ƿ����� "0"
		if(this.checkNum(s)) {
			return s;
		} else {
			return "";
		}
	}
	
	/**
	 * �ж��û�����������Ƿ�Ϸ����û�ֻ���������������֣��������������ַ�
	 * 
	 * @return ����û��������ݺϷ������� true�����򷵻� false
	 */
	private boolean checkNum(String s) {
		// ����û�����������з������ַ�������Ϊ�Ƿ����ݣ����� false
		try {
			double f = Double.valueOf(s);
			if(-99999.99<=f&&f<=-0.01) {
				flag = 1;	//��¼����ĸ�ֵ
				//System.out.println("flagΪ��" +flag);
				return true;				
			}
			else if(0.01<=f&&f<=99999.99)
			{
				return true;
			}
			else if(f==0){
				System.out.println("����Ϊ0�����������룡");
				return false;				
			}
			else
			{
				System.out.println("������Ʊ����޶���������룡");
				return false;
			}
		} catch (NumberFormatException e) {
			System.out.println("�Ƿ����ݣ����飡");
			return false;
		}	
	}
	
	/**
	 * ���û����������С����Ϊ��ָ���������� numFormat() ����
	 * ������Ӧ�����Ľ���д��ʽ��ת��
	 * @param s String
	 * @return ת���õ����Ľ���д��ʽ���ַ���
	 */
	private String splitNum(String s) {
		// ���������ǿմ���������ؿմ�
		if("".equals(s)) {
			return "";
		}		
		double f = Double.parseDouble(s);
		if(flag == 1)
			f = -f;//���������Ǹ�������תΪ����
		s = new java.text.DecimalFormat("#0.00").format(f);
		// ��С����Ϊ��ָ�����ַ���
				int index = s.indexOf(".");
				// ��ȡ��ת�����������������
				//System.out.println("SΪ��" +s);
				String intOnly = s.substring(0, index);
				//System.out.println("��������Ϊ��" +intOnly);
				String part1 = this.numFormat(intOnly,zhengshu,1);
				
				// ��ȡ��ת���������С������
				String smallOnly = s.substring(index + 1);
				//System.out.println("xiaoshu����Ϊ��" +smallOnly);
				String part2 = this.numFormat(smallOnly,xiaoshu,0);
				
				// ��ת�����˵��������ֺ�С����������ƴ��һ���µ��ַ���
				String newS = part1 + part2;
				return newS;
				//return s;

	}
private String numFormat(String s,String s1[],int f) {
	// ���Ҵ�д��ʽ
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
			   //k=1;//�ж��������������Ƿ����λ����λ��ʮλ����Ϊ0
	       for(int i = sLength-2; i >= 0; i --)
	       {		
		       if(s.charAt(i) - 48!=0)			
		       newS = chinese[s.charAt(i)-48]+ s1[sLength - i - 1] + newS;
		       else if(s.charAt(i-1) - 48!=0&&s.charAt(i) - 48==0)
		    	   {
		    	   for(int j=sLength-1;j>=i;j--)	    	   
		    		   if(s.charAt(j) - 48!=0)
		    		    k=1;//�жϴ�λ����λ֮���Ƿ�ȫΪ0
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
		newS =  newS;//ȥ��С����λΪ0������ת��
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