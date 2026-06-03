import java.io.IOException;
import java.util.Scanner;
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
        Peer peer = new Peer(speicher);
        try{
            peer.verbinden(eigenerPort, IPzuVerbinden, PortZuVerbinden);
            peer.empfangenStarten(userName);
            System.out.print(userName + "> ");
            while(scanner.hasNextLine()){
                String input = scanner.nextLine();
                if(input.isBlank()){continue;}
                peer.senden(userName + "> " + input);
                //System.out.println(userName + "> " + input);
                System.out.print(userName + "> ");
            }
        }catch(IOException | InterruptedException e){}
    }
}
