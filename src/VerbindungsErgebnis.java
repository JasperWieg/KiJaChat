import java.net.Socket;

public class VerbindungsErgebnis {
    private Socket socket = null;

    private void setSocket(Socket socket){
        this.socket = socket;
        //danach alle threads aufrufen
    }

    private Socket wartenAufSocket(){
        //während socket null ist warten und dann socket zurückgeben 
        return socket;
    }
}
