package homework6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client2 extends JFrame {
    private final String SERVER_IP = "localhost";
    private final int SERVER_PORT = 3345;

    private JTextField msgInputField;
    private JTextArea chatArea;

    private Socket socket2;
    private DataInputStream dataInputStream2;
    private DataOutputStream dataOutputStream2;

    public Client2(){
        try {
            openConnection();
        } catch (Exception e){
            e.printStackTrace();
        }
        prepareWindow();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Client2();
            }
        });
    }

    public void openConnection()throws Exception {
        socket2 = new Socket(SERVER_IP, SERVER_PORT);
        dataInputStream2 = new DataInputStream(socket2.getInputStream());
        dataOutputStream2 = new DataOutputStream(socket2.getOutputStream());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        String serverMessage = dataInputStream2.readUTF();
                        if (serverMessage.equalsIgnoreCase("quit")){
                            break;
                        }
                        chatArea.append(serverMessage);
                        chatArea.append("\n");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();//запуск второго потока
    }

    public void closeConnection(){
        try {
            dataInputStream2.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        try {
            dataOutputStream2.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        try {
            socket2.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendMessage(){
        try {
        dataOutputStream2.writeUTF(msgInputField.getText());
        msgInputField.setText("");
        msgInputField.grabFocus();

        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ошибка отправки сообщения");
        }
    }

    public void prepareWindow(){
        //параметры окна
        setBounds(600, 100, 500, 500);
        setTitle("Client2");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //текстовое поле
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);
        //панель для ввода сообщений
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JButton btnSendMsg = new JButton("Отправить");
        bottomPanel.add(btnSendMsg, BorderLayout.EAST);
        msgInputField = new JTextField();
        add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(msgInputField, BorderLayout.CENTER);
        btnSendMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        msgInputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        //закрытие окон
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    dataOutputStream2.writeUTF("quit");
                    closeConnection();
                } catch (Exception exc){
                    exc.printStackTrace();
                }
            }
        });

        setVisible(true);
    }
}
