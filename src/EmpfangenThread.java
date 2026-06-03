import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class EmpfangenThread implements Runnable {
    private Socket socket;
    private String userName;
    private ChatSpeicher speicher;

    public EmpfangenThread(Socket socket, String userName, ChatSpeicher speicher){
        this.socket = socket;
        this.userName = userName;
        this.speicher = speicher;
    }

    public void run(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String nachrichtErhalten;
            while((nachrichtErhalten = in.readLine()) != null){
                speicher.hinzufuegenNachricht(nachrichtErhalten);
                System.out.print("\r           ");
                System.out.println("\r" + nachrichtErhalten);
                System.out.print(">");
            }
        } catch (IOException e) {
        }
    }
}
