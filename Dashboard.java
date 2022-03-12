import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	private JTextField Writemsg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Dashboard frame = new Dashboard();
						frame.setVisible(true);	
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			});
		} 
	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Dashboard() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the Message");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(103, 10, 250, 32);
		contentPane.add(lblNewLabel);
		
		Writemsg = new JTextField();
		Writemsg.setBounds(113, 52, 189, 61);
		contentPane.add(Writemsg);
		Writemsg.setColumns(10);
		
		JButton SendBtn = new JButton("Send");
		try {
			SendBtn.addActionListener(new ActionListener() {
				Client client=new Client();
				public  void actionPerformed(ActionEvent e) {
					try {
						
						client.sendMessage(Writemsg.getText()+"\n");
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SendBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		SendBtn.setBounds(164, 123, 85, 21);
		contentPane.add(SendBtn);
		
		JLabel lblNewLabel_1 = new JLabel("Received Message");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(113, 153, 189, 32);
		contentPane.add(lblNewLabel_1);
		ClientThread ct=null;
//		try {
//			ct=new ClientThread();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		JTextArea txtrHello = new JTextArea();
//		txtrHello.setText(ct.readMessage());
		txtrHello.setEditable(false);
		txtrHello.setBounds(113, 201, 189, 52);
		contentPane.add(txtrHello);
	}
}
