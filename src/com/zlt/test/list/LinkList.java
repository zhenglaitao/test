package com.zlt.test.list;

import java.util.Iterator;

public class LinkList<E> {
	private Entry<E> header = new Entry<E>(null);   //表头为空
    private Entry<E> tail = null; //表尾
    private Entry<E> another = null;  //用于操作各节点的节点变量
    private int size = 0;   //节点数目
     
    public void add(E element) {    //添加一个元素（在表尾添加新元素）
        Entry<E> newEntry = new Entry<E>(element);
        if(size == 0) { 
            tail = newEntry;
            header.next = tail;
        } else {
            tail.next = newEntry;
            tail = newEntry;
        }
        size++;
    }
     
    public void clear() {   //清空链表
        header = new Entry<E>(null);
        tail = null;
        another = null;
        size = 0;
    }
     
    public boolean insert(E element, E insertElement) { //在指定的元素前插入一个元素
        another = header.next;
        Entry<E> previous = header;
        while(another != null) {
            if(another.element.equals(element)) {
                Entry<E> newEntry = new Entry<E>(insertElement);
                previous.next = newEntry;
                newEntry.next = another;
                size++;
                return true;
            }
            previous = another;
            another = another.next;
        }
        return false;
    }
     
    public boolean isEmpty() {  //判断链表是否为空
        return size > 0 ? false : true;
    }
     
    public boolean set(E oldElement, E newElement) {    //用新值替换旧值
        another = header.next;
        while(another != null) {
            if(another.element.equals(oldElement)) {
                another.element = newElement;
                return true;
            }
            another = another.next;
        }
        return false;
    }
     
    public E getFirst() {   //得到链表的第一个元素
        return header.next.element;
    }
     
    public E getLast() {    //得到链表的最后一个元素
        return tail.element;
    }
     
    public boolean contains(E element) {    //链表中是否包含某个元素
        another = header.next;
        while(another != null) {
            if(another.element.equals(element)) {
                return true;
            }
            another = another.next;
        }
        return false;
    }
     
    public boolean remove(E element) {  //移除指定的元素
        another = header.next;
        Entry<E> previous = header;   //被移除元素的上一个元素（如果此元素存在）
        while(another != null) {
            if(another.element.equals(element)) {
                previous.next = another.next;
                size--;
                return true;
            }
            previous = another;
            another = another.next;
        }
        return false;
    }
     
    public boolean removeFirst() {  //移除第一个元素
        if(size <= 0) {
            return false;
        }
        header.next = header.next.next;
        return true;
    }
     
    public boolean removeLast() {   //移除最后一个元素
        if(size <= 0) {
            return false;
        }
        another = header.next;
        Entry<E> previous = header;
        while(another.next != null) {
            previous = another;
            another = another.next;
        }
        previous.next = another.next;
        size--;
        return true;
    }
     
    public int size() {
        return size;
    }
     
    public Iterator<E> iterator() {
        return new Itr();
    }
     
    private class Itr implements Iterator<E> {    //实现的迭代器
        private Entry<E> current = header.next;
        @Override
        public boolean hasNext() {
            if(current != null) {
                return true;
            }
            return false;
        }
 
        @Override
        public E next() {
            E element = current.element;
            current = current.next;
            return element;
        }
 
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
         
    }
     
    private static class Entry<E> {   //链表上的节点
        E element;
        Entry<E> next;
        Entry(E element) {
            this.element = element;
            next = null;
        }
    }
     
    public void test() {    //测试函数
        another = header.next;
        while(another != null) {
            System.out.println(another.element);
            another = another.next;
        }
    }
}
