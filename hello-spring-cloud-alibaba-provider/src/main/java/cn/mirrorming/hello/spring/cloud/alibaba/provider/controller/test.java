package cn.mirrorming.hello.spring.cloud.alibaba.provider.controller;

import java.util.ArrayList;

public class test {
    static class A{

        static {
            System.out.println(1);
        }

        public A(){
            System.out.println(2);
        }
    }

    static class B extends A{

        static {
            System.out.println("a");
        }

        public B(){
            System.out.println("b");
        }
    }

    public static void main(String[] args) {
        A ab = new B();
        ab = new B();
    }
}
