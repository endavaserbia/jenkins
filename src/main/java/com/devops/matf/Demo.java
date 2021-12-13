package com.devops.matf;

public class Demo {

    private final String message = "Hello World!";

    //Even if we add a comment
    public Demo() {}

    public static void main(String[] args) {
        System.out.println(new Demo().getMessage());
    }

    private final String getMessage() {
        return message;
    }

}
