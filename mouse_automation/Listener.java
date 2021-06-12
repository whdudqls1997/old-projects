package JCAPEX;

import java.awt.AWTException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

public class Listener implements NativeMouseInputListener, NativeKeyListener {
    
    private boolean bool;
    private int[] currG;
    
    private final Guns g = new Guns();
    private final int[] R301 = {0, 30, 0, 30, -10, 30, -10, 30, 0, 30, -8, 5, -10, 10, -8, 11, -10, 10, 30, 5, 20, 11, 15, 2, -3, 5, -4, 0, -7, 5, -7, 5};
    private final int[] R99 = {0, 35, 0, 40, -15, 40, -15, 50, -15, 50, 0, 50, 5, 45, 0, 45, 0, 30, 0, 30};
    private final int[] FlatLine = {0, 30, 5, 30, 15, 30, 20, 30, 15, 20, 0, 20, 0, 20, -5, 8, -7, 6, -15, 0, -15, 8, -9, 1, -1, 8, 10, 8, 20, 10, 22, 10, 28, 10, 28, 10, 20, 10};
    private boolean peaceKeeper;
    
    public Listener() throws AWTException{
        bool = false;
        peaceKeeper = false;
        currG = R301;
    }
    
    @Override
    public void nativeKeyPressed(NativeKeyEvent nke) {
        if (nke.getKeyCode() == NativeKeyEvent.VC_F10)
            bool = !bool;
        if (nke.getKeyCode() == NativeKeyEvent.VC_F1){
            currG = R301;
            peaceKeeper = false;
        }
        if (nke.getKeyCode() == NativeKeyEvent.VC_F2){
            currG = R99;
            peaceKeeper = false;
        }
        if (nke.getKeyCode() == NativeKeyEvent.VC_F3){
            currG = FlatLine;
            peaceKeeper = false;
        }
        if (nke.getKeyCode() == NativeKeyEvent.VC_F4)
            peaceKeeper = true;
        /*
        if (nke.getKeyCode() == NativeKeyEvent.VC_F3)
            currG = SpitFire;
        if (nke.getKeyCode() == NativeKeyEvent.VC_F4)
            currG = FlatLine;
        */
    }
    
    private void sequencer(int x){
        if (x < currG.length) {
            try {
                g.startSequence(currG[x], currG[x + 1]);
            } catch (InterruptedException | AWTException ex) {
                Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
            }
            sequencer(x += 2);
        }
    }

    @Override
    public void nativeMousePressed(NativeMouseEvent nme) {
        if(bool && nme.getButton() == NativeMouseEvent.BUTTON1){
            if(peaceKeeper){
                try {
                    g.peaceKeeper();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
                sequencer(0);
        }
    }
    
    @Override
    public void nativeMouseReleased(NativeMouseEvent nme) {
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nke) {
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nke) {
    }
    
    @Override
    public void nativeMouseClicked(NativeMouseEvent nme) {
    }

    @Override
    public void nativeMouseMoved(NativeMouseEvent nme) {
    }

    @Override
    public void nativeMouseDragged(NativeMouseEvent nme) {
    }
}