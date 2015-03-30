package com.zlt.test.list;

import java.util.Iterator;

public class LinkList<E> {
	private Entry<E> header = new Entry<E>(null);   //��ͷΪ��
    private Entry<E> tail = null; //��β
    private Entry<E> another = null;  //���ڲ������ڵ�Ľڵ����
    private int size = 0;   //�ڵ���Ŀ
     
    public void add(E element) {    //���һ��Ԫ�أ��ڱ�β�����Ԫ�أ�
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
     
    public void clear() {   //�������
        header = new Entry<E>(null);
        tail = null;
        another = null;
        size = 0;
    }
     
    public boolean insert(E element, E insertElement) { //��ָ����Ԫ��ǰ����һ��Ԫ��
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
     
    public boolean isEmpty() {  //�ж������Ƿ�Ϊ��
        return size > 0 ? false : true;
    }
     
    public boolean set(E oldElement, E newElement) {    //����ֵ�滻��ֵ
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
     
    public E getFirst() {   //�õ�����ĵ�һ��Ԫ��
        return header.next.element;
    }
     
    public E getLast() {    //�õ���������һ��Ԫ��
        return tail.element;
    }
     
    public boolean contains(E element) {    //�������Ƿ����ĳ��Ԫ��
        another = header.next;
        while(another != null) {
            if(another.element.equals(element)) {
                return true;
            }
            another = another.next;
        }
        return false;
    }
     
    public boolean remove(E element) {  //�Ƴ�ָ����Ԫ��
        another = header.next;
        Entry<E> previous = header;   //���Ƴ�Ԫ�ص���һ��Ԫ�أ������Ԫ�ش��ڣ�
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
     
    public boolean removeFirst() {  //�Ƴ���һ��Ԫ��
        if(size <= 0) {
            return false;
        }
        header.next = header.next.next;
        return true;
    }
     
    public boolean removeLast() {   //�Ƴ����һ��Ԫ��
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
     
    private class Itr implements Iterator<E> {    //ʵ�ֵĵ�����
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
     
    private static class Entry<E> {   //�����ϵĽڵ�
        E element;
        Entry<E> next;
        Entry(E element) {
            this.element = element;
            next = null;
        }
    }
     
    public void test() {    //���Ժ���
        another = header.next;
        while(another != null) {
            System.out.println(another.element);
            another = another.next;
        }
    }
}
