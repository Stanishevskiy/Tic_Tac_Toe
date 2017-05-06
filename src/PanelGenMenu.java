import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PanelGenMenu extends GameSettings {

    PanelGenMenu() {
        pnlGenMenu.setLayout(new GridBagLayout());          // Задаем компоновщик панели
        pnlGenMenu.setBackground(Color.CYAN);
        pnlApp.add(pnlGenMenu, "General Menu");  // Добавляем нашу панель к компоновщику карт

        // Название игры
        // Задаем название
        Label lblGenMenu = new Label();
        lblGenMenu.setText("TIC-TAC-TOE");
        // Задаем шрифт
        Font fntLbl = new Font("lblGenMenu", Font.BOLD, 54);
        lblGenMenu.setFont(fntLbl);
        lblGenMenu.setSize(150, 40);
        // Задаем параметры компоновщика и добавляем на панель
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 8;
        pnlGenMenu.add(lblGenMenu, gbc);

        // Кнопки в главном меню
        // Создаем объекты типа кнопка и задаем их название
        Button btnStartGame = new Button("Start Game");
        Button btnSettings = new Button("Settings");
        Button btnScore = new Button("Score");
        Button btnExit = new Button("Exit");
        // Задаем шрифт
        Font fntBtn = new Font("btnGenMenu", Font.BOLD, 44);
        btnStartGame.setFont(fntBtn);
        btnSettings.setFont(fntBtn);
        btnScore.setFont(fntBtn);
        btnExit.setFont(fntBtn);
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


        // Обработка событий
        // Переход на игровое поле
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnlGameMap = new PanelGameMap();         // Перед вызовом поля обновляем все игровые параметры
                cardLayout.show(pnlApp, "Game Map");
            }
        });
        // Переход в меню настроек по нажатию Settings
        btnSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(pnlApp, "Settings Menu");
            }
        });
        // Закрытие программы по нажатию Exit
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
