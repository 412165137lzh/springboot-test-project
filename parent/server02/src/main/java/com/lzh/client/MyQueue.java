package com.lzh.client;

import java.util.Iterator;

public class MyQueue<T> implements Iterable<T> {
    public Item first;
    public Item last;
    int num = 0;

    public void enqueue(T t){
        Item item = new Item();
        item.data = t;
        if (num==0){
            first = item;
            last = item;
        }else {
            last.next = item;
            last = item;
        }
        num++;
    }

    public T dequeue() throws Exception {
        if (num==0){
            throw new Exception("队列数据为空,出列失败！");
        }else {
            T data = first.data;
            first = first.next;
            num--;
            return data;
        }
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }


    class Item{
        public Item next;
        public T data;
    }

    class MyIterator implements Iterator{
        Item item = first;
        int N = num;

        @Override
        public boolean hasNext() {
            return N!=0;
        }

        @Override
        public T next() {
            T data = item.data;
            item = item.next;
            N--;
            return data;
        }
    }

}
