package atm.simulator;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
public class BalanceEnquiry extends JFrame implements ActionListener  {
    JButton back,exit;
    String pinnumber;
    
    BalanceEnquiry(String pinnumber){
        this.pinnumber=pinnumber;
      
        setLayout(null);
        ImageIcon i1=new  ImageIcon(ClassLoader.getSystemResource("icon/ATM.jpeg"));
        Image i2=i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 700, 700);
        add(image);
        
        
         back = new JButton("Back");
        back.setBounds(310, 355, 130, 30);
        back.addActionListener(this);
        image.add(back);
        
         exit = new JButton("Exit");
        exit.setBounds(310, 390, 130, 30);
        exit.addActionListener(this);
        image.add(exit);
        
        Conn c = new Conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
            
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));

                }
            }
        }catch (Exception e){
                    System.out.println(e);
        }
        JLabel text = new JLabel("Your Current Balance is Rs "+balance);
        text.setForeground(Color.black);
        text.setBounds(170,230,400,30);
        image.add(text);
        
        setSize(700,700);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(true);
            new Transactions(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==exit){
            setVisible(false);
            }
    }
    public static void main(String args[]){
        new BalanceEnquiry("");
        
    }
        

}