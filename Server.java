import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	ServerSocket serverSocket;
	Socket socket;
	InputStream in;
	OutputStream out;
	ArrayList<ServerThread> sockets = new ArrayList<>();
	public Server() throws IOException
	{
		serverSocket = new ServerSocket(9002);
		System.out.println("Server ready Waiting for the client....");
		while(true)
		{
			socket=serverSocket.accept();
			ServerThread serverThread = new ServerThread(this, socket);
			sockets.add(serverThread);
			serverThread.start();
			System.out.println("client joins");
		}
		
		
	}

 	public static void main(String args[])
	{
		try {
			Server server=new Server();
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println("Server not Connected");
		}
	}
}