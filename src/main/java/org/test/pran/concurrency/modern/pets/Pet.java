package org.test.pran.concurrency.modern.pets;

/**
 * Created by pramodh on 3/14/14.
 */
public abstract class Pet {
    protected final String name;

    protected Pet(String name) {
        this.name = name;
    }
    public abstract void examine();
}
