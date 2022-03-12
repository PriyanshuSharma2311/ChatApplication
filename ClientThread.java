import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
public class ClientThread extends Thread
{
	private InputStream in;
	public ClientThread(InputStream in) 
	{
		this.in = in;
		
	}
//	public ClientThread() throws IOException
//	{
//		readMessage();
//	}
	
	@Override
	public void run() {
		try {
			readMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("Error");
		}
	}
	public  String readMessage() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String inputLine = "";
		while(true) 
		{ 
			inputLine = br.readLine();
			System.out.println("Message Rec "+inputLine);
			if(inputLine!=null)
				{
				return inputLine;
				}
		}	 
	}
}
