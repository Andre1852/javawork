package server;
//Малыгин Андрей, домашнее задание к 7 уроку Java2.
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private Server server;
    private PrintWriter outMsg;
    private Scanner inMsg;
    private static int clientCount = 0;

    public ClientHandler(Socket clientSocket, Server server) {
        try {
            clientCount++;
            this.clientSocket = clientSocket;
            this.server = server;
            this.outMsg = new PrintWriter(clientSocket.getOutputStream());
            this.inMsg = new Scanner(clientSocket.getInputStream());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
                server.notificationAllClients("New client in our chat");
                server.notificationAllClients("In our chat " + clientCount + " clients.");
                while (true) {
                    if (inMsg.hasNext()) {
                        String clientMsg = inMsg.nextLine();
                        if (clientMsg.equalsIgnoreCase("QUIT")) {
                            break;
                        }
                        System.out.println(clientMsg);
                        server.notificationAllClients(clientMsg);
                    }
                }
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            exitFromChat();
        }

    }

    private void exitFromChat() {
        clientCount--;
        server.notificationAllClients("Client exit. In our chat " + clientCount + " clients.");
        server.removeClient(this);
    }

    public void sendMessage(String msg) {
        try {
          outMsg.println(msg);
          outMsg.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
