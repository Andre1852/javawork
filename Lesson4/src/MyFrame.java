import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Малыгин Андрей, домашнее задание к 4 уроку Java2.

public class MyFrame extends JFrame {
    public MyFrame(){
        setTitle("Test pane");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 250, 130);
        JPanel contents = new JPanel();
        setLayout(new FlowLayout());
        TextField textField1 = new TextField(25);
        contents.add(textField1);
        TextField textField2 = new TextField(25);// поле ввода
        contents.add(textField2);
        Button button = new Button("Enter");
        contents.add(button);

        ActionListener listener = new ActionListener() {//создаем слушатель для кнопки
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("нажал кнопку Enter");
                textField1.setText(textField2.getText());
            }
        };
        ActionListener fieldlistener = new ActionListener() {//создаем слушатель для поля
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField2.getText());
            }
        };
        button.addActionListener(listener);//устанавливаем слушатель на кнопку
        textField2.addActionListener(fieldlistener);//устанавливаем слушатель на текстовое поле

        setContentPane(contents);//содержимое панели
        setVisible(true);
    }
}
