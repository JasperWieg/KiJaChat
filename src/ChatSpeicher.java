import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class ChatSpeicher{
    ArrayList<String> nachrichten = new ArrayList();

    public void hinzufuegenNachricht(String nachricht){
        nachrichten.add(nachricht);
        speicherNachrichten("chat.txt");

    }

    public void speicherNachrichten(String pfad) {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(pfad));

            for(String zeile : nachrichten) {
                writer.write(zeile + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Speichern fehlgeschlagen");
        }
    }

}