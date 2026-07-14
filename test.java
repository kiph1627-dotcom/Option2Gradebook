
import java.util.ArrayList;

public class GradebookStudent
{
    private int id;
    private String name;
    private ArrayList<GradeItem> grades;
    public GradebookStudent(int id, String name )
    {
        this.id = id;
        this.name = name.trim();
        this.grades = new ArrayList<GradeItem>();
    }
}
