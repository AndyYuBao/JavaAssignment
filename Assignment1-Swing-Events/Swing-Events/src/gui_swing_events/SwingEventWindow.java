package gui_swing_events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingEventWindow implements ActionListener {
    private JFrame frame;
    private JRadioButton totalRadioButton;
    private JRadioButton averageRadioButton;
    private JRadioButton maxRadioButton;
    private JRadioButton minRadioButton;
    private JButton calculateButton;
    private JTextField inputField;
    private JTextField resultField;

    public SwingEventWindow() {
        // Create the main JFrame window
        frame = new JFrame("Swing Events");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the main panel and set its layout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 1));

        // Panel 1: Display the main label
        JPanel panel1 = new JPanel();
        JLabel lblMain = new JLabel("Excel Functionality");
        panel1.add(lblMain);
        mainPanel.add(panel1);

        // Panel 2: Prompt the user to enter numbers
        JPanel panel2 = new JPanel();
        JLabel lblRequest = new JLabel("Enter numbers separated by commas:");
        panel2.add(lblRequest);
        mainPanel.add(panel2);

        // Panel 3: Input field for entering numbers
        JPanel panel3 = new JPanel();
        inputField = new JTextField(20);
        panel3.add(inputField);
        mainPanel.add(panel3);

        // Panel 4: Radio buttons for selecting the desired calculation
        JPanel panel4 = new JPanel();
        totalRadioButton = new JRadioButton("Total");
        averageRadioButton = new JRadioButton("Average");
        maxRadioButton = new JRadioButton("Maximum");
        minRadioButton = new JRadioButton("Minimum");

        // Group the radio buttons together
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(totalRadioButton);
        buttonGroup.add(averageRadioButton);
        buttonGroup.add(maxRadioButton);
        buttonGroup.add(minRadioButton);

        // Add the radio buttons to panel 4
        panel4.add(totalRadioButton);
        panel4.add(averageRadioButton);
        panel4.add(maxRadioButton);
        panel4.add(minRadioButton);

        mainPanel.add(panel4);

        // Panel 5: Button for initiating the calculation
        JPanel panel5 = new JPanel();
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        panel5.add(calculateButton);
        mainPanel.add(panel5);

        // Panel 6: Display the result
        JPanel panel6 = new JPanel();
        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField(20);
        resultField.setEditable(false);
        panel6.add(resultLabel);
        panel6.add(resultField);
        mainPanel.add(panel6);

        // Add the main panel to the frame
        frame.add(mainPanel);
    }

    public void createAndShowGUI() {
        // Pack and display the frame
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the input from the input field
        String input = inputField.getText();
        // Create an Excel object with the input
        Excel excel = new Excel(input);

        // Check which radio button is selected and perform the corresponding calculation
        if (totalRadioButton.isSelected()) {
            double total = excel.findTotal();
            resultField.setText(Double.toString(total));
        } else if (averageRadioButton.isSelected()) {
            double average = excel.findAvg();
            resultField.setText(Double.toString(average));
        } else if (maxRadioButton.isSelected()) {
            double maximum = excel.findMax();
            resultField.setText(Double.toString(maximum));
        } else if (minRadioButton.isSelected()) {
            double minimum = excel.findMin();
            resultField.setText(Double.toString(minimum));
        }
    }
}