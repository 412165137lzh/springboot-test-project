package com.lzh.client;

import java.util.Iterator;

/**
 * 栈数据（使用单向链表实现）
 * @param <T>
 */
public class MyStack<T> implements Iterable {

    Item first;
    int num = 0;

    public void push(T t){
        Item item = new Item();
        item.data = t;
        if (num==0){
            first = item;
        }else {
            item.next = first;
            first = item;
        }
        num++;
    }

    public T pop() throws Exception {
        if (num==0){
            throw new Exception("栈数据为空,弹栈失败！");
        }else {
            Item item = first;
            first = first.next;
            num--;
            return item.data;
        }
    }

    public boolean isEmpty(){
        return num==0;
    }

    public int size(){
        return num;
    }

    /***
     * 注意，每次使用foreach遍历，系统都会调用一次该方法，也就是每次的迭代器都是最新的！
     * 所以不用担心item和N不是最新的
     * @return
     */
    @Override
    public Iterator<T> iterator() {
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
            N--;
            item = item.next;
            return data;
        }
    }

}

