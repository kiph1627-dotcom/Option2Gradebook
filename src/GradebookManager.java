package src;
import java.util.ArrayList;
public class GradebookManager 
{
    private ArrayList<GradebookStudent> students;    

    public GradebookManager()
    {
        this.students = new ArrayList<>(); //makes it an empty array
    }

    public boolean addStudent(GradebookStudent student)
    {
        for (GradebookStudent s : students) //loops thtough all the students in the list
        {
            if (s.getID() == student.getID())
            {
                return false;
            }
        }
        students.add(student);
        return true;
    }

    public boolean addGradeToStudent(int id, String title, double score)
    {
        for (GradebookStudent s1 : students)
        {
            if (s1.getID() == id)
            {
                s1.addGrade(new GradeItem(title, score)); // goes to the add grade method in gradebook student
                return true;
            }
        }
        return false;
    }
    public GradebookStudent findById(int id)
    {
        for (GradebookStudent s2 : students) //loops through all of the students
        {
            if (s2.getID() == id)
            {
                return s2;
            }
        }
        return null;
    }

    public ArrayList<GradebookStudent> viewAllStudents()
    {
        return new ArrayList<GradebookStudent>(students); //returns a copy of the list of students
    }

}
