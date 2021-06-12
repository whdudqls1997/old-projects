import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.util.Queue;

public class Automations implements ClipboardOwner {

    private Clipboard cb;
    private Robot r;
    
    public Automations() throws AWTException{
        cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        r = new Robot();
    }
    
    public tab(int i){
        while(i != 0){
           r.keyPress(KeyEvent.VK_TAB);
           sleep(50);
           r.keyRelease(KeyEvent.VK_TAB);
        }
    }
    
    public void keyPress(Char c){
        r.keyPress(Character.toUpperCase(c));
        sleep(50);
        r.keyRelease(Character.toUpperCase(c));
    }
    
    public void copy(String s){
        StringSelection ss = new StringSelection(s);
        cb.setContents(ss, this);
    }
    
    public void paste(){
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        sleep(50);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_V);
    }
    
    private void sleep(int i){
        Thread.sleep(i);
    }
    
    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}