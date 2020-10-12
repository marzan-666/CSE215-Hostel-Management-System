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
import javax.swing.JTextField;

/**
 *
 * @author peyash
 */
public class AddMealWindow implements ActionListener{
    
    //declaring all the components
    JFrame frame;
    
    JLabel selectMemberL;
    JComboBox member;
    
    JLabel breakFastL;
    JTextField breakFast;
    
    JLabel lunchL;
    JTextField lunch;
    
    JLabel dinnerL;
    JTextField dinner;
    
    JButton add;
    JButton cancel;
    
    MessManagement manager = new MessManagement();
    
    
    public AddMealWindow(){
        //intializing all the components
        frame = new JFrame();
        
        
        selectMemberL = new JLabel("Select Member");
//        String[] choices = {"Peyash", "Nazmul", "Promit"};
        member = new JComboBox(manager.getMembers());
        
        breakFastL = new JLabel("Breakfast");        
        breakFast = new JTextField("1");       
        
        lunchL = new JLabel("Lunch");
        lunch = new JTextField("1");
        
        dinnerL = new JLabel("Dinner");
        dinner = new JTextField("1");
        
        
        add = new JButton("Add");
        add.addActionListener(this);
        
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        
        //intializing layout
        GridLayout layout = new GridLayout(5, 2);
        frame.setLayout(layout);
        
        //add components into the frame
        frame.add(selectMemberL);
        frame.add(member);
        frame.add(breakFastL);
        frame.add(breakFast);
        frame.add(lunchL);
        frame.add(lunch);
        frame.add(dinnerL);
        frame.add(dinner);
        frame.add(add);
        frame.add(cancel);
        
        
        // Displaying the layout
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setTitle("ADD MEAL");
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == add){
            int totalMeal = Integer.parseInt(breakFast.getText()) + Integer.parseInt(lunch.getText()) + Integer.parseInt(dinner.getText());
            String name = (String) member.getSelectedItem();
            manager.addMeal(name, totalMeal);
            
            JOptionPane.showMessageDialog(frame, "Meal Added");
            frame.setVisible(false);
        }
        
        if(ae.getSource() == cancel){
            frame.setVisible(false);
        }
        
        
    }
        
}
