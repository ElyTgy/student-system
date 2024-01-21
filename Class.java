import java.util.*;



public class Class
{
    //instance variable
    public ArrayList<Student> classList = new ArrayList<Student>();
    
    
    
    
    
    /**
     * Summary: Constructor for Class class
     * @param: None
     * @return: None
     */
    public Class()
    {
        //Constructor is empty
    }//END of class
    
    
    
    
    
    /**
     * Summary: Add the student passed in as argument to the classList
     * @param: [Student] new student to be added to the list
     * @return: None
     */
    public void addStudent(Student newStudent)
    {
        classList.add(newStudent);
        System.out.println("New student added.");
        Utility.printSpace();
    }//END of addStudent
    
    
    
    
    
    /**
     * Summary: Add a new student to the list that the user enters
     * @param: None
     * @return: None
     */
    public void addStudent()
    {
        //variable instantiation and declaration
        String ID = Utility.getString("Please enter the ID of the student you want to add: ", "The string is too long, enter a shorter ID: ");
        int mark;
        
        
        
        if(findStudentByID(ID) != -1){
            System.out.println("A student with that ID already exists. The database was not modified.");
            Utility.printSpace();
            
            return;
        }//END of if-statement
        
        mark = Utility.getPercentage("Enter the student's mark: ");
        
        Student newStudent = new Student(ID, mark);
        addStudent(newStudent);
    }//END of addStudent
    
    
    
    
    
    /**
     * Summary: Remove new student to the list that the user enters
     * @param: None
     * @return: None
     */
    public void removeStudent()
    {
        //variable declaration
        String studentID = Utility.getString("Please enter the ID of the student you want to remove: ", "The string is too long, enter a shorter ID: ");       
    
        
        
        if(findStudentByID(studentID) == -1){
            System.out.println("A student with that ID does not exist"); 
            Utility.printSpace();
            
            return;
        }//END of if statement
        
        
        
        for(int i = 0; i < classList.size(); i++){if(studentID.equals(classList.get(i).studentID))
            {
                classList.remove(i);
            }
        }//END of for loop
        
        
        
        System.out.println("Student removed.");
        Utility.printSpace();
    }//END of removeStudent
    
    
    
    
    
    /**
     * Summary: Modify mark of the student as specified by the user
     * @param: None
     * @return: None
     */
    public void modifyStudent()
    {
        //variable declaration
        String studentID = Utility.getString("Please enter the ID of the student you want to modify: ", "The string is too long, enter a shorter ID: ");;
        int newMark;
        
        
        
        if(findStudentByID(studentID) == -1){
            System.out.println("A student with that ID does not exist"); 
            Utility.printSpace();
            
            return;
        }//end of if-statement
        
        newMark = Utility.getPercentage("Enter the student's new mark: ");
        
        for(int i = 0; i < classList.size(); i++){
            if(studentID.equals(classList.get(i).studentID)){
                Student updatedStudent = new Student(studentID, newMark);
                classList.set(i, updatedStudent);
            }
        }//end of for-loop
        
        
        
        System.out.println("Mark of student with ID " + studentID + " updated to " + newMark);
        Utility.printSpace();
    }//END of modifyStudent
    
    
    
    
    
    /**
     * Summary: Find a student based on the passed in argument
     * @param: [String] studentID: ID of the student you want to find
     * @return: [int]: index of the student if it was found, -1 if it wasnt found
     */
    public int findStudentByID(String studentID)
    {
        for(int i = 0; i < classList.size(); i++)
        {
            if(studentID.equals(classList.get(i).studentID)){
                return i;
            }//END of if-statement
        }//END of for-loop
        return -1;
    }//END of findStudentByID
    
    
    
    
    
    /**
     * Summary: Find and print student based on the passed in argument
     * @param: None
     * @return: None
     */
    public void showStudentByID()
    {   
        //variable declaration and initialization
        String studentID = Utility.getString("Please enter the ID of the student you want to find: ", "The string is too long, enter a shorter ID: ");
        int searchResult = findStudentByID(studentID);
        
        
        
        if (searchResult != -1){
            System.out.println(classList.get(searchResult).toString());
        }else{
            System.out.println("Sorry, no student with that ID was found.");
        }//END of if-else
        
        
        
        Utility.printSpace();
    }//END of showStudentByID
    
    
    
    
    
    /**
     * Summary: Find and print the average mark of students
     * @param: None
     * @return: None
     */
    public void showMean()
    {
        //variable declaration and initialization
        int sum = 0;
        double mean;
        
        
        
        for(int i = 0; i < classList.size(); i++){
            sum += classList.get(i).getMark();
        }//END of for loop
        
        
        
        mean = sum / classList.size();
        
        System.out.println("The average mark for this class is " + mean);
        Utility.printSpace();
    }//END of showMean
    
    
    
    
    
