import java.awt.*;

class GameWindow extends Frame implements GamePanelObjects {

    public static void main(String[] args) {
        GameWindow playGame = new GameWindow();
    }

    GameWindow() {
        // Задаем размеры окна приложения и его название
        setBounds(300, 50, 516, 538);
        setTitle("Tic-Tac-Toe");

        // Вызов объекта панели глвного меню
        PanelGenMenu genMenu = new PanelGenMenu();
        // Вызов объекта панели меню настроек
        PanelSetMenu setMenu = new PanelSetMenu();

        // Добавляем на окно приложения панель содержащую в себе остальные (CardLayout)
        add(pnlApp);

        // Завершение программы по закрытию окна приложения
        addWindowListener(new GameWindowClose());

        setVisible(true);

        // Проверка размеров окна приложения
        System.out.println(pnlGenMenu.getWidth());
        System.out.println(pnlGenMenu.getHeight());
    }
}