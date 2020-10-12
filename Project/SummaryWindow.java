package project;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author peyash
 */
public class SummaryWindow {
    JFrame frame;
    JTable table;
    
    MessManagement manager = new MessManagement();
    public SummaryWindow() throws FileNotFoundException, IOException{
        int size = manager.getMembers().length;
        String[][] rows = new String[size][4];
        String[] columns = {"Name", "Meals", "Shopping", "Status"};
        
        manager.generateSummary();
        File f = new File("summary.txt");
        
        Scanner scan = new Scanner(f);
        
        int i , j ;
        i = j = 0;
        while(scan.hasNext()){
            rows[i][0] = scan.next();
            rows[i][1] = scan.next();
            rows[i][2] = scan.next();
            rows[i][3] = scan.nextLine();
            i++;
        }
        
        scan.close();
        
        frame = new JFrame();

        table = new JTable(rows, columns);
        table.setRowHeight(50);
                    
        JScrollPane sp=new JScrollPane(table); 
        
        frame.add(sp);
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(1000,300);
        frame.setTitle("End-Of-The-Month Summary");
        
    }
    
    
   
}
