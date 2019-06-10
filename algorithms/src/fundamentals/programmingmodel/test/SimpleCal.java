package fundamentals.programmingmodel.test;

import java.io.*;

public class SimpleCal  {

        String Cal(int i) {
            i = (3*i + 7)%11;
            String result = Integer.toBinaryString(i);
            return result;
        }

        public static void main(String args[]) { // NOTE 命令行参数写法
         //   if (args.length < 1 ) { //NOTE 判断命令行参数的个数。另外java中args是不包括程序本身的。所以如果args从0开始计算。而C++中的命令行参数包括程序本身，所以argc从1开始计算。
         //       System.out.println("There should be one parameter.");  
         //       return;
         //   }
            SimpleCal sc = new SimpleCal(); //生成当前类SimpleCal的对象，等会儿在当前的main函数中使用。
            BufferedReader in; //读文件的类。
            String str;
            String arr[]; //字符串数组
           // int intarr[]; //整数数组
            int tmp;
            File file=new File("F://Java//Algorithms//algs4-data//tale.txt");
            try { //①读文件的整个流程使用try {...}catch(){...}包裹。如果没写try catch，编译将报错。
                in = new BufferedReader(new FileReader(file)); //②第一层，FileReader，第二层BufferedReader。
                while ((str = in.readLine()) !=  null) { //③固定搭配: 用readLine()读一行到String.
                   // System.out.println("\n\n" + str); 
                    arr = str.split(",");//④把读的一行进行tokenize, 结果放入String[] array中。
                    for (String each : arr) { //⑤类似for each 语句，变量声明String each必须在括号中完成，提到前面会报错。
                        System.out.print(each+" ");
                          //   each = each.replaceAll(" +", ""); //⑥replaceAll去掉头尾空格。
                      //  tmp = Integer.parseInt(each); //⑦String To Int
                       // System.out.format("%d->%s\n",tmp, sc.Cal(tmp)); //⑧格式化输出。
                    }
                }
            } catch (IOException e) { //异常: IOException
                System.out.println("IO file Exeption"); 
            }
        }
}
