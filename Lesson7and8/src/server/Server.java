package server;
//Малыгин Андрей, домашнее задание к 7 уроку Java2.
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private List<ClientHandler> clientHandlers = new ArrayList<>();

    public Server(){
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("Server launcher");

            while (true) {
                clientSocket = serverSocket.accept();
                ClientHandler client = new ClientHandler(clientSocket, this);
                clientHandlers.add(client);
                new Thread(client).start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                serverSocket.close();
                clientSocket.close();
                System.out.println("Server finished");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void notificationAllClients(String msg){
        for (ClientHandler clientHandler: clientHandlers) {
            clientHandler.sendMessage(msg);

        }
    }
    public void removeClient(ClientHandler clientHandler){
        clientHandlers.remove(clientHandler);

    }

}
