package data;

import java.util.*;

import business.*;

/**
 * ID: n01555914
 * Name: Wenhao Fang
 * 
 * This is a class represents the response sent from RandomIO to UI.
 * 
 * @author Wenhao Fang
 */
public class RandomResponse {

    // region Private members
    private RadomSignal signal;
    private String message;
    private ArrayList<Person> personList;

    // endregion

    // region Constructors

    /**
     * Default constuctor.
     */
    RandomResponse() {
        this.signal = RadomSignal.ERROR;// Default signal.
        this.message = "";
    }

    /**
     * Constructors with 3 parameters.
     * 
     * @param signal     The signal sent from the IO.
     * @param message    The message to pass to UI.
     * @param personList A list of persons.
     */
    RandomResponse(RadomSignal signal, String message, ArrayList<Person> personList) {
        this.signal = signal;
        this.message = message;
        this.personList = personList;
    }

    // endregion

    // region Setters and Getters

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
    // endregion

    // region Supportive methods

    /**
     * Overrides the toString() method.
     * Print the information of reponse.
     */
    @Override
    public String toString() {
        String list = "";
        for (Person p : personList) {
            list = list + p.toString() + "\n";
        }
        return "%s\t%s\n%s".formatted(signal, message, list);
    }
    // endregion
}
