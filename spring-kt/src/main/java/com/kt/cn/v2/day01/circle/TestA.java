package com.kt.cn.v2.day01.circle;

/**
 * @author hujie
 */
public class TestA {

    private TestB testB;

    public TestA(TestB testB) {
        this.testB = testB;
    }

    public void a(){
        testB.b();
    }

    public TestB getTestB() {
        return testB;
    }

    public void setTestB(TestB testB) {
        this.testB = testB;
    }
}
