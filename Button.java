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
import java.awt.Rectangle;
import java.awt.FontMetrics;
import java.awt.Font;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Point;

public class Button {
    
    public int x;
    public int y;
    public int width;
    public int height;
    public String text;
    public Color color;
    public Rectangle buttonBounds;
    public Scene buttonScene;
    public int ID;
    public MyFunction F;

    /**
     * Creates a button using the Mochatitan framework, just input the data and out comes the button
     * @param x the x coordinate of the button
     * @param y the y coordinate of the button
     * @param width the width of the button
     * @param height the height of the button
     * @param color the color of the button
     * @param text the text on the button
     * @param buttonScene the scene the button appears in
     * @param ID the specific ID of the button, appears when you click it in the terminal
     * @param F the function of the button, format MyFunction f = () -> System.out.println("chicken");
     */
    public Button(int x, int y, int width, int height, Color color, String text, Scene buttonScene, int ID, MyFunction F) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.text = text;
        this.buttonScene = buttonScene;
        this.ID = ID;
        this.F = F;

        this.buttonBounds = new Rectangle(x,y,width,height);
    }


    public void checkIfPressed(Point point){
        if(correctScene()){
            if (( point.x >= buttonBounds.getMinX() && point.x <= buttonBounds.getMaxX() )   // check if X is within range
             && ( point.y >= buttonBounds.getMinY() && point.y <= buttonBounds.getMaxY())){
                this.press();
             }        
        }
    }

    public void press(){
        System.out.println("pressed ID="+this.ID);
        F.apply();
    }


    public void draw(Graphics g){
            if(correctScene()){
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
    }






    private void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
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
    public boolean correctScene(){
        if(Constants.scene == buttonScene){return true;}
        return false;
    }

}
