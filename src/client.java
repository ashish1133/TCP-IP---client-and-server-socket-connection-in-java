import java.net.*;
import java.io.*;

public class client{
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;

    public client(String address,int port){
        try {
            socket = new Socket(address, port);
            System.out.println("connected");

            input = new DataInputStream(System.in);

            output = new DataOutputStream(socket.getOutputStream());
        }
        catch (Exception p){
            System.out.println(p);
            return;
        }
        String line = "";
        while (!line.equals("over")){
            try {
                line = input.readLine();
                output.writeUTF(line);
            }catch (Exception p){
                System.out.println(p);
            }
        }
        try {
            input.close();
            output.close();
            socket.close();
        }catch (Exception p){
            System.out.println(p);
        }
    }

    public static void main(String[] args) {

        client client = new client("127.0.0.1",222);
    }
}