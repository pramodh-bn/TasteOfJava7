package org.test.pran.concurrency.old;

/**
 * Created by pramodh on 3/13/14.
 */
public class Author {
    private String name;

    public Author(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
