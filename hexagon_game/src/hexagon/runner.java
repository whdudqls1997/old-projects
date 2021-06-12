package hexagon;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class runner extends JFrame{

    Hexagon hex;
    
    public runner() {
        super("Lines Drawing Demo");
        
        hex = new Hexagon();
        hex.activate();
 
        setSize(480, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
 
    void lineline(Graphics2D g2d, Point2D x){
        g2d.draw(new Line2D.Double(100 + x.getX() + 5, 100 + 10 + x.getY(), 100 + 10 + x.getX(), 100 + x.getY()));
        g2d.draw(new Line2D.Double(100 + x.getX() + 10, 100 + x.getY(), 100 + 5 + x.getX(), 100 - 10 + x.getY()));
        g2d.draw(new Line2D.Double(100 + x.getX() + 5, 100 - 10 + x.getY(), 100 - 5 + x.getX(), 100 - 10 + x.getY()));
        g2d.draw(new Line2D.Double(100 + x.getX() - 5, 100 - 10 + x.getY(), 100 - 10 + x.getX(), 100 + x.getY()));
        g2d.draw(new Line2D.Double(100 + x.getX() - 10, 100 + x.getY(), 100 - 5 + x.getX(), 100 + 10 + x.getY()));
        g2d.draw(new Line2D.Double(100 + x.getX() - 5, 100 + 10 + x.getY(), 100 + 5 + x.getX(), 100 + 10 + x.getY()));
    }
    
    void drawLines(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.draw(new Line2D.Double(100 + 5, 100 + 10 , 100 + 10 , 100));
        g2d.draw(new Line2D.Double(100  + 10, 100 , 100 + 5 , 100 - 10 ));
        g2d.draw(new Line2D.Double(100  + 5, 100 - 10 , 100 - 5  , 100 - 10 ));
        g2d.draw(new Line2D.Double(100  - 5, 100 - 10 , 100 - 10 , 100 ));
        g2d.draw(new Line2D.Double(100 - 10, 100 , 100 - 5 , 100 + 10 ));
        g2d.draw(new Line2D.Double(100  - 5, 100 + 10 , 100 + 5 , 100 + 10 ));
        
        /*
        for(Point2D x : hex.returnMap().keySet()){
            for(Point2D y : hex.returnMap().get(x)){
                lineline(g2d, y);
            }
        }
        */
 
        //g2d.drawLine(120, 50, 360, 50);
 
        //g2d.draw(new Line2D.Double(59.2d, 99.8d, 419.1d, 99.8d));
 
        //g2d.draw(new Line2D.Float(21.50f, 132.50f, 459.50f, 132.50f));
    }
 
    public void paint(Graphics g) {
        super.paint(g);
        drawLines(g);
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new runner().setVisible(true);
            }
        });
    }
}