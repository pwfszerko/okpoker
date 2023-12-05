/*
* File: MainWindow.java
* Author: Szeri Bendegúz
* Copyright: 2023, Szeri Bendegúz 
* Date: 2023-11-29
* Licenc: MIT
*
*/
import java.awt.Color;
import javax.swing.*;
import java.util.List;

public class MainWindow extends JFrame {
    private JButton startBtn = new JButton("Start");
    private JButton stopBtn = new JButton("Stop");
    private JButton nextBtn = new JButton("Következő");
    private JPanel tablePanel = new JPanel();
    private List<JButton> flopButtons = List.of(new JButton(""), new JButton(""), new JButton(""));
    private JPanel handPanel = new JPanel();
    private List<JButton> humanCards = List.of(new JButton(), new JButton());
    private JPanel buttonPanel = new JPanel();
    private JButton turnButton = new JButton();
    private JButton riverButton = new JButton();

    public MainWindow() {
        configureTablePanel();
        configureHandPanel();
        configureButtonPanel();

        setupLayout();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
    }

    private void configureTablePanel() {
        tablePanel.setSize(100, 100);
        tablePanel.setBackground(Color.LIGHT_GRAY);
        flopButtons.forEach(button -> {
            button.setVisible(false);
            tablePanel.add(button);
        });
        turnButton.setVisible(false);
        riverButton.setVisible(false);
        tablePanel.add(turnButton);
        tablePanel.add(riverButton);
    }

    private void configureHandPanel() {
        humanCards.forEach(cardButton -> handPanel.add(cardButton));
    }

    private void configureButtonPanel() {
        buttonPanel.add(startBtn);
        buttonPanel.add(nextBtn);
        buttonPanel.add(stopBtn);
    }

    private void setupLayout() {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        add(buttonPanel);
        add(tablePanel);
        add(handPanel);
    }
}
