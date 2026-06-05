import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Klasse zum Speichern von gesendeten und empfangenen
 * Nachrichten in einer .txt Datei
 *
 */
public class ChatSpeicher{
    DynArray<String> nachrichten = new DynArray();

    /**
    * fügt Nachricht zum DynArray hinzu
    *
    * @param nachricht übertragene nachricht
    */
    public void hinzufuegenNachricht(String nachricht){
        nachrichten.append(nachricht);
        speicherNachrichten("chat.txt");

    }
    /**
    * speichert die Nachrichten aus dem DynArray in einem txt file
    *
    * @param pfad pfad der txt-Datei
    * 
    */
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
    /**
    * leert die gespeicherten Nachrichten aus dem file
    *
    * @param pfad pfad der txt-Datei
    * 
    */

    public void chatLeeren(String pfad){
        try{
            FileWriter writer = new FileWriter("chat.txt", false);

            writer.write("");
            System.out.println("Chat wurde geleert.");



        } catch (IOException e) {
            System.out.println("Chat leeren fehlgeschlagen");
        }
    }

}