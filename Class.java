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
    
    public void showClass(Boolean ascending)
    {
        Collections.sort(classList, new SortByMark());
        
        if(!ascending)
        {
            Collections.reverse(classList);
        }
        
        
        
        //print the information 
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
        
        Utility.printSpace();
    }
    
    //-----------------move to manager-----------------
    public Boolean checkQuit(String string)
    {
        if(string.toLowerCase().equals("quit") || string.toLowerCase().equals("q")){return true;}
        else{return false;} 
    }
    
    public void main()
    {
        //clear screen
        System.out.flush();
        System.out.print("\f");
        
        int studentCount = Utility.getNumber("How many students do you have in your class? ", "The number you entered was too long. Please try again: ", "Please enter an integer: ");
        System.out.println("If you want to stop entering students, type q or quit");
        Utility.printSpace();
    
        for(int i = 0; i < studentCount; i++)
        {
            String studentID = Utility.getString("Please enter the student's ID: ");
            if(checkQuit(studentID)){break;}
            int mark = Utility.getPercentage("Please enter the student's mark for this class: ", "Please enter an integer (round up the percetange if it is has decimals): ");
            Student newStudent = new Student(studentID, mark);
            addStudent(newStudent);
        }
        
        removeStudent("7");
        showStudentByID("1");
        showMean();
        showMax();
        showClass(true);
        showClass(false);
    }
}



/*
 * Notes:
 * Reflections for portfolio posts: Having UI/UX in a sepeate class makes it easier to expand and modify the program later
 * Having different classes also allows easier further modification of the program if we wanted to make a system with mutliple classes or having an a parent class with child classes of different types
 * 
 * 
 * Test Code
*/
