import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class GameWindow extends Frame {

    GameWindow() {
        // Отрисовка главного окна
        setBounds(300, 50, 500, 500);
        setTitle("Tic-Tac-Toe");

        // Переопределяем классы отвечающие за обработку событий своими
        addWindowListener(new MyWindowAdapter());

        Panel genMenuPanel = new Panel();



        setVisible(true);
    }
}

// Отвечает за завершение работы программы по закрытию окна
class MyWindowAdapter extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}