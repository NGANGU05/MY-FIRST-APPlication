package harvey1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;


public class TASKANDREPORT {
    // i give made it static so that i can use it everywhere
    public static Scanner scanner = new Scanner(System.in);
    public  static List<String> ledeveloper = new ArrayList<String>();
    public static List<String> TASKNOM = new ArrayList<String>();
    public static List<String> taskIDList = new ArrayList<String>();
    public static List<String> LADUREE = new ArrayList<String>();
    public static List<String> LESTATUS = new ArrayList<String>();
     
    public static int totalHours;

    

    static String Last3;
    static String DevDetail;
    static String TaskNam;
    static String[] poper;
   static String TaskD;
   static String Tn;
    static String Duration;
    static String statusMessage = "";

        static int TaskNum;

    public TASKANDREPORT() {
// this array i have created to show how i started  
        String[] Options = {" PLEASE ADD YOUR INFORMATION"};

        int val = JOptionPane.showOptionDialog(null,
                "",
                "",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE, null,
                Options,
                0);
       

        TaskNum();
    
    
    // at this stage  the user will need to input tasks .
  }
    
    // at this stage  the user will need to input tasks .

    public static boolean TaskNum() {
        String Number = JOptionPane.showInputDialog("Please add number of your people  who want to sign in ");
        int x = Integer.parseInt(Number);
        // here i have created same condition   that will  help  to loop the name of the task you will input 
        for (int i = 0; i < x; i++) {

            TaskMaker();

        }
        // i called my part3 here 
        part3();
        return true;

    }
    // here the user will need to input his information 

