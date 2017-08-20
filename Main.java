/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goSweatMarsRoversExercise;

import javax.swing.JOptionPane;

/**
 *
 * @author rippon
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        (new MarsExploration("Mars Exploration")).setVisible(true);

        String resultsMessage;

        Rover huey = new Rover("huey", "1 2 N", "LMLMLMLMM");
        resultsMessage = "start \n";
        resultsMessage += huey.statusMessage();
        resultsMessage += "\n";
        huey.executeInstructions();
        resultsMessage += "end \n";
        resultsMessage += huey.statusMessage();
        resultsMessage += "\n";

        Rover dewey = new Rover("dewey", "3 3 E", "MMRMMRMRRM");
        resultsMessage += "start \n";
        resultsMessage += dewey.statusMessage();
        resultsMessage += "\n";
        dewey.executeInstructions();
        resultsMessage += "end \n";
        resultsMessage += dewey.statusMessage();
        resultsMessage += "\n";

//        JOptionPane.showMessageDialog(null, resultsMessage);
    }


}
