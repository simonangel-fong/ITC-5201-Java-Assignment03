import data.*;

/**
 * This is a demo class with the main function of the application.
 */
public class RandomDemo {
    private final static String PATH = "./data/RandomFileData.dat";

    public static void main(String[] args) {
        RandomIO controller = new RandomIO(PATH);
    }
}
