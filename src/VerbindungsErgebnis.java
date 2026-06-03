import java.net.Socket;

public class VerbindungsErgebnis {
    private Socket socket = null;

    public synchronized void setSocket(Socket socket){
        this.socket = socket;
        notifyAll();
        
    }

    public synchronized Socket wartenAufSocket() throws InterruptedException{
        while(socket == null){
            wait();
        }
        return socket;
    }
}
