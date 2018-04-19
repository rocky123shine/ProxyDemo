package com.study.rocky.proxydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.study.rocky.proxydemo.dynamic_proxy.IOrder;
import com.study.rocky.proxydemo.dynamic_proxy.OrderBean;
import com.study.rocky.proxydemo.dynamic_proxy.OrderInvocationHandler;
import com.study.rocky.proxydemo.static_proxy.RockyShopPhone;
import com.study.rocky.proxydemo.static_proxy.ShopProxy;

import java.lang.reflect.Proxy;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //静态代理测试
//        RockyShopPhone shopPhone = new RockyShopPhone();
//        ShopProxy proxy = new ShopProxy(shopPhone);
//        proxy.shopPhone("Rocky","IPhoneX");

        //动态代理测试
        //模拟数据是从数据或者网络请求得到 (目标对象)
        OrderBean orderBean = new OrderBean("1", "IPhone", "6800", "Rocky");

        //通过目标对象拿到目标接口
        Class<?>[] interfaces = orderBean.getClass().getInterfaces();

        //生成代理对象
        IOrder proxyOrder = (IOrder) Proxy.newProxyInstance(orderBean.getClass().getClassLoader(), interfaces, new OrderInvocationHandler(orderBean));
        Log.d("MainActivity", proxyOrder.getOrderPrice());

    }
}
