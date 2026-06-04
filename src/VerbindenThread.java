import java.io.*;
import java.net.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Thread zum Verbinden mit anderem Socket
 *
 */
public class VerbindenThread implements Runnable{
    private String IPZuVerbinden;
    private int PortZuVerbinden;
    private AtomicBoolean verbunden;
    private VerbindungsErgebnis ergebnis;

    /**
    * Konstruktor VerbindenThread
    * @param IPZuVerbinden IP mit der sich verbunden wird
    * @param PortZuVerbinden Port mit dem sich verbunden wird
    * @param verbunden Wahrheitswert ob verbunden wurde oder nicht
    * @param ergebnis ergebnisObjekt zum weitergeben des Socket
    * 
    */
    public VerbindenThread(String IPZuVerbinden, int PortZuVerbinden, AtomicBoolean verbunden, VerbindungsErgebnis ergebnis){
        this.IPZuVerbinden = IPZuVerbinden;
        this.PortZuVerbinden = PortZuVerbinden;
        this.verbunden = verbunden;
        this.ergebnis = ergebnis;
    }

        /**
    * versucht aktiv sich mit einem anderen Socket zu verbinden
    *
    * 
    */
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