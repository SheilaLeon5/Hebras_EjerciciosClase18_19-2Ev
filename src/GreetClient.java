import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.UnknownHostException;

public class GreetClient {
	private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
 
    public void startConnection(String ip, int port) {
        
        try {
        	clientSocket = new Socket(ip, port);
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (UnknownHostException e1) {
			System.out.println(e1.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} 
    }
 
    public String sendMessage(String msg) {
        out.println(msg);
        String resp = null;
		try {
			resp = in.readLine();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
        return resp;
    }
 
    public void stopConnection() {
        try {
			in.close();
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        out.close();
    }
    
    public static void main(String[] args) { 
	    GreetClient client = new GreetClient();
	    client.startConnection("192.168.104.58", 6666);
	    String response = client.sendMessage("hello server");
	    System.out.println("CLIENTE: " + response);
    }       
}




//https://www.baeldung.com/a-guide-to-java-sockets
