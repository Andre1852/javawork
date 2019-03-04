package homework6;
//Малыгин Андрей, домашнее задание к 6 уроку Java2.
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        // при работе с другим компом в поле host прописывается IP адрес
        try (
                Socket socket = new Socket("localhost", 3345);//подключение к серверу (cоздаётся сокет потока и подключается к указанному порту)
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//поток вводa с клавиатуры
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream())) {
            System.out.println("клиент подключен к серверу");
            while (!socket.isOutputShutdown()) {//true, если выход сокета включен
                if (br.ready()) {//готовность потока к чтению из консоли
                    System.out.println("клиент пишет");
                    Thread.sleep(1000);
                    String message = br.readLine();

                    dataOutputStream.writeUTF(message);
                    dataOutputStream.flush();
                    System.out.println("клиент отправил сообщение: " + message);
                    Thread.sleep(4000);

                    if (message.equalsIgnoreCase("quit")) {
                        System.out.println("сединение с клиеном разорвано");
                        Thread.sleep(2000);
                        if (dataInputStream.read() > -1) {
                                System.out.println("читаем.....");
                            //    String serverMessage = dataInputStream.readUTF();
                            //    System.out.println(serverMessage);
                        }
                        break;
                    }
                    System.out.println("продолжаем работу");
                    //Thread.sleep(2000);
                    if (dataInputStream.read() > -1){
                    System.out.println("читаем.....");
                    //    String serverMessage = dataInputStream.readUTF();
                    //    System.out.println(serverMessage);
                    }
                }
            }

            System.out.println("конец связи");
        } catch (Exception e) {
            System.out.println("что-то произошло");
            e.printStackTrace();
        }

    }
}

