package lection1;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private final int WINDOW_HEIGHT = 430;
    private final int WINDOW_WIDTH = 350;

    private static int mode = 0;
    private static int sizeX = 3;
    private static int sizeY = 3;
    private static int winLength = 3;

    public static int getMode() {
        return mode;
    }

    public static int getSizeX() {
        return sizeX;
    }

    public static int getSizeY() {
        return sizeY;
    }

    public static int getWinLength() {
        return winLength;
    }

    JButton btnStart = new JButton("Start new game");
    SettingsWindow(GameWindow gameWindow) {
        setLocation(600, 130);
//        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        setLayout(new GridLayout(9, 1));
        add(new JLabel("Выберите режим игры."));

        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton pvp = new JRadioButton("Человек против человека.");

        JRadioButton pvc = new JRadioButton("Человек против компьютера.");
        buttonGroup.add(pvp);
        buttonGroup.add(pvc);
        add(pvp);
        add(pvc);


        JLabel labelField = new JLabel("Выберите размер поля.");
        add(labelField);

        JSlider sliderFieldSize = new JSlider(3, 10, 3);
        add(sliderFieldSize);

        JLabel labelWinSize = new JLabel("Выберите длину для победы.");
        add(labelWinSize);
        JSlider sliderWinSize = new JSlider(3, 4, 3);
        add(sliderWinSize);
        sliderFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelField.setText("Текущий размер поля " + sliderFieldSize.getValue());
                if (sliderFieldSize.getValue() < 4) {
                    sliderWinSize.setValue(3);
                    labelWinSize.setText("Выбрано количество ячеек для победы: " + sliderWinSize.getValue());
                }
            }
        });

        sliderWinSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelWinSize.setText("Выбрано количество ячеек для победы: " + sliderWinSize.getValue());
            }
        });

        add(btnStart);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pvc.isSelected()) {
                    mode = 1;
                }
                sizeX = sliderFieldSize.getValue();
                sizeY = sliderFieldSize.getValue();
                winLength = sliderWinSize.getValue();
                gameWindow.startNewGame(mode, sizeX, sizeY, winLength);
                System.out.printf("Mode: %d;\nSize: x=%d, y=%d;\nWin Length: %d\n",
                        mode, sizeX, sizeY, winLength);
                setVisible(false);
            }
        });
    }
}
