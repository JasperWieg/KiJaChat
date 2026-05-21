import java.net.*;

public class EmpfangenThread implements Runnable {
    private Socket socket;
    private String userName;

    public EmpfangenThread(Socket socket, String userName){
        this.socket = socket;
        this.userName = userName;
    }

    public void run(){
        /*hier zeilen lesen per bufferedReader, dann in konsole drucken 
        und schließlich neuen input erwarten per /r schön formatieren,
        später noch messagehandler objekt erstmal aber nicht */
    }
}
