import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class PanelGameMap extends GameSettings {
    private int fieldWidth = 500;
    private int fieldHeight = 500;
    private Integer currentPlr = 1;
    private int oppositePlr = 2;
    private String player1Name = "Player 1";
    private String player2Name = "Player 2";
    private String typePlr1 = "Human";
    private String typePlr2 = "AI";
    private String figureTypePlayer1 = "Cross";
    private String figureTypePlayer2 = "Circle";
    private String figureColorPlayer1S = "Red";
    private String figureColorPlayer2S = "Blue";
    private Color figureColorPlayer1 = Color.RED;
    private Color figureColorPlayer2 = Color.BLUE;
    private int cellsCount = 3;
    private int combToWin = 3;
    private int cellWidth = fieldWidth/cellsCount;
    private int cellHeight = fieldHeight/cellsCount;
    private int mouseX = 0;
    private int mouseY = 0;
    private int[][] mapCells = new int[cellsCount][cellsCount];
    private Random rndTurn = new Random();
    private boolean aiSearchCombo = false;
    private String gameOver = "Nothing";

//----------------------------------------------------------------------

    PanelGameMap() {
        // Устанавливаем тип игрока
        if( !typePlr1.equals(chsTypePlayer1.getSelectedItem()) )
            typePlr1 = chsTypePlayer1.getSelectedItem();
        if( !typePlr2.equals(chsTypePlayer2.getSelectedItem()) )
            typePlr2 = chsTypePlayer2.getSelectedItem();

        // Устанавливаем тип фишки игроков
        if( !figureTypePlayer1.equals(chsFigureTypePlayer1.getSelectedItem()) )
            figureTypePlayer1 = chsFigureTypePlayer1.getSelectedItem();
        if( !figureTypePlayer2.equals(chsFigureTypePlayer2.getSelectedItem()) )
            figureTypePlayer2 = chsFigureTypePlayer2.getSelectedItem();

        // Устанавливаем цвет фишки игроков
        if( !figureColorPlayer1S.equals(chsFigureColorPlayer1.getSelectedItem()) ) {
            figureColorPlayer1S = chsFigureColorPlayer1.getSelectedItem();
            figureColorPlayer1 = selectColor(figureColorPlayer1S, figureColorPlayer1);
        }
        if( !figureColorPlayer2S.equals(chsFigureColorPlayer2.getSelectedItem()) ) {
            figureColorPlayer2S = chsFigureColorPlayer2.getSelectedItem();
            figureColorPlayer2 = selectColor(figureColorPlayer2S, figureColorPlayer2);
        }

        // Устанавливаем размер игрового поля
        if( cellsCount != Integer.parseInt(chsCellsCount.getSelectedItem()) )
            cellsCount = Integer.parseInt(chsCellsCount.getSelectedItem());

        // Устанавливаем выигрышную комбинацию
        if( combToWin != Integer.parseInt(chsCombToWin.getSelectedItem()) )
            combToWin = Integer.parseInt(chsCombToWin.getSelectedItem());

        // Добавляем панель игрового поля к перечню карт
        setBackground(Color.PINK);
        setLayout(new GridLayout(3, 3));
        pnlApp.add(this, "Game Map");

        // Обработка клика по игровому полю с последующей постановкой фишки
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                mouseX = me.getX();
                mouseY = me.getY();
                if((currentPlr == 1 && typePlr1.equals("Human")) || (currentPlr == 2 && typePlr2.equals("Human"))) {
                    humanTurn();
                    gameOver();
                }
                else {
                    if((currentPlr == 1 && typePlr1.equals("AI")) || (currentPlr == 2 && typePlr2.equals("AI"))) {
                        aiTurn();
                        gameOver();
                    }
                }
            }
        });

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                width();
                height();
                cellWidth = fieldWidth/cellsCount;
                cellHeight = fieldHeight/cellsCount;
                mapCells = new int[cellsCount][cellsCount];
            }
        });
    }

