/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package goSweatMarsRoversExercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ControlPanel extends JPanel {
    
    private final MarsExploration mars;

    private final int xMin = 0;
    private final int xMax = 5;
    private final int yMin = 0;
    private final int yMax = 5;

    private final String[] instructionChoices;
    private final String[] xPositionChoices;
    private final String[] yPositionChoices;
    private final String[] directionChoices;
    private final JButton exitButton = new JButton("Exit");
    private final JComboBox instructionSelector;
    private final JComboBox orientationSelector;
    private final JComboBox xPositionSelector;
    private final JComboBox yPositionSelector;
    private String instructionString;
    private final JLabel instructionStringJLabel;
    private final Point position;
    private char direction;

    public ControlPanel(MarsExploration mars) { //constructor
        this.mars = mars;
        this.position = new Point(0, 0);
        this.direction = 'N';

        this.instructionString = "";
        this.instructionStringJLabel = new JLabel("instructionString = ");

        this.instructionChoices = new String[4];
        this.instructionChoices[0] = "select instruction from choices below";
        this.instructionChoices[1] = 'L' + "    ( = turn left)";
        this.instructionChoices[2] = 'R' + "    ( = turn right)";
        this.instructionChoices[3] = 'M' + "    ( = move forward one unit)";
        instructionSelector = new JComboBox(instructionChoices);

        this.directionChoices = new String[5];
        this.directionChoices[0] = "select orientation from choices below";
        this.directionChoices[1] = 'N' + "    ( = North orientation)";
        this.directionChoices[2] = 'E' + "    ( = East orientation)";
        this.directionChoices[3] = 'S' + "    ( = South orientation)";
        this.directionChoices[4] = 'W' + "    ( = West orientation)";
        orientationSelector = new JComboBox(directionChoices);

        this.xPositionChoices = new String[xMax + 2];
        this.xPositionChoices[0] = "select xPosition from choices below";
        for (int i = 1; i < (xMax + 2); i++) {
            xPositionChoices[i] = (i - 1) + "    ( = xPosition)";
        }
        xPositionSelector = new JComboBox(xPositionChoices);

        this.yPositionChoices = new String[yMax + 2];
        this.yPositionChoices[0] = "select yPosition from choices below";
        for (int i = 1; i < (yMax + 2); i++) {
            yPositionChoices[i] = (i - 1) + "    ( = yPosition)";
        }
        yPositionSelector = new JComboBox(yPositionChoices);
        setupUI();
    }

    private void setupUI() {
        exitButton.addActionListener(new ExitButtonWatcher());
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.setLayout(new GridLayout(10, 1));
        this.add(exitButton);
        this.add(xPositionSelector);
        this.add(yPositionSelector);
        this.add(orientationSelector);
        this.add(instructionSelector);
        xPositionSelector.addActionListener(new xPositionSelectorActionWatcher());
        yPositionSelector.addActionListener(new yPositionSelectorActionWatcher());
        orientationSelector.addActionListener(new directionSelectorActionWatcher());
        instructionSelector.addActionListener(new InstructionSelectorActionWatcher());
        this.add(instructionStringJLabel);
    }

    private class xPositionSelectorActionWatcher implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
            String selection = (String) cb.getSelectedItem();
            for (int i = 1; i < (xMax + 2); i++) {
                if (selection.equals(xPositionChoices[i])) {
                    position.setLocation(i - 1, (int) position.getY());
                }
            }
            String alertString = "hallo from xPositionSelectorActionWatcher \n";
            alertString += "xPosition is: " + (int) position.getX() + "\n";
//            JOptionPane.showMessageDialog(null, alertString);
        }
    }

    private class yPositionSelectorActionWatcher implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
            String selection = (String) cb.getSelectedItem();
            for (int i = 1; i < (yMax + 2); i++) {
                if (selection.equals(yPositionChoices[i])) {
                    position.setLocation((int) position.getX(), i - 1);
                }
            }
        }
    }

    private class directionSelectorActionWatcher implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
            String selection = (String) cb.getSelectedItem();
            if (selection.equals(directionChoices[0])) {
            }
            if (selection.equals(directionChoices[1])) { // North
                direction = 'N';
            }
            if (selection.equals(directionChoices[2])) { // East
                direction = 'E';
            }
            if (selection.equals(directionChoices[3])) { // South
                direction = 'S';
            }
            if (selection.equals(directionChoices[4])) { // West
                direction = 'W';
            }
                JOptionPane.showMessageDialog(null, "direction = " + direction);
        }
    }

    private class InstructionSelectorActionWatcher implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
            String selection = (String) cb.getSelectedItem();
            if (selection.equals(instructionChoices[0])) {
//                JOptionPane.showMessageDialog(null, "you chose: " + instructionChoices[0]);
            }
            if (selection.equals(instructionChoices[1])) { // turn left
                instructionString += "L";
                mars.getDisplayPanel().getJourneyStringLabel().setText(mars.getDisplayPanel().getJourneyStringLabel().getText() + "L");
            }
            if (selection.equals(instructionChoices[2])) { // turn right
                instructionString += "R";
                mars.getDisplayPanel().getJourneyStringLabel().setText(mars.getDisplayPanel().getJourneyStringLabel().getText() + "R");
            }
            if (selection.equals(instructionChoices[3])) { // move forward one unit
                instructionString += "M";
                mars.getDisplayPanel().getJourneyStringLabel().setText(mars.getDisplayPanel().getJourneyStringLabel().getText() + "M");
            }
        }
    }

    private class ExitButtonWatcher implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent a) {
            System.exit(0);
        }
    }

}
