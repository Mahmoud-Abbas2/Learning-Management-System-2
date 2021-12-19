/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning.management.system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTextArea;

/**
 *
 * @author Abbas
 */
public class Admin extends User{
    public void addUsers(int userType, String name, String password, int ID) throws IOException{
        if(userType == 2){
            String userData = String.valueOf(ID)+","+name+","+password;
            FileWriter fw = new FileWriter("Users/lecturers.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(userData+"\n");
            bw.newLine();
            bw.close();
        }
        if(userType == 3){
            String userData = String.valueOf(ID)+","+name+","+password;
            BufferedWriter writer = new BufferedWriter(new FileWriter("Users/students.txt"));
            writer.write(userData);
            writer.close();
        }
    }
    public void deleteUser(int userType, int ID) throws IOException{
        String allData = "";
        
        if(userType == 2){
            try (BufferedReader br = new BufferedReader(new FileReader("Users/lecturers.txt"))) {
                String line;

                while ((line = br.readLine()) != null) {
                    String []receivedData = line.split(",");
                    if(receivedData[0].equals(String.valueOf(ID))){
                        //Do nothing
                    }
                    else{
                        allData = allData+"\n"+line;
                    }


                }
                
                
                FileWriter writer = new FileWriter("Users/lecturers.txt", false);
                writer.write(allData);
                writer.close();
                
            }
        }
        
        if(userType == 3){
            try (BufferedReader br = new BufferedReader(new FileReader("Users/students.txt"))) {
                String line;

                while ((line = br.readLine()) != null) {
                    String []receivedData = line.split(",");
                    if(receivedData[0].equals(String.valueOf(ID))){
                        //Do nothing
                    }
                    else{
                        allData = allData+"\n"+line;
                    }


                }
                
                FileWriter writer = new FileWriter("Users/students.txt", false);
                writer.write(allData);
                writer.close();
            }
        }
    }
    
    public void viewUsers(int userType, JTextArea t) throws FileNotFoundException, IOException{
        if(userType == 2){
            String allData ="";
            try (BufferedReader br = new BufferedReader(new FileReader("Users/lecturers.txt"))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                
                    allData = allData+"\n"+ line;
             
                }
            }
            t.setText(allData);
            
        }
        if(userType == 3){
            String allData ="";
            try (BufferedReader br = new BufferedReader(new FileReader("Users/students.txt"))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                
                    allData = allData+"\n"+ line;
             
                }
            }
            t.setText(allData);
        }
        
    }
}
