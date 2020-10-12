package project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author peyash
 */
public class AddShoppingWindow implements ActionListener{
    // Declaring all the components
    JFrame frame;
    JLabel selectMemberL;
    JComboBox member;
    JLabel shoppingL;
    JTextField shopping;
    JButton add;
    JButton cancel;
    
    MessManagement manager = new MessManagement();
    
    public AddShoppingWindow(){
        // initializing the component
        frame = new JFrame();
        
        selectMemberL = new JLabel("Select Member");
        
        member = new JComboBox(manager.getMembers());
        
        shoppingL = new JLabel("Shopping Amount");
        shopping = new JTextField();
        
        add = new JButton("Add");
        cancel = new JButton("Cancel");
        
        
        // initializing the layout
        GridLayout layout = new GridLayout(3, 2);
        frame.setLayout(layout);
        
        // adding components to the layout
        frame.add(selectMemberL);
        frame.add(member);
        
        frame.add(shoppingL);
        frame.add(shopping);
        
        frame.add(add);
        add.addActionListener(this);
        frame.add(cancel);
        cancel.addActionListener(this);
        
        // displaying the layout
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setTitle("Add Shopping");
        
        
        
    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){
            String name = (String)member.getSelectedItem();
            double shoppingAmount = Double.parseDouble(shopping.getText());
            manager.addShopping(name, shoppingAmount);
            JOptionPane.showMessageDialog(frame, "Shopping Added!");
            frame.setVisible(false);
        }
        
        if(e.getSource() == cancel){
            frame.setVisible(false);
        }
        
    }
    
 
    
    
}
