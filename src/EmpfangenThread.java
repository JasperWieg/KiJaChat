import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import org.jline.reader.LineReader;

/**
 * Thread zum Empfangen vom Nachrichten
 *
 */
public class EmpfangenThread implements Runnable {
    private Socket socket;
    private String userName;
    private ChatSpeicher speicher;
    private LineReader lineReader;

    /**
    * Konstruktor EmpfangenThread
    *
    * @param socket zugehöriger Socket
    * @param userName Name des Users
    * @param speicher speicher objekt
    * @param lineReader lineReaderObjekt
    * 
    */
    public EmpfangenThread(Socket socket, String userName, ChatSpeicher speicher, LineReader lineReader){
        this.socket = socket;
        this.userName = userName;
        this.speicher = speicher;
        this.lineReader = lineReader;
    }
    /**
    * 
    * Empfängt Nachrichten
    * 
    */
    public void run(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String nachrichtErhalten;
            while((nachrichtErhalten = in.readLine()) != null){
                speicher.hinzufuegenNachricht(nachrichtErhalten);
                lineReader.printAbove(nachrichtErhalten);
            }
        } catch (IOException e) {
        }
    }
}
