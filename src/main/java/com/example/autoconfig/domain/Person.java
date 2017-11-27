package com.example.autoconfig.domain;

import java.io.Serializable;
import java.util.List;

public class Person implements Serializable {
private static final long serialVersionUID = 4464233896798170487L;
private String name;
private int age;
public String getName() {
        return name;
		}
public void setName(String name) {
	this.name = name;
		}
public int getAge() {
        return age;
		}
public void setAge(int age) {
        this.age = age;
		}
@Override
public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
		}
public int getNonOptionArgs() {
	int n=123;
	return n;
}

}