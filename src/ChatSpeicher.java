import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ChatSpeicher{
    DynArray<String> nachrichten = new DynArray();

    public void hinzufuegenNachricht(String nachricht){
        nachrichten.append(nachricht);
        speicherNachrichten("chat.txt");

    }

    public void speicherNachrichten(String pfad) {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(pfad));

            for(int i = 0; i < nachrichten.getLength(); i ++) {
                writer.write(nachrichten.getItem(i) + "\n");
            }
            

            writer.close();
        } catch (IOException e) {
            System.out.println("Speichern fehlgeschlagen");
        }
    }

}