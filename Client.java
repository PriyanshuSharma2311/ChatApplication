import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	Socket socket;
	InputStream in;
	static OutputStream out;
	ClientThread clientThread;
	public Client() throws UnknownHostException, IOException
	{
		System.out.println("client Comes Online");
		socket=new Socket("localhost",9002);
		in=socket.getInputStream();
		out=socket.getOutputStream();
		clientThread= new ClientThread(in); 
		clientThread.start();
	}
	public  void  sendMessage(String message) throws IOException
	{
		byte b[] = message.getBytes();
		out.write(b);		
	}
	public void closeConnection() throws IOException 
	{
		if(socket!=null) 
		{
		socket.close();
		}
	}
//	public static void main(String[] args) 
//	{
//		// TODO Auto-generated method stub
//		try 
//		{
//			Client client = new Client();
//			while(true) 
//			{
//				System.out.println("Send Message to Server");
//				String message = new Scanner(System.in).nextLine();
//				client.sendMessage(message+"\n");
//			}
//		} 
//		catch (UnknownHostException e) 
//		{
////			e.printStackTrace();
//			System.out.println("Unknown Host Cannot Connect");
//		} 
//		catch (IOException e) 
//		{
////			e.printStackTrace();
//			System.out.println("Error");
//		}
//	}
}
