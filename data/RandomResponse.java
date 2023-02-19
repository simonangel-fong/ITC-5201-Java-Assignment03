package data;

import java.util.*;

import business.*;

/**
 * ID: n01555914
 * Name: Wenhao Fang
 * 
 * This is a class represent the response sent from RandomIO to UI.
 * 
 * @author Wenhao Fang
 */
public class RandomResponse {
    private RadomSignal signal;
    private String message;
    private ArrayList<Person> personList;

    RandomResponse() {
        this.signal = RadomSignal.ERROR;
        this.message = "";
    }

    RandomResponse(RadomSignal signal, String message, ArrayList<Person> personList) {
        this.signal = signal;
        this.message = message;
        this.personList = personList;
    }

    public RadomSignal getSignal() {
        return signal;
    }

    public void setSignal(RadomSignal signal) {
        this.signal = signal;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }

    @Override
    public String toString() {
        String list = "";
        for (Person p : personList) {
            list = list + p.toString() + "\n";
        }
        return "%s\t%s\n%s".formatted(signal, message, list);
    }
}
