package goSweatMarsRoversExercise;

import java.awt.*;
import javax.swing.*;

public class MarsExploration extends JFrame {

    private Container contentPane;
    private final ControlPanel myCP;
    private final DisplayPanel myDP;
    private final Dimension screenSize;

    private final int xMin = 0;
    private final int xMax = 5;
    private final int yMin = 0;
    private final int yMax = 5;

    public MarsExploration(String title) {
        super(title);
        Toolkit tk = Toolkit.getDefaultToolkit();
        screenSize = tk.getScreenSize();
        myCP = new ControlPanel(this);
        myDP = new DisplayPanel(this);
        initialise();
    }

    private void initialise() {
        this.setSize((int) (screenSize.width * 0.65), (int) (screenSize.height * 0.67));
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));
        contentPane = this.getContentPane();
        contentPane.add(myCP);
        contentPane.add(myDP);
    }
    
    public int getXMax(){ return xMax; }
    public int getYMax(){ return yMax; }
    public ControlPanel getControlPanel(){ return myCP; }
    public DisplayPanel getDisplayPanel(){ return myDP; }
    
}
