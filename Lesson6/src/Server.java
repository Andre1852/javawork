import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(3345);//реализация сокета сервера (ожидает запросы на вход по сети)
            System.out.println("сервер запущен, ожидаем подключения...");
            Socket client = server.accept();//прослушивает подключение к сокету и подключает (блокировка до установки подключения)
            System.out.println("клиент подключился");
            DataInputStream inStream = new DataInputStream(client.getInputStream());
            System.out.println("создан входящий поток");
            DataOutputStream outStream = new DataOutputStream(client.getOutputStream());
            System.out.println("создан исходящий поток");

            while (!client.isClosed()){//true если сокет открыт
                String message = inStream.readUTF();
                System.out.println("сервер читает информацию от клиента: " + message);

                if (message.equalsIgnoreCase("quit")){
                    System.out.println("клиент прекращает работу");
                    outStream.writeUTF("ок, сервер слышит, прекращаем работу");
                    outStream.flush();
                    Thread.sleep(5000);
                    break;
                }
                Thread.sleep(1000);
                outStream.writeUTF("сервер ждет твою информацию");
                outStream.flush();
                System.out.println("сервер ждет информацию от клиента");
            }
            System.out.println("сединение с клиеном разорвано");
            inStream.close();
            outStream.close();

            client.close();
            System.out.println("Exit");

        } catch (Exception e) {
            System.out.println("что-то не так");
            e.printStackTrace();
        }
    }
}
