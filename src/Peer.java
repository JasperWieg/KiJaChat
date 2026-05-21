import java.io.*;
import java.net.*;

public class Peer {
    private Socket socket;
    private PrintWriter out;

    public void verbinden(int meinPort, String IPZuVerbinden, int PortZuVerbinden){
        /*neue atomicboolean(falsch) und verbindungsergebnis erstellen 
        dann wartethread und verbindethread starten und von ergebnis
        wartefunktion socket kriegen dann outputstream vom socket zum
        printWriter machen*/
    }

    public void empfangenStarten(String userName){
        /*empfangsthread starten  */
    }

    public void senden(String nachricht){
        //Nachricht zu printwriter drucken
    }

    public void beenden(){
        Socket schließen;
    }
}
