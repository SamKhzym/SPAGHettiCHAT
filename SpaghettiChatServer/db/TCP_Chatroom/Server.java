import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Server implements Runnable {

    private List<ConnectionHandler> connections;
    private ServerSocket server;
    private boolean done;
    private ExecutorService pool;

    public Server(){
        connections = new ArrayList<>();
        done = false;
    }

    @Override
    public void run(){
        try {
            server = new ServerSocket(8080); // We are listening on port 8080
            pool = Executors.newCachedThreadPool();
            while(!done) {
                Socket client = server.accept(); // When we accept a connection from client, we get its socket (address)
                ConnectionHandler handler = new ConnectionHandler(client);
                connections.add(handler);
                pool.execute(handler);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            shutdown();
        }


    }

    public void broadcast(String message){
        for (ConnectionHandler ch: connections){
            if(ch != null){
                ch.sendMessage(message);
            }
        }
    }

    public void shutdown(){
        done = true;
        pool.shutdown();
        try {
            System.out.println("Server: " + server);
            if (!server.isClosed()) {
                server.close();
            }
            for (ConnectionHandler ch : connections){
                ch.shutdown();
            }
        } catch (IOException e){
            // Ignore exception, we cant really handle it
        }
    }

    class ConnectionHandler implements Runnable {

        private Socket client;
        private ObjectInputStream in;
        private ObjectOutputStream out;
        private String nickname;

        public ConnectionHandler(Socket client){
            this.client = client;
        }
        @Override
        public void run(){
            try {
                out = new ObjectOutputStream(client.getOutputStream());
                in = new ObjectInputStream(client.getInputStream());
//                out.println("Please enter a nickname: ");
                System.out.println("New user connected!");
                broadcast("New user joined the chat server");


                Object objMessage;
                while ((objMessage = in.readObject()) != null) {
                    if (objMessage instanceof Message) {
                        Message message = (Message) objMessage;
                        String text = message.getMessage(); // Reminder add .getMessage method to the Message object
                        nickname = message.getSender().getFirstName();

                        if (text.startsWith("/nick")) {
                            // Handle nickname change
                            String[] parts = text.split(" ", 2);
                            if (parts.length == 2) {
                                broadcast(nickname + " renamed themselves to " + parts[1]);
                                nickname = parts[1];
                                sendMessage("Successfully changed nickname to " + nickname);
                            } else {
                                sendMessage("No nickname provided!");
                            }
                        } else if (text.startsWith("/quit")) {
                            // Handle quit
                            broadcast(nickname + " left the chat");
                            shutdown();
                            break; // Exit loop to end thread
                        } else {
                            // Broadcast normal message
                            broadcast(nickname + ": " + text);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                shutdown();
            }
        }

        public void sendMessage(String text) {

            try {
                out.writeUTF(text); 
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void shutdown(){
            try {
                in.close();
                out.close();
                if(!client.isClosed()){
                    client.close();
                }
            } catch (IOException e){
                // Ignore; we cant really handle it
            }
        }

    }

    public static void main(String[] args){
        Server server = new Server();
        server.run();
    }
}
