import java.awt.*;

class GameSettings extends Panel implements CardPanels {
    // Переменные содержат объекты панелей и их компоненты
    protected static Panel pnlGenMenu = new Panel();
    protected static Panel pnlGameMap = new Panel();
    protected static Panel pnlSetMenu = new Panel();
    protected static GridBagConstraints gbc = new GridBagConstraints();
    protected static Choice chsTypePlayer1 = new Choice();
    protected static Choice chsTypePlayer2 = new Choice();
    protected static Choice chsFigureTypePlayer1 = new Choice();
    protected static Choice chsFigureTypePlayer2 = new Choice();
    protected static Choice chsFigureColorPlayer1 = new Choice();
    protected static Choice chsFigureColorPlayer2 = new Choice();
    protected static Choice chsCellsCount = new Choice();
    protected static Choice chsCombToWin = new Choice();
}
