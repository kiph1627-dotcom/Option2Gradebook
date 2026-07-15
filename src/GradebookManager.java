package src;
import java.util.ArrayList;
public class GradebookManager 
{
    private ArrayList<GradebookStudent> students;    

    public GradebookManager(ArrayList<GradebookStudent> students)
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
}
