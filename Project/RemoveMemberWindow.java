package project;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author peyash
 */
public class RemoveMemberWindow implements ActionListener{
    JFrame frame;
    JLabel removeMemberL;
    JComboBox member;
    JButton remove;
    JButton cancel;
    
    MessManagement manager = new MessManagement();
    
    public RemoveMemberWindow(){
        frame = new JFrame();
        
        removeMemberL = new JLabel("Remove Member");
        member = new JComboBox(manager.getMembers());
        
        remove = new JButton("remove");
        remove.addActionListener(this);
        
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        
        //layout
        GridLayout layout = new GridLayout(3, 2);
        frame.setLayout(layout);

        frame.add(removeMemberL);
        frame.add(member);
        frame.add(remove);
        frame.add(cancel);
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setTitle("Remove Member");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == remove){
            String name = (String)member.getSelectedItem();
            if(manager.removeMember(name)){
                JOptionPane.showMessageDialog(frame, "Member removed successfully!");
                frame.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(frame, "Couldn't remove member "+name,"Inane error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if(e.getSource() == cancel){
            frame.setVisible(false);
        }
    }
    

    
}
