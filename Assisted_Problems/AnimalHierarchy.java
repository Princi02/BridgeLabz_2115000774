package Assisted_Problems;
import java.util.*;

class Animal{
    String name;
    int age;

    Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void makeSound(){
        System.out.println("voice of animal");
    }
}



class Dog extends Animal{

    Dog(String name, int age){
        super(name, age);
    }

    @Override
    public void makeSound(){
        System.out.println("voice of dog");
    }
}


class Cat extends Animal{

    Cat(String name, int age){
        super(name, age);
    }

    @Override
    public void makeSound(){
        System.out.println("voice of cat");
    }
}


class Bird extends Animal{

    Bird(String name, int age){
        super(name, age);
    }

    @Override
    public void makeSound(){
        System.out.println("voice of bird");
    }
}

public class AnimalHierarchy {
    public static void main(String[] args) {
        Animal dog = new Dog("Junior", 1);
        Animal cat = new Cat("Junior", 1);
        Animal bird = new Bird("Junior", 1);
        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
    }
}
