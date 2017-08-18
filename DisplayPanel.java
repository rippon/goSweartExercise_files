/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package goSweatMarsRoversExercise;

import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.*;

public class DisplayPanel extends JPanel {

    private MarsExploration mars;
    private JLabel xPositionInfoLabel;
    private JLabel yPositionInfoLabel;
    private JLabel directionInfoLabel;
    private JLabel journeyStringLabel;
    private JLabel activityReportingLabel;

    DisplayPanel(MarsExploration mars) {
        super();
        this.mars = mars;
        xPositionInfoLabel = new JLabel("   xPosition info: ");
        yPositionInfoLabel = new JLabel("   yPosition info: ");
        directionInfoLabel = new JLabel("   direction info: ");
        journeyStringLabel = new JLabel("   journey string: ");
        activityReportingLabel = new JLabel("   activity reporting: ");
        initialise();
    }

    private void initialise() {
        setLayout(new GridLayout(10, 1));
        add(xPositionInfoLabel);
        add(yPositionInfoLabel);
        add(directionInfoLabel);
        add(journeyStringLabel);
        add(activityReportingLabel);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    public MarsExploration getMars() { return mars; }
    public JLabel getxPositionInfoLabel() { return xPositionInfoLabel; }
    public JLabel getyPositionInfoLabel() { return yPositionInfoLabel; }
    public JLabel getDirectionInfoLabel() { return directionInfoLabel; }
    public JLabel getJourneyStringLabel() { return journeyStringLabel; }
    public JLabel getActivityReportingLabel() { return activityReportingLabel; }
}
