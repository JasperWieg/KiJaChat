import java.io.IOException;
import java.net.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class WarteThread implements Runnable{
    private int eigenerPort;
    private AtomicBoolean verbunden;
    private VerbindungsErgebnis ergebnis;

    public WarteThread(int eigenerPort, AtomicBoolean verbunden, VerbindungsErgebnis ergebnis){
        this.eigenerPort = eigenerPort;
        this.verbunden = verbunden;
        this.ergebnis = ergebnis;
    }

    public void run(){
        try{
            ServerSocket serverSocket = new ServerSocket(eigenerPort);
            Socket eingehendSocket = null;

            while(eingehendSocket == null) {
                eingehendSocket = serverSocket.accept();
            }

            serverSocket.close();
            if(verbunden.compareAndSet(false, true)){
                ergebnis.setSocket(eingehendSocket);
            } else{
                eingehendSocket.close();
            }
        } catch(IOException IO){
            
        }
        /*hier mit serversocket hören auf verbindung, dann daraus 
        wweiteren socket nehmen und wieder schließen, dann falls nicht
        verbunden true auf true setzen, sonst einfach socket schließen
        weil anderer thread schneller verbunden hat */
    }
}
