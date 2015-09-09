package com.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类
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
        //反射得到操作者的doAction方法
//        Method doAction = this.obj.getClass().getDeclaredMethod("doAction", new Class[]{Method.class});
        Method doAction = this.obj.getClass().getMethod("doAction", null);
        //反射执行doAction方法
        doAction.invoke(this.obj, new Object[] { });
        
        //反射得到操作者的doAction2方法
//        Method doAction2 = this.obj.getClass().getDeclaredMethod("doAction2", new Class[]{Method.class});
        Method doAction2 = this.obj.getClass().getMethod("doAction2", null);
        //反射执行doAction方法
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
