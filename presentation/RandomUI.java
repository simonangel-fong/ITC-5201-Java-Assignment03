package presentation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.text.AttributeSet;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

import data.*;
import business.*;

/**
 * Assignment: #03
 * ID: n01555831
 * Name: Tsz Kit Cheung (Kevin Cheung)
 *
 * @version v1.0
 *          Main GUI
 *
 */

public class RandomUI extends JFrame {

        /** frame settings */
        private static final int FRAME_WIDTH = 400;
        private static final int FRAME_HEIGHT = 400;

        /** 2 main panels */
        private JPanel middlePanel;
        private JPanel lowerPanel;

        /** middle Panel Variable */
        private JLabel recordIDLabel;
        private JTextField recordIDTF;
        private JLabel fnameLabel;
        private JTextField fnameTF;
        private JLabel lnameLabel;
        private JTextField lnameTF;
        private JLabel ageLabel;
        private JTextField ageTF;
        private JLabel phoneLabel;
        private JTextField phoneTF;

        /** Lower Panel Variable */
        private JButton bt1;
        private JButton bt2;

        /** Left, Right Panel Variable (For padding) */
        private JPanel leftPanel;
        private JPanel rightPanel;

        /** Results and Outputs */
        int recordID;
        String fname;
        String lname;
        int age;
        String phone;

        /** Call other files */
        // private final static String PATH = "./data/RandomFileData.dat";
        private final static String PATH = "src/RandomFileData.dat";

        private RandomIO io;
        private RandomResponse response;

        /**
         * Main Statement
         * Provide frame settings and create main layout
         */
        public RandomUI() {

                /** Set frame */
                setSize(FRAME_WIDTH, FRAME_HEIGHT);
                setTitle("Random File Processing");
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                setResizable(false);
                setVisible(true);

                /** Call Product Controller File */
                io = new RandomIO(PATH);
                response = new RandomResponse();

                /** Display middle, Lower Panel */
                // setLayout(new GridLayout(2, 1, 0, 50)); // grid layout, add layout according
                // to add
                add(createmiddlePanel(), BorderLayout.CENTER);
                add(createLowerPanel(), BorderLayout.SOUTH);
                add(createLeftPanel(), BorderLayout.WEST);
                add(createRightPanel(), BorderLayout.EAST);

        }

        public RandomUI(String path) {
                this();
                io = new RandomIO(path);
        }

        /**
         * The middle panel used a group layout to arrange the Labels and Text Fields
         * Dimensions and inputs are used for arranging dimensions
         * setHorizontalGroup and setVerticalGroup can assign the location for each
         * items
         * Then add group and add components to them
         */

