package atm.simulator;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;



public class FastCash extends JFrame implements ActionListener {

    JButton a100, a500, a1000, a2000, a5000, a10000, back;
    String pinnumber;

    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/ATM.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 700, 700);
        add(image);

        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setBounds(200, 170, 500, 35);
        text.setForeground(Color.black);
        image.add(text);

        a100 = new JButton("Rs 100");
        a100.setBounds(130, 290, 130, 30);
        a100.addActionListener(this);
        image.add(a100);

        a500 = new JButton("Rs 500");
        a500.setBounds(310, 290, 130, 30);
        a500.addActionListener(this);
        image.add(a500);

        a1000 = new JButton("Rs 1000");
        a1000.setBounds(130, 325, 130, 30);
        a1000.addActionListener(this);
        image.add(a1000);

        a2000 = new JButton("Rs 2000");
        a2000.setBounds(310, 325, 130, 30);
        a2000.addActionListener(this);
        image.add(a2000);

        a5000 = new JButton("Rs 5000");
        a5000.setBounds(130, 360, 130, 30);
        a5000.addActionListener(this);
        image.add(a5000);

        a10000 = new JButton("Rs 10000");
        a10000.setBounds(310, 360, 130, 30);
        a10000.addActionListener(this);
        image.add(a10000);

        back = new JButton("Back");
        back.setBounds(310, 395, 130, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(700, 700);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(3);//Rs 500
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));

                    }
                }
                if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;

                }
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);

            }
        }

    }





    public static void main(String args[]) {
        new FastCash("");

    }

}
