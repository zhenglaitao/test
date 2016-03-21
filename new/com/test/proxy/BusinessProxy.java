package com.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ������
 * @author zlt
 *
 */
public class BusinessProxy implements InvocationHandler{

	Object obj ;
	public BusinessProxy(Object obj) {
		this.obj = obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = null;  
        doBefore();  
//        for (int i = 0; i < args.length; i++) {
//			System.out.println(args[i]);
//		}
//        System.out.println(this.obj.getClass().getDeclaredMethods().length);
//        for (int i = 0; i < this.obj.getClass().getDeclaredMethods().length; i++) {
//			this.obj.getClass().getDeclaredMethods()[i].invoke(this.obj, null);
//			this.obj.getClass().getDeclaredMethods()[i].invoke(this.obj, new Object[]{});
//		}
        //����õ������ߵ�doAction����
//        Method doAction = this.obj.getClass().getDeclaredMethod("doAction", new Class[]{Method.class});
        Method doAction = this.obj.getClass().getMethod("doAction", null);
        //����ִ��doAction����
        doAction.invoke(this.obj, new Object[] { });
        
        //����õ������ߵ�doAction2����
//        Method doAction2 = this.obj.getClass().getDeclaredMethod("doAction2", new Class[]{Method.class});
        Method doAction2 = this.obj.getClass().getMethod("doAction2", null);
        //����ִ��doAction����
        doAction2.invoke(this.obj, new Object[] {  });
        
        
        result = method.invoke(obj,args);  
        doAfter();  
        return result;
	}

	public static Object factory(Object obj){
		Class cls = obj.getClass();
		return Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), new BusinessProxy(obj));
	}
	
	public void doBefore(){
		System.out.println("doBefore");
	}
	
	public void doAfter(){
		System.out.println("doAfter");
	}
}
