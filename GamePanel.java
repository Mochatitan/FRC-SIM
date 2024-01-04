package mochatitan.ana.game.window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mochatitan.ana.game.player.Player;
import mochatitan.ana.game.util.Constants;
import mochatitan.ana.game.util.Global;

import static mochatitan.ana.game.util.Constants.GamePanelConstants.*;

public class GamePanel extends JPanel implements ActionListener,MouseListener,KeyListener{

    private Timer timer;
    
    public Player player;
        
    public GamePanel(JFrame parent){
        player = new Player(100,100);

        addKeyListener(this);
        addMouseListener(this);
        

        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        timer = new Timer(DELAY, this);
        timer.start();
    }

    
    






    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setBackground(Color.BLUE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(this.getHeight());

        
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        System.out.println("mouse pressed");
        System.out.println("x: "+e.getX());
        System.out.println("y: "+e.getY());
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        
    }

    

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("key typed: " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("key pressed: " + e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("key released: " + e.getKeyChar());
    }


    @Override
    public void mouseEntered(MouseEvent e) {
       
    }


    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    

    
    
}
