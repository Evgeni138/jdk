package lection1.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class ChatWindow extends JFrame {

    private final int WINDOW_HEIGHT = 555;
    private final int WINDOW_WIDTH = 507;
    private final int WINDOW_POSX = 500;
    private final int WINDOW_POSY = 100;
    private String path = "C:\\Example\\jdk\\src\\main\\java\\lection1\\chat\\test.txt";


    private FileProcessing processing = new FileProcessing();

    JButton btnConnect = new JButton("Connect");
    JButton btnExit = new JButton("Exit");

    ChatWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_HEIGHT, WINDOW_WIDTH);
        setTitle("Chat");
        setResizable(false);

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JPanel panSet = new JPanel(new GridLayout(6, 1));
        JTextField loginField = new JTextField("Login: ");
        JTextField passwordField = new JTextField("Password: ");
        JTextField ipField = new JTextField("IP: ");
        JTextField portField = new JTextField("Port: ");
        panSet.add(loginField);
        panSet.add(passwordField);
        panSet.add(ipField);
        panSet.add(portField);
        panSet.add(btnConnect);
        add(panSet, BorderLayout.NORTH);

        JPanel panMid = new JPanel(new GridLayout(1, 2));
        JTextArea chatField = new JTextArea("Chat: ");
        chatField.setEditable(false);
        JList<String> listUsers = new JList<>();
        String users[] = {"User1", "User2", "User3"};
        listUsers.setListData(users);
        JScrollPane scrollPane = new JScrollPane(chatField);
        panMid.add(scrollPane);
        panMid.add(listUsers);
        add(panMid);

        btnConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chatField.setText("Chat: ");
                List<String> list = processing.fileRead(path);
                String[] messages = new String[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    messages[i] = list.get(i);
                    chatField.append(list.get(i));
                    chatField.append("\n");
                }

            }
        });

        JPanel panChat = new JPanel(new GridLayout(2, 1));
        JTextField messageField = new JTextField("Enter text: ");
        JButton btnSendMessage = new JButton("Send");
        btnSendMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chatField.append(messageField.getText() + String.format("\n"));
                processing.fileWrite(path, messageField.getText());
                messageField.setText("Enter text: ");
            }
        });
        messageField.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                chatField.append(messageField.getText() + String.format("\n"));
                processing.fileWrite(path, messageField.getText());
                messageField.setText("Enter text: ");
            }
        });
        panChat.add(messageField);
        panChat.add(btnSendMessage);
        add(panChat, BorderLayout.SOUTH);

        setVisible(true);
    }
}