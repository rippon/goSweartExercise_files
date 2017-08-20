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

    private final int numberOf_sampleRoutes;
    private final String[] instructions;
    private final String[] xPositions;
    private final String[] yPositions;
    private final String[] directions;
    private final String[][] sampleJourneys;
    private final String[] sampleJourneysJComboBox_selectionStrings;
    private final JButton exitButton = new JButton("Exit");
    private final JComboBox instructionSelector;
    private final JComboBox orientationSelector;
    private final JComboBox xPositionSelector;
    private final JComboBox yPositionSelector;
    
    private final JComboBox sampleJourneySelector;
    
    private String instructionString;
    private final JLabel instructionStringJLabel;
    private final Point position;
    private char direction;

    public ControlPanel(MarsExploration mars) { //constructor
        this.mars = mars;
        
        numberOf_sampleRoutes = 5;
        position = new Point(0, 0);
        direction = 'N';

        this.instructionString = "";
        instructionStringJLabel = new JLabel("instructionString = ");

        instructions = new String[4];
        instructions[0] = "select instruction from choices below";
        instructions[1] = 'L' + "    ( = turn left)";
        instructions[2] = 'R' + "    ( = turn right)";
        instructions[3] = 'M' + "    ( = move forward one unit)";
        instructionSelector = new JComboBox(instructions);
        
        sampleJourneysJComboBox_selectionStrings = new String[numberOf_sampleRoutes + 1];
        sampleJourneys = new String[numberOf_sampleRoutes + 1][2];
        sampleJourneys[0][0] = "select ";
        sampleJourneys[0][1] = "sample journey";
        sampleJourneys[1][0] = "1 2 N";
        sampleJourneys[1][1] = "LMLMLMLMM";
        sampleJourneys[2][0] = "3 3 E";
        sampleJourneys[2][1] = "MMRMMRMRRM";
        sampleJourneys[3][0] = "0 5 S";
        sampleJourneys[3][1] = "MLMMMRMLMRM";
        sampleJourneys[4][0] = "2 2 W";
        sampleJourneys[4][1] = "MR";
        sampleJourneysJComboBox_selectionStrings[0] = sampleJourneys[0][0] + " " + sampleJourneys[0][1];
        for (int i=1; i < numberOf_sampleRoutes; i++){
            sampleJourneysJComboBox_selectionStrings[i] = "start configuration: " + sampleJourneys[i][0] + "     \n" +
                                                        "route: " + sampleJourneys[i][1];
        }
        sampleJourneySelector = new JComboBox(sampleJourneysJComboBox_selectionStrings);
        
        directions = new String[5];
        directions[0] = "select orientation from choices below";
        directions[1] = 'N' + "    ( = heading North)";
        directions[2] = 'E' + "    ( = heading East)";
        directions[3] = 'S' + "    ( = heading South)";
        directions[4] = 'W' + "    ( = heading West)";
        orientationSelector = new JComboBox(directions);

        xPositions = new String[xMax + 2];
        xPositions[0] = "select xPosition from choices below";
        for (int i = 1; i < (xMax + 2); i++) {
            xPositions[i] = (i - 1) + "    ( = xPosition)";
        }
        xPositionSelector = new JComboBox(xPositions);

        this.yPositions = new String[yMax + 2];
        this.yPositions[0] = "select yPosition from choices below";
        for (int i = 1; i < (yMax + 2); i++) {
            yPositions[i] = (i - 1) + "    ( = yPosition)";
        }
        yPositionSelector = new JComboBox(yPositions);
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
        this.add(sampleJourneySelector);
        
        xPositionSelector.setEnabled(false);
        yPositionSelector.setEnabled(false);
        orientationSelector.setEnabled(false);
        instructionSelector.setEnabled(false);
        
        xPositionSelector.addActionListener(new xPositionSelectorActionWatcher());
        yPositionSelector.addActionListener(new yPositionSelectorActionWatcher());
        orientationSelector.addActionListener(new directionSelectorActionWatcher());
        instructionSelector.addActionListener(new InstructionSelectorActionWatcher());
        sampleJourneySelector.addActionListener(new sampleRouteSelectorActionWatcher());
//        this.add(instructionStringJLabel);
    }
        

    private class sampleRouteSelectorActionWatcher implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String resultsMessage;
            JComboBox cb = (JComboBox) e.getSource();
            String selection = (String) cb.getSelectedItem();
            for (int i = 1; i < sampleJourneys.length; i++) {
                if (selection.equals(sampleJourneysJComboBox_selectionStrings[i])) {
//                    JOptionPane.showMessageDialog(null,
//                            "You chose: \n" + sampleJourneysJComboBox_selectionStrings[i]);
                    Rover rover = new Rover("rover", sampleJourneys[i][0], sampleJourneys[i][1]);
                    resultsMessage = "start \n";
                    resultsMessage += rover.statusMessage();
                    resultsMessage += "\n";
                    rover.executeInstructions();
                    resultsMessage += "end \n";
                    resultsMessage += rover.statusMessage();
                    resultsMessage += "\n";
                    JOptionPane.showMessageDialog(null, resultsMessage);
                }
            }
        }
    }

    private class xPositionSelectorActionWatcher implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
            String selection = (String) cb.getSelectedItem();
            for (int i = 1; i < (xMax + 2); i++) {
                if (selection.equals(xPositions[i])) {
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
                if (selection.equals(yPositions[i])) {
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
            if (selection.equals(directions[0])) {
            }
            if (selection.equals(directions[1])) { // North
                direction = 'N';
            }
            if (selection.equals(directions[2])) { // East
                direction = 'E';
            }
            if (selection.equals(directions[3])) { // South
                direction = 'S';
            }
            if (selection.equals(directions[4])) { // West
                direction = 'W';
            }
//                JOptionPane.showMessageDialog(null, "direction = " + direction);
        }
    }

    private class InstructionSelectorActionWatcher implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
            String selection = (String) cb.getSelectedItem();
            if (selection.equals(instructions[0])) {
//                JOptionPane.showMessageDialog(null, "you chose: " + instructions[0]);
            }
            if (selection.equals(instructions[1])) { // turn left
                instructionString += "L";
                mars.getDisplayPanel().getJourneyStringLabel().setText(mars.getDisplayPanel().getJourneyStringLabel().getText() + "L");
            }
            if (selection.equals(instructions[2])) { // turn right
                instructionString += "R";
                mars.getDisplayPanel().getJourneyStringLabel().setText(mars.getDisplayPanel().getJourneyStringLabel().getText() + "R");
            }
            if (selection.equals(instructions[3])) { // move forward one unit
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