    public static boolean TaskMaker() {
        TaskNam = JOptionPane.showInputDialog(" please Enter the name of your job and departement ");

        //This alllows us to input a task description with a character limit of 50 characters
        String TaskD = JOptionPane.showInputDialog("enter the symbole of your departement");
        Pattern P = Pattern.compile("((?=.*[a-z]).{0,50})");
        Matcher M = P.matcher(TaskD);
        boolean exitLoop = false;
        while (exitLoop == false) {

            P = Pattern.compile("((?=.*[a-z]).{0,50})");
            M = P.matcher(TaskD);
            if (M.matches()) {
                JOptionPane.showMessageDialog(null, " your symbol is successfully caputured");
                exitLoop = true;
            } else {
                JOptionPane.showMessageDialog(null, "Please your symbole  description must be  of less than 50 characters");
                JOptionPane.showInputDialog(" enter your symbol again");
                return exitLoop = true;

            }


            }
        

        DevDetail = JOptionPane.showInputDialog(" please enter the name and your surname ");
        Duration = JOptionPane.showInputDialog("please enter your shift hours");

        String Tn = TaskNam.substring(0, 2);
        String Last3 = DevDetail.substring(DevDetail.length() - 3);
       
     

        JOptionPane.showMessageDialog(null, "Task ID is " + (Tn + ":" + TaskNum + ":" + Last3).toUpperCase());

        String[] Status = {"male", "female", "other"};


    
  int status = JOptionPane.showOptionDialog(null,
                "Please select your gender",
                "Gender",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                Status,
                0);

        if (status == 0) {
            statusMessage = "male ";
        } else if (status == 1) {
            statusMessage = "female";
        } else if (status == 2) {
            statusMessage = "other";
        }
        TaskNum = TaskNum + 1;
        JOptionPane.showMessageDialog(null,
                "your gender : " + statusMessage + "\n"
                + "your name and your surname is : " + DevDetail + "\n"
             
                + "the name of your job and departement is : " + TaskNam + "\n"
                + "the symbole of your departement: " + TaskD + "\n"
                + "YOUR ID is " + ((Tn + ":" + TaskNum + ":" + Last3).toUpperCase()) + "\n"
                + "your shift hour is : " + Duration + " h");

      
        ArrayList<String> domir = new ArrayList();
        domir.add("Developer   " + DevDetail);
        domir.add("Task Name " + TaskNam);
        domir.add("Task ID   " + ((Tn +  TaskNum  + Last3).toUpperCase()));
        domir.add("Task Duration  " + Duration+"hours");
        domir.add("Task Status  " + statusMessage);
        poper = domir.toArray(new String[1]);
        
        System.out.println(" the report is   " + Arrays.toString(poper));
     
                
              
            ledeveloper.add(DevDetail);
            TASKNOM.add(TaskNam);
            taskIDList.add(Tn+TaskNum+Last3);
            LADUREE.add(Duration);
            LESTATUS.add(statusMessage);
             

         
        return true;

    }
// my part3
    public static void part3() {
     // this  stage  i created  an array that will show  everthing that the report will show 
        int listOp = JOptionPane.showOptionDialog(null, " WELCOME TO THE REPORT OF EVERTHING YOU HAVE DONE ,DO YOU WANT TO SEE THE TASK LIST?,PRESS OK TO SEE  ",
                 "List OPTION",
                JOptionPane.PLAIN_MESSAGE,

                
                 JOptionPane.PLAIN_MESSAGE,
                null, null, 0);
        
        // this is my array that i used to show options  for reports
        
        String[] options = {"CHECK MALE INFORMATION",
            
            "Search  THE JOB",
            "Search develper",
            "delete your information",
            "display report",
            "cancel"};
       
        
        
        int start = JOptionPane.showOptionDialog(null,
                 "select Option", "List app",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                0);

    if (start == 0) {
            // i am trying  to Display the Developer, Task Names and Task Duration for all tasks with the status of done .

            statusMessage = "other ";

            JOptionPane.showMessageDialog(null,
                    "gender is: " + statusMessage + "\n"
                    + "your name and your surname is : " + DevDetail + "\n"
                    + "Task Name: " + TaskNam + "\n"
                    + "Task Duration: " + Duration + " hours");

        }
        // Search for a task with a Task Name and display the Task Name, Developer and Task Status


        if (start == 1) {
             String Task1 = JOptionPane.showInputDialog("please enter your job name ;");
            if (Arrays.asList(TaskNam).contains(Task1)) {
                JOptionPane.showMessageDialog(null,
                        "Task Status: " + statusMessage + "\n"
                        + "Developer Details: " + DevDetail + "\n"
                        + "Task Name: " + TaskNam + "\n"
                ) ;
            }else{
                JOptionPane.showMessageDialog(null, "sorry we did not found your job in our system");

            }


        }
        if (start == 2) {
            //Search for all tasks assigned to a developer and display the Task Name and Task
            
            String dev = JOptionPane.showInputDialog("please enter your name and your surname ");
            if (Arrays.asList(DevDetail).contains(dev)) {
                JOptionPane.showMessageDialog(null,
                        "GENDER: " + statusMessage + "\n"
                        + " Name OF THE JOB IS: " + TaskNam + "\n"
                );

            } else {

                JOptionPane.showMessageDialog(null,
                        "sorry we didnt found your information in our system");
            }
        }
        // here i am trying to removed task ,Delete a task using the Task Name.
        if (start == 3) {

            String Taskd = JOptionPane.showInputDialog("please enter the name of your job");
            if (Arrays.asList(TaskNam).contains(Taskd)) {
                TaskNam = null;
                JOptionPane.showMessageDialog(null,
                        "your information has been removed "
                );
    } else {
                JOptionPane.showMessageDialog(null,
                        "sorry we didnt found  the name in our system, please restart again");

            }

        }
        if (start == 4) {
    //Display a report that lists the full details of all captured tasks.
        ArrayList<String> domirList = new ArrayList<String>();
        domirList.add("Developer   " + DevDetail);
        domirList.add("Task Name " + TaskNam);
        domirList.add("Task ID   " + ((Tn +  TaskNum  + Last3).toUpperCase()));
        domirList.add("Task Duration  " + Duration+"hours");
        domirList.add("Task Status  " + statusMessage);
          String TASKCAPTURED= " YOUR REPORT:\n";
        for (int i = 0; i < taskIDList.size(); i++) {
            TASKCAPTURED += "- THE ID IS: " + taskIDList.get(i) + "THE NAME OF THE JOB IS : " + TASKNOM.get(i) + "THE NAME AND SURNAME ARE  : "
                    + ledeveloper.get(i) + ", THE SHIFT HOUR IS : : " + LADUREE.get(i) +"h"+ ", Gender: " + LESTATUS.get(i) + "\n";
        }
        JOptionPane.showMessageDialog(null, TASKCAPTURED);
   }
    
            
      
    
     
        
        
        // this JOptionPane showing that , it  is the cancel side of the program , it will end the program automatically .
        if (start == 5) {
            JOptionPane.showMessageDialog(null, "I wish you a nice day");

        }

    }

    class Task {

        TASKANDREPORT app = new TASKANDREPORT();

        public boolean myboolean(boolean myboo) {

            String taskdes = app.DevDetail;
            if (taskdes.length() <= 50) {
                myboo = true;
            } else {
                myboo = false;
            }
            return myboo;
        }

        public String mystring(String mystring) {
            String taskid = app.TaskD;

            return taskid;
        }

        public String duration(String time) {
            String num = app.Duration;
            time = num;

            return time;

        }

        public String mystring2(String display) {
            display = app.DevDetail;
            return display;
        }

    }
// my unit test that i tried to start , and there is other class i created , you can just check the file .
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


    
}
