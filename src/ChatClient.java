// mhsd_pc@yahoo.com
//https://github.com/mhsedaghat
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class ChatClient {

    private JFrame frame;
    private JTextField textFieldMessage;
    private JTextField textFieldaddress;


    private static JTextArea textArea;
    private static Socket con;
    DataInputStream input;
    DataOutputStream output;
    private JScrollPane scrollPane;
    private static String address;
    private static String addressedit;


    /**
     * Launch the application.
     *
     * @throws IOException
     * @throws UnknownHostException
     */
    public static void main(String[] args) throws UnknownHostException, IOException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChatClient window = new ChatClient();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        if (getipaddress() != "") {
            address = getipaddress();
        }

        con = new Socket(address, 5032);//  sedaghat













        //resive from server //resive from server //resive from server //resive from server
        //resive from server //resive from server //resive from server //resive from server //resive from server
        //resive from server //resive from server //resive from server //resive from server //resive from server






        while (true) {
            try {

                DataInputStream input = new DataInputStream(con.getInputStream());
                String string = input.readUTF();                                               //resive from server
                textArea.setText(textArea.getText() + "\n" + "Server : " + string);
            } catch (Exception ev) {
                textArea.setText(textArea.getText() + " \n" + "Network issues ");

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

    //resive from server //resive from server //resive from server //resive from server



















    private static String getipaddress() {
        return addressedit;
    }

    /**
     * Create the application.
     */
    public ChatClient() {
        initialize();
        address = "127.0.0.1";
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(UIManager.getColor("MenuBar.highlight"));
        frame.setBounds(100, 130, 605, 378);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textFieldMessage = new JTextField();
        textFieldMessage.setFont(new Font("Lato Medium", Font.PLAIN, 22));
        textFieldMessage.setForeground(Color.BLUE);
        textFieldMessage.setBackground(Color.DARK_GRAY);
        frame.setTitle("Client Chat");
        textFieldMessage.setBounds(12, 45, 344, 38); // set message
        frame.getContentPane().add(textFieldMessage);
        textFieldMessage.setColumns(10);


// sedaghat

        textFieldaddress = new JTextField();
        textFieldaddress.setFont(new Font("Lato Medium", Font.PLAIN, 22));
        textFieldaddress.setForeground(Color.BLUE);
        textFieldaddress.setBackground(Color.YELLOW);
        textFieldaddress.setBounds(12, 85, 344, 38);
        frame.getContentPane().add(textFieldaddress);
        textFieldaddress.setColumns(10);

        addressedit = textFieldaddress.getText();//sedaghat

        JButton btnNewButton = new JButton("Send");













        // send to server // send to server // send to server // send to server // send to server
        // send to server // send to server // send to server // send to server // send to server // send to server
        // send to server // send to server // send to server // send to server // send to server // send to server // send to server








        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (textFieldMessage.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please write some text !");
                } else {
                    textArea.setText(textArea.getText() + "\n" + "Client :" + textFieldMessage.getText());
                    try {

                        DataOutputStream output = new DataOutputStream(con.getOutputStream());
                        String tempaddress = "";
                        tempaddress = textFieldaddress.getText();
                        if (tempaddress == "")
                        {
                            tempaddress = "server";
                        }

                        output.writeUTF(tempaddress + " :" + textFieldMessage.getText());                             // send to server
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





        // send to server // send to server // send to server // send to server // send to server // send to server












        btnNewButton.setFont(new Font("Arial", Font.BOLD, 22));
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.setBackground(Color.WHITE);
        btnNewButton.setBounds(398, 45, 164, 38);
        frame.getContentPane().add(btnNewButton);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 149, 557, 157);
        frame.getContentPane().add(scrollPane);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
        textArea.setFont(new Font("Arial", Font.PLAIN, 22));//Comic Sans MS
        textArea.setForeground(new Color(0, 255, 0));
        textArea.setBackground(new Color(0, 128, 128));
    }
}
