package org.test.pran.concurrency.modern.pets;

/**
 * Created by pramodh on 3/14/14.
 */
public class Dog extends Pet {
    public Dog(String name) {
        super(name);
    }

@Override
    public void examine() {
    System.out.println("Woof, woof");
    }
}
