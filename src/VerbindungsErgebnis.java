import java.net.Socket;

/**
 * Zentralsteuerung der Verbindungsthreads, Handling von Socket und Verbindung
 *
 */
public class VerbindungsErgebnis {
    private Socket socket = null;

    /**
    * setzt socket und weckt andere methode auf
    *
    * @param socket socket der gesetzt werden soll
    * 
    */
    public synchronized void setSocket(Socket socket){
        this.socket = socket;
        notifyAll();
        
    }

    /**
    * gibt socket zurück sobald methode durch setSocket geweckt wird
    *
    * @return socket auf dem verbindung läuft
    * 
    */
    public synchronized Socket wartenAufSocket() throws InterruptedException{
        while(socket == null){
            wait();
        }
        return socket;
    }
}
