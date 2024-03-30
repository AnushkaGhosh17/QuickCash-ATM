package atm.simulator;
import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
public class Transactions extends JFrame implements ActionListener {
    JButton deposit,cash,fastcash,balance,mstatement,pinchange,exit,help;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        
        ImageIcon i1=new  ImageIcon(ClassLoader.getSystemResource("icon/ATM.jpeg"));
        Image i2=i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 700, 700);
        add(image);
        
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(200, 170, 500, 35);
        text.setForeground(Color.black);
        image.add(text);
        
         deposit = new JButton("Deposit");
        deposit.setBounds(130, 290, 130, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
         cash = new JButton("Cash Withdrawl");
        cash.setBounds(310, 290, 130, 30);
        cash.addActionListener(this);
        image.add(cash);
        
         fastcash = new JButton("Fast Cash");
        fastcash.setBounds(130, 325, 130, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
         balance = new JButton("Balance Enquiry");
        balance.setBounds(310, 325, 130, 30);
        balance.addActionListener(this);
        image.add(balance);
        
         mstatement = new JButton("Mini Statement");
        mstatement.setBounds(130, 360, 130, 30);
        mstatement.addActionListener(this);
        image.add(mstatement);
        
         pinchange = new JButton("PIN Change");
        pinchange.setBounds(310, 360, 130, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);
       
         exit = new JButton("Exit");
        exit.setBounds(310, 395, 130, 30);
        exit.addActionListener(this);
        image.add(exit);
        
         help = new JButton("Help");
        help.setBounds(130, 395, 130, 30);
        help.addActionListener(this);
        image.add(help);
        
        setSize(700,700);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }
        else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==cash){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balance){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==help){
            JOptionPane.showMessageDialog(null, "For any futhur help Please contact on Phonr number : 2344-1233 or Email Id : zdc@gmail.com ");
        }
        else if(ae.getSource()==mstatement){
            //setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new Transactions("");
        
    }
    
}
