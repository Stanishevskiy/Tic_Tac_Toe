import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class PanelGameMap extends Panel implements GameSettings, KeyListener {

    PanelGameMap() {
        pnlGameField.setLayout(new GridBagLayout());
        pnlApp.add(pnlGameField, "Game Field");

//        pnlApp.setVisible(false);

//        Frame gameField = new Frame();
//        gameField.add(pnlGameField);
//        gameField.setTitle("Test");
//        gameField.setBounds(300, 50, 500, 500);
//        gameField.setVisible(true);

    }

    // Метод отвечает за отрисовку игрового поля
    @Override
    public void paint(Graphics g) {
        // Отрисовка сетки
        try {
            int cellsCount = Integer.parseInt(chsCellsCount.getSelectedItem());
            for(int i = 0; i < cellsCount + 1; i++)
                g.drawLine(((fieldWidth * i) / cellsCount), 0, ((fieldWidth * i) / cellsCount), fieldHeight);
            for(int i = 0; i < cellsCount + 1; i++)
                g.drawLine(0, ((fieldHeight * i) / cellsCount), fieldWidth, ((fieldHeight * i) / cellsCount));
        } catch(Exception e) {
            System.out.println("Ошибка отрисовки сетки");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_ESCAPE) {

        }
    }
}