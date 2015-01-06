package algoritmiek;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by sam on 25/12/2014.
 */
public class Keys implements KeyListener {

    private boolean[] keys = new boolean[120];
    public boolean i;

    public void update() {
        i = keys[KeyEvent.VK_I];
    }

    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    public void keyTyped(KeyEvent e) {

    }
}