package fundamentals.programmingmodel.test;

import java.io.*;

public class SimpleCal  {

        String Cal(int i) {
            i = (3*i + 7)%11;
            String result = Integer.toBinaryString(i);
            return result;
        }

        public static void main(String args[]) { // NOTE �����в���д��
         //   if (args.length < 1 ) { //NOTE �ж������в����ĸ���������java��args�ǲ�����������ġ��������args��0��ʼ���㡣��C++�е������в�����������������argc��1��ʼ���㡣
         //       System.out.println("There should be one parameter.");  
         //       return;
         //   }
            SimpleCal sc = new SimpleCal(); //���ɵ�ǰ��SimpleCal�Ķ��󣬵Ȼ���ڵ�ǰ��main������ʹ�á�
            BufferedReader in; //���ļ����ࡣ
            String str;
            String arr[]; //�ַ�������
           // int intarr[]; //��������
            int tmp;
            File file=new File("F://Java//Algorithms//algs4-data//tale.txt");
            try { //�ٶ��ļ�����������ʹ��try {...}catch(){...}���������ûдtry catch�����뽫����
                in = new BufferedReader(new FileReader(file)); //�ڵ�һ�㣬FileReader���ڶ���BufferedReader��
                while ((str = in.readLine()) !=  null) { //�۹̶�����: ��readLine()��һ�е�String.
                   // System.out.println("\n\n" + str); 
                    arr = str.split(",");//�ܰѶ���һ�н���tokenize, �������String[] array�С�
                    for (String each : arr) { //������for each ��䣬��������String each��������������ɣ��ᵽǰ��ᱨ��
                        System.out.print(each+" ");
                          //   each = each.replaceAll(" +", ""); //��replaceAllȥ��ͷβ�ո�
                      //  tmp = Integer.parseInt(each); //��String To Int
                       // System.out.format("%d->%s\n",tmp, sc.Cal(tmp)); //���ʽ�������
                    }
                }
            } catch (IOException e) { //�쳣: IOException
                System.out.println("IO file Exeption"); 
            }
        }
}
