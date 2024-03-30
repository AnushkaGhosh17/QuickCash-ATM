
package atm.simulator;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
public class Withdrawl extends JFrame implements ActionListener {
    JTextField amount;
    JButton withdraw,back;
    String pinnumber;
    
    Withdrawl(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
    
    
        ImageIcon i1=new  ImageIcon(ClassLoader.getSystemResource("icon/ATM.jpeg"));
        Image i2=i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 700, 700);
        add(image);
        
        JLabel text = new JLabel ("Enter the amount you wany to withdraw");
        text.setForeground(Color.black);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setBounds(140, 170, 350, 35);
        
        
        image.add(text);
        
         amount =new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,20));
        amount.setForeground(Color.black);
        amount.setBounds(140, 230, 270, 25);
        amount.setBackground(Color.LIGHT_GRAY);
        image.add(amount);
        
         withdraw = new JButton("Withdraw");
        withdraw.setBounds(310, 355, 130, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
         back = new JButton("Back");
        back.setBounds(310, 390, 130, 30);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(700,700);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
    
}
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== withdraw){
            String money =amount.getText();
            Date date  = new Date();
            if(money.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            }
            else{
                try{
                Conn conn=new Conn();
                String query ="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+money+"' )";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+money+" Withdraw Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                        }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        else if(ae.getSource()== back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            
        }
        
    }
    public static void main (String args[]){
        new Withdrawl("");
        
    }
    
}

