package presentation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Assignment: #03
 * ID: n01555831
 * Name: Tsz Kit Cheung (Kevin Cheung)
 *
 * @version v1.0
 * Main GUI
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
    String recordID;
    String fname;
    String lname;
    int age;
    String phone;

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

        /** Display middle, Lower Panel */
        //setLayout(new GridLayout(2, 1, 0, 50)); // grid layout, add layout according to add
        add(createmiddlePanel(),BorderLayout.CENTER);
        add(createLowerPanel(),BorderLayout.SOUTH);
        add(createLeftPanel(),BorderLayout.WEST);
        add(createRightPanel(),BorderLayout.EAST);
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
        //recordIDTF.setDocument(new LimitInputDocument("[0-9]"));
        recordIDTF.setPreferredSize(new Dimension(middleTFWidth, middleTFHeight));

        /** First Name label */
        fnameLabel = new JLabel("First Name");
        fnameLabel.setFont(btnFont);
        fnameLabel.setPreferredSize(new Dimension(middleLabelWidth, middleLabelHeight));

        /** First Name Text Field */
        fnameTF = new JTextField(middleTFColumn);
        fnameTF.setFont(btnFont);
        fnameTF.setVisible(true);
        fnameTF.setDocument(new LimitInputDocument(25,"[a-zA-Z]"));
        fnameTF.setPreferredSize(new Dimension(middleTFWidth, middleTFHeight));

        /** Last Name label */
        lnameLabel = new JLabel("Last Name");
        lnameLabel.setFont(btnFont);
        lnameLabel.setPreferredSize(new Dimension(middleLabelWidth, middleLabelHeight));

        /** Last Name Text Field */
        lnameTF = new JTextField(middleTFColumn);
        lnameTF.setFont(btnFont);
        lnameTF.setVisible(true);
        lnameTF.setDocument(new LimitInputDocument(25,"[a-zA-Z]"));
        lnameTF.setPreferredSize(new Dimension(middleTFWidth, middleTFHeight));

        /** Age label */
        ageLabel = new JLabel("Age");
        ageLabel.setFont(btnFont);
        ageLabel.setPreferredSize(new Dimension(middleLabelWidth, middleLabelHeight));

        /** Age Text Field */
        ageTF = new JTextField(middleTFColumn);
        ageTF.setFont(btnFont);
        ageTF.setVisible(true);
        ageTF.setDocument(new LimitInputDocument(3,"[0-9]"));
        ageTF.setPreferredSize(new Dimension(middleTFWidth, middleTFHeight));

        /** Phone label */
        phoneLabel = new JLabel("Phone");
        phoneLabel.setFont(btnFont);
        phoneLabel.setPreferredSize(new Dimension(middleLabelWidth, middleLabelHeight));

        /** Phone Text Field */
        phoneTF = new JTextField(middleTFColumn);
        phoneTF.setFont(btnFont);
        phoneTF.setVisible(true);
        phoneTF.setDocument(new LimitInputDocument(10,"[0-9]"));
        phoneTF.setPreferredSize(new Dimension(middleTFWidth, middleTFHeight));

        /** Create gaps for group layout */
        //middleLayout.setAutoCreateGaps(true);
        middleLayout.setAutoCreateContainerGaps(true);

        /**
         * Create Horizontal Groups for group layout
         * Sequential Group can create 2 parallel groups (label & text field)
         */
        middleLayout.setHorizontalGroup(middleLayout.createSequentialGroup()
                .addGroup(middleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(recordIDLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addComponent(fnameLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addComponent(lnameLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addComponent(ageLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addComponent(phoneLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))

                .addGroup(middleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(recordIDTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addComponent(fnameTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addComponent(lnameTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addComponent(ageTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addComponent(phoneTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)));

        /**
         * Create Horizontal Groups for group layout
         * Sequential Group can create 2 parallel groups (record ID & name)
         */
        middleLayout.setVerticalGroup(middleLayout.createSequentialGroup()
                .addGroup(middleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(recordIDLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addComponent(recordIDTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))
                .addGap(vertGapWidth)
                .addGroup(middleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(fnameLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addComponent(fnameTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))
                .addGap(vertGapWidth)
                .addGroup(middleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lnameLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addComponent(lnameTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))
                .addGap(vertGapWidth)
                .addGroup(middleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(ageLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addComponent(ageTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))
                .addGap(vertGapWidth)
                .addGroup(middleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(phoneLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addComponent(phoneTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
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
        lowerPanel.setLayout(new GridLayout(1, 2,70,50)); // grid layout, add layout according to add
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

    /** Input data type in format */
    public void dataInput() {
        recordID = recordIDTF.getText();
        fname = fnameTF.getText();
        lname = lnameTF.getText();
        age = Integer.parseInt(ageTF.getText());
        phone = phoneTF.getText();
    }

    /** Add Button Listener */
    class AddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dataInput();
            /** statement */
        }
    }

    class FindListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dataInput();
            /** statement */
        }
    }



    /**
     * The inner class of Document, extending the super class of PlainDocument.
     * The object of this class will be set to the textfield to limit the input.
     */
    class LimitInputDocument extends PlainDocument {

        // private member
        private int maxLen;
        private String regex;

        /**
         * Class constructor specifying the limitation of input.
         *
         * @param //maxLen THe max length of input
         * @param regex    The string of regex indicator
         */

        LimitInputDocument(int maxLen, String regex) {
            this.maxLen = maxLen;
            this.regex = regex;
        }

        /**
         * Overrides the insertString() method of the super class.
         * The input is valid only when the total length of input is less than the
         * parameter maxlen and the input matched the regex.
         * Otherwise, the content in the textfield will not change.
         */
        @Override
        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
            // System.out.println(str);
            if (getLength() + str.length() <= maxLen && str.matches(regex)) {
                super.insertString(offset, str, attr);
            }
        }
    }
}
