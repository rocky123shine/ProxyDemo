package com.study.rocky.proxydemo.static_proxy;

/**
 * Created by Administrator on 2018/4/19 0019.
 */
//代理对象 实现目标接口 持有目标对象引用
public class ShopProxy implements IShopPhone {

    private IShopPhone shopPhone;

    public ShopProxy(IShopPhone phone) {
        shopPhone = phone;
    }

    /**
     * 代理对象 代理购买
     * @param phoneName
     */
    @Override
    public void shopPhone(String customName,String phoneName) {
        shopPhone.shopPhone(customName,phoneName);
    }
}
