import java.awt.*;

class GameSettings extends Panel implements CardPanels {
    // Переменные содержат объекты панелей и их компоненты
//    protected CardLayout cardLayout = new CardLayout();
//    protected Panel pnlApp = new Panel(cardLayout);
    protected Panel pnlGenMenu = new Panel();
    protected Panel pnlSetMenu = new Panel();
    protected GridBagConstraints gbc = new GridBagConstraints();
    //    protected DrawGameField gameField;
    protected Choice chsTypePlayer1 = new Choice();
    protected Choice chsTypePlayer2 = new Choice();
    protected Choice chsFigureTypePlayer1 = new Choice();
    protected Choice chsFigureTypePlayer2 = new Choice();
    protected Choice chsFigureColorPlayer1 = new Choice();
    protected Choice chsFigureColorPlayer2 = new Choice();
    protected Choice chsCellsCount = new Choice();
    protected Choice chsCombToWin = new Choice();

    // Переменные содержат игровые параметры
    protected int windowWidth = 516;
    protected int windowHeight = 538;
    protected String typePlr1 = "Human";
    protected String typePlr2 = "AI";
    protected String figureTypePlayer1 = "Cross";
    protected String figureTypePlayer2 = "Circle";
    protected String figureColorPlayer1 = "Red";
    protected String figureColorPlayer2 = "Blue";
    protected Color figColPlr1 = Color.RED;
    protected Color figColPlr2 = Color.BLUE;
    protected int cellsCount = 3;
    protected int combToWin = 3;

}
