import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class GameWindowClose extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
