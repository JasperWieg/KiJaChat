import java.io.IOException;
import java.net.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Thread zum lauschen auf Verbindungen von anderen Sockets
 *
 */
public class WarteThread implements Runnable{
    private int eigenerPort;
    private AtomicBoolean verbunden;
    private VerbindungsErgebnis ergebnis;

    /**
    * Konstruktor WarteThread
    *
    * @param eigenerPort port auf dem nach Verbindungen geelauscht wird
    * @param verbunden Wahrheitswert ob verbunden wurde
    * @param ergebnis ergebnis Objekt zum weitergeben des Sockets 
    * 
    */
    public WarteThread(int eigenerPort, AtomicBoolean verbunden, VerbindungsErgebnis ergebnis){
        this.eigenerPort = eigenerPort;
        this.verbunden = verbunden;
        this.ergebnis = ergebnis;
    }

    /**
    * lauscht nach Verbindungen und gibt erfolgreich verbundene Sockets weiter
    * 
    */
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
    }
}
