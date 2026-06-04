import java.io.IOException;
import java.util.Scanner;
import org.jline.reader.*;
import org.jline.terminal.*;

public class Main {
    public static void main(String[] args) {
        int eigenerPort = 5000;
        int PortZuVerbinden = 5000;

        ChatSpeicher speicher = new ChatSpeicher();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dein Name:");
        String userName = scanner.nextLine();
        System.out.println("Zu kontaktierende IP-Adresse:");
        String IPzuVerbinden = scanner.nextLine();
        
        try {
            Terminal terminal = TerminalBuilder.builder().system(true).build();
            LineReader lineReader = LineReaderBuilder.builder().terminal(terminal).build();

            Peer peer = new Peer(speicher);
            peer.verbinden(eigenerPort, IPzuVerbinden, PortZuVerbinden);
            peer.empfangenStarten(userName, lineReader);

            while(true){
                try {
                    String input = lineReader.readLine(userName + "> ");
                    if(input == null || input.isBlank()) continue;
                    peer.senden(userName + "> " + input);
                    lineReader.printAbove(userName + "> " + input);
                } catch(UserInterruptException | EndOfFileException e){
                    break;
                }
            }
            peer.beenden();
        } catch(IOException | InterruptedException e){}
    }
}
