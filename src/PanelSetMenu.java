import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PanelSetMenu extends Frame implements GamePanelObjects {

    PanelSetMenu() {

        pnlSettings.setLayout(new GridBagLayout());             // Задаем компоновщик панели
        pnlApp.add(pnlSettings, "Settings Menu");    // Добавляем нашу панель к компоновщику карт

        // Заглавие меню
        Label lblSettings = new Label("Settings");
        Font fntLblSettings = new Font("Helvetica", Font.BOLD, 34);
        lblSettings.setFont(fntLblSettings);
        gbc.gridx = 0;
        gbc.gridy = 0;
        pnlSettings.add(lblSettings, gbc);

        // Добавляем составляющие меню
        Font fntSetElements = new Font("Helvetica", Font.BOLD, 24);
        // Настройки игрока 1
        gbc.gridx = 0;
        gbc.gridy = 1;
        Label lblPlayer1 = new Label("Player 1:");
        lblPlayer1.setFont(fntSetElements);
        pnlSettings.add(lblPlayer1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        Label lblPlayer1Name = new Label("Name: ");
        lblPlayer1Name.setFont(fntSetElements);
        pnlSettings.add(lblPlayer1Name, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        TextField txtNamePlayer1 = new TextField("Player 1");
        txtNamePlayer1.setFont(fntSetElements);
        pnlSettings.add(txtNamePlayer1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        Label lblPlayer1Type = new Label("Player: ");
        lblPlayer1Type.setFont(fntSetElements);
        pnlSettings.add(lblPlayer1Type, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        Label chooseTypePlayer1 = new Label("AI, Human");
        chooseTypePlayer1.setFont(fntSetElements);
        pnlSettings.add(chooseTypePlayer1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        Label lblPlayer1FigureType = new Label("Figure: ");
        lblPlayer1FigureType.setFont(fntSetElements);
        pnlSettings.add(lblPlayer1FigureType, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        Label chooseFigureTypePlayer1 = new Label("Cross, Circle, Square");
        chooseFigureTypePlayer1.setFont(fntSetElements);
        pnlSettings.add(chooseFigureTypePlayer1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        Label lblPlayer1FigureColor = new Label("Color: ");
        lblPlayer1FigureColor.setFont(fntSetElements);
        pnlSettings.add(lblPlayer1FigureColor, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        Label chooseFigureColorPlayer1 = new Label("Red, Blue, Yellow, Green, Black");
        chooseFigureColorPlayer1.setFont(fntSetElements);
        pnlSettings.add(chooseFigureColorPlayer1, gbc);

        // Настройки игрока 2
        gbc.gridx = 0;
        gbc.gridy = 6;
        Label lblPlayer2 = new Label("Player 2:");
        lblPlayer2.setFont(fntSetElements);
        pnlSettings.add(lblPlayer2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        Label lblPlayer2Name = new Label("Player: ");
        lblPlayer2Name.setFont(fntSetElements);
        pnlSettings.add(lblPlayer2Name, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        TextField txtNamePlayer2 = new TextField("Player 2");
        txtNamePlayer2.setFont(fntSetElements);
        pnlSettings.add(txtNamePlayer2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        Label lblPlayer2Type = new Label("Player: ");
        lblPlayer2Type.setFont(fntSetElements);
        pnlSettings.add(lblPlayer2Type, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        Label chooseTypePlayer2 = new Label("AI, Human");
        chooseTypePlayer2.setFont(fntSetElements);
        pnlSettings.add(chooseTypePlayer2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        Label lblPlayer2FigureType = new Label("Figure: ");
        lblPlayer2FigureType.setFont(fntSetElements);
        pnlSettings.add(lblPlayer2FigureType, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        Label chooseFigureTypePlayer2 = new Label("Cross, Circle, Square");
        chooseFigureTypePlayer2.setFont(fntSetElements);
        pnlSettings.add(chooseFigureTypePlayer2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        Label lblPlayer2FigureColor = new Label("Color: ");
        lblPlayer2FigureColor.setFont(fntSetElements);
        pnlSettings.add(lblPlayer2FigureColor, gbc);

        gbc.gridx = 1;
        gbc.gridy = 10;
        Label chooseFigureColorPlayer2 = new Label("Red, Blue, Yellow, Green, Black");
        chooseFigureColorPlayer2.setFont(fntSetElements);
        pnlSettings.add(chooseFigureColorPlayer2, gbc);

        // Игровые параметры
        gbc.gridx = 0;
        gbc.gridy = 11;
        Label lblGameFieldSize = new Label("Field Size: ");
        lblGameFieldSize.setFont(fntSetElements);
        pnlSettings.add(lblGameFieldSize, gbc);

        gbc.gridx = 1;
        gbc.gridy = 11;
        Label chooseGameFieldSize = new Label("3...9");
        chooseGameFieldSize.setFont(fntSetElements);
        pnlSettings.add(chooseGameFieldSize, gbc);

        gbc.gridx = 0;
        gbc.gridy = 12;
        Label lblCombToWin = new Label("Winning combination: ");
        lblCombToWin.setFont(fntSetElements);
        pnlSettings.add(lblCombToWin, gbc);

        gbc.gridx = 1;
        gbc.gridy = 12;
        Label chooseCombToWin = new Label("3...9");
        chooseCombToWin.setFont(fntSetElements);
        pnlSettings.add(chooseCombToWin, gbc);

        // Добавляем кнопку выхода из меню настроек
        gbc.gridx = 0;
        gbc.gridy = 13;
        Button btnToGenMenu = new Button("Back To Menu");
        btnToGenMenu.setFont(fntSetElements);
        pnlSettings.add(btnToGenMenu, gbc);


        // Обработка событий
        // Обработка клавиш меню настроек
        btnToGenMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.previous(pnlApp);
            }
        });
    }
}
