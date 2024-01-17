import java.util.*;

/*
 * DONE: add students
 * DONE: remove students (by ID)
 * DONE: provide student info (search by ID)
 * DONE: show class info (all student ids, marks in class, mean and stuff) + allow user to view in ascending or descending order of marks
 * //TODO: if csv file is allowed, have mean, min, and max as instance variables and change them whenever remove student or addstudent is called. DONE: show specific class info (mean, max, min)
    TODO: dont allow for duplicate IDs
    DONE: allow for user to quit while entering students
   
   */


public class Class
{
    ArrayList<Student> classList = new ArrayList<Student>();
    
    public Class()
    {
        //Constructor is empty
    }
    
    public void addStudent(Student newStudent)
    {
        classList.add(newStudent);
        System.out.println("New student added.");
        Utility.printSpace();
    }
    
    public void addStudent()
    {
        String ID = Utility.getString("Please enter the ID of the student you want to add: ", "The string is too long, enter a shorter ID: ");
        int mark;
        
        
        if(findStudentByID(ID) != -1){
            System.out.println("A student with that ID already exists. The database was not modified.");
            Utility.printSpace();
            
            return;
        }
        
        mark = Utility.getPercentage("Enter the student's mark: ");
        
        Student newStudent = new Student(ID, mark);
        classList.add(newStudent);
        
        System.out.println("New student added.");
        Utility.printSpace();
    }
    
    public void removeStudent()
    {
        String studentID = Utility.getString("Please enter the ID of the student you want to remove: ", "The string is too long, enter a shorter ID: ");       
    
        if(findStudentByID(studentID) == -1){
            System.out.println("A student with that ID does not exist"); 
            Utility.printSpace();
            
            return;
        }
        
        for(int i = 0; i < classList.size(); i++)
        {
            if(studentID.equals(classList.get(i).studentID))
            {
                classList.remove(i);
            }
        }
        
        System.out.println("Student removed.");
        Utility.printSpace();
    }
    
    public void modifyStudent()
    {
        String studentID = Utility.getString("Please enter the ID of the student you want to modify: ", "The string is too long, enter a shorter ID: ");;
        int newMark;
        
        
        
        if(findStudentByID(studentID) == -1){
            System.out.println("A student with that ID does not exist"); 
            Utility.printSpace();
            
            return;
        }
        
        newMark = Utility.getPercentage("Enter the student's new mark: ");
        
        
        
        for(int i = 0; i < classList.size(); i++)
        {
            if(studentID.equals(classList.get(i).studentID))
            {
                Student updatedStudent = new Student(studentID, newMark);
                classList.set(i, updatedStudent);
            }
        }
        
        
        
        System.out.println("Mark of student with ID " + studentID + " updated to " + newMark);
        Utility.printSpace();
    }
    
    public int findStudentByID(String studentID)
    {
        for(int i = 0; i < classList.size(); i++)
        {
            if(studentID.equals(classList.get(i).studentID))
            {
                return i;
            }
        }
        return -1;
    }
    
    public void showStudentByID()
    {   
        String studentID = Utility.getString("Please enter the ID of the student you want to find: ", "The string is too long, enter a shorter ID: ");
        int searchResult = findStudentByID(studentID);
        
        if (searchResult != -1){
            System.out.println(classList.get(searchResult).toString());
        }else{
            System.out.println("Sorry, no student with that ID was found.");
        }
        
        Utility.printSpace();
    }
    
    public void showMean()
    {
        //variable declaration and initialization
        int sum = 0;
        double mean;
        
        
        
        for(int i = 0; i < classList.size(); i++)
        {
            sum += classList.get(i).getMark();
        }
        
        
        
        mean = sum / classList.size();
        System.out.println("The average mark for this class is " + mean);
        Utility.printSpace();
    }
    
    public void showMin()
    {
        Student minStudent = Collections.min(classList, new SortByMark());
        System.out.println("Student with the lowest mark is " + minStudent.studentID + " and has a mark of " + minStudent.getMark());
        Utility.printSpace();
    }
    
    public void showMax()
    {
        Student maxStudent = Collections.max(classList, new SortByMark());
        System.out.println("Student with the highest mark is " + maxStudent.studentID + " and has a mark of " + maxStudent.getMark());
        Utility.printSpace();
    }
    
    public void showClass()
    {
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
    }
    
    
    public void main()
    {
        int studentCount;
        String userInput;
        
        Utility.clearScreen();
        
        studentCount = Utility.getNumber("How many students do you have in your class? ", "The number you entered was too long. Please try again: ", "Please enter an integer: ");
        System.out.println("If you want to stop entering students, type q or quit");
        Utility.printSpace();
    
        for(int i = 0; i < studentCount; i++)
        {
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
        
        System.out.println("The data you entered can be viewed and modified in a number of ways. Please select your operation from the menu below.");
        Utility.printSpace();
        
        UI.showMenu();
        Utility.printSpace();
        
        while (true)
        {
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
            }
            else{
                System.out.println("Sorry, that command is not recognized. Please try again.");
            }
        }
    }
}



/*
 * Notes:
 * Reflections for portfolio posts: Having UI/UX in a sepeate class makes it easier to expand and modify the program later
 * Having different classes also allows easier further modification of the program if we wanted to make a system with mutliple classes or having an a parent class with child classes of different types
 * 
 *      System.out.println("1) Add a student");
        System.out.println("2) Remove a student");
        System.out.println("3) Modify a mark");
        System.out.println("4) Find a student by ID");
        System.out.println("5) Average mark for class");
        System.out.println("6) Minimum mark for class");
        System.out.println("7) Maxmimum mark for class");
        System.out.println("8) Get Information for the whole class");
        System.out.println("9) Quit");
 * 
 * 
 * Test Code:
 * //print the information 
        System.out.println("--------------------");
        System.out.println("|   ID   |   Mark   |");
        System.out.println("--------------------");
        for(int i = 0; i < classList.size(); i++)
        {
            String studentID = classList.get(i).studentID;
            int mark = classList.get(i).getMark();
            
            System.out.println("|   " + studentID + "   |   " + mark + "   |");
            System.out.println("--------------------");
        }
        
        
public void addStudent(Student newStudent)
    {
        classList.add(newStudent);
        System.out.println("New student added.");
        Utility.printSpace();
    }
    
    public void removeStudent(String studentID)
    {
        //TODO: replace ArrayList with Hashmap for more efficient search (remove forloop and use .get()) o use binary search
        for(int i = 0; i < classList.size(); i++)
        {
            if(studentID.equals(classList.get(i).studentID))
            {
                classList.remove(i);
            }
        }
        System.out.println("Student removed.");
        Utility.printSpace();
    }
    
    public void modifyStudent(String studentID, int newMark)
    {
        for(int i = 0; i < classList.size(); i++)
        {
            if(studentID.equals(classList.get(i).studentID))
            {
                Student updatedStudent = new Student(studentID, newMark);
                classList.set(i, updatedStudent);
            }
        }
        System.out.println("Mark of student with ID " + studentID + " updated to " + newMark);
        Utility.printSpace();
    }
    
    public void showStudentByID(String studentID)
    {
        Boolean found = false;
        for(int i = 0; i < classList.size(); i++)
        {
            if(studentID.equals(classList.get(i).studentID))
            {
                System.out.println(classList.get(i).toString());
                found = true;
            }
        }
        
        if(!found){System.out.println("Sorry, no student with that ID was found.");}
        
        Utility.printSpace();
    }   
*/
