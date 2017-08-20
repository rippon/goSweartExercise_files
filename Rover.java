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
// names could be: huey, dewey, louis, gooey
public class Rover {
    private final String name;
    private Point position;
    private char heading;
    private final String instructions;

    //constructor
    public Rover(String name, String startConfiguration, String instructions){
        this.name = name;
        this.instructions = instructions;

        this.position = new Point();
        int x, y;
        char c;

        if (startConfigurationString_formatGood()) {
            c = startConfiguration.charAt(0);
            x = Character.getNumericValue(c);
            c = startConfiguration.charAt(2);
            y = Character.getNumericValue(c);
            this.position.setLocation(new Point(x, y));
            this.heading = startConfiguration.charAt(4);
        }
    }

    public void executeInstructions() {
        for (int i = 0; i < this.instructions.length(); i++) {
            char c = this.instructions.charAt(i);
            switch (c) {
                case 'L':
                    turnLeft();
                    break;
                case 'R':
                    turnRight();
                    break;
                case 'M':
                    move();
                    break;
                default:
                    break;
            }
        }
    }

    private void turnLeft() {
        switch (heading) {
            case 'N':
                setHeading('W');
                break;
            case 'E':
                setHeading('N');
                break;
            case 'S':
                setHeading('E');
                break;
            case 'W':
                setHeading('S');
                break;
            default:
                break;
        }
    }

    private void turnRight() {
        switch (heading) {
            case 'N':
                setHeading('E');
                break;
            case 'E':
                setHeading('S');
                break;
            case 'S':
                setHeading('W');
                break;
            case 'W':
                setHeading('N');
                break;
            default:
                break;
        }
    }

    private void move() {
        switch (heading) {
            case 'N':
                position.translate(0, 1);
                break;
            case 'E':
                position.translate(1, 0);
                break;
            case 'S':
                position.translate(0, -1);
                break;
            case 'W':
                position.translate(-1, 0);
                break;
            default:
                break;
        }
    }

    public String statusMessage() {
        String message;

        message = this.name + "'s position is:   ("
                + (int) this.position.getX() + ", " + (int) this.position.getY() + ") \n";
        message += this.name + "'s heading is:  " + this.heading + "\n";
        return message;
    }
    private void doNothing(){ }
    private boolean startConfigurationString_formatGood(){ return true; }
    public void setHeading(char toThis){ this.heading = toThis; }
    public char getHeading(){ return this.heading; }
    public void setPosition(Point toThis){ this.position = toThis; }
    public Point getPosition(){ return this.position; }
    public String getName(){ return this.name; }

}
