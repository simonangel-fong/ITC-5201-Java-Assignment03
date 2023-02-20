
import javax.swing.*;

import data.*;
import presentation.*;

/**
 * Assignment: #03
 * ID: n01555831
 * Name: Tsz Kit Cheung (Kevin Cheung)
 *
 * @version v1.0
 *          Controller
 *
 */
public class RandomDemo {
    private final static String PATH = "./data/RandomFileData.dat";

    public static void main(String[] args) {
        JFrame frame = new RandomUI();
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
        // RandomIO controller = new RandomIO(PATH);
    }
}
