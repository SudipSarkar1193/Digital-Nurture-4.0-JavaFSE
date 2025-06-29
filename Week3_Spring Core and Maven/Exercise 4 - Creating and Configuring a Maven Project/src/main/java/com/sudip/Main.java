package com.sudip;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        if(context == null){
            System.out.println("Spring Context Not Initialized!");
        }else{
            System.out.println("Spring Context Initialized!");
        }
        context.close();
    }
}