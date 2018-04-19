package com.study.rocky.proxydemo.static_proxy;

import android.util.Log;

/**
 * Created by Administrator on 2018/4/19 0019.
 */

//目标对象实现目标接口
public class RockyShopPhone implements IShopPhone {

    @Override
    public void shopPhone(String customName,String phoneName) {
        Log.d("RockyShopPhone", customName+"要购买的手机是：" + phoneName);
    }
}
