package project;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author peyash
 */
public class AddMemberWindow implements ActionListener{
    JFrame frame;
    JLabel nameL;
    JTextField name;
    JButton add;
    JButton cancel;
    
    MessManagement manager = new MessManagement();
    
    public AddMemberWindow(){
        
        frame = new JFrame(); 
        
        nameL = new JLabel("Name");
        name = new JTextField();
        
        add = new JButton("Add");
        add.addActionListener(this);
        
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        
        GridLayout layout = new GridLayout(3, 2);
        frame.setLayout(layout);
        
        frame.add(nameL);
        frame.add(name);
        frame.add(add);
        frame.add(cancel);
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(400,200);
        frame.setTitle("Add Member");        
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){
            String member = name.getText();
            
            if(manager.isMember(member)){
                JOptionPane.showMessageDialog(frame, member+ " Already Exists!","Inane error", JOptionPane.ERROR_MESSAGE);
            } else {
                manager.addMember(member);
                JOptionPane.showMessageDialog(frame, "Member Added!");
                frame.setVisible(false);
            }
        }
        
        if(e.getSource() == cancel){
            frame.setVisible(false);
        }
    }

}
