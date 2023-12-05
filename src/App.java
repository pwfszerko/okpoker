/*
* File: App.java
* Author: Szeri Bendegúz
* Copyright: 2023, Szeri Bendegúz 
* Date: 2023-11-29
* Licenc: MIT
*
*/

import controllers.MainController;
import views.MainWindow;

public class App {
    public static void main(String[] args) {
        launchApplication();
    }

    private static void launchApplication() {
        try {
            MainWindow mainWindow = createMainWindow();
            MainController mainController = new MainController(mainWindow);
            displayMainWindow(mainWindow);
        } catch (Exception e) {
            handleException(e);
        }
    }

    private static MainWindow createMainWindow() {
        return new MainWindow();
    }

    private static void displayMainWindow(MainWindow mainWindow) {
        mainWindow.setVisible(true);
    }

    private static void handleException(Exception exception) {
        exception.printStackTrace();
    }
}
