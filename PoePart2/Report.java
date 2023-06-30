package PoePart2;

import static PoePart2.Part2.TaskDuration;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Report {
    String doneTasks = "";
    String allTasks = "";
    String taskSearchResults = "";
    String devSearchResults = "";

    public Report() {
        processData();
        
        String[] options = {
            "Show all done", "Longest Duration", "Find Task", "Find Developer's Tasks", "Delete", "Display Report"
        };
        
        int buttonPressed = JOptionPane.showOptionDialog(null, "Select an Action", "Part 3", 0, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        
        if(buttonPressed == 0){
            showAllDone();
        }else if(buttonPressed == 1){
            longestDuration();
        }else if(buttonPressed == 2){
            searchWithTaskName();
        }else if(buttonPressed == 3){
            searchDeveloperTasks();
        }else if(buttonPressed == 4){
            delete();
        }else if(buttonPressed == 5){
            displayReport();
        }
        
    }
    
    public void processData(){
        for (int i = 0; i < Part2.numberOfTasks; i++){
            if(Part2.TaskStatus[i].equals("Done")){
                doneTasks +=  "\n Developer: " + Part2.Developer[i].toString() +"  Task Name: " + Part2.TaskNames.toString() + "   TaskDuration: " + Part2.TaskDuration.toString();
            }
        }
    }
    
    public void showAllDone(){
        // Display all tasks with the status of done
        JOptionPane.showMessageDialog( null, doneTasks);
    }
    
    public void longestDuration(){
        int longestIndex = 0;
        
        for(int i = 0; i < Part2.numberOfTasks; i++){
            if(Part2.TaskDuration[i] > Part2.TaskDuration[longestIndex]){
                longestIndex = i;
            }
        }
        String message = Part2.Developer[longestIndex] + " is the developer with the longest duration";
        JOptionPane.showMessageDialog(null, message);
    }
    
    public void searchWithTaskName(){
        String nameInput = JOptionPane.showInputDialog("Enter the name of the task:");
        for (int i = 0; i < Part2.numberOfTasks; i++){
            if (nameInput.equals(Part2.TaskNames[i].toString())){
                taskSearchResults += "Task Name: " + Part2.TaskNames[i] + "   Developer Names: " + Part2.Developer[i] + "   Task Status: " + Part2.TaskStatus[i] + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, taskSearchResults);
    }
    
    public void searchDeveloperTasks(){
        String nameInput = JOptionPane.showInputDialog("Enter the name of the Developer:");
        for (int i = 0; i < Part2.numberOfTasks; i++){
            if (nameInput.equals(Part2.Developer[i].toString())){
                devSearchResults += "Task Name: " + Part2.TaskNames[i] + "   Task Status: " + Part2.TaskStatus[i] + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, devSearchResults);
    }
    
    public void delete(){
        String nameInput = JOptionPane.showInputDialog("Enter the name of the task you want to delete:");
        for (int i = 0; i < Part2.numberOfTasks; i++){
            if (nameInput.equals(Part2.TaskNames[i].toString())){
                Part2.Array[i] = "";
                Part2.Developer[i] = "";
                Part2.TaskDuration[i] = 0;
                Part2.TaskNames[i] = "";
                Part2.TaskStatus[i] = "";
            }
        }
    }
    
    public void displayReport(){
        for (int i = 0; i < Part2.numberOfTasks; i++){
            allTasks += "-->TaskName: " + Part2.TaskNames[i] + "   -->Task Description: " + Part2.Array[i] + "   -->Developer Name: " + Part2.Developer[i] + "   -->Task Duration: " + Part2.TaskDuration[i] + "   -->Task Status: " + Part2.TaskStatus[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, allTasks);
    }
}


    
 class myclass {

        public String TestDataTask1(String my) {

            String TaskName = "Login Feature";
            String TaskNumber = "Auto generated";
            String TaskDescription = "Create Login to authenticate users";

            String DeveloperDetails = "Mike Smith";

            int TaskDuration = 8;
            String TaskID = "Auto generated";
            String TaskStatus = " to do";

            return my;
        }

        public String TestDataTask2(String Develop) {
            String TaskName = "Add Task Feature";
            String TaskNumber = "Auto generated";

            String TaskDescription = "Add Task feature to add task users";
            String DeveloperDetails = "Edward Harrison";

            int TaskDuration
                    = 10;
            String TaskID
                    = "Auto generated";
            String TaskStatus = "Doing";

            return Develop;
        }

        public String TestDataTask3(String Develop) {
            String Developer = "Samantha Paulson";
            String TaskName = "Create Reports";

            int TaskDuration = 2;

            String TaskStatus = "Done";

            return Develop;
        }

        public String TestDataTask4(String Develop) {

            String Developer = "Glenda Oberholzer";

            String TaskName = "Add Arrays";

            int TaskDuration = 11;

            String TaskStatus = "To Do";

            return Develop;
        }

        public String Developerarray(String Develop) {

            String s = " Mike Smith";

            return Develop;
        }

        public String Searchfortasks(String Develop) {
            String s = "Glenda Oberholzer , 11";

            return Develop;
        }

        public String SearchalltasksassignedDeveloper(String Develop) {

            String z = " Mike Smith ";
            String Entry = "Create reports";

            return Develop;
        }

        public String DeleteTaskfromarray(String Develop) {

            String re = "successfully deleted";
            Develop = re;
            return Develop;
        }

        public String DisplayReport(String Develop) {

            return Develop;
        }
        
 }



   
