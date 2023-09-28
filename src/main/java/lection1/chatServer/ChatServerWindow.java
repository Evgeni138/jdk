package lection1.chatServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatServerWindow extends JFrame {

    private final int WINDOW_HEIGHT = 555;
    private final int WINDOW_WIDTH = 507;
    private final int WINDOW_POSX = 500;
    private final int WINDOW_POSY = 100;

    private boolean isServerWorking;

    ChatServerWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_HEIGHT, WINDOW_WIDTH);
        setTitle("Chat Server");
        setResizable(false);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.setPreferredSize(new Dimension(507, 450));
        JButton btnStart = new JButton("Start");
        JButton btnStop = new JButton("Stop");
        panel.add(btnStart);
        panel.add(btnStop);
        add(panel);
        JTextArea log = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(log, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(0, 100));
        add(scrollPane, BorderLayout.SOUTH);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStart.setText("Server is working");
                btnStop.setText("Stop");
                if (!isServerWorking)
                log.append("Server started.\n");
                isServerWorking = true;
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStart.setText("Start");
                btnStop.setText("Server stopped");
                if (isServerWorking) log.append("Server stopped.\n");
                isServerWorking = false;

            }
        });
        setVisible(true);
    }
}
