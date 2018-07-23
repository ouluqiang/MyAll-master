package com.example.test;

import com.myolq.frame.utils.LogUtils;

/**
 * Created by dell on 2018/1/11.
 */

public class TestBean {

    private String name;
    private String sex;
    private int age;

    public String getName() {
        return name;
    }

    public TestBean setName(String name) {
        this.name = name;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public TestBean setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public int getAge() {
        return age;
    }

    public TestBean setAge(int age) {
        this.age = age;
        return this;
    }

    public TestBean getBuile(){
        LogUtils.e(toString());
            return this;
        }

    @Override
    public String toString() {
        return "TestBean{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

//    public static class Buile{
//        private String name;
//        private String sex;
//        private int age;
//
//        public Buile setName(String name) {
//            this.name = name;
//            return this;
//        }
//
//
//        public Buile setSex(String sex) {
//            this.sex = sex;
//            return this;
//        }
//
//        public Buile setAge(int age) {
//            this.age = age;
//            return this;
//        }
//
//        public TestBean getBuile(){
//            TestBean testBean=new TestBean();
//            testBean.setAge(age);
//            testBean.setName(name);
//            testBean.setSex(sex);
//            return testBean;
//        }
//
//    }

}
