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
        /*hier mit serversocket hören auf verbindung, dann daraus 
        wweiteren socket nehmen und wieder schließen, dann falls nicht
        verbunden true auf true setzen, sonst einfach socket schließen
        weil anderer thread schneller verbunden hat */
    }
}
