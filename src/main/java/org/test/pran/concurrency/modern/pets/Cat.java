package org.test.pran.concurrency.modern.pets;

/**
 * Created by pramodh on 3/14/14.
 */
public class Cat extends Pet {
    public Cat(String name) {
        super(name);
    }

@Override
    public void examine() {
    System.out.println("Meow");
    }
}
