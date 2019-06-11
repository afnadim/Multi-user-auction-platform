/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_auction;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.net.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nadim
 */
public class ClientGUI extends javax.swing.JFrame {
    //--------------------------------------------------------------------------------------------------------------------------------
    
    String username, address = "localhost";
    int port = 2222;
    Boolean isConnected=true;  
    Socket sock;
    BufferedReader reader;
    PrintWriter writer;
    Calendar CurrentTime = Calendar.getInstance();
     //--------------------------------------------------------------------------------------------------------------------------------
    //method to disconnect the Client from thee server
   public void Disconnect() 
    {
        try 
        {
            info_display.append("Disconnected.\n");
            sock.close();
        } catch(Exception ex) {
            info_display.append("Failed to disconnect. \n");
        }
        isConnected = false;
    }  
     
   //---------------------------------------------------------------------------------------------------------------------------------
    /**
     * Creates new form ClientGUI
     */
    public ClientGUI() {
        initComponents();
    }
    //--------------------------------------------------------------------------------------------------------------------------------   
     /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Product_Display = new javax.swing.JTextArea();
        Bid = new javax.swing.JTextField();
        Connect = new javax.swing.JButton();
        Disconnect = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        info_display = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        Submit_bid = new javax.swing.JButton();
        Time_remaining = new javax.swing.JTextField();
        time_remaining = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        bid_display = new javax.swing.JTextField();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Product_Display.setColumns(20);
        Product_Display.setRows(5);
        jScrollPane1.setViewportView(Product_Display);

