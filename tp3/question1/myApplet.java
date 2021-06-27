package question1;
import java.applet.*;
import javax.swing.JApplet;
import java.awt.*;

/**
 * Write a description of class myApplet here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class myApplet extends JApplet
{
    //it doesn't work
    public void paint(Graphics g){
        g.drawString("test test", 400, 500);
    }
}
