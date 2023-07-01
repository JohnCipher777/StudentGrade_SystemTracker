/* * *
 CODED BY   : 丂ʜᴀᴅᴏᴡ尺ᴇᴀᴘᴇ尺
 FROM       : 𝐂𝐓 𝐈𝐍𝐂𝐎𝐑𝐏𝐎𝐑𝐀𝐓𝐄𝐃
 PATCH DATE : 6/5/23
 * * */
import java.io.IOException;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static GradeSystemTracker tracker;
    private static int input_num = 0;  
    //FOR ANDROID USERS USING TERMINAL
    public static void clearScreenmobile(){
        System.out.print("\033c");
        System.out.flush();
    }
    
    //FOR DESKTOP USERS
    private static void clearScreen(){
        try{
            if(System.getProperty("os.name").contains("Windows")){
              new ProcessBuilder("cmd","/c", "cls").inheritIO().start().waitFor();
            }else{
                 new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        }catch(IOException | InterruptedException e){
        }
    }
    
    //THIS FUNCTION HERE WILL ANALYZE THE NUMEBR OF SPACES THE USER INPUTTED
    private static int countConsecutiveSpaces(String input) {
        int consecutiveSpaces = 0;
        int currentConsecutiveSpaces = 0;

        char[] chars = input.toCharArray();
        int length = chars.length;
        
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                currentConsecutiveSpaces++;
            } else {
                if (currentConsecutiveSpaces > 1) {
                    consecutiveSpaces += currentConsecutiveSpaces;
                }
                currentConsecutiveSpaces = 0;
            }
        }

        if (currentConsecutiveSpaces > 1) {
            consecutiveSpaces += currentConsecutiveSpaces;
        }

        return consecutiveSpaces;
    }
    private static void waitForEnterKey() {
        System.out.print("press enter key to continue...");
        scanner.nextLine();
        System.out.println();
    }
    private static void printMenu() {
        String Color = "\u001B[96m";//cyan
        String resetColor = "\u001B[0m";
        System.out.println( Color+"   _____ _____            _____  ______ __  __           _____ _______ ______ _____          "+resetColor);
       	System.out.println( Color+"  / ____|  __ \\     /\\   |  __ \\|  ____|  \\/  |   /\\    / ____|__   __|  ____|  __ \\     "+resetColor);
       	System.out.println( Color+" | |  __| |__) |   /  \\  | |  | | |__  | \\  / |  /  \\  | (___    | |  | |__  | |__) |       "+resetColor);
       	System.out.println( Color+" | | |_ |  _  /   / /\\ \\ | |  | |  __| | |\\/| | / /\\ \\  \\___ \\   | |  |  __| |  _  /    "+resetColor);
       	System.out.println( Color+" | |__| | | \\ \\  / ____ \\| |__| | |____| |  | |/ ____ \\ ____) |  | |  | |____| | \\ \\     "+resetColor);
       	System.out.println( Color+"  \\_____|_|  \\_\\/_/    \\_\\_____/|______|_|  |_/_/    \\_\\_____/   |_|  |______|_|  \\_\\ "+resetColor);
        Color = "\u001B[92m";//light green
        System.out.println(Color+"                                        v1.0(beta)           \n"+ resetColor);
        Color = "\u001B[31m";//red
        System.out.println(Color + "            ===============================================================" + resetColor );
        // ANSI escape code to reset text color to default  
        
        Color = "\u001B[36m";//cyan
        System.out.print(Color + "           |"+ resetColor);
        String background = "\u001B[47m";
         Color = "\u001B[92m";//light green
        System.out.print(background+ "---------------"+ resetColor+ "|"+Color+" STUDENT GRADE SYSTEM TRACKER "+resetColor+"|"+background+"----------------"+ resetColor);
        Color = "\u001B[36m";//cyan
        System.out.println(Color +"|"+resetColor);
         Color = "\u001B[31m";//red
        System.out.println(Color + "            ==============================================================="+ resetColor);
        Color = "\u001B[33m";//yellow
        System.out.print(Color + "                                    [1] "+resetColor );
        System.out.println("Add Student              ");
        Color = "\u001B[33m";//yellow
        System.out.print(Color + "                                    [2] "+ resetColor);
        System.out.println("View Grade Report        ");
        Color = "\u001B[33m";//yellow
        System.out.print(Color + "                                    [3] "+ resetColor);
        System.out.println("Delete Student           ");
         Color = "\u001B[33m";//yellow
        System.out.print(Color + "                                    [4] "+ resetColor);
        Color = "\u001B[31m";//red
        System.out.println(Color+"Exit                     "+resetColor);
         Color = "\u001B[31m";//red
        System.out.println(Color + "            _______________________________________________________________" + resetColor );
        System.out.println(Color + "            ===============================================================" + resetColor );
        Color = "\u001B[36m";//cyan
        System.out.print(Color + "            Enter your choice: "+ resetColor);
    }
    public static void main(String[] args) {
        String choice;

        do {
            String Color;
            String resetColor = "\u001B[0m";
            clearScreenmobile();
            clearScreen();
            printMenu();
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addStudent();
                    waitForEnterKey();
                    break;
                case "2":
                    viewGradeReport();
                    break;
                case "3":
                    deleteStudent();
                    break;
                case "4":
                    Color = "\u001B[31m";//red
                    System.out.println(Color+"                          ========================================"+resetColor);
                    Color = "\u001B[93m";//light yellow
                    System.out.println("                          ||    "+Color+"Thanks for using our system"+resetColor+"     ||");
                    System.out.println(Color+"                          ========================================"+resetColor);
                    System.out.print("                          press enter key to continue...");
                    scanner.nextLine();
                    break;
                default:
                     Color = "\u001B[31m";//red
                     System.out.println(Color+"            ________________________________________________________"+resetColor);
                    if(choice.length()==0){
                     Color = "\u001B[93m";
                     System.out.println(Color+"            [WARNING]"+resetColor+": Please enter something...");
                     System.out.print("            press enter key to continue...");
                     scanner.nextLine();
                    }else if(choice.contains(" ")){
                        Color = "\u001B[31m";//red
                        if(countConsecutiveSpaces(choice)>0){
                              System.out.println(Color+"            [ERROR]"+resetColor+": Spaces is not allowed in the input.");
                              System.out.print("            press enter key to continue...");
                              scanner.nextLine();
                        }else{
                              System.out.println(Color+"            [ERROR]"+resetColor+": Space is not allowed in the input.");
                              System.out.print("            press enter key to continue...");
                              scanner.nextLine();;
                        }
                    }else{
                        Color = "\u001B[31m";//red
                        System.out.println(Color+"            [ERROR]"+resetColor+": Invalid choice. Please try again.");
                        System.out.print("            press enter key to continue...");
                        scanner.nextLine();
                        }
                    break;
            }
        } while (!choice.equals("4"));
        scanner.close();
    }

    private static void addStudent() {
        String name;
        double[] grades;
        String[] subjects;
        input_num = 1;
        String Color = "\u001B[31m";//red
        String resetColor = "\u001B[0m";
        System.out.println(Color+"            ========================================"+resetColor);
        System.out.print("            NUMBER OF STUDENT/s: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("            NUMBER OF SUBJECT/s PER STUDENT: ");
        int numSubjects = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        tracker = new GradeSystemTracker(numStudents, numSubjects);
        
        clearScreenmobile();
        clearScreen();
        System.out.println(Color + "========================================"+ resetColor);
        Color = "\u001B[32m";//green
        String background = "\u001B[47m";
        System.out.println(background+"||   -----"+resetColor+"|"+Color + "STUDENT DATA ENTRY"+resetColor+"|"+background+"-----   ||"+ resetColor);
        Color = "\u001B[31m";//red
        System.out.println(Color + "========================================"+ resetColor);

        for (int x = 0; x < numStudents; x++) {
	    
            if(input_num>=2){
               System.out.println("----------------------------------------\n");
            }else{
               System.out.println("----------------------------------------");
            }
            System.out.print("NAME OF STUDENT["+(x+1)+"]: ");
            name = scanner.nextLine();
            grades = new double[tracker.getNumSubjects()];
            subjects = new String[tracker.getNumSubjects()];
        
            for (int i = 0; i < tracker.getNumSubjects(); i++) {
                System.out.println("____________________________________");
                System.out.println("          | "+Color +"SUBJECT"+resetColor+"["+ (i + 1) + "] |");
                System.out.print("Subject Name : ");
                String subjectName = scanner.nextLine();
                subjects[i] = subjectName;
                System.out.print("Subject Grade: ");
                grades[i] = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character
                input_num++;
            }
            tracker.addStudent(name, grades, subjects);
        }
            System.out.println("------------------------------------");
            System.out.println("Student added successfully!");
            System.out.println("----------------------------------------");
    }
    
    private static void viewGradeReport() {
        int i,j;
        boolean remainingData;
        boolean noremaining_data = false;
        input_num = 1;
        String Color = "\u001B[31m";//red
        String resetColor = "\u001B[0m";
        String background = "\u001B[47m";
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String decimalValue;
        //CONDITION WHEN NO DATA HAS BEEN ADDED
        if (tracker == null || tracker.getNumStudents() == 0) {
            Color = "\u001B[31m";//red
            System.out.println();
            System.out.println(Color+"                       ==========================================="+resetColor);
            Color = "\u001B[93m";//light yellow     
            System.out.println(Color+"                       [WARNING]"+resetColor+": No current data.");
             Color = "\u001B[32m";//green
            System.out.println(Color+"                       [CONDITION]"+resetColor+": Please add student/s first.");
            Color = "\u001B[31m";//red
            System.out.println(Color+"                       ==========================================="+resetColor);
            System.out.print("                          press enter key to continue...");
            scanner.nextLine();
        }else {
            clearScreenmobile();
            clearScreen();
            System.out.println(Color + "========================================"+ resetColor);
            Color = "\u001B[93m";//light yellow
            System.out.println(background+"||  -----"+resetColor+"|"+Color + "STUDENT DATA REPORT"+resetColor+"|"+background+"-----   ||"+ resetColor);
            Color = "\u001B[31m";//red
            System.out.println(Color + "========================================"+ resetColor);
        
            //CONDITION TO DETECT IF THE DELETION IS SUCCESSFULL & TO VIEW THE REMAINING DATA
            if (tracker.deletion_detected()) {
                remainingData = false;
                for (i = 0; i < tracker.getNumStudents(); i++) {
                    if (tracker.getStudentName(i) != null) {
                        remainingData = true;
                        Color = "\u001B[33m";//yellow
                        if(input_num>=2){
                            System.out.println(Color+"\nNAME: "+resetColor+tracker.getStudentName(i).toUpperCase());
                        }else{
                            System.out.println(Color+"NAME: "+resetColor+tracker.getStudentName(i).toUpperCase());
                        }
                        System.out.println("-----------------------------");
                        System.out.println("["+Color+"SUBJECTS"+resetColor+"]          ["+Color+"GRADES]"+resetColor);
                        double[] grades = tracker.getStudentGrades(i);
                        String[] subjects = tracker.getSubjectNames(i);

                        for (j = 0; j < grades.length; j++) {
                          System.out.print(subjects[j]);
                          //I MADE THIS CONDITION FOR EACH SPACE GAP between each subject names and grades
                          if(subjects[j].length()==1){
                            System.out.print("                     ");  
                          }else if(subjects[j].length()==2){
                            System.out.print("                    ");  
                          }else if(subjects[j].length()==3){
                             System.out.print("                   ");  
                          }else if(subjects[j].length()==4){
                             System.out.print("                  "); 
                             
                          }else if(subjects[j].length()==5){
                             System.out.print("                 ");
                          
                          }else if(subjects[j].length()==6){
                             System.out.print("                ");  
                          
                          }else if(subjects[j].length()==7){
                             System.out.print("               ");  
                          
                          }else if(subjects[j].length()==8){
                             System.out.print("              ");  
                          
                          }else if(subjects[j].length()==9){
                             System.out.print("             ");  
                          
                          }else if(subjects[j].length()==10){
                             System.out.print("            ");
                          
                          }else if(subjects[j].length()==11){
                             System.out.print("           ");  
                          
                          }else if(subjects[j].length()==12){
                             System.out.print("          ");
                          
                          }else if(subjects[j].length()==13){
                             System.out.print("         ");
                          
                          }else if(subjects[j].length()==14){
                             System.out.print("        ");
                          
                          }else if(subjects[j].length()==15){
                             System.out.print("       ");
                          
                          }else if(subjects[j].length()==16){
                             System.out.print("      ");
                          
                          }else if(subjects[j].length()==17){
                             System.out.print("     ");
                          
                          }else if(subjects[j].length()==18){
                             System.out.print("    ");
                          
                          }else if(subjects[j].length()==19){
                             System.out.print("   ");
                          
                          }else if(subjects[j].length()==20){
                             System.out.print("  ");
                          
                          }
                          System.out.print(grades[j]+"\n");
                        }
                        if(tracker.getAverageGrade(i)>=80){
                            Color = "\u001B[96m";//light cyan
                          }else{
                            Color = "\u001B[31m";//red
                          }
                        decimalValue = decimalFormat.format(tracker.getAverageGrade(i));
                        System.out.println("_____________________________");
                        System.out.println("    Average Grade: "+Color+decimalValue+resetColor);
                        System.out.println("-----------------------------");
                        input_num++; 
                        
                    }

                }
                //CONDITION WHEN NO DATA HAS BEEN REMAINING AFTER USER DELETED ALL THE STUDENT DATA
                if (!remainingData) {
                    Color = "\u001B[31m";//red
                    System.out.println(Color+"========================================"+resetColor);
                    Color = "\u001B[93m";//light yellow   
                    System.out.println(Color+"[WARNING]"+resetColor+": No current data remaining.");
                    Color = "\u001B[32m";//green
                    System.out.println(Color+"[CONDITION]"+resetColor+": Please add student/s again.");
                    Color = "\u001B[31m";//red
                    System.out.println(Color+"========================================"+resetColor);
                    noremaining_data = true;
                }
                waitForEnterKey();
                Color = "\u001B[31m";//red
                System.out.println(Color+"========================================"+resetColor);
            //THIS CONDITION HERE WILL ANALYZE IF THE USER INPUTTED THE WRONG STUDENT NAME FOR THE DATA OF THE STUDENT THAT THE USER WANTS TO DELETE
            //& WANTS TO VIEW THE REMAINING DATA
            }else if(!tracker.deletion_detected()){
                remainingData = false;
                for (i = 0; i < tracker.getNumStudents(); i++) {
                    if (tracker.getStudentName(i) != null) {
                        remainingData = true;
                        Color = "\u001B[33m";//yellow
                        if(input_num>=2){
                            System.out.println(Color+"\nNAME: "+resetColor+tracker.getStudentName(i).toUpperCase());
                        }else{
                            System.out.println(Color+"NAME: "+resetColor+tracker.getStudentName(i).toUpperCase());
                        }
                        System.out.println("-----------------------------");
                        System.out.println("["+Color+"SUBJECTS"+resetColor+"]          ["+Color+"GRADES]"+resetColor);
                        double[] grades = tracker.getStudentGrades(i);
                        String[] subjects = tracker.getSubjectNames(i);

                        for (j = 0; j < grades.length; j++) {
                          System.out.print(subjects[j]);
                           //I MADE THIS CONDITION FOR EACH SPACE GAP between each subject names and grades
                          if(subjects[j].length()==1){
                            System.out.print("                     ");  
                          }else if(subjects[j].length()==2){
                            System.out.print("                    ");  
                          }else if(subjects[j].length()==3){
                             System.out.print("                   ");  
                          }else if(subjects[j].length()==4){
                             System.out.print("                  "); 
                             
                          }else if(subjects[j].length()==5){
                             System.out.print("                 ");
                          
                          }else if(subjects[j].length()==6){
                             System.out.print("                ");  
                          
                          }else if(subjects[j].length()==7){
                             System.out.print("               ");  
                          
                          }else if(subjects[j].length()==8){
                             System.out.print("              ");  
                          
                          }else if(subjects[j].length()==9){
                             System.out.print("             ");  
                          
                          }else if(subjects[j].length()==10){
                             System.out.print("            ");
                          
                          }else if(subjects[j].length()==11){
                             System.out.print("           ");  
                          
                          }else if(subjects[j].length()==12){
                             System.out.print("          ");
                          
                          }else if(subjects[j].length()==13){
                             System.out.print("         ");
                          
                          }else if(subjects[j].length()==14){
                             System.out.print("        ");
                          
                          }else if(subjects[j].length()==15){
                             System.out.print("       ");
                          
                          }else if(subjects[j].length()==16){
                             System.out.print("      ");
                          
                          }else if(subjects[j].length()==17){
                             System.out.print("     ");
                          
                          }else if(subjects[j].length()==18){
                             System.out.print("    ");
                          
                          }else if(subjects[j].length()==19){
                             System.out.print("   ");
                          
                          }else if(subjects[j].length()==20){
                             System.out.print("  ");
                          
                          }
                          if(grades[j]>=80){
                            Color = "\u001B[96m";//light cyan
                          }else{
                            Color = "\u001B[31m";//red
                          }
                          System.out.print(Color+grades[j]+"\n"+resetColor);
                        }
                        if(tracker.getAverageGrade(i)>=80){
                            Color = "\u001B[96m";//light cyan
                          }else{
                            Color = "\u001B[31m";//red
                          }
                        decimalValue = decimalFormat.format(tracker.getAverageGrade(i));
                        System.out.println("_____________________________");
                        System.out.println("    Average Grade: "+Color+decimalValue+resetColor);
                        System.out.println("-----------------------------");
                        input_num++; 
                        
                   }
                   
                }
                //CONDITION WHEN NO DATA HAS BEEN REMAINING AFTER USER DELETED ALL THE STUDENT DATA
                if (!remainingData) {
                    Color = "\u001B[31m";//red
                    System.out.println(Color+"========================================"+resetColor);
                    Color = "\u001B[93m";//light yellow   
                    System.out.println(Color+"[WARNING]"+resetColor+": No current data remaining.");
                    Color = "\u001B[32m";//green
                    System.out.println(Color+"[CONDITION]"+resetColor+": Please add student/s again.");
                    Color = "\u001B[31m";//red
                    System.out.println(Color+"========================================"+resetColor);
                    noremaining_data = true;
                }
                waitForEnterKey();
                 Color = "\u001B[31m";//red
                System.out.println(Color+"========================================"+resetColor);
            }else {
                for (i = 0; i < tracker.getNumStudents(); i++) {
                    Color = "\u001B[33m";//yellow
                        if(input_num>=2){
                            System.out.println(Color+"\nNAME: "+resetColor+tracker.getStudentName(i).toUpperCase());
                        }else{
                            System.out.println(Color+"NAME: "+resetColor+tracker.getStudentName(i).toUpperCase());
                        }
                        System.out.println("-----------------------------");
                        System.out.println("["+Color+"SUBJECTS"+resetColor+"]          ["+Color+"GRADES]"+resetColor);
                        ;
                        double[] grades = tracker.getStudentGrades(i);
                        String[] subjects = tracker.getSubjectNames(i);

                        for (j = 0; j < grades.length; j++) {
                           System.out.print(subjects[j]);
                           //I MADE THIS CONDITION FOR EACH SPACE GAP between each subject names and grades
                          if(subjects[j].length()==1){
                            System.out.print("                     ");  
                          }else if(subjects[j].length()==2){
                            System.out.print("                    ");  
                          }else if(subjects[j].length()==3){
                             System.out.print("                   ");  
                          }else if(subjects[j].length()==4){
                             System.out.print("                  "); 
                             
                          }else if(subjects[j].length()==5){
                             System.out.print("                 ");
                          
                          }else if(subjects[j].length()==6){
                             System.out.print("                ");  
                          
                          }else if(subjects[j].length()==7){
                             System.out.print("               ");  
                          
                          }else if(subjects[j].length()==8){
                             System.out.print("              ");  
                          
                          }else if(subjects[j].length()==9){
                             System.out.print("             ");  
                          
                          }else if(subjects[j].length()==10){
                             System.out.print("            ");
                          
                          }else if(subjects[j].length()==11){
                             System.out.print("           ");  
                          
                          }else if(subjects[j].length()==12){
                             System.out.print("          ");
                          
                          }else if(subjects[j].length()==13){
                             System.out.print("         ");
                          
                          }else if(subjects[j].length()==14){
                             System.out.print("        ");
                          
                          }else if(subjects[j].length()==15){
                             System.out.print("       ");
                          
                          }else if(subjects[j].length()==16){
                             System.out.print("      ");
                          
                          }else if(subjects[j].length()==17){
                             System.out.print("     ");
                          
                          }else if(subjects[j].length()==18){
                             System.out.print("    ");
                          
                          }else if(subjects[j].length()==19){
                             System.out.print("   ");
                          
                          }else if(subjects[j].length()==20){
                             System.out.print("  ");
                          
                          }
                          System.out.print(grades[j]+"\n");
                        } 
                        if(tracker.getAverageGrade(i)>=80){
                            Color = "\u001B[96m";//light cyan
                        }else{
                            Color = "\u001B[31m";//red
                        }
                        decimalValue = decimalFormat.format(tracker.getAverageGrade(i));
                        System.out.println("_____________________________");
                        System.out.println("    Average Grade: "+Color+decimalValue+resetColor);
                        System.out.println("-----------------------------");
                        input_num++; 
                        
                }
                Color = "\u001B[31m";//red
                System.out.println(Color+"========================================"+resetColor);
                waitForEnterKey();
            }
            tracker.setRemainingdata_condition(noremaining_data);
        }
    }   
    
    private static void deleteStudent() {
        int lineLength,num_line1,num_line2;
        String Color;
        String resetColor = "\u001B[0m";
        //CONDITION IF THE USER CHOOSE DELETE A STUDENT DATA EVEN WHEN NO DATA HAS BEEN ADDED...
        if (tracker == null || tracker.getNumStudents() == 0) {
            System.out.println();
            Color = "\u001B[31m";//red
            System.out.println(Color+"                       ==========================================="+resetColor);
            Color = "\u001B[93m";//light yellow     
            System.out.println(Color+"                       [WARNING]"+resetColor+": No current data.");
             Color = "\u001B[32m";//green
            System.out.println(Color+"                       [CONDITION]"+resetColor+": Please add student/s first.");
            Color = "\u001B[31m";//red
            System.out.println(Color+"                       ==========================================="+resetColor);
            System.out.print("                          press enter key to continue...");
            scanner.nextLine();
            
        }else{
            //CONDITION WHEN NO DATA HAS BEEN REMAINING AFTER USER DELETED ALL THE STUDENT DATA                    
            if (tracker.noreemaining_data()) {
                System.out.println();
                Color = "\u001B[31m";//red
                System.out.println(Color+"                       ==========================================="+resetColor);
                Color = "\u001B[93m";//light yellow     
                System.out.println(Color+"                       [WARNING]"+resetColor+": No current data remaining.");
                Color = "\u001B[32m";//green
                System.out.println(Color+"                       [CONDITION]"+resetColor+": Please add student/s again.");
                Color = "\u001B[31m";//red
                System.out.println(Color+"                       ==========================================="+resetColor);
                System.out.print("                       press enter key to continue...");
                scanner.nextLine();
            }
            //Condition to delete the specific student data using student name
            else{
                clearScreenmobile();
                clearScreen();
                Color = "\u001B[31m";//red
                System.out.println(Color + "=================================================="+ resetColor);
                Color = "\u001B[36m";//red
                System.out.println(Color + "||       -----|STUDENT DATA DELETION|-----      ||"+ resetColor);
                Color = "\u001B[31m";//red
                System.out.println(Color + "=================================================="+ resetColor);
                Color = "\u001B[32m";//green
                System.out.print(Color + "[NOTE]: "+ resetColor);
                Color = "\u001B[33m";//yellow
                System.out.println(Color + "To delete a student from the stored data,"+ resetColor);
                System.out.println(Color + "enter the exact name used when adding the student."+ resetColor);
                Color = "\u001B[31m";//red
                System.out.println(Color + "__________________________________________________"+ resetColor);
                System.out.print(Color + "Name of the student to delete: "+ resetColor);
                String deleteName = scanner.nextLine();
                
                tracker.deleteStudent(deleteName);
                boolean deletionSuccessful = tracker.deletion_detected();
                
                lineLength = deleteName.length() + 41;
                //CONDITION FOR THE LINES
                if (deletionSuccessful) { 
                    for(num_line1=0;num_line1<lineLength;num_line1++){
                       System.out.print("-");
                    }
                    System.out.println();
                    Color = "\u001B[93m";//light yellow  
                    System.out.println(Color+"Student "+resetColor+"\"" + deleteName + "\""+Color+" has been successfully deleted."+resetColor);
                   for(num_line2=0;num_line2<lineLength;num_line2++){
                       System.out.print("-");
                    }
                    System.out.println();
                    Color = "\u001B[31m";//red
                    System.out.println(Color + "=================================================="+ resetColor);
                }else {
                    for(num_line1=0;num_line1<lineLength;num_line1++){
                       System.out.print("-");
                    }
                    System.out.println();
                     Color = "\u001B[31m";//red
                    System.out.println(Color+"Student "+resetColor+"\"" + deleteName + "\""+Color+" not found. Deletion failed."+resetColor);
                    for(num_line2=0;num_line2<lineLength;num_line2++){
                       System.out.print("-");
                    }
                    System.out.println();
                    Color = "\u001B[31m";//red
                    System.out.println(Color + "=================================================="+ resetColor);
                }
                waitForEnterKey();
           }
       }
    }
}
