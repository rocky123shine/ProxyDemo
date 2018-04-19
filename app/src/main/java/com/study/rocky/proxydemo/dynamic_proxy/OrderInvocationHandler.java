package com.study.rocky.proxydemo.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class OrderInvocationHandler implements InvocationHandler {

    private IOrder order;
	
	public OrderInvocationHandler(IOrder order){
		this.order = order;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//反射机制处理->iOS-Runtime机制（动态访问属性和方法）
		if("getOrderPrice".equals(method.getName())){
			//权限处理
			if (!"Rocky".equals(this.order.getOrderUserName())){
				try {
					throw new SecurityException("没有权限访问，请确定你是否是管理员用户...");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				String price ="100.00";
				order.setOrderPrice(price);
			}
		}
		return method.invoke(order, args);
	}
	
}
