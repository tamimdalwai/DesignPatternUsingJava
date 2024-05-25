package com.tamim.dp._01Singleton;

/**
 * SingletonDesignPattern
 */
public class SingletonDesignPattern {
    
    
    private static SingletonDesignPattern Earlyinstance = new SingletonDesignPattern();
    private static SingletonDesignPattern Lazyinstance = null;
    
    private SingletonDesignPattern(){
        
    }

    // Eager loading
    public static SingletonDesignPattern getInstanceEarlyLoading(){
        return Earlyinstance;
    }

    // Lazy Loading
    public static SingletonDesignPattern getInstanceLazy(){
        if(Lazyinstance == null){
            Lazyinstance = new SingletonDesignPattern();
        }
        return Lazyinstance;
    }

}