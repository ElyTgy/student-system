/**
 * Title: Class Manager
 * 
 * Program Summary: A program intended to be used as a classroom manager by a teacher for working with their marks
 * 
 * Program Element List: use of acess modifiers final and private to prevent the unintentional modification of student ID, wrapper functions, Seperate Student and Class to implement a has-a relationship, create setter and getter functions for private varaibles, Utility class with static helper functions, use of for and while loop in multiple instances for sorting/searching/input validation, try-catch exceptions, use of javas collections class with a user defined class and comparison function implementation, function overloading, Thread.sleep to delay the program
 *
 * @author Ellie Taghavi
 * @version January 17th, 2023
 */
public class Main
{
    /**
     * Summary: Constructor for Main class
     * @params: None
     * @return: None
     */
    public Main()
    {
        // None
    }//END of Main constructor

    /**
     * Summary: entry point for the program
     */
    public static void main (String[] args)
    {
         Class classOne = new Class();
         classOne.main();
    }//END of main
}//END of Main class





/*
 * Notes:
 * Reflections for portfolio posts: Having utility in a sepeate class makes it easier to expand and modify the program later, using comparator
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
