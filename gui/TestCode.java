
package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import javax.swing.*;

public class TestCode implements ActionListener {
    private JFrame frame;
    private JLabel idL;
    private JLabel nameL;
    private JLabel deptL;
    private JTextField id;
    private JTextField name;
    private JComboBox dept;
    private JButton submit;
    private JButton cancel;

    public TestCode(){
        frame = new JFrame();
        idL = new JLabel("ID");
        nameL = new JLabel("NAME");
        deptL = new JLabel("DEPARTMEENT");
        
        id = new JTextField();
        name =  new JTextField();
        
        String [] options = {"ECE","ENG","ECO","BBA"};
        dept = new JComboBox(options);
        
        submit = new JButton("SUBMIT");
        submit.addActionListener(this);
        cancel =  new JButton("CANCEL");
        cancel.addActionListener(this);
        
        GridLayout g = new GridLayout(4, 2);
        frame.setLayout(g);
        
        frame.add(idL);
        frame.add(id);
        frame.add(nameL);
        frame.add(name);
        frame.add(deptL);
        frame.add(dept);
        frame.add(submit);
        frame.add(cancel);
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);
        frame.setTitle("Information Window"); 
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==submit){
            String i = id.getText();
            String n = name.getText();
            String d = dept.getSelectedItem().toString();
            
            System.out.println(i+n+d);
            
        }
        else if(e.getSource()==cancel){
            id.setText("");
            name.setText("");
            dept.setSelectedIndex(0);
        }
    }
    
    
    
    
}
