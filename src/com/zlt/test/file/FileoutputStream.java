package com.zlt.test.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileoutputStream {

	
	public static void main(String[] args) {  
	     // TODO�Զ����ɵķ������  
	     byte[] buffer=new byte[512];   //һ��ȡ�����ֽ�����С,��������С  
	     int numberRead=0;  
	     FileInputStream input=null;  
	     FileOutputStream out =null;  
	     try {  
	        input=new FileInputStream("D://tiger.jpg");  
	        out=new FileOutputStream("D://test/tiger2.jpg"); //����ļ������ڻ��Զ����� ,cuowu 
	         
	        while ((numberRead=input.read(buffer))!=-1) {  //numberRead��Ŀ�����ڷ�ֹ���һ�ζ�ȡ���ֽ�С��buffer���ȣ�  
	           out.write(buffer, 0, numberRead);       //������Զ������0  
	        }  
	     } catch (final IOException e) {  
	        // TODO�Զ����ɵ� catch ��  
	        e.printStackTrace();  
	     }finally{  
	        try {  
	           input.close();  
	           out.close();  
	        } catch (IOException e) {  
	           // TODO�Զ����ɵ� catch ��  
	           e.printStackTrace();  
	        }  
	         
	     }  
	  }  
}
