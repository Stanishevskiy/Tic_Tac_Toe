import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class GameWindow extends Frame implements CardPanels {

    public static void main(String[] args) {
        GameWindow playGame = new GameWindow();
    }

    private GameWindow() {
        // Задаем размеры окна приложения и его название
        setBounds(300, 50, 516, 538);
        setTitle("Tic-Tac-Toe");

        // Вызов объекта панели глвного меню
        PanelGenMenu genMenu = new PanelGenMenu();
        // Вызов объекта панели меню настроек
        PanelSetMenu setMenu = new PanelSetMenu();

        PanelScoreMenu scoreMenu = new PanelScoreMenu();

        add(pnlApp);

        setVisible(true);

        // Завершение программы по закрытию окна приложения
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
}