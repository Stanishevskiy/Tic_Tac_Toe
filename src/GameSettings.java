import java.awt.*;

interface GameSettings extends GamePanelObjects {
    int fieldWidth = pnlGameField.getWidth();       // Получаем ширину поля в пикселях
    int fieldHeight = pnlGameField.getHeight();     // Получаем высоту поля в пикселях

    // Получаем количество ячеек игрового поля
    Choice chsCellsCount = new Choice();

    // Получаем длину выигрышной комбинации
    Choice chsCombToWin = new Choice();
//    int comboToWin = Integer.parseInt(chsCombToWin.getSelectedItem());
}
