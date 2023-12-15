import java.util.Comparator;



public class Student
{
    // instance variables - replace the example below with your own
    final public String studentID;
    private int mark = 0;
    
    
    /**
     * Constructor for objects of class Student
     */
    public Student(String studentID, int mark)
    {
        this.studentID = studentID;
        setMark(mark);
    }
    
    public void setMark(int mark)
    {
        //TODO: maybe do the loop here instead of the Class class to ensure mark is alway initialized to a percentage?
        if((mark > 100) || (mark < 0))
        {
            System.out.println("Please enter the mark as a percentage between 0 and 100.");
            this.mark = -1;
        }
        else
        {
            this.mark = mark;
        }
    }
    
    public int getMark()
    {
        return mark;
    }
    
    public String toString()
    {
        return (studentID + "'s mark is " + mark);
    }
}

class SortByMark implements Comparator<Student> {
    
    // Sorting in ascending order of marks
    public int compare(Student a, Student b)
    {
 
        return a.getMark() - b.getMark();
    }
}
