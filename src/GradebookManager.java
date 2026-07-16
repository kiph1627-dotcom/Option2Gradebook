package src;
import java.util.ArrayList;
public class GradebookManager 
{
    private ArrayList<GradebookStudent> students;    

    public GradebookManager()
    {
        this.students = new ArrayList<>();
    }

    public boolean addStudent(GradebookStudent student)
    {
        for (GradebookStudent s : students)
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
                s1.addGrade(new GradeItem(title, score));
                return true;
            }
        }
        return false;
    }
    public GradebookStudent findById(int id)
    {
        for (GradebookStudent s2 : students)
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
        return new ArrayList<GradebookStudent>(students);
    }

}
