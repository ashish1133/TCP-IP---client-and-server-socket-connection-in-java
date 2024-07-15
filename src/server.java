import java.net.*;
import java.io.*;

public class server{
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream input = null;

    public server(int port){
        try {
            server = new ServerSocket( port);
            System.out.println("server is connecte");

            System.out.println("waiting for client");

            socket = server.accept();

            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            String line = "";
            while (!line.equals("over")){
                try {
                    line = input.readUTF();
                    System.out.println(line);
                }catch (Exception p){
                    System.out.println(p);
                }
            }

            input.close();
            socket.close();
        }catch (Exception p){
            System.out.println(p);
        }
    }

    public static void main(String[] args) {

        server server = new server(222);
    }
}