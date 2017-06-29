import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class PanelScoreMenu extends GameSettings {
	Connection connection;
	Statement stmt;
	
	public void getRefreshDB() {
		refreshDB();
	}
	
    PanelScoreMenu() {
        pnlScoreMenu.setLayout(new BorderLayout());
        pnlApp.add(pnlScoreMenu, "Score Menu");


        // Добавляем панель для настройки отображаемого рейтинга
        Panel pnlScoreSet = new Panel(new GridBagLayout());
        pnlScoreSet.setBackground(Color.LIGHT_GRAY);
        pnlScoreMenu.add(pnlScoreSet, BorderLayout.NORTH);

        // Добавляем название меню
        Label lblScore = new Label("Score");
        Font fntScore = new Font("lblScore", Font.BOLD, 28);
        lblScore.setFont(fntScore);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 0;
        gbc.ipady = 30;
        gbc.weighty = 15;
        gbc.gridwidth = 2;
        pnlScoreSet.add(lblScore, gbc);

        // Добавляем опцию для выбора размера игрового поля
        Label lblFieldSize = new Label("Field Size");
        Font fntScoreOptions = new Font("ScoreOptions", Font.BOLD, 18);
        lblFieldSize.setFont(fntScoreOptions);
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 50;
        gbc.ipady = 4;
        gbc.gridwidth = 1;
        pnlScoreSet.add(lblFieldSize, gbc);

        Choice chsFieldSize = new Choice();
        chsFieldSize.add("3");
        chsFieldSize.add("4");
        chsFieldSize.add("5");
        chsFieldSize.add("6");
        chsFieldSize.add("7");
        chsFieldSize.add("8");
        chsFieldSize.add("9");
        chsFieldSize.setFont(fntScoreOptions);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 1;
        pnlScoreSet.add(chsFieldSize, gbc);

        // Добавляем опцию для выбора размера игрового поля
        Label lblWinComb = new Label("Win Combo");
        lblWinComb.setFont(fntScoreOptions);
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipady = 15;
        gbc.weighty = 4;
        pnlScoreSet.add(lblWinComb, gbc);

        Choice chsWinCombo = new Choice();
        chsWinCombo.add("3");
        chsWinCombo.setFont(fntScoreOptions);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 2;
        pnlScoreSet.add(chsWinCombo, gbc);


        // Добавляем панель на которой отображаются рейтинги игроков
        Panel pnlScoreRating = new Panel(new BorderLayout());
        pnlScoreRating.setBackground(Color.CYAN);
        pnlScoreMenu.add(pnlScoreRating, BorderLayout.CENTER);
        TextArea txtArRating = new TextArea("First Line", 10, 2, TextArea.SCROLLBARS_NONE);
        Font fntRatArea = new Font("RateArea", Font.BOLD, 28);
        txtArRating.setBackground(Color.GREEN);
        txtArRating.setFont(fntRatArea);
        pnlScoreRating.add(txtArRating, BorderLayout.CENTER);


        // Добавляем панель на которой будет присутствовать кнопка возврата в меню
        Panel pnlExitToMenu = new Panel();
        pnlExitToMenu.setLayout(new GridBagLayout());
        pnlExitToMenu.setBackground(Color.LIGHT_GRAY);
        pnlScoreMenu.add(pnlExitToMenu, BorderLayout.SOUTH);
        Button btnExitToMenu = new Button("Back to Menu");
        btnExitToMenu.setFont(fntScoreOptions);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 50;
        gbc.ipady = 10;
        pnlExitToMenu.add(btnExitToMenu, gbc);
        
        // Добавляем БД к нашему проекту
        try {
			connectDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
//        try {
//			showTable();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
        System.out.println(player);
        System.out.println(score);
      
        // Отображаем содержимое БД
        try {
        String str = "SELECT * FROM score ORDER BY score DESC";
        ResultSet rs = stmt.executeQuery(str);
        txtArRating.setText("");
        while(rs.next()) {
        	txtArRating.append(rs.getString("name") + "          " + rs.getInt("score") + "\n");
        }
        } catch(Exception e) {
        	e.printStackTrace();
        }
        
        // Данный анонимный класс регулирует, чтобы победная комбинация не превышала размер поля
        chsFieldSize.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                chsWinCombo.removeAll();
                for(int i = 3; i < 10; i++) {
                    if( (i <= Integer.parseInt(chsFieldSize.getSelectedItem()) ) ) {
                        chsWinCombo.add(String.valueOf(i));
                    }
                }
            }
        });


        btnExitToMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cardLayout.show(pnlApp, "General Menu");
            }
        });
    }
    
    // Метод отвечает за подключение к БД
    private void connectDB() throws Exception {
    	Class.forName("org.sqlite.JDBC");
    	connection = DriverManager.getConnection("jdbc:sqlite:scoreTab");
    	stmt = connection.createStatement();
    }
    
    // Закрытие связи с БД после закрытия окна Frame
    private void disconectDB() throws Exception {
    	connection.close();
    }
    
    // Обновления таблицы БД
    private void refreshDB() {
    	System.out.println(player + " " + score);
    }
    
    // Выводим все данные из БД в текстовую область с рейтингом
//    private void showTable() throws SQLException {
//        String str = "SELECT * FROM score ORDER BY score DESC";
//        ResultSet rs = stmt.executeQuery(str);
//        while(rs.next()) {
//        	
//        	System.out.println(rs.getString("name") + " " + rs.getInt("score"));
//        }
//    }
}

