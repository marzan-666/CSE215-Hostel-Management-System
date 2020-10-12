package project;


import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
public class MainWindow implements ActionListener{
    JFrame frame;
    
    JLabel totalMembersL;
    JTextField totalMembers;
    
    JLabel totalMealL;
    JTextField totalMeal;
    
    JLabel mealRateL;
    JTextField mealRate;
    
    JLabel totalShoppingL;
    JTextField totalShopping;
    
    JTable table;
    JScrollPane scrollPane;
    
    JButton addMeal;
    JButton addShopping;
    JButton addMember;
    JButton removeMember;
    JButton summary;
    JButton exit;
    
    MessManagement manager = new MessManagement();    
    
    public MainWindow(){
        frame = new JFrame();
        
        totalMembersL = new JLabel("Total Members");
        totalMembers = new JTextField(manager.getMembers().length + "");
        
        totalMealL = new JLabel("Total Meals");
        totalMeal = new JTextField(manager.getTotalMeals()+"");
        
        mealRateL = new JLabel("Meal Rate");
        mealRate = new JTextField(manager.getMealRate() + "");
        
        totalShoppingL = new JLabel("Total Shopping");
        totalShopping = new JTextField(manager.getTotalShopping()+"");

        addMeal = new JButton("Add Meal");
        addMeal.addActionListener(this);
        
        addShopping = new JButton("Add Shopping");
        addShopping.addActionListener(this);
        
        addMember = new JButton("Add Member");
        addMember.addActionListener(this);
        
        removeMember = new JButton("Remove Member");
        removeMember.addActionListener(this);
        
        summary = new JButton("Summary");
        summary.addActionListener(this);
        
        exit = new JButton("Exit");
        exit.addActionListener(this);
        
        //setting layout
        GridLayout layout = new GridLayout(7, 2);
        frame.setLayout(layout);
        
        //adding elements to the layout
        frame.add(totalMembersL);
        frame.add(totalMembers);
        frame.add(totalMealL);
        frame.add(totalMeal);
        frame.add(mealRateL);
        frame.add(mealRate);
        frame.add(totalShoppingL);
        frame.add(totalShopping);
        //frame.add(table);
        frame.add(addMeal);
        frame.add(addShopping);
        frame.add(addMember);
        frame.add(removeMember);
        frame.add(summary);
        frame.add(exit);
        
        //displaying the layout
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setTitle("Mess Management System");
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addMeal){
            new AddMealWindow();
        }      
        else if(e.getSource() == addShopping){
            new AddShoppingWindow();
        }
        else if(e.getSource() == addMember){
            new AddMemberWindow();
        }
        else if(e.getSource() == removeMember){
            new RemoveMemberWindow();
        }
        else if(e.getSource() == summary){
            try {
                new SummaryWindow();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error! Couldn't read the database", "Inane error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(e.getSource() == exit){
            System.exit(0);
        }
        
        
    }
    
     
   
}
