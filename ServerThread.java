import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ServerThread extends Thread
{
	private Socket socket; // Client Connection
	private InputStream in;
	private Server server;
	private OutputStream out;
	public ServerThread(Server server, Socket socket) throws IOException 
	{
		this.socket = socket;
		this.in = this.socket.getInputStream();
		this.out = this.socket.getOutputStream();
		this.server = server;
	}
	@Override
	public void run() 
	{
			try 
			{
				readMessage();
			} 
			catch (IOException e) 
			{
//				e.printStackTrace();
				System.out.println("Message Error");
			}
	}
	public void readMessage() throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String inputLine;
		while(true)
		{ 
			inputLine = br.readLine()+"\n";
			System.out.println("message from client to another client\n"+inputLine);
			for(ServerThread thread : server.sockets) 
			{
					thread.socket.getOutputStream().write(inputLine.getBytes());
			}

		}
		 
	}

}
