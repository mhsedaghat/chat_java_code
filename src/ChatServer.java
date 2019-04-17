// mhsd_pc@yahoo.com
//https://github.com/mhsedaghat

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ChatServer {

	private JFrame frmServerChat;
	private JTextField textFieldMessage;
	private JTextField textFieldaddress;
	private static   JTextArea textArea;
	private JButton btnNewButton;
	static ServerSocket server ;
	static Socket con;
	private JScrollPane scrollPane;
	private static JLabel lblNewLabel_2;
	private static JLabel lblNewLabel;




	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException   {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatServer window = new ChatServer();
					window.frmServerChat.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
		 serverConnection();
	
	
	}

	private static void serverConnection() throws IOException {
		server = new ServerSocket(5032);

		 con = server.accept();
		 lblNewLabel_2.setText("Client found !");
			lblNewLabel_2.setForeground(new Color(0, 0, 128));







		/// resive from server/// resive from server/// resive from server/// resive from server
		/// resive from server/// resive from server/// resive from server/// resive from server/// resive from server
		/// resive from server/// resive from server/// resive from server/// resive from server/// resive from server/// resive from server







		 while (true) {
			try {
				
				DataInputStream input = new DataInputStream(con.getInputStream());
				String string = input.readUTF();                                                          /// resive from server
				textArea.setText(textArea.getText() + "\n" + "Client : " + string);
			} catch (Exception ev) {
				 textArea.setText(textArea.getText()+" \n" +"Network issues ");
				 
					try {
						Thread.sleep(2000);
						System.exit(0);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}

		}
	}



/// resive from server/// resive from server/// resive from server/// resive from server/// resive from server







	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public ChatServer() throws IOException {
		initialize();


		 
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frmServerChat = new JFrame();
		frmServerChat.getContentPane().setBackground(UIManager.getColor("MenuBar.highlight"));
		frmServerChat.setForeground(Color.BLUE);
		frmServerChat.setBackground(Color.WHITE);
		frmServerChat.setTitle("Server Chat");
		frmServerChat.setIconImage(Toolkit.getDefaultToolkit().getImage("/home/mohammed/Desktop/icon/Java.png"));
		frmServerChat.getContentPane().setForeground(Color.GREEN);
		frmServerChat.setBounds(100, 130, 605, 403);
		frmServerChat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmServerChat.getContentPane().setLayout(null);
		
		textFieldMessage = new JTextField();
		textFieldMessage.setFont(new Font("Lato Semibold", Font.PLAIN, 24));
		textFieldMessage.setForeground(new Color(255, 255, 255));
		textFieldMessage.setBackground(Color.DARK_GRAY);
		textFieldMessage.setBounds(12, 45, 344, 38);
		frmServerChat.getContentPane().add(textFieldMessage);

// sedaghat
		textFieldaddress = new JTextField();
		textFieldaddress.setFont(new Font("Lato Medium", Font.PLAIN, 22));
		textFieldaddress.setForeground(Color.BLUE);
		textFieldaddress.setBackground(Color.YELLOW);
		textFieldaddress.setBounds(12, 85, 344, 38);
		frmServerChat.getContentPane().add(textFieldaddress);
		textFieldaddress.setColumns(10);




		textFieldMessage.setColumns(10);
		
		btnNewButton = new JButton("Send");










		//send to client //send to client //send to client //send to client //send to client
		//send to client //send to client //send to client //send to client //send to client //send to client
		//send to client //send to client //send to client //send to client //send to client //send to client //send to client









		btnNewButton.addActionListener(new ActionListener() {
			 
			public void actionPerformed(ActionEvent e) {
				
				if (textFieldMessage.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Please write some text !");
			 
				}
				else if(textFieldMessage.isFocusable()){
					btnNewButton.setEnabled(true);
					textArea.setText(textArea.getText() + "\n" + "Server : " + textFieldMessage.getText());
					try {
						DataOutputStream output = new DataOutputStream(con.getOutputStream());
						String tempaddress = "";
						tempaddress = textFieldaddress.getText();
						if (tempaddress == "")
						{
							tempaddress = "client";
						}

						output.writeUTF(tempaddress + " :" + textFieldMessage.getText());                         //send to client
					} catch (IOException e1) {
						textArea.setText(textArea.getText() + "\n " + " Network issues");
						try {
							Thread.sleep(2000);
							System.exit(0);
						} catch (InterruptedException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}

					}
					textFieldMessage.setText("");
				}
			}
		});




		//send to client //send to client //send to client //send to client //send to client //send to client //send to client

















		btnNewButton.setFont(new Font("Arial", Font.BOLD, 24));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(398, 45, 164, 38);
		frmServerChat.getContentPane().add(btnNewButton);
		 
		 scrollPane = new JScrollPane();
		 scrollPane.setBounds(12, 134, 557, 157);
		 frmServerChat.getContentPane().add(scrollPane);
		
		 textArea = new JTextArea();
		 scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Arial", Font.BOLD, 24));
		textArea.setForeground(Color.ORANGE);
		textArea.setBackground(Color.DARK_GRAY);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		
		lblNewLabel.setBounds(154, 13, 242, 33);
		frmServerChat.getContentPane().add(lblNewLabel);
		 if (server.isClosed()) {
			lblNewLabel.setText("Server is closed");
		}else{
			lblNewLabel.setText("Waiting for connection");
			lblNewLabel.setForeground(Color.GREEN);
		}
		JLabel lblNewLabel_1 = new JLabel("Status");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 22));
		lblNewLabel_1.setBounds(37, 12, 95, 30);
		frmServerChat.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblNewLabel_2.setBounds(22, 303, 128, 30);
		frmServerChat.getContentPane().add(lblNewLabel_2);






	}
}
