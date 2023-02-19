package data;

/**
 * ID: n01555914
 * Name: Wenhao Fang
 * 
 * This is a class represent a signel sent from RandomIO.
 * 
 * @author Wenhao Fang
 */
public enum RadomSignal {
    SUCCESS, // The signal when execution meets business logic without exception.
    WARNING, // The signal when execution fails business logic without exception.
    ERROR// The signal when execution raises exception.
}
