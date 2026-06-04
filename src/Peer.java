import java.io.*;
import java.net.*;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jline.reader.LineReader;

/**
 * Klasse zum handlen der Verbindung per Socket und Nachrichten
 *
 */
public class Peer {
    private Socket socket;
    private PrintWriter out;
    private ChatSpeicher speicher;

    /**
    * Konstruktor Peer
    *
    * @param speicher speicher Objekt
    * 
    */
    public Peer(ChatSpeicher speicher){
        this.speicher = speicher;
    }

    /**
    *  verbindung mit anderem socket herstellen
    *
    * @param meinPort eigener Port
    * @param IPZuVerbinden Ip die angefunkt wird
    * @param PortZuVerbinden Port der angefunkt wird
    * 
    */
    public void verbinden(int meinPort, String IPZuVerbinden, int PortZuVerbinden)throws IOException, InterruptedException{
        AtomicBoolean verbunden = new AtomicBoolean(false);
        VerbindungsErgebnis ergebnis = new VerbindungsErgebnis();
        Thread warteThread = new Thread(new WarteThread(meinPort, verbunden, ergebnis));
        warteThread.start();
        Thread verbindenThread = new Thread(new VerbindenThread(IPZuVerbinden, PortZuVerbinden, verbunden, ergebnis));
        verbindenThread.start();
        socket = ergebnis.wartenAufSocket();
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    /**
    * startet den EmpfangsThread
    *
    * @param userName Name des Users
    * @param lineReader lineReader Objekt
    * 
    */
    public void empfangenStarten(String userName, LineReader lineReader){
        Thread empfangenThread = new Thread(new EmpfangenThread(socket, userName, speicher, lineReader));
        empfangenThread.start();
    }

    /**
    * vsersenden von Nachrichten
    *
    * @param nachricht zu versendende Nachricht
    * 
    */
    public void senden(String nachricht){
        speicher.hinzufuegenNachricht(nachricht);
        out.println(nachricht);
        out.flush();
    }

    /**
    * schließt den Socket des Peers
    * 
    */
    public void beenden()throws IOException{
        if(socket!=null){socket.close();}
    }
}