//----------------------------------------------------------------------

    // Установить размеры игрового поля
    private void width() {
        fieldWidth = this.getWidth();
    }

    private void height() {
        fieldHeight = this.getHeight();
    }

//----------------------------------------------------------------------

    @Override
    public void paint(Graphics g) {
//        System.out.println(4);
        Graphics2D g2 = (Graphics2D) g;

        // Отрисовка сетки игрового поля
        g2.setStroke(new BasicStroke(3));
        for(int i = 0; i < cellsCount + 1; i++)
            g2.drawLine( aX(i), 0, aX(i), fieldHeight);
        for(int i = 0; i < cellsCount + 1; i++)
            g2.drawLine(0, aY(i), fieldWidth, aY(i));

        // Заполнение ячеек игрового поля
        g2.setStroke(new BasicStroke(5));
        for(int i = 0; i < cellsCount; i++) {
            for(int j = 0; j < cellsCount; j++) {
                if(mapCells[i][j] == 1) {     // Если клетка первого игрока
                    switch(figureTypePlayer1) {
                        case "Cross":
                            g2.setColor(Color.BLACK);
                            g2.drawLine( aX(i)+5,  aY(j)+8, aX(i+1)-9, aY(j+1)-5 );
                            g2.drawLine( aX(i)+10, aY(j+1)-4, aX(i+1)-4, aY(j)+10 );
                            g2.setColor(figureColorPlayer1);
                            g2.drawLine( aX(i)+7,  aY(j)+7, aX(i+1)-7, aY(j+1)-7 );
                            g2.drawLine( aX(i)+7, aY(j+1)-7, aX(i+1)-7, aY(j)+7 );
                            break;
                        case "Circle":
                            g2.setColor(Color.BLACK);
                            g2.drawOval( aX(i)+10, aY(j)+10, cellWidth-14, cellHeight-14 );
                            g2.setColor(figureColorPlayer1);
                            g2.drawOval( aX(i)+7, aY(j)+7, cellWidth-14, cellHeight-14 );
                            break;
                        case "Square":
                            g2.setColor(Color.BLACK);
                            g2.drawRect( aX(i)+10, aY(j)+10, cellWidth-14, cellHeight-14 );
                            g2.setColor(figureColorPlayer1);
                            g2.drawRect( aX(i)+7, aY(j)+7, cellWidth-14, cellHeight-14 );
                            break;
                        case "fCircle":
                            g2.setColor(Color.BLACK);
                            g2.fillOval( aX(i)+10, aY(j)+10, cellWidth-14, cellHeight-14 );
                            g2.setColor(figureColorPlayer1);
                            g2.fillOval( aX(i)+7, aY(j)+7, cellWidth-14, cellHeight-14 );
                            break;
                        case "fSquare":
                            g2.setColor(Color.BLACK);
                            g2.fillRect( aX(i)+10, aY(j)+10, cellWidth-14, cellHeight-14 );
                            g2.setColor(figureColorPlayer1);
                            g2.fillRect( aX(i)+7, aY(j)+7, cellWidth-14, cellHeight-14 );
                            break;
                    }
                }
                if(mapCells[i][j] == 2) {     // Если клетка второго игрока
                    switch(figureTypePlayer2) {
                        case "Cross":
                            g2.setColor(Color.BLACK);
                            g2.drawLine( aX(i)+5,  aY(j)+8, aX(i+1)-9, aY(j+1)-5 );
                            g2.drawLine( aX(i)+10, aY(j+1)-4, aX(i+1)-4, aY(j)+10 );
                            g2.setColor(figureColorPlayer2);
                            g2.drawLine( aX(i)+7,  aY(j)+7, aX(i+1)-7, aY(j+1)-7 );
                            g2.drawLine( aX(i)+7, aY(j+1)-7, aX(i+1)-7, aY(j)+7 );
                            break;
                        case "Circle":
                            g2.setColor(Color.BLACK);
                            g2.drawOval( aX(i)+10, aY(j)+10, cellWidth-14, cellHeight-14 );
                            g2.setColor(figureColorPlayer2);
                            g2.drawOval( aX(i)+7, aY(j)+7, cellWidth-14, cellHeight-14 );
                            break;
                        case "Square":
                            g2.setColor(Color.BLACK);
                            g2.drawRect( aX(i)+10, aY(j)+10, cellWidth-14, cellHeight-14 );
                            g2.setColor(figureColorPlayer2);
                            g2.drawRect( aX(i)+7, aY(j)+7, cellWidth-14, cellHeight-14 );
                            break;
                        case "fCircle":
                            g2.setColor(Color.BLACK);
                            g2.fillOval( aX(i)+10, aY(j)+10, cellWidth-14, cellHeight-14 );
                            g2.setColor(figureColorPlayer2);
                            g2.fillOval( aX(i)+7, aY(j)+7, cellWidth-14, cellHeight-14 );
                            break;
                        case "fSquare":
                            g2.setColor(Color.BLACK);
                            g2.fillRect( aX(i)+10, aY(j)+10, cellWidth-14, cellHeight-14 );
                            g2.setColor(figureColorPlayer2);
                            g2.fillRect( aX(i)+7, aY(j)+7, cellWidth-14, cellHeight-14 );
                            break;
                    }
                }
            }
        }

        if(!gameOver.equals("Nothing") && !aiSearchCombo) {
            g2.setFont(new Font("Helvetica", Font.BOLD, 72));
            g2.setColor(Color.BLACK);
            g2.drawString(gameOver, 10, 200);
            g2.setColor(Color.ORANGE);
            g2.drawString(gameOver, 6, 196);
            gameOverWindow();
        }
    }

