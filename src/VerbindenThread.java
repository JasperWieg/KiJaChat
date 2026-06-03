import java.io.*;
import java.net.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class VerbindenThread implements Runnable{
    private String IPZuVerbinden;
    private int PortZuVerbinden;
    private AtomicBoolean verbunden;
    private VerbindungsErgebnis ergebnis;

    public VerbindenThread(String IPZuVerbinden, int PortZuVerbinden, AtomicBoolean verbunden, VerbindungsErgebnis ergebnis){
        this.IPZuVerbinden = IPZuVerbinden;
        this.PortZuVerbinden = PortZuVerbinden;
        this.verbunden = verbunden;
        this.ergebnis = ergebnis;
    }

    public void run(){
        while(!verbunden.get()){
            try {
                Socket socket = new Socket(IPZuVerbinden, PortZuVerbinden);
                if(verbunden.compareAndSet(false, true)){
                    ergebnis.setSocket(socket);
                } else{
                    socket.close();  
                }
                return;
            } catch (IOException e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException r) {}
            }
        }
    }
}