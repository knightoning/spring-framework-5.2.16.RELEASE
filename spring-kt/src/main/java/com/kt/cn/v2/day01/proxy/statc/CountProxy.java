package com.kt.cn.v2.day01.proxy.statc;

/**
 * @author hujie
 */
public class CountProxy implements Count{

    private CountImpl countImpl;

    /**
     * 覆盖默认构造器
     * @param countImpl
     */
    public CountProxy(CountImpl countImpl){
        this.countImpl = countImpl;
    }

    @Override
    public void queryCount() {
        System.out.println("==查询账户开始");
        countImpl.queryCount();
        System.out.println("==查询账户结束");

    }

    @Override
    public void updateCount() {
        System.out.println("==更新账户开始");
        countImpl.updateCount();
        System.out.println("==更新户结束");
    }
}