//----------------------------------------------------------------------

    // Вспомогательные методы для упрощения кода
    private int aX(int i) {
        return (fieldWidth*i)/cellsCount;
    }

    private int aY(int j) {
        return (fieldHeight*j)/cellsCount;
    }


    // Вспомогательные метод для упрощения кода
    private Color selectColor(String figColPlrStr, Color figColPlr) {
        Color resClr = figColPlr;
        switch(figColPlrStr) {
            case "Red":
                resClr = Color.RED;
                break;
            case "Blue":
                resClr = Color.BLUE;
                break;
            case "Yellow":
                resClr = Color.YELLOW;
                break;
            case "Green":
                resClr = Color.GREEN;
                break;
            case "Purple":
                resClr = Color.MAGENTA;
                break;
        }
        return resClr;
    }

//----------------------------------------------------------------------

    // Метод отвечает за ход человека
    private void humanTurn() {
        int cellX = mouseX/cellWidth;
        int cellY = mouseY/cellHeight;
        if(mapCells[cellX][cellY] == 0) {
            if(currentPlr == 1) {
                mapCells[cellX][cellY] = 1;
                this.repaint();
                currentPlr = 2;
                oppositePlr = 1;
            } else {
                mapCells[cellX][cellY] = 2;
                this.repaint();
                currentPlr = 1;
                oppositePlr = 2;
            }
        }

    }


    // Доработанный AI компьютера, который умеет блокировать выигрышные комбинации
    private void aiTurn() {
        int x = -1, y = -1;
        aiSearchCombo = true;       // сигнализируем программе, что могут быть ложные срабатывания условия победы

        // ИИ ищет свои выигрышные комбинации. Если находит, запоминает
        for(int i = 0; i < cellsCount; i++)
            for(int j = 0; j < cellsCount; j++) {
                if(mapCells[i][j] == 0) {
                    mapCells[i][j] = currentPlr;
                    if(checkWin(currentPlr)) {
                        x = j;
                        y = i;
                    }
                    mapCells[i][j] = 0;
                    gameOver = "Nothing";
                }
            }

        // Если ИИ не нашел выигрышные комбинации, он ищет выигрышные комбинации соперника
        if(x == -1 && y == -1) {
            for(int i = 0; i < cellsCount; i++)
                for(int j = 0; j < cellsCount; j++) {
                    if(mapCells[i][j] == 0) {
                        mapCells[i][j] = 1;
                        if(checkWin(oppositePlr)) {
                            x = j;
                            y = i;
                        }
                        mapCells[i][j] = 0;
                        gameOver = "Nothing";
                    }
                }
        }

        // Если ИИ не нашел выигрышную комбинацию он ставит фишку на случайную позицию
        if(x == -1 && y == -1) {
            do {
                x = rndTurn.nextInt(cellsCount);
                y = rndTurn.nextInt(cellsCount);
            } while(mapCells[y][x] != 0);
        }

        // Подставляем фишку компьютера
        mapCells[y][x] = currentPlr;
        repaint();
        aiSearchCombo = false;          // AI определился с ходом и походил походил

        // Смена игрока
        if(currentPlr == 1) {
            currentPlr = 2;
            oppositePlr = 1;
        } else {
            currentPlr = 1;
            oppositePlr = 2;
        }
    }

