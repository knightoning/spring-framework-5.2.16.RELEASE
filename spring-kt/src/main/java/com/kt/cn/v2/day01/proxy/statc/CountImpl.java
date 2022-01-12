package com.kt.cn.v2.day01.proxy.statc;

import com.kt.cn.v2.day01.proxy.statc.Count;

/**
 * @author hujie
 */
public class CountImpl implements Count {
    @Override
    public void queryCount() {
        System.out.println("==查询账户");
    }

    @Override
    public void updateCount() {
        System.out.println("==更新账户");
    }
}
