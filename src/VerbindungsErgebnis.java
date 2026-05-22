import java.net.Socket;

public class VerbindungsErgebnis {
    private Socket socket = null;

    public void setSocket(Socket socket){
        this.socket = socket;
        notifyAll();
        
    }

    private Socket wartenAufSocket() throws InterruptedException{
        while(socket == null){
            wait();
        }
        return socket;
    }
}
