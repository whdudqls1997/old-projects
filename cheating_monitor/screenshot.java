package summwhere;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class screenshot {
    public screenshot(){
    }
    public void saveScreenShot(String name) {
        try {
            Robot robot = new Robot(); 
            String format = "png";
            String fileName = name + "." + format;
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
            ImageIO.write(screenFullImage, format, new File("C:\\tempS\\"+fileName));
        } catch (AWTException | IOException ex) {
            System.err.println(ex);
        }
    }
}