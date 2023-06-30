/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PoePart2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Shinsa
 */
public class Part2 {
    
    static int numberOfTasks;
    static String[] Array;
    static String[] Developer;
    static String[] TaskNames;
    static String[] TaskID;
    static double[] TaskDuration;
    static String[] TaskStatus;
    
    Part2(){
        String numTasksInput = JOptionPane.showInputDialog(null, "How Many Tasks would you like to add?");
        numberOfTasks = Integer.parseInt(numTasksInput);
        Array = new String[numberOfTasks];
        Developer = new String[numberOfTasks];
        TaskNames = new String[numberOfTasks];
        TaskID = new String[numberOfTasks];
        TaskDuration = new double[numberOfTasks];
        TaskStatus = new String[numberOfTasks];
        
        for(int i = 0; i < numberOfTasks; i++){
            TaskNames[i] = JOptionPane.showInputDialog("Enter the Task Name.");
            
            Developer[i] = JOptionPane.showInputDialog("Enter the developer name.");
            String timeInput = JOptionPane.showInputDialog("Enter The duration of the task.");
            String  TaskID = JOptionPane.showInputDialog(" enter  your task description");
             Pattern P = Pattern.compile("((?=.*[a-z]).{0,50})");
             Matcher M=P.matcher(TaskID);
             boolean exitLoop = false;
             while(exitLoop == false){
             
             P = Pattern.compile("((?=.*[a-z]).{0,50})");
             M = P.matcher(TaskID);
             if(M.matches()){
                 JOptionPane.showMessageDialog(null, "your task is saved");
                 exitLoop = true;
                 
                 
             }else {
             System.out.println("THE TASK MUST be less that 50");
             
             
             }
             
             
             }
            TaskDuration[i] = Double.parseDouble(timeInput);
            String[] statusOptions = {"To DO", "Done", "Doing"};
            int statusInput = JOptionPane.showOptionDialog(null, "Select the status of the task", "Task Status", 0, 1, null, statusOptions, null);
            switch(statusInput){
                case 0:
                    TaskStatus[i] = "To Do";
                break;
                case 1:
                    TaskStatus[i] = "Done";
                break;
                case 2:
                    TaskStatus[i] = "Doing";
                break;
                
                
            }
        }
        
    }
}
