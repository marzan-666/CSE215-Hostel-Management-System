package project;


import java.io.*;
import java.util.*;


public class MessManagement {
    
    private ArrayList<Member> list = new ArrayList<Member>();
    
    public MessManagement(){
        
        File f = new File("database.txt");
        
        try{
            Scanner scan = new Scanner(f);
            
            while(scan.hasNext()){
                String name = scan.next();
                int meals = Integer.parseInt(scan.next());
                double shopping = Double.parseDouble(scan.next());
                
                list.add(new Member(name, meals, shopping));
            }
            
            scan.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
    }
    

    
    public Member search(String name){
        for(Member temp: list){
            if(temp.getName().equalsIgnoreCase(name)){
                return temp;
            }
        }
        
        return null;
    }
    
    
    
    
    //***************************
    public void addMeal(String name, int meal){
        Member member = search(name);
        int index = list.indexOf(search(name));
        meal += list.get(index).getMeals();
        list.set(index, new Member(member.getName(), meal , member.getShopping())); 
        
        save();
    }
    
    public void addShopping(String name, double shopping){
        Member member = search(name);
        int index = list.indexOf(search(name));
        shopping += list.get(index).getShopping();
        
        list.set(list.indexOf(search(name)), new Member(member.getName(), member.getMeals(), shopping));
        
        save();
    }
    
    public void addMember(String name){
        if(search(name) == null){
            list.add(new Member(name, 0, 0));
            save();
        } else {
            System.out.println("Member already exists!");
        }
        
    }
    //*************************
    
    
    
    
    
    //*************************
    public int getTotalMeals(){
        int total = 0;
        
        for(Member temp: list){
            total += temp.getMeals();
        }
        
        return total;
    }
    
    public double getMealRate(){
        return ((double)getTotalShopping()) / getTotalMeals();
    }
    
    
    public double getTotalShopping(){
        double total = 0;
        
        for(Member temp: list){
            total += temp.getShopping();
        }
        
        return total;
    }
    
    //returns the members as an array
    public String[] getMembers(){
        String[] members;
        members = new String[list.size()];
        
        for(int i=0; i<list.size(); i++){
            members[i] = list.get(i).getName();
        }
        
        return members;
    }
    
    public String getMembers(int index){
        return list.get(index).getName();
    }
    
    //checks if a given member exists
    public boolean isMember(String name){
        for(Member temp: list){
            if(temp.getName().equalsIgnoreCase(name)){
                return true;
            } 
        }
        
        return false;
    }
    
    
    //deletes member
    public boolean removeMember(String name){
        Member member = search(name);
        boolean bool =  list.remove(member);
        save();
        return bool;
    }
    
    
    public void save(){
        File f = new File("database.txt");
        try{
            FileWriter writer = new FileWriter(f);
            
            for(Member temp: list){
                writer.write(temp + "\n");
            }
            
            writer.close();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
    
    
    public void generateSummary() throws IOException{
        File f = new File("summary.txt");
        FileWriter writer = new FileWriter(f);
        
        for(int i=0; i<list.size(); i++){
            float consumed = (float) (getMealRate() * list.get(i).getMeals());
            float shopping = (float) list.get(i).getShopping();
            float finalAmount = shopping - consumed;
            String status = null;
            if(finalAmount < 0){
                finalAmount = finalAmount * (-1);
                status = "Owes "+finalAmount+" TK";
            }
            else if(finalAmount > 0){
                status = "Gets back "+finalAmount+" TK";
            }
            else{
                status = "";
            }
            
            writer.write(list.get(i).toString()+" "+status+"\n");
        }
        
        
        writer.close();
    }
    

        
}
