package JCAPEX;

import com.sun.glass.events.KeyEvent;
import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;

public class Guns {
    
    private final Robot r;
    
    public Guns() throws AWTException{
        r = new Robot();
    }
    
    public void startSequence(int x, int y) throws InterruptedException, AWTException{
        Point temp;
        temp = getPos();
        r.mouseMove((int) temp.getX() + x, (int) temp.getY() + y);
        Thread.sleep(100);
    }
    
    public void peaceKeeper() throws InterruptedException{
        Thread.sleep(100);
        r.keyPress(KeyEvent.VK_R);
        r.keyRelease(KeyEvent.VK_R);
        Thread.sleep(200);
        r.keyPress(KeyEvent.VK_2);
        r.keyRelease(KeyEvent.VK_2);
        Thread.sleep(200);
        r.keyPress(KeyEvent.VK_1);
        r.keyRelease(KeyEvent.VK_1);
    }
    
    private Point getPos(){
        Point a = MouseInfo.getPointerInfo().getLocation();
        return a;
    }
}