        Bid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BidActionPerformed(evt);
            }
        });

        Connect.setText("Connect");
        Connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectActionPerformed(evt);
            }
        });

        Disconnect.setText("Disconnect");
        Disconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisconnectActionPerformed(evt);
            }
        });

        info_display.setColumns(20);
        info_display.setRows(5);
        jScrollPane2.setViewportView(info_display);

        jLabel1.setText("Product Description");

        Submit_bid.setText("Bid");
        Submit_bid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Submit_bidActionPerformed(evt);
            }
        });

        Time_remaining.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Time_remainingActionPerformed(evt);
            }
        });

        time_remaining.setText("        Time remaining to bid ");

        jLabel3.setText("              Information Display");

        jTextField1.setText("        Current Highest Bid");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        bid_display.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bid_displayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Connect, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Disconnect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel1)
                                        .addGap(0, 40, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(bid_display, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(Submit_bid, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(Bid, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(Time_remaining, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(time_remaining, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(time_remaining)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Time_remaining, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Bid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Submit_bid)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bid_display, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Disconnect)
                    .addComponent(Connect))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BidActionPerformed
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_BidActionPerformed

    private void ConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConnectActionPerformed
        // TODO add your handling code here:
        //-----------------------------------------------------------------------------------------------------------------------------
        //starting a client Thread
        Thread starter = new Thread(new Client_thread());
        starter.start();
        //------------------------------------------------------------------------------------------------------------------------------
          try {
            username= InetAddress.getLocalHost().getHostAddress();
            sock = new Socket(address, port);
          //sending the server information about the client
            writer = new PrintWriter(sock.getOutputStream());
            writer.println("New Connection: "+ username);
            writer.flush();    
        } catch (IOException ex) {
            Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
              
      
    }//GEN-LAST:event_ConnectActionPerformed

    private void DisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisconnectActionPerformed
                                                    
            try {
                sock = new Socket(address, port);
                //Calendar ConnectionDate = Calendar.getInstance();
                writer = new PrintWriter(sock.getOutputStream());
                //writer.println("Client :" + username + "Disconnected  on: "+ConnectionDate.getTime()+"\n");
                writer.println("Client Disconnected"+username);
                writer.flush();
                
            } catch (IOException ex) {
                Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            Disconnect();
            //didnt work with the boolean
            //this.isConnected=false; 
    }//GEN-LAST:event_DisconnectActionPerformed
   //---------------------------------------------------------------------------------------------------------------------------------
    private void Time_remainingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Time_remainingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Time_remainingActionPerformed

    private void Submit_bidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Submit_bidActionPerformed
    //--------------------------------------------------------------------------------------------------------------------------------
        try {
            //string to send over to the server
            String bidString="New Bid of :"+ Bid.getText()+":"+"By"+username;
            sock = new Socket(address, port);
            writer = new PrintWriter(sock.getOutputStream());
            writer.println(bidString);
            writer.flush();
        } catch (IOException ex) {
            Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Submit_bidActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void bid_displayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bid_displayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bid_displayActionPerformed
    //setting end time countdown format
    private static String formatSeconds(long seconds) {
    return (seconds != 1) ? String.format(
      "%d seconds", seconds) : "1 second";
    }
    //--------------------------------------------------------------------------------------------------------------------------------
   //creating client thread     
    public class Client_thread implements Runnable  {
   
    @Override
    public void run() {
       
            try 
            {
               Socket ClientSocket = new Socket(address, port); 
               //setting up writes and readers
               PrintWriter writer = new PrintWriter(ClientSocket.getOutputStream(),true);
               InputStreamReader isReader = new InputStreamReader(ClientSocket.getInputStream());
               reader = new BufferedReader(isReader);
               
                while (isConnected==true) 
                {
                    //setting up string to identify diffrent incomeing messages from the client
                    Calendar CurrentTime = Calendar.getInstance();
                    String message, start="Start", stop= "Server shutdown", Product_details="item description",
                    timeremaining="Time Remainging", Bid_finish="Current Bidding finished",
                    New_high_bid="New highest Bid",bid_value="current highest bid",
                    new_message="Welcome", bid_winner="the winner of the bid is" ;
                    String[] data;
	            while ((message = reader.readLine()) != null) 
                 {
                //to spilt the data when necessary
                     data = message.split(":");
                    for (String token:data) 
                    {
                    //info_display.append(token + "\n");
                    }
                    //creatin a for loop to give right size to the array
                   for (int i = 0; i < data.length; i++) {
                       
                    if (data[i].equals(start)) 
                    {
                      info_display.append(message + "\n"+ CurrentTime.getTime()+"\n\n");
                        
                    } 
                    else if (data[i].equals(stop)) 
                    {
                     info_display.append(message + "\n"+ CurrentTime.getTime()+"\n\n");
                       
                    } 
                    
                    else if (data[i].contains(Product_details)) 
                    {
                    Product_Display.append(message + "\n Time:\n"+ CurrentTime.getTime()+"\n\n"); 
                    Submit_bid.setEnabled(true);
                    } 
                    
                    else if (data[i].contains(timeremaining)) 
                    {
                    String[] parts = message.split(":");
                    String part1 = parts[0];
                    String part2 = parts[1];
                    int countdown=Integer.parseInt(part2);
                    //---------------------------------------------------------------------------------------------------------------------
                    //set timer for countdown
                    Timer CurrentTime1 = new Timer();
                    int minutes =countdown;
                    long startTime = System.currentTimeMillis();
                    long endTime = startTime + (minutes * 60 * 1000);
                    CurrentTime1.scheduleAtFixedRate(new TimerTask(){
                    @Override
                    public void run() {
                    while (System.currentTimeMillis() < endTime){
                    String s =formatSeconds(endTime - System.currentTimeMillis());
                    Time_remaining.setText(s);  
            }
        }}, 0, 1000);
                   //----------------------------------------------------------------------------------------------------------------------
                    } 
                    else if (data[i].equals(Bid_finish)) 
                    {
                    info_display.append(message + "\n Time:"+ CurrentTime.getTime()+"\n\n"); 
                    Submit_bid.setEnabled(false);
                    } 
                    
                      else if (data[i].contains(New_high_bid)) 
                    {
                    info_display.append(message + "\n Time:"+ CurrentTime.getTime()+"\n\n");  
                    String[] parts = message.split(":");
                    String part1 = parts[0];
                    String part2 = parts[1];
                     bid_display.setText(part2);  
                     
                    }
                    
                    else if (data[i].contains(bid_value)) 
                    {
                    bid_display.setText(message+"\n");  
                    }
                    
                   else if (data[i].contains(new_message)) 
                    {
                    Product_Display.setText(message+"\n");
                    }
                    
                      else if (data[i].contains(bid_winner)) 
                    {
                     info_display.append(message+"\n");
                    }
                    
                    
                   }
			
                }//while loop ends		
                }
            }
            catch (IOException ex)
            {
               info_display.append("Error making a connection. \n");
            }

    }
      
    }
    //--------------------------------------------------------------------------------------------------------------------------------
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ClientGUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Bid;
    private javax.swing.JButton Connect;
    private javax.swing.JButton Disconnect;
    private javax.swing.JTextArea Product_Display;
    private javax.swing.JButton Submit_bid;
    private javax.swing.JTextField Time_remaining;
    private javax.swing.JTextField bid_display;
    private javax.swing.JTextArea info_display;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel time_remaining;
    // End of variables declaration//GEN-END:variables
}
