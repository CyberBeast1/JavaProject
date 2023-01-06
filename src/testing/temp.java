/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testing;
/**
 *
 * @author amritpal
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class temp extends JFrame {
    public static void main(String args[]) throws Exception {
	new temp();
    }
    private JButton button;
    public temp() {
    setTitle("JButtonTest");
    button = new JButton("Click or press ALT-C");
    button.setMnemonic('C');
    add(button, BorderLayout.CENTER);
    button.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent evt) {
	  JOptionPane.showMessageDialog(null, ("Button clicked or pressed"));
       }
    });
    setSize(475, 250);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
    }   
}
    
//public class temp {
//    public static void main(String[] args){
//        UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
//        for (UIManager.LookAndFeelInfo look : looks) {
//            System.out.println(look.getClassName());
//        }
//    }
//}
