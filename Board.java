
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
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
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.FontMetrics;
import java.awt.Font;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Point;

import javax.swing.ImageIcon;

public class Board extends JPanel implements ActionListener,MouseListener,KeyListener,MouseMotionListener{

    public static final int DELAY = 20; //ms delay
    public static int camX = 0;
    public int mouseX = 0;
    public int mouseY = 0;
    private Timer timer;
    private Image title_background = loadImage("resources\\img\\coolbackground.jpg", 600, 400);
    private Image main_background = loadImage("resources\\img\\empty.jpg", 900, 400);

    Button newGameButton;
    Button settingsButton;

    public Board(){
        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);

        timer = new Timer(DELAY, this);
        timer.start();

        MyFunction f = () -> Constants.scene = Scene.MAIN_GAME;
        MyFunction openSettings = () -> openSettings();

        newGameButton = new Button(150,220,300,50,Color.GREEN, "PLAY", Scene.TITLE,10010, f);
        settingsButton = new Button(150,300,300,50,Color.GREEN, "SETTINGS", Scene.TITLE, 10020, openSettings);
        
        //newGameButton.press(){System.out.println("chick");}
    }


      
    @Override
    public void actionPerformed(ActionEvent e) {
        if(mouseX >= 500 && camX < 200){
            camX += 5;
            System.out.println("moving right");
        }
        else if(mouseX <= 100 && camX > 0){
            camX -= 5;
            System.out.println("moving left");
        }
        repaint();
    }


    public void paint(Graphics g){
        if(Constants.scene == Scene.TITLE){
            //background
            //this.drawBackground(g,Color.GRAY);
            g.drawImage(title_background,0,0, null);
            newGameButton.draw(g);
            settingsButton.draw(g);

        }
        if(Constants.scene == Scene.MAIN_GAME){
            g.drawImage(main_background,0-camX,0,null);
        }
    }

 
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyText(e.getKeyCode()) + " pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyText(e.getKeyCode()) + " released");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mouse pressed at x: "+e.getX()+", y: "+e.getY());
        newGameButton.checkIfPressed(e.getPoint());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouse released at x: "+e.getX()+", y: "+e.getY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    @Override
    public void mouseDragged(MouseEvent e) {

    }



    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

 
    public void drawBackground(Graphics g, Color color){
        g.setColor(color);
        g.fillRect(0,0,600,400);
    }
    public void drawRectangleWithText(Graphics g, int x, int y, int width, int height, Color color, String text){
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.setColor(Color.YELLOW);
        g.drawRect(x, y, width, height);
        text.length();
        if(text != ""){
            g.setColor(Color.BLACK);
        this.drawCenteredString(g, text, new Rectangle(x,y,width,height), new Font("Serif", Font.BOLD, 18));
        }
    }
    /**
     * Draw a String centered in the middle of a Rectangle.
     *
     * @param g The Graphics instance.
     * @param text The String to draw.
     * @param rect The Rectangle to center the text in.
     */
    public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        // Get the FontMetrics
        FontMetrics metrics = g.getFontMetrics(font);
        // Determine the X coordinate for the text
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        // Set the font
        g.setFont(font);
        // Draw the String
        g.drawString(text, x, y);
    }
    public boolean isPointInRectangle(Point point, Rectangle rect){
        
        if (( point.x >= rect.getMinX() && point.x <= rect.getMaxX() )   // check if X is within range
         && ( point.y >= rect.getMinY() && point.y <= rect.getMaxY())){
            return true;
         }
         return false;
    }

    public Image loadImage(String imageName, int width, int height){
        ImageIcon ii = new ImageIcon(imageName);
        return ii.getImage().getScaledInstance(width, height, 0);
    }
    public Image loadImage(String imageName){
        ImageIcon ii = new ImageIcon(imageName);
        return ii.getImage();
    }

    public void openSettings(){

    }



    
}
