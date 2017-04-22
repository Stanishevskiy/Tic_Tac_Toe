import java.awt.*;

interface GamePanelObjects {
    CardLayout cardLayout = new CardLayout();
    Panel pnlApp = new Panel(cardLayout);               // Создаем панель-компоновщик карт
    Panel pnlGenMenu = new Panel();                     // Создаем панель главного меню
    Panel pnlSettings = new Panel();                    // Создаем панель меню настроек

    GridBagConstraints gbc = new GridBagConstraints();  // Создаем ограничитель для компоновщика

}
