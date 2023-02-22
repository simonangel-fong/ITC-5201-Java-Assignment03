import data.*;
import img.*;
import javax.swing.*;

/**
 * This is a demo class with the main function of the application.
 */
public class RandomDemo {
    //private final static String PATH = "./data/RandomFileData.dat";
    private final static String PATH = "src/RandomFileData.dat";

    public static void main(String[] args) {
        RandomIO io = new RandomIO(PATH);
        JFrame frame = new mainframe();
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }
}
