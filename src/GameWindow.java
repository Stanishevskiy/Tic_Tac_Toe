import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class GameWindow extends Frame {

    GameWindow() {
        // Отрисовка главного окна и основные свойства
        setBounds(300, 50, 516, 538);
        setTitle("Tic-Tac-Toe");
        addWindowListener(new MyWindowAdapter());

        // Панель/карты приложения содержит в себе остальные панели
        CardLayout cardLayout = new CardLayout();
        Panel pnlApp = new Panel(cardLayout);
        add(pnlApp);

        // Добавляем панель главного меню
        Panel pnlGenMenu = new Panel();
        pnlGenMenu.setLayout(new GridBagLayout());
        pnlApp.add(pnlGenMenu, "General Menu");
        // Создаем ограничитель для компоновщика
        GridBagConstraints gbc = new GridBagConstraints();

        // Название приложения
        Label lblGenMenu = new Label();
        lblGenMenu.setText("TIC-TAC-TOE");
        lblGenMenu.setBackground(Color.LIGHT_GRAY);
        // Задаем шрифт
        Font fntLbl = new Font("Helvetica", Font.BOLD, 54);
        lblGenMenu.setFont(fntLbl);
        lblGenMenu.setSize(150, 40);
        // Задаем параметры компоновщика и добавляем на панель
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 8;
        pnlGenMenu.add(lblGenMenu, gbc);

        // Задаем кнопки главного меню
        Button btnStartGame = new Button("Start Game");
        Button btnSettings = new Button("Settings");
        Button btnScore = new Button("Score");
        Button btnExit = new Button("Exit");
        // Задаем шрифт и расположение кнопок
        Font fntBtn = new Font("Helvetica", Font.BOLD, 44);
        btnStartGame.setFont(fntBtn);
        btnStartGame.setSize(100, 25);
        btnSettings.setFont(fntBtn);
        btnSettings.setSize(100, 25);
        btnScore.setFont(fntBtn);
        btnScore.setSize(100, 25);
        btnExit.setFont(fntBtn);
        btnExit.setSize(100, 25);
        // Задаем параметры компоновщика и добавляем на панель
        gbc.gridy = 1;
        gbc.weighty = 2;
        gbc.ipadx = 20;
        pnlGenMenu.add(btnStartGame, gbc);
        gbc.gridy = 2;
        gbc.ipadx = 81;
        pnlGenMenu.add(btnSettings, gbc);
        gbc.gridy = 3;
        gbc.ipadx = 132;
        pnlGenMenu.add(btnScore, gbc);
        gbc.weighty = 4;
        gbc.gridy = 4;
        gbc.ipadx = 172;
        pnlGenMenu.add(btnExit, gbc);


        setVisible(true);
        // Проверка размера панели
        System.out.println(pnlGenMenu.getWidth());
        System.out.println(pnlGenMenu.getHeight());
    }
}

// Отвечает за завершение работы программы по закрытию окна
class MyWindowAdapter extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}