package com.lsc.domain;

public class Person {
    private String name;
    private int age;
    private Dog dog;

    public String getName() {
        return name;
    }
    public Dog getDog() {
        return dog;
    }
    public void setDog(Dog dog) {
        this.dog = dog;
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
    
}
