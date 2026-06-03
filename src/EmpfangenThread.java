import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class EmpfangenThread implements Runnable {
    private Socket socket;
    private String userName;

    public EmpfangenThread(Socket socket, String userName){
        this.socket = socket;
        this.userName = userName;
    }

    public void run(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String nachrichtErhalten = in.readLine();
            while((nachrichtErhalten = in.readLine()) != null){
                System.out.println(nachrichtErhalten);
                System.out.print(">");
            }
        } catch (Exception e) {
        }
    }
}