        private JPanel createmiddlePanel() {

                /** Set middle Panel */
                middlePanel = new JPanel(); // Using Group layout with a panel
                GroupLayout middleLayout = new GroupLayout(middlePanel);
                middlePanel.setLayout(middleLayout);
                middlePanel.setPreferredSize(new Dimension(300, 350));

                /** Set Dimension for label, Text Field, Font and gap width */
                int middleLabelWidth = 120;
                int middleLabelHeight = 30;
                int middleTFColumn = 10;
                int middleTFWidth = 120;
                int middleTFHeight = 30;
                int vertGapWidth = 20;
                Font btnFont = new Font("Dialog", Font.BOLD, 16);

                /** record # label */
                recordIDLabel = new JLabel("record #");
                recordIDLabel.setFont(btnFont);
                recordIDLabel.setPreferredSize(new Dimension(middleLabelWidth, middleLabelHeight));

                /** record # Text Field */
                recordIDTF = new JTextField(middleTFColumn);
                recordIDTF.setFont(btnFont);
                recordIDTF.setVisible(true);
                // recordIDTF.setDocument(new LimitInputDocument(4, "[0-9]"));
                recordIDTF.setPreferredSize(new Dimension(middleTFWidth, middleTFHeight));

                /** First Name label */
                fnameLabel = new JLabel("First Name");
                fnameLabel.setFont(btnFont);
                fnameLabel.setPreferredSize(new Dimension(middleLabelWidth, middleLabelHeight));

                /** First Name Text Field */
                fnameTF = new JTextField(middleTFColumn);
                fnameTF.setFont(btnFont);
                fnameTF.setVisible(true);
                // fnameTF.setDocument(new LimitInputDocument(20, "[a-zA-Z]"));
                fnameTF.setPreferredSize(new Dimension(middleTFWidth, middleTFHeight));

                /** Last Name label */
                lnameLabel = new JLabel("Last Name");
                lnameLabel.setFont(btnFont);
                lnameLabel.setPreferredSize(new Dimension(middleLabelWidth, middleLabelHeight));

                /** Last Name Text Field */
                lnameTF = new JTextField(middleTFColumn);
                lnameTF.setFont(btnFont);
                lnameTF.setVisible(true);
                // lnameTF.setDocument(new LimitInputDocument(25, "[a-zA-Z]"));
                lnameTF.setPreferredSize(new Dimension(middleTFWidth, middleTFHeight));

                /** Age label */
                ageLabel = new JLabel("Age");
                ageLabel.setFont(btnFont);
                ageLabel.setPreferredSize(new Dimension(middleLabelWidth, middleLabelHeight));

                /** Age Text Field */
                ageTF = new JTextField(middleTFColumn);
                ageTF.setFont(btnFont);
                ageTF.setVisible(true);
                // ageTF.setDocument(new LimitInputDocument(4, "[0-9]"));
                ageTF.setPreferredSize(new Dimension(middleTFWidth, middleTFHeight));

                /** Phone label */
                phoneLabel = new JLabel("Phone");
                phoneLabel.setFont(btnFont);
                phoneLabel.setPreferredSize(new Dimension(middleLabelWidth, middleLabelHeight));

                /** Phone Text Field */
                phoneTF = new JTextField(middleTFColumn);
                phoneTF.setFont(btnFont);
                phoneTF.setVisible(true);
                // phoneTF.setDocument(new LimitInputDocument(10, "[0-9]"));
                phoneTF.setPreferredSize(new Dimension(middleTFWidth, middleTFHeight));

                /** Create gaps for group layout */
                // middleLayout.setAutoCreateGaps(true);
                middleLayout.setAutoCreateContainerGaps(true);

                /**
                 * Create Horizontal Groups for group layout
                 * Sequential Group can create 2 parallel groups (label & text field)
                 */
                middleLayout.setHorizontalGroup(middleLayout.createSequentialGroup()
                                .addGroup(middleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(recordIDLabel, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                .addComponent(fnameLabel, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lnameLabel, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ageLabel, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                .addComponent(phoneLabel, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE))

                                .addGroup(middleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(recordIDTF, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                .addComponent(fnameTF, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lnameTF, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ageTF, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                .addComponent(phoneTF, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)));

                /**
                 * Create Horizontal Groups for group layout
                 * Sequential Group can create 2 parallel groups (record ID & name)
                 */
                middleLayout.setVerticalGroup(middleLayout.createSequentialGroup()
                                .addGroup(middleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(recordIDLabel, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                .addComponent(recordIDTF, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE))
                                .addGap(vertGapWidth)
                                .addGroup(middleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(fnameLabel, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                .addComponent(fnameTF, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE))
                                .addGap(vertGapWidth)
                                .addGroup(middleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(lnameLabel, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lnameTF, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE))
                                .addGap(vertGapWidth)
                                .addGroup(middleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(ageLabel, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ageTF, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE))
                                .addGap(vertGapWidth)
                                .addGroup(middleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(phoneLabel, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                .addComponent(phoneTF, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)));
                return middlePanel;
        }

        /**
         * The Lower panel used a grid layout to arrange left Lower panel
         * It can make sure that all the labels, textfields and textareas are in correct
         * positions
         *
         * for group layout:
         * Dimensions and inputs are used for arranging dimensions
         * setHorizontalGroup and setVerticalGroup can assign the location for each
         * items
         * Then add group and add components to them
         */

        private JPanel createLowerPanel() {

                /** Set lower Panel */
                lowerPanel = new JPanel(); // Using Group layout with a panel
                lowerPanel.setPreferredSize(new Dimension(300, 80));
                Font btnFont = new Font("Dialog", Font.BOLD, 16);

                /** Button 1, Add */
                bt1 = new JButton("Add");
                bt1.setFont(btnFont);
                bt1.setPreferredSize(new Dimension(160, 80));
                bt1.addActionListener(new AddListener());

                /** Button 2, Find */
                bt2 = new JButton("Find");
                bt2.setFont(btnFont);
                bt2.setPreferredSize(new Dimension(160, 80));
                bt2.addActionListener(new FindListener());

                /** Display 2 Buttons */
                lowerPanel.setLayout(new GridLayout(1, 2, 70, 50)); // grid layout, add layout according to add
                lowerPanel.setBorder(BorderFactory.createEmptyBorder(10, 25, 40, 25)); // 10 px empty border
                lowerPanel.add(bt1);
                lowerPanel.add(bt2);

                return lowerPanel;
        }

        private JPanel createLeftPanel() {
                leftPanel = new JPanel();
                leftPanel.setPreferredSize(new Dimension(50, 400));
                return leftPanel;
        }

        private JPanel createRightPanel() {
                rightPanel = new JPanel();
                rightPanel.setPreferredSize(new Dimension(50, 400));
                return rightPanel;
        }

        /** Add Button Listener */
        class AddListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                        // textField members to be validated
                        JTextField[] textFields = { recordIDTF, fnameTF, lnameTF, ageTF, phoneTF };

                        // String message when the above textFields is empty.
                        String[][] validationMsg = {
                                        { "ID is required!", "[0-9]*", "ID is number only!" },
                                        { "First name is required!", "[a-zA-Z]*",
                                                        "First name is character only!" },
                                        { "Last name is required!", "[a-zA-Z]*",
                                                        "Last name is character only!" },
                                        { "Age is required!", "[0-9]*", "Age is number only!" },
                                        { "Phone is required!", "[0-9]*", "Phone is number only!" }
                        };
                        boolean flag = valiation(textFields, validationMsg);// validate inpute

                        if (flag == true) {// if valid
                                Person person = formPerson();
                                response = io.addPerson(person);
                                if (response.getSignal() == RadomSignal.SUCCESS) {
                                        JOptionPane.showMessageDialog(middlePanel, response.getMessage());
                                        emptyTextField(textFields);
                                } else {
                                        JOptionPane.showMessageDialog(middlePanel, response.getMessage());
                                }
                        }
                }

        }

        /** Find Button Listener */
        class FindListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                        // textField members to be validated
                        JTextField[] textFields = { recordIDTF };

                        // String message when the above textFields is empty.
                        String[][] validationMsg = {
                                        { "ID is required!", "[0-9]*", "ID is number only!" } };
                        boolean flag = valiation(textFields, validationMsg);// validate inpute
                        if (flag == true) {// if valid
                                int recordNum = Integer.parseInt(recordIDTF.getText());
                                response = io.findPerson(recordNum);
                                if (response.getSignal() == RadomSignal.SUCCESS) {
                                        JOptionPane.showMessageDialog(middlePanel, response.getMessage());
                                        System.out.println(response.getPersonList().get(0));
                                        bindTextField(response.getPersonList().get(0));
                                } else {
                                        JOptionPane.showMessageDialog(middlePanel, response.getMessage());
                                }
                        }
                }
        }

        /**
         * Valides a list of textfield, checking whether they are empty and match a
         * specific regex.
         * If mo valid, a prompt will be displayed.
         * 
         * @author Wenhao Fang
         * @param textFields An array of JTextField objects.
         * @param msgs       An 2 dimentional array contains prompt messages and
         *                   regexes.
         * @return True if all text fields are valid.
         */
        public boolean valiation(JTextField[] textFields, String[][] msgs) {
                boolean result = true;
                String promt = "";

                for (int i = 0; i < textFields.length; i++) {// loop each text field object.
                        String input = textFields[i].getText();
                        // System.out.println("input:" + input);
                        // System.out.println("isEmpty:" + input.isEmpty());
                        if (input.length() == 0) {
                                promt += String.format("<p>%s</p>", msgs[i][0]);// collect messages.
                                result = false;
                                continue;// jump to the next iteration.
                        }

                        String regex = msgs[i][1];
                        // System.out.println("regex:" + regex);
                        // System.out.println("match:" + input.matches(regex));
                        if (!input.matches(regex)) {
                                promt += String.format("<p>%s</p>", msgs[i][2]);
                                result = false;
                        }
                }

                if (!promt.isEmpty()) {// if prompt has content ,then display.
                        JOptionPane.showMessageDialog(middlePanel,
                                        String.format("<html><h3>Warning</h3>%s</html>", promt));
                }

                return result;
        }

        // create a person object from the gui
        private Person formPerson() {
                Person person = new Person();
                person.setID(Integer.parseInt(recordIDTF.getText()));
                person.setFirstName(fnameTF.getText());
                person.setLastName(fnameTF.getText());
                person.setAge(Integer.parseInt(ageTF.getText()));
                person.setPhone(phoneTF.getText());

                return person;
        }

        // empty all text field
        private void emptyTextField(JTextField[] textFields) {
                for (JTextField tf : textFields) {
                        tf.setText("");
                }
        }

        // bing data to all text field for a person object
        public void bindTextField(Person person) {
                recordIDTF.setText(Integer.toString(person.getID()).trim());
                fnameTF.setText(person.getFirstName().trim());
                lnameTF.setText(person.getLastName().trim());
                ageTF.setText(Integer.toString(person.getAge()).trim());
                phoneTF.setText(person.getPhone().trim());
        };

}