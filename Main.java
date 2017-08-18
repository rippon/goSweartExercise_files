/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goSweatMarsRoversExercise;

import java.awt.Point;

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
        
        System.out.println("rover: huey");
        Rover huey = new Rover("1 2 N", "LMLMLMLMM");
        huey.setPosition(new Point(1,2));
        huey.setHeading('N');
        huey.doInstructions("LMLMLMLMM");
        System.out.println("huey's new position is: (" + 
                (int) huey.getPosition().getX() + ", " + (int) huey.getPosition().getY() + ")");
        System.out.println("huey's new orientation is: " + huey.getHeading() + "\n");
        
        
        System.out.println("rover: dewey");
        Rover dewey = new Rover("3 3 E", "MMRMMRMRRM");
        dewey.setPosition(new Point(3,3));
        dewey.setHeading('E');
        dewey.doInstructions("MMRMMRMRRM");        
        System.out.println("dewey's new position is: (" + 
                (int) dewey.getPosition().getX() + ", " + (int) dewey.getPosition().getY() + ")");
        System.out.println("dewey's new orientation is: " + dewey.getHeading() + "\n");
    }
    
}
