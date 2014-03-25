package org.test.pran.concurrency.modern.pets;

/**
 * Created by pramodh on 3/14/14.
 */
public class Appointment<T> {
    private final T toBeSeen;
    public T getPatient(){
        return toBeSeen;
    }
    public Appointment(T incoming){
        toBeSeen = incoming;
    }
}
