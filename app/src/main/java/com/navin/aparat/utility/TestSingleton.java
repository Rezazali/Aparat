package com.navin.aparat.utility;

public class TestSingleton {


    private static TestSingleton instance = null;

    private TestSingleton() {

    }


    public static TestSingleton getInstance() {

        if (instance == null) {
            instance = new TestSingleton();
        }

        return instance;

    }


}
