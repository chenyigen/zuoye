#include <stdio.h>  
#include <stdlib.h>  
#include <wchar.h>  
#include <locale.h>  
#include <math.h>
  
wchar_t cstrs[10];  
wchar_t bit[10];  
  
int main()  
{  double innum;
 int k=0; int tmp=1;  
  int e, ee, t=0;  
  long et; 
  char ch;
    cstrs[0]=0x96F6;cstrs[1]=0x58F9;cstrs[2]=0x8D30;  
    cstrs[3]=0x53C4;cstrs[4]=0x8086;cstrs[5]=0x4F0D;  
    cstrs[6]=0x9678;cstrs[7]=0x67D2;cstrs[8]=0x634C;  
    cstrs[9]=0x7396;  
    bit[0]=0x5706;bit[1]=0x62FE;bit[2]=0x4F70;  
    bit[3]=0x4EDF;bit[4]=0x842C;bit[5]=0x62FE;  
    bit[6]=0x4F70;bit[7]=0x4EDF;bit[8]=0x5104;  
    bit[9]=0x62FE;bit[10]=0x4F70;bit[11]=0x4EDF;  
    bit[12]=0x842C;  
  
    setlocale(LC_ALL, "");  
    
   
  
    scanf("%lf", &innum);  
if (innum>=-9999.99 && innum<=9999.99)	
{
	if(innum<0)
   { printf("欠款");
     innum=abs(innum);
   }
		while(tmp<innum){  
    k+=1; tmp*=10;  
    }  
    if(tmp>innum){k--; tmp=tmp/10;}  
    if(k<0){k=0, tmp=1;}  
    e=(int)innum;  
    while(e>=1){  
    ee = (int)e/tmp;  
        if(ee!=0){  
        if(t){  
        printf("%lc",cstrs[0]);  
        t=0;  
        }  
        printf("%lc", cstrs[ee]);  
        printf("%lc", bit[k]);  
    } else {  
        t=1;  
        if(k==8 || k==4)printf("%lc",bit[k]);  
    }  
    k--; e=e%tmp; tmp=tmp/10;  
    }  
     
    et=(long)(innum*10); printf("%lc%lc",cstrs[et%10], 0x89D2);  
    et=(long)(innum*100); printf("%lc%lc",cstrs[et%10], 0x5206);  
  
    puts("");  
    
	ch=getch();
	 return 0; 
}
else
	printf("输入的数值有误");
   
	ch=getch();
	 return 0; 
}  