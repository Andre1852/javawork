import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Chat extends JFrame {
    JPanel jpN = new JPanel(new GridLayout());//северная панель
    JPanel jpS = new JPanel(new GridLayout());//южная панель

    JButton jb = new JButton("Отправить");
    JTextArea jta = new JTextArea();
    JScrollPane jsp = new JScrollPane(jta);
    JTextField jtf = new JTextField();

    JMenuBar menuBar = new JMenuBar();
    JMenu menuFile = new JMenu("Файл");
    JMenu menuHelp = new JMenu("Помощь");
    JMenuItem menuFileHelp = new JMenuItem("О программе");
    JMenuItem menuFileNew = new JMenuItem("Создать новый файл");


    public Chat(){
        super("Чат");
        setBounds(200, 200, 400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jpN.add(jsp);
        jpS.add(jtf);
        jpS.add(jb);

        ActionListener listener = new ActionListener() {//создаем слушатель для кнопки
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("нажал кнопку");
                //jta.setText(jtf.getText());
                sendMessages();
            }
        };
        ActionListener fieldlistener = new ActionListener() {//создаем слушатель для поля
            @Override
            public void actionPerformed(ActionEvent e) {
                //jta.setText(jtf.getText());
                sendMessages();
            }
        };
        jb.addActionListener(listener);//устанавливаем слушатель на кнопку
        jtf.addActionListener(fieldlistener);//устанавливаем слушатель на текстовое поле

        setJMenuBar(menuBar);
        menuBar.add(menuFile);
        menuBar.add(menuHelp);
        menuFile.add(menuFileNew);
        menuHelp.add(menuFileHelp);
        menuFileHelp.addActionListener(e -> JOptionPane.showMessageDialog(null, "Это чат", "О программе", JOptionPane.INFORMATION_MESSAGE));
        menuFileNew.addActionListener(e -> JOptionPane.showMessageDialog(null, "Создать новый файл"));


        add(jpN);//добавление add меняет расстановку полей по сравнению с set
        add("South", jpS);
        setVisible(true);
    }

    public void sendMessages(){
        String out = jtf.getText();
        jta.append(getTime() + ": " + out + "\n");
        jtf.setText("");
        jtf.grabFocus();
    }

    public String getTime(){
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

}
