import java.util.Comparator;



public class Student
{
    // instance variables - replace the example below with your own
    final public String studentID;
    private int mark = 0;
    
    
    
    
    
    /**
     * Summary: Constructor for objects of class Student
     * @param: 
     *        [String] studentID: ID for the student
     *        [int] mark: mark for the student
     * @return: [Student] The object
     */
    public Student(String studentID, int mark)
    {
        this.studentID = studentID;
        setMark(mark);
    }//END of constructor
    
    
    
    
    
    /**
     * Summary: Settter function for marks. Checks that it is inclusively between 0 and 100
     * @param: [int] mark: mark for the student
     * @return: None
     */
    public void setMark(int mark)
    {
        if((mark > 100) || (mark < 0)){
            System.out.println("Please enter the mark as a percentage between 0 and 100.");
            this.mark = -1;
        }else{
            this.mark = mark;
        }//if-else
    }//END of setMark
    
    
    
    
    
    /**
     * Summary: Settter function for marks. Checks that it is inclusively between 0 and 100
     * @param: Getter function for marks
     * @return: None
     */
    public int getMark()
    {
        return mark;
    }//END of getMark
    
    
    
    
    
    /**
     * Summary: toString function to be used whenever printing a Student to the console
     * @param: None
     * @return: None
     */
    public String toString()
    {
        return (studentID + "'s mark is " + mark);
    }//END of toString
}//END of Student





// Comparator class to be used whenever java's collection class is used on the Student class for sorting and searching purposes
class SortByMark implements Comparator<Student> 
{
    /**
     * Summary: The function to be called when java sorts something that includes Student class
     * @param: 
     *          [Student] a: first student used for comparison
     *          [Student] b: second student used for comparison
     * @return: [int]: bigger than 1 if a is bigger, less than one if b is smaller, and 0 if they are equal
     */
    public int compare(Student a, Student b)
    {
 
        return a.getMark() - b.getMark();
    }//END of compare
}//END of SortByMark
