import java.util.concurrent.atomic.AtomicBoolean;

public class VerbindenThread implements Runnable{
    private String IPZuVerbinden;
    private int PortZuVerbinden;
    private AtomicBoolean verbunden;
    private VerbindungsErgebnis ergebnis;

    public VerbindenThread(String IPZuVerbinden, int PortZuVerbinden, AtomicBoolean verbunden, VerbindungsErgebnis ergebnis){
        this.IPZuVerbinden = IPZuVerbinden;
        this.PortZuVerbinden = PortZuVerbinden;
        this.verbunden = verbunden;
        this.ergebnis = ergebnis;
    }

    public void run(){
        
    }
}