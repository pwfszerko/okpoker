/*
* File: MainController.java
* Author: Szeri Bendegúz
* Copyright: 2023, Szeri Bendegúz 
* Date: 2023-11-29
* Licenc: MIT
*
*/


package controllers;

import java.util.Random;
import views.MainWindow;

public class MainController {
    private final MainWindow mainWindow;
    private final String[] cards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "B", "D", "K", "A"};
    private Round round = Round.PREFLOP;

    public MainController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        initEvent();
    }

    private int getRandom() {
        Random random = new Random();
        return random.nextInt(13);
    }

    private void updateHumanCards() {
        Random random = new Random();
        int hcard1 = random.nextInt(13);
        int hcard2 = random.nextInt(13);
        random = null;

        String humanCard1Str = cards[hcard1];
        String humanCard2Str = cards[hcard2];
        mainWindow.humanCard1Btn.setText(humanCard1Str);
        mainWindow.humanCard2Btn.setText(humanCard2Str);

        System.out.printf("%d %d\n", hcard1, hcard2);
    }

    private void handleStartButton() {
        mainWindow.startBtn.addActionListener(event -> {
            updateHumanCards();
        });
    }

    private void handleStopButton() {
        mainWindow.stopBtn.addActionListener(event -> {
            System.out.println("Állj");
        });
    }

    private void handleNextButton() {
        mainWindow.nextBtn.addActionListener(event -> {
            if (round == Round.PREFLOP) {
                handlePreflop();
            } else if (round == Round.FLOP) {
                handleFlop();
            } else if (round == Round.TURN) {
                handleTurn();
            }
        });
    }

    private void handlePreflop() {
        int flop1 = getRandom();
        int flop2 = getRandom();
        int flop3 = getRandom();

        String flop1Str = cards[flop1];
        String flop2Str = cards[flop2];
        String flop3Str = cards[flop3];

        mainWindow.flop1Btn.setText("♦" + flop1Str);
        mainWindow.flop2Btn.setText(flop2Str);
        mainWindow.flop3Btn.setText(flop3Str);

        mainWindow.flop1Btn.setVisible(true);
        mainWindow.flop2Btn.setVisible(true);
        mainWindow.flop3Btn.setVisible(true);

        round = Round.FLOP;
    }

    private void handleFlop() {
        int turn = getRandom();
        mainWindow.turnButton.setText(cards[turn]);
        mainWindow.turnButton.setVisible(true);
        round = Round.TURN;
    }

    private void handleTurn() {
        int river = getRandom();
        mainWindow.riverButton.setText(cards[river]);
        mainWindow.riverButton.setVisible(true);
        round = Round.RIVER;
    }

    private void initEvent() {
        handleStartButton();
        handleStopButton();
        handleNextButton();
    }

    enum Round {
        PREFLOP,
        FLOP,
        TURN,
        RIVER,
        SHOW
    }
}