//----------------------------------------------------------------------

    // Метод проверяет все возможные варианты завершения игры
    private void gameOver() {
        if(checkWin(oppositePlr)) {
            for(int i = 0; i < cellsCount; i++)
                for(int j = 0; j < cellsCount; j++)
                    if(mapCells[i][j] == 0)
                        mapCells[i][j] = -1;
            repaint();
            return;
        }

        if(isFieldFull()) {
            gameOver = "        Draw";
            repaint();
        }
    }

    // Метод проверяет наличие выигрышной комбинации
    private boolean checkWin(int player) {
        for(int i = 0; i < cellsCount; i++)
            for(int j = 0; j < cellsCount; j++) {
                if(checkLine(i, j, 1, 0, combToWin, player) ||
                        checkLine(i, j, 0, 1, combToWin, player) ||
                        checkLine(i, j, 1, 1, combToWin, player) ||
                        checkLine(i, j, 1, -1, combToWin, player)) {
                    if(player == 1)
                        gameOver = " " + txtNamePlayer1.getText() + " WON";
                    if(player == 2)
                        gameOver = " " + txtNamePlayer2.getText() + " WON";
                    return true;
                }
            }
        return false;
    }

    // Метод проверяет линию по заданным параметрам
    private boolean checkLine(int sx, int sy, int vx, int vy, int l, int currentPlayer) {
        if(sx + l * vx > cellsCount ||
                sy + l * vy > cellsCount ||
                sy + l * vy < -1)
            return false;
        for(int i = 0; i < l; i++) {
            if(mapCells[sy + vy * i][sx + vx * i] != currentPlayer)
                return false;
        }
        return true;
    }

    // Метод проверяет заполненность поля
    private boolean isFieldFull() {
        for(int[] x1 : mapCells) {
            for(int x2 : x1) {
                if(x2 == 0)
                    return false;
            }
        }

        return true;
    }

//----------------------------------------------------------------------

    private void gameOverWindow() {
        System.out.println(9);

//        Panel pnlGameOver = new Panel();
//        pnlGameOver.setBackground(Color.LIGHT_GRAY);
//        pnlGameOver.setLayout(new GridBagLayout());
//        pnlGameMap.add(pnlGameOver, new GridLayout(2, 2));

        Frame frmGameOver = new Frame();
        frmGameOver.setBackground(Color.LIGHT_GRAY);
        frmGameOver.setBounds(300, 50, 200, 200);
        frmGameOver.setLayout(new GridBagLayout());

        Button btnPlayAgain = new Button("Play Again");
        Button btnMainMenu = new Button("Main Menu");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 20;
        gbc.weighty = 5;
        frmGameOver.add(btnPlayAgain, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        frmGameOver.add(btnMainMenu, gbc);


        frmGameOver.setVisible(true);


        btnPlayAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                gameOver = "Nothing";
                for(int i = 0; i < cellsCount; i++)
                    for(int j = 0; j < cellsCount; j++)
                        mapCells[i][j] = 0;
                frmGameOver.setVisible(false);
                repaint();
            }
        });

        btnMainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmGameOver.setVisible(false);
                cardLayout.show(pnlApp, "General Menu");
            }
        });
    }
}