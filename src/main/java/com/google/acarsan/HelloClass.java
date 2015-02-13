package com.google.acarsan;

public class HelloClass {
    public String message = "Hello World";
    public int age = 10;

    public HelloClass () {
    }

    public HelloClass (String name) {
        this.message = "Hello " + name + "!";
    }

    public HelloClass(int age) {
		this.message = String.valueOf(age+5);
	}

    public HelloClass(String name, String surname) {
        this.message = name+surname;
    }

    public String getMessage() {
        return message;
    }
}
