package com.tamim.dp._01Singleton;

public class Test {
    
    public static void main(String[] args) {
        // SingletonDesignPattern s = new SingletonDesignPattern();
        // SingletonDesignPattern s1 = new SingletonDesignPattern();

        SingletonDesignPattern s1 = SingletonDesignPattern.getInstanceEarlyLoading();
        SingletonDesignPattern s2 = SingletonDesignPattern.getInstanceEarlyLoading();
        System.out.println(s2.hashCode());
        System.out.println(s1.hashCode());

        SingletonDesignPattern s3 = SingletonDesignPattern.getInstanceLazy();
        SingletonDesignPattern s4 = SingletonDesignPattern.getInstanceLazy();

        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());
    }
}
