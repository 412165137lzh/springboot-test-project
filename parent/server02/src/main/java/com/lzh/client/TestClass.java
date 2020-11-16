package com.lzh.client;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.Arrays;

public class TestClass {

    @Test
    public void test() throws Exception{
        File file = new File("test.png");
        System.out.println(file.exists());
    }

    /**
     * 3-sum代码(找出数组中3个数和为0的元组数量)
     * @throws Exception
     */
    @Test
    public void test06() throws Exception{
        FileReader numReader = new FileReader("src\\main\\resources\\test_file\\2Kints.txt");
        LineNumberReader lineNumberReader = new LineNumberReader(numReader);
        lineNumberReader.skip(Long.MAX_VALUE);
        int lineNumber = lineNumberReader.getLineNumber()+1;

        FileReader fileReader = new FileReader("src\\main\\resources\\test_file\\2Kints.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str = "";
        int[] ints = new int[lineNumber];
        int N= 0;
        while ((str = bufferedReader.readLine())!=null){
            ints[N] =Integer.parseInt(str.trim());
            N++;
        }

        int num = 0;
        long begin = System.currentTimeMillis();

        //方式1
        for(int i=0;i<N;i++){
            for (int j=i+1;j<N;j++){
                for (int k=j+1;k<N;k++){
                    if (ints[i]+ints[j]+ints[k]==0){
                        num++;
                    }
                }
            }
        }

        //方式2
        /*Arrays.sort(ints);
        for(int i=0;i<N;i++){
            for (int j=i+1;j<N;j++){
                if (this.rank(ints,-(ints[i]+ints[j]))>j){
                    num++;
                }
            }
        }*/

        long end = System.currentTimeMillis();
        System.out.println("和为0的组合数量为："+num+"耗时："+((end-begin)/1000.0)+"s");


    }

    /**
     * 2-sum代码(找出数组中2个数和为0的元组数量)
     * @throws Exception
     */
    @Test
    public void test05() throws Exception{
        FileReader numReader = new FileReader("src\\main\\resources\\test_file\\32Kints.txt");
        LineNumberReader lineNumberReader = new LineNumberReader(numReader);
        lineNumberReader.skip(Long.MAX_VALUE);
        int lineNumber = lineNumberReader.getLineNumber()+1;

        FileReader fileReader = new FileReader("src\\main\\resources\\test_file\\32Kints.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str = "";
        int[] ints = new int[lineNumber];
        int N= 0;
        while ((str = bufferedReader.readLine())!=null){
            ints[N] =Integer.parseInt(str.trim());
            N++;
        }

        long begin = System.currentTimeMillis();
        int num = 0;
//        //方式1
//        for (int i=0;i<N;i++) {
//            for (int j=i+1;j<N;j++){
//                if (ints[i]+ints[j]==0){
//                    System.out.println(ints[i]);
//                    num++;
//                }
//            }
//        }

        //方式2
        Arrays.sort(ints);
        for (int i=0;i<N;i++) {
            if (this.rank(ints,-ints[i])>i){
                System.out.println(ints[i]);
                num++;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("和为0的组合数量为："+num+"耗时："+((end-begin)/1000.0)+"s");


    }

    @Test
    public void test04() throws Exception{

        int[] ints = {0,1,2,3,5};
        Arrays.sort(ints);
        System.out.println(rank(ints,0));
        System.out.println(rank(ints,1));
        System.out.println(rank(ints,2));
        System.out.println(rank(ints,3));
        System.out.println(rank(ints,5));
        System.out.println(rank(ints,8));
        System.out.println(rank(ints,4));
        System.out.println(rank(ints,-1));
    }

    public int rank(int[] arr,int i){
//        Arrays.sort(arr);
        int begin = 0;
        int end = arr.length-1;
        while(begin<=end){
            int ave = (begin + end) / 2;
            if (i == arr[ave]){
                return ave;
            }else if (i<arr[ave]){
                end = ave-1;
            }else if (i>arr[ave]){
                begin = ave+1;
            }
        }
        //代表没有找到
        return -1;

    }







    @Test
    public void test03() throws Exception{
        FileReader fileReader = new FileReader("src\\main\\resources\\test_file\\4Kints.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str = "";
        Long[] longs = new Long[32000];
        int N= 0;
        while ((str = bufferedReader.readLine())!=null){
            longs[N] = Long.parseLong(str.trim());
            N++;
        }

        long begin = System.currentTimeMillis();
        int num = 0;
        for(int i=0;i<N;i++){
            for (int j=i+1;j<N;j++)
                for (int k=j+1;k<N;k++)
                    if (longs[i]+longs[j]+longs[k] == 0)
                        num++;
        }
        long end = System.currentTimeMillis();
        System.out.println("和为0的组合数量为："+num+"耗时："+((end-begin)/1000.0)+"s");
    }


    @Test
    public void test02() throws Exception{
        MyStack<String> stringMyStack = new MyStack<>();
        stringMyStack.push("A");
        stringMyStack.push("B");
        stringMyStack.push("C");

        for (Object o : stringMyStack) {
            System.out.println("遍历数据"+o);
        }

        System.out.println("pop："+stringMyStack.pop());

        stringMyStack.push("1");
        stringMyStack.push("2");
        stringMyStack.push("3");

        for (Object o : stringMyStack) {
            System.out.println("遍历数据"+o);
        }
    }


    @Test
    public void test01() throws Exception {
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        for (String s : queue) {
            System.out.println("遍历数据"+s);
        }

        System.out.println("dequeue："+queue.dequeue());

        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");

        for (String s : queue) {
            System.out.println("遍历数据"+s);
        }
    }

}
