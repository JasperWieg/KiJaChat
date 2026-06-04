import java.io.*;
import java.net.*;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jline.reader.LineReader;

public class Peer {
    private Socket socket;
    private PrintWriter out;
    private ChatSpeicher speicher;

    public Peer(ChatSpeicher speicher){
        this.speicher = speicher;
    }

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

    public void empfangenStarten(String userName, LineReader lineReader){
        Thread empfangenThread = new Thread(new EmpfangenThread(socket, userName, speicher, lineReader));
        empfangenThread.start();
    }

    public void senden(String nachricht){
        speicher.hinzufuegenNachricht(nachricht);
        out.println(nachricht);
        out.flush();
    }

    public void beenden()throws IOException{
        if(socket!=null){socket.close();}
    }
}
