#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#define N 30  //30是因为可能怕数组越界
void rmb_units(int k);
void big_write_num(int l);
int main()
    {
        char c[N],*p;
        int a,i,j,len,len_integer=0,len_decimal=0;   //len_integer整数部分长度,len_decimal小数部分长度
        printf("please input (阿拉伯数字小写金额): ￥");
        scanf("%s",c);
        printf("/n/n");
        p=c;
        len=strlen(p);
        /*求出整数部分的长度*/
        for(i=0;i<=len-1 && *(p+i)<='9' && *(p+i)>='0';i++);
        if(*(p+i)=='.' || *(p+i)=='\0')   //*(p+i)=='/0'没小数点的情况
            len_integer=i;
        else
            {
               printf("\n\n Error: 输入有错误，整数部分含有错误的字符！\n\n");
               system("pause");
               
            }
        if(len_integer>9)
            {
               printf("超过范围，最大小于十亿！整数部分最多位！程序暂停\n");
               system("pause");
               printf("/n程序继续执行,注意：超过十亿部分只是简单读出数字的中文大写!!!\n\n");
            }
       
        printf("￥%s 的中文大写金额如下所示：\n\n人民币/RMB:",c);
        /*转换整数部分*/
        for(i=0;i<len_integer;i++)
            {
                a=*(p+i)-'0';
                if(a==0)
                    {
                        if(i==0)
                            {
                                if(*(p+1)!='.' && *(p+1)!='\0' && *(p+1)!='0')
                                    {
                                       printf("\n\n输入有错误！第一位为0而后整数部分有非字符，请检查！\n\n");
                                       system("pause");
                                       printf("\n程序继续执行,注意：整数部分的剩下部分将被忽略！\n\n");
                                    }
                                printf("零圆");
                                break;   //若第一个是则忽略其他整数部分
                            }
                        else if(*(p+i+1)!='0' && i!=len_integer-5 && i!=len_integer-1 && i!=len_integer-9)   //圆、万、亿位为时选择不加零                           {
                            {
                                 printf("零");
                                 continue;                           
                            }
                       
                        else if(i==len_integer-1 || i==len_integer-5 || i==len_integer-9)   //圆万亿单位不能掉
                            {
                                 rmb_units(len_integer+1-i);
                                 continue;
                            }
                        else
                                 continue;
                     }
               big_write_num(a);              //阿拉伯数字中文大写输出
                rmb_units(len_integer+1-i);   //人民币货币单位中文大写输出
           }
        /*求出小数部分的长度*/
        len_decimal=len-len_integer-1;
        if(len_decimal<0)
            {
                len_decimal=0;
                printf("整");   //或正
            }
        if(len_decimal>2)      //只取两位小数
                len_decimal=2;
        p=c;
        /*转换小数部分*/
        for(j=0;j<len_decimal;j++)    
            {
                a=*(p+len_integer+1+j)-'0';    //定位到小数部分，等价于a=*(p+len-len_decimal+j)-'0';
                if(a<0 || a>9)
                    {
                        printf("\n\n Error: 输入有错误，小数部分含有错误的字符！\n\n");
                        system("pause");
                        exit(EXIT_FAILURE);
                    }
                if(a==0)
                    {
                        if(j+1<len_decimal)
                         {
                             if(*(p+len_integer+j+2)!='0')      
                                printf("零");
                             else
                                {
                                 printf("整");
                                 break;
                                 }
                         }
                          continue;
                     }
                big_write_num(a);
                rmb_units(1-j);
            }
        printf("\n\n");
        system("pause");       
    }
    /*人民币货币单位中文大写输出*/
    void rmb_units(int k)
      {
         //相当于const char rmb_units[]="fjysbqwsbqisbqw";
         //"分角圆拾佰仟万拾佰仟亿拾佰仟万";
          switch(k)
              {
                   case 3:case 7:case 11: printf("拾");break;
                   case 4:case 8:case 12: printf("佰");break;
                   case 5:case 9:case 13: printf("仟");break;
                   case 6: case 14:       printf("万");break;
                   case 10:               printf("亿");break;
                   case 2:                printf("圆");break;
                   case 1:                printf("角");break;
                   case 0:                printf("分");break;
                   default:               break;
              }
      }
    /*阿拉伯数字中文大写输出*/
    void big_write_num(int l)
      {
        //相当于const char big_write_num[]="0123456789";
        //"零壹贰叁肆伍陆柒捌玖"
        switch(l)
             {
                  case 0:printf("零");break;
                  case 1:printf("壹");break;
                  case 2:printf("贰");break;
                  case 3:printf("叁");break;
                  case 4:printf("肆");break;
                  case 5:printf("伍");break;
                  case 6:printf("陆");break;
                  case 7:printf("柒");break;
                  case 8:printf("捌");break;
                  case 9:printf("玖");break;
                  default:break;
             }
      }
    
