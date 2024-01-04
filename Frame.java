import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.*;

public class Frame extends JFrame{

    public static final String TITLE = "FRC Simulator";
    public static final Rectangle STARTING_BOUNDS = new Rectangle(100, 100, 600, 400);

    public Frame(){

        setTitle(TITLE);
        setBounds(STARTING_BOUNDS);
        
        add(new Board());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
}
