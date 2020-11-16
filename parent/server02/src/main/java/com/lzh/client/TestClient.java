package com.lzh.client;

import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestClient {

    int a = 10;
    public final int[] arr;

//    public TestClient(){};

    public TestClient(int[] arr){
        this.arr = arr;
    }

    public void test(){
        int a = 20;
        System.out.println(a);
        System.out.println(this.a);

    }

    @Override
    public String toString() {
        String message = "";
        for (int i : arr) {
            message = message + i + " ";
        }
        return message;
    }

    public static void main(String[] args) {
        /*int[] arr = {1,2,3};
        int[] arr2 = {1,2,3};

        TestClient testClient = new TestClient(arr);
        System.out.println(testClient);
        testClient.arr[0] = 100;
        arr[1] = 200;
        System.out.println(testClient);

//        testClient.arr =arr2;*/




        /*String str = "2.5*4+(2*5)";
        Pattern p;
        Matcher m;
        p = Pattern.compile("\\+|\\-|\\*|\\/|\\(|\\)");
        m = p.matcher(str);
        while(m.find()){
            System.out.println(m.group());
        }
        p = Pattern.compile("\\d+(\\.\\d+)*");
        m = p.matcher(str);
        while(m.find()){
            System.out.println(m.group());
        }*/


        /*String str2 = "2.5*4+(2*5)";
        Pattern p2;
        Matcher m2;
        p2 = Pattern.compile("\\+|\\-|\\*|\\/|\\(|\\)|\\d+(\\.\\d+)*");
        m2 = p2.matcher(str2);
        while(m2.find()){
            System.out.println(m2.group());
        }*/

       /* String str = "-2.5";
        System.out.println(str.matches("^(\\-|\\+)?\\d+(\\.\\d+)?$"));*/

//        String calculation = "(1+((2+3)*(4*5)))";
        String calculation = "(1-((2-3)*(4*5)))";
        Stack<Double> doubles = new Stack<>();
        Stack<String> strings = new Stack<>();

        Pattern p;
        Matcher m;
        p = Pattern.compile("\\d+(\\.\\d+)*|\\+|\\-|\\*|\\/|\\(|\\)");
        m = p.matcher(calculation);
        while (m.find()){
            String data = m.group();
            //如果是数字，那么将数字放入数字栈(使用正则表达式，匹配正数负数小数)
            if (data.matches("^(\\-|\\+)?\\d+(\\.\\d+)?$")) doubles.push(new Double(data));
            //匹配加减乘除
            else if (data.matches("^(\\+|\\-|\\*|\\/)$")) strings.push(data);
            //匹配右括号
            else if (data.equals(")")) {
                String pop = strings.pop();
                Double back = doubles.pop();
                Double front = doubles.pop();
                if (pop.equals("+")) doubles.push(front + back);
                if (pop.equals("-")) doubles.push(front - back);
                if (pop.equals("*")) doubles.push(front * back);
                if (pop.equals("/")) doubles.push(front / back);
            }
        }
        System.out.println(calculation+"的结果是："+doubles.pop());

        Fanxing<String> stringFanxing = new Fanxing<>(10);
        System.out.println(stringFanxing);

        Object[] objects = new Object[10];
        objects[0]=new Fanxing<String>(10);
        Fanxing f = (Fanxing) objects[0];
        objects[0] = null;
        System.out.println(f);

    }

}

class Fanxing<T1> {

    private T1[] data;
    private T1 data2;


    public Fanxing(int cap){
        data = (T1[])new Object[cap];
        data2 = (T1)new Object();
    }

    @Override
    public String toString() {
        return "Fanxing{" +
                "data=" + Arrays.toString(data) +
                ", data2=" + data2 +
                '}';
    }
}
