import java.io.*;
import java.net.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.synth.SynthToggleButtonUI;

import java.awt.BorderLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;

public class Server extends JFrame {
   
   
    
        ServerSocket server;
        Socket socket;


        BufferedReader br;
        PrintWriter out;

        private JLabel heading =new JLabel("Server Area");
    private JTextArea messageArea=new JTextArea();
    private JTextField messssageInput=new JTextField();
    private Font font=new Font("Roboto",Font.PLAIN,20);
        public Server()
        {
           
         try{
                  server=new ServerSocket(7777);
                  System.out.println("server is ready accept connection");
                  System.out.println("watting...");
                  socket=server.accept();


                  br=new BufferedReader(new InputStreamReader(socket.getInputStream()), 1);
                  out=new PrintWriter(socket.getOutputStream());
                 createGUI();
                  handleEvents();
                  startReading();
                  startwriting();
            }
            catch(Exception e){
                e.printStackTrace();
            }
    
        }

        public void handleEvents(){
            messssageInput.addKeyListener(new KeyListener() {
             public void keyTyped(KeyEvent e){
     
             }
               public void keyPressed(KeyEvent e){
     
             }
              public void keyReleased(KeyEvent e){
                          
                // System.out.println("key released "+e.getKeyCode());
                 if(e.getKeyCode()==10){
                     //System.out.println("you have pressed enter button");
                     String contentToSend=messssageInput.getText();
                     out.println(contentToSend);
                     messageArea.append("Me: "+contentToSend+"\n");
                     out.flush();
                     messssageInput.setText("");
                     messssageInput.requestFocus();
                 }
             }
     
            });
        }
        private void createGUI(){
            this.setTitle("Server Message[END]");
            this.setSize(600,600);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            heading.setFont(font);
            messageArea.setFont(font);
            messssageInput.setFont(font);
         
            heading.setHorizontalAlignment(SwingConstants.CENTER);
            heading.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
            messageArea.setEditable(false);
            messssageInput.setHorizontalAlignment(SwingConstants.CENTER);
    
            this.setLayout(new BorderLayout());
            this.add(heading,BorderLayout.NORTH);
            JScrollPane JScrollPane=new JScrollPane(messageArea);
             this.add(JScrollPane,BorderLayout.CENTER);
              this.add(messssageInput,BorderLayout.SOUTH);
           
    
    
            this.setVisible(true);
        }
    
        public void startReading()
        {
            //read
                Runnable r1=()->{
                    System.out.println("reader started...");
                    while(true){
                        try{
                        String msg=br.readLine();
                        if(msg.equals("exit"))
                        {
                            System.out.println("client terminated the chat");
                            messssageInput.setEnabled(false);
                            socket.close();
                            break;
                        }
                        System.out.println("client: "+msg);
                        messageArea.append("client: "+msg+"\n");
                        String url="jdbc:mysql://localhost:3306/chatapp";
        String username="root";
        String passworld="w@2915djkq#";
        Connection con=DriverManager.getConnection(url,username,passworld);
            String query = "INSERT INTO  message (meg) VALUES (?)";
            String querye = "INSERT INTO  messaget (content) VALUES (?)";
            
            PreparedStatement pstmt=con.prepareStatement(query);
             PreparedStatement psttmt=con.prepareStatement(querye);
            pstmt.setString(1,msg);
             psttmt.setString(1,msg);
            System.out.println("message is enter");
            pstmt.executeUpdate();
             psttmt.executeUpdate();
                    }
                    catch(Exception e){
                      // e.printStackTrace();
                    }
                    }

                };
                new Thread(r1).start();
        }

        public void startwriting()
        {
              //send client
              Runnable r2=()->{
                System.out.println("writter started...");

                while(true){
                    try{

                        BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
                        String content=br1.readLine();
                        out.println(content);
                        out.flush();

                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
              };
              new Thread(r2).start();
        }
        public static void main(String[] args){
            System.out.println("this is servar...going start servar");
            new Server();
        }
    }
    

