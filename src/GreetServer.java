import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class GreetServer {
	private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
 
    public void start(int port) {
    	String greeting = null;
        try {
			serverSocket = new ServerSocket(port);
			System.out.println("-- servidor iniciado --");
			clientSocket = serverSocket.accept();  // Espera la referencia del socket del cliente
	        out = new PrintWriter(clientSocket.getOutputStream(), true);
	        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	        greeting = in.readLine();
			
	        
	        
            if ("hello server".equals(greeting)) {
                out.println("Servidor de Sheila --> hello client");
            }
            else {
                out.println("unrecognised greeting");
            }
	
		} catch (IOException e) {
			System.out.println(e.getMessage());;
		}
    }
 
    public void stop() {
        try {
			in.close();
			out.close();
	        clientSocket.close();
	        serverSocket.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
    }
    public static void main(String[] args) {
        GreetServer server=new GreetServer();
        server.start(6666);
    }
}

