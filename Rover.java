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
    private Point position;
    private char heading;

    public Rover(String startConfiguration, String instructions) {
    }

    public void doInstructions(String instructions) {
        for (int i = 0; i < instructions.length(); i++) {
            char c = instructions.charAt(i);
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
    
    public void setHeading(char toThis){ heading = toThis; }
    public char getHeading(){ return heading; }
    public void setPosition(Point toThis){ position = toThis; }
    public Point getPosition(){ return position; }

}
