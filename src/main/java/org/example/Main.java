package org.example;

import Form.DemoForm;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        DemoForm screen= new DemoForm();
        screen.setResizable(false);
        screen.show();
    }
}