    /**
     * Summary: Find and print the minimum mark of students
     * @param: None
     * @return: None
     */
    public void showMin()
    {
        Student minStudent = Collections.min(classList, new SortByMark());
     
        System.out.println("Student with the lowest mark is " + minStudent.studentID + " and has a mark of " + minStudent.getMark());
        Utility.printSpace();
    }//END of showMin
    
    
    
    
    
    /**
     * Summary: Find and print the maximum mark of students
     * @param: None
     * @return: None
     */
    public void showMax()
    {
        Student maxStudent = Collections.max(classList, new SortByMark());
        
        System.out.println("Student with the highest mark is " + maxStudent.studentID + " and has a mark of " + maxStudent.getMark());
        Utility.printSpace();
    }//END of showMax
    
    
    
    
    
    /**
     * Summary: Print the information about the class in a tabular format and in ascending order of their marks
     * @param: None
     * @return: None
     */
    public void showClass()
    {
        //variable declaration
        Formatter fmt = new Formatter(); 
        
        Collections.sort(classList, new SortByMark());
        
        
        
        fmt.format("%-21s %-21s %n", "ID", "Mark");
        for(int i = 0; i < classList.size(); i++)
        {
            String studentID = classList.get(i).studentID;
            int mark = classList.get(i).getMark();
            
            fmt.format("%-20s %-20s \n", studentID, mark);
        }
        System.out.println(fmt);
        
        
        
        Utility.printSpace();
    }//END of showClass
    
    
    
    
    
    /**
     * Summary: Runs the main logic of the program. Asks for user to input students and also uses a menu to ask for their different commands
     * @param: None
     * @return: None
     */
    public void main()
    {
        //variable declarations
        int studentCount;
        String userInput;
        
        
        
        Utility.clearScreen();
        
        UI.showTitle();
        Utility.printSpace();
        Utility.printSpace();
        
        UI.showIntro();
        Utility.printSpace();
        
        
        
        studentCount = Utility.getNumber("How many students do you have in your class? ", "The number you entered was too long. Please try again: ", "Please enter an integer: ");
        System.out.println("If you want to stop entering students, type q or quit");
        Utility.printSpace();
    
        for(int i = 0; i < studentCount; i++){
            String studentID = Utility.getString("Please enter the student's ID: ", "The ID can't be longer than 20 character, please try again: ");
            
            if(findStudentByID(studentID) != -1){
                System.out.println("Student with that ID already exists."); 
                Utility.printSpace();
                
                --i;
                
                continue;
            }
            
            if(studentID.toLowerCase().equals("quit") || studentID.toLowerCase().equals("q")){break;}
            
            int mark = Utility.getPercentage("Please enter the student's mark for this class: ");
            
            
            
            Student newStudent = new Student(studentID, mark);
            addStudent(newStudent);
        }
        
        
        
        Utility.clearScreen();
        System.out.println("The data you entered can be viewed and modified in a number of ways. Please select your operation from the menu below.");
        Utility.printSpace();
        
        UI.showMenu();
        Utility.printSpace();
        
        while (true){
            userInput = (Utility.getString("Please enter you command: ", "Your input was too long, please enter something shorter")).toLowerCase();
            
            if ((userInput.equals("1")) || (userInput.equals("add")) || (userInput.equals("add a student")) || (userInput.equals("add student"))){
                addStudent();
            }else if ((userInput.equals("2")) || (userInput.equals("remove")) || (userInput.equals("remove a student")) || ( userInput.equals("remove student"))){
                removeStudent();
            }else if ((userInput.equals("3")) || (userInput.equals("modify")) || (userInput.equals("modify a mark")) || (userInput.equals("modify mark"))){
                modifyStudent();
            }else if ((userInput.equals("4")) || (userInput.equals("find")) || (userInput.equals("find student")) || (userInput.equals("find by id"))){
                showStudentByID();
            }else if ((userInput.equals("5")) || (userInput.equals("average"))){
                showMean();
            }else if ((userInput.equals("6")) || (userInput.equals("min")) || (userInput.equals("minimum"))){
                showMin();
            }else if ((userInput.equals("7")) || (userInput.equals("max")) || (userInput.equals("maximum"))){
                showMax();
            }else if ((userInput.equals("8")) || (userInput.equals("class")) || (userInput.equals("get information for the whole class"))){
                showClass();
            }else if ((userInput.equals("9")) || (userInput.equals("quit"))){
                UI.showBye();
                System.exit(0);
            }else{
                System.out.println("Sorry, that command is not recognized. Please try again.");
                Utility.printSpace();
            }//END of if-else
        }//END of while loop
    }//END of main
}//END of Class class