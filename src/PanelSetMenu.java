import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class PanelSetMenu extends GameSettings {

    PanelSetMenu() {
        pnlSetMenu.setLayout(new GridBagLayout());             // Задаем компоновщик панели
        pnlSetMenu.setBackground(Color.GRAY);
        pnlApp.add(pnlSetMenu, "Settings Menu");    // Добавляем нашу панель к компоновщику карт

        // Заглавие меню
        Label lblSettings = new Label("Settings");
        Font fntLblSettings = new Font("Helvetica", Font.BOLD, 28);
        lblSettings.setFont(fntLblSettings);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 0;
        gbc.ipady = 10;
        gbc.gridwidth = 2;
        pnlSetMenu.add(lblSettings, gbc);

        // Добавляем составляющие меню
        Font fntSetElements = new Font("Helvetica", Font.BOLD, 18);
        // Настройки игрока 1
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 20;
        gbc.ipady = 4;
        Label lblPlayer1 = new Label("Player 1");
        lblPlayer1.setFont(fntSetElements);
        pnlSetMenu.add(lblPlayer1, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipady = 0;
        Label lblPlayer1Name = new Label("Name: ");
        lblPlayer1Name.setFont(fntSetElements);
        pnlSetMenu.add(lblPlayer1Name, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.ipadx = 60;
        TextField txtNamePlayer1 = new TextField("Player 1");
        txtNamePlayer1.setBackground(Color.LIGHT_GRAY);
        txtNamePlayer1.setFont(fntSetElements);
        pnlSetMenu.add(txtNamePlayer1, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.ipadx = 20;
        Label lblPlayer1Type = new Label("Player: ");
        lblPlayer1Type.setFont(fntSetElements);
        pnlSetMenu.add(lblPlayer1Type, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.ipadx = 69;
        chsTypePlayer1.add("Human");
        chsTypePlayer1.add("AI");
        chsTypePlayer1.setBackground(Color.LIGHT_GRAY);
        chsTypePlayer1.setFont(fntSetElements);
        pnlSetMenu.add(chsTypePlayer1, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.ipadx = 20;
        Label lblPlayer1FigureType = new Label("Figure: ");
        lblPlayer1FigureType.setFont(fntSetElements);
        pnlSetMenu.add(lblPlayer1FigureType, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.ipadx = 63;
        chsFigureTypePlayer1.add("Cross");
        chsFigureTypePlayer1.add("Circle");
        chsFigureTypePlayer1.add("Square");
        chsFigureTypePlayer1.add("fCircle");
        chsFigureTypePlayer1.add("fSquare");
        chsFigureTypePlayer1.setBackground(Color.LIGHT_GRAY);
        chsFigureTypePlayer1.setFont(fntSetElements);
        pnlSetMenu.add(chsFigureTypePlayer1, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.ipadx = 20;
        Label lblPlayer1FigureColor = new Label("Color: ");
        lblPlayer1FigureColor.setFont(fntSetElements);
        pnlSetMenu.add(lblPlayer1FigureColor, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.ipadx = 71;
        chsFigureColorPlayer1.add("Red");
        chsFigureColorPlayer1.add("Blue");
        chsFigureColorPlayer1.add("Yellow");
        chsFigureColorPlayer1.add("Green");
        chsFigureColorPlayer1.add("Purple");
        chsFigureColorPlayer1.setBackground(Color.LIGHT_GRAY);
        chsFigureColorPlayer1.setFont(fntSetElements);
        pnlSetMenu.add(chsFigureColorPlayer1, gbc);

        // Настройки игрока 2
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.ipady = 4;
        gbc.ipadx = 20;
        Label lblPlayer2 = new Label("Player 2");
        lblPlayer2.setFont(fntSetElements);
        pnlSetMenu.add(lblPlayer2, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.ipady = 0;
        Label lblPlayer2Name = new Label("Name: ");
        lblPlayer2Name.setFont(fntSetElements);
        pnlSetMenu.add(lblPlayer2Name, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.ipadx = 60;
        TextField txtNamePlayer2 = new TextField("Player 2");
        txtNamePlayer2.setBackground(Color.LIGHT_GRAY);
        txtNamePlayer2.setFont(fntSetElements);
        pnlSetMenu.add(txtNamePlayer2, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.ipadx = 20;
        Label lblPlayer2Type = new Label("Player: ");
        lblPlayer2Type.setFont(fntSetElements);
        pnlSetMenu.add(lblPlayer2Type, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.ipadx = 69;
        chsTypePlayer2.add("AI");
        chsTypePlayer2.add("Human");
        chsTypePlayer2.setBackground(Color.LIGHT_GRAY);
        chsTypePlayer2.setFont(fntSetElements);
        pnlSetMenu.add(chsTypePlayer2, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.ipadx = 20;
        Label lblPlayer2FigureType = new Label("Figure: ");
        lblPlayer2FigureType.setFont(fntSetElements);
        pnlSetMenu.add(lblPlayer2FigureType, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.ipadx = 63;
        chsFigureTypePlayer2.add("Circle");
        chsFigureTypePlayer2.add("Cross");
        chsFigureTypePlayer2.add("Square");
        chsFigureTypePlayer2.add("fCircle");
        chsFigureTypePlayer2.add("fSquare");
        chsFigureTypePlayer2.setBackground(Color.LIGHT_GRAY);
        chsFigureTypePlayer2.setFont(fntSetElements);
        pnlSetMenu.add(chsFigureTypePlayer2, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.ipadx = 20;
        Label lblPlayer2FigureColor = new Label("Color: ");
        lblPlayer2FigureColor.setFont(fntSetElements);
        pnlSetMenu.add(lblPlayer2FigureColor, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.ipadx = 71;
        chsFigureColorPlayer2.add("Blue");
        chsFigureColorPlayer2.add("Red");
        chsFigureColorPlayer2.add("Yellow");
        chsFigureColorPlayer2.add("Green");
        chsFigureColorPlayer2.add("Purple");
        chsFigureColorPlayer2.setBackground(Color.LIGHT_GRAY);
        chsFigureColorPlayer2.setFont(fntSetElements);
        pnlSetMenu.add(chsFigureColorPlayer2, gbc);

        // Игровые параметры
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.ipady = 4;
        gbc.ipadx = 20;
        Label lblGameFieldSize = new Label("Field Size: ");
        lblGameFieldSize.setFont(fntSetElements);
        pnlSetMenu.add(lblGameFieldSize, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 11;
        gbc.ipadx = 40;
        chsCellsCount.add("3");
        chsCellsCount.add("4");
        chsCellsCount.add("5");
        chsCellsCount.add("6");
        chsCellsCount.add("7");
        chsCellsCount.add("8");
        chsCellsCount.add("9");
        chsCellsCount.setBackground(Color.LIGHT_GRAY);
        chsCellsCount.setFont(fntSetElements);
        pnlSetMenu.add(chsCellsCount, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.ipadx = 20;
        Label lblCombToWin = new Label("Combo to Win: ");
        lblCombToWin.setFont(fntSetElements);
        pnlSetMenu.add(lblCombToWin, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 12;
        gbc.ipadx = 40;
        chsCombToWin.add("3");
        chsCombToWin.setBackground(Color.LIGHT_GRAY);
        chsCombToWin.setFont(fntSetElements);
        pnlSetMenu.add(chsCombToWin, gbc);

        // Добавляем кнопку выхода из меню настроек
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.ipady = 10;
        gbc.gridwidth = 2;
        Button btnToGenMenu = new Button("Back To Menu");
        btnToGenMenu.setFont(fntSetElements);
        pnlSetMenu.add(btnToGenMenu, gbc);


        // Обработка событий
        // Обработка клавиш меню настроек
        btnToGenMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(pnlApp, "General Menu");
            }
        });

        // Данный анонимный класс регулирует, чтобы победная комбинация не превышала размер поля
        chsCellsCount.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                chsCombToWin.removeAll();
                for(int i = 3; i < 10; i++) {
                    if( (i <= Integer.parseInt(chsCellsCount.getSelectedItem()) ) ) {
                        chsCombToWin.add(String.valueOf(i));
                    }
                }
            }
        });
    }
}
