import java.io.*;
import java.net.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Peer {
    private Socket socket;
    private PrintWriter out;

    public Peer(){}

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

    public void empfangenStarten(String userName){
        Thread empfangenThread = new Thread(new EmpfangenThread(socket, userName));
        empfangenThread.start();
    }

    public void senden(String nachricht){
        out.println(nachricht);
        out.flush();
    }

    public void beenden()throws IOException{
        if(socket!=null){socket.close();}
    }
}
