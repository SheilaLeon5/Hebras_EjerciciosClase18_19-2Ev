import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public void start(int port) {
        try {
			ServerSocket serverSocket = new ServerSocket(port);
			Socket clientSocket = serverSocket.accept();
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			 
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				if (".".equals(inputLine)) {
					out.println("good bye");
					break;
				}	
			 }
			 out.println(inputLine);
			 serverSocket.close(); 
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
    }

    public static void main(String[] args) {
        GreetServer server=new GreetServer();
        server.start(4444);
    }   
} 


