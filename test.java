
import java.util.ArrayList;

public class GradebookStudent
{
    private int id;
    private String name;
    private ArrayList<GradeItem> grades;
    public GradebookStudent(int id, String name) {
        if (id <= 0) {
            throw new IllegalArgumentException("Student id must be > 0.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name must not be null or empty.");
        }
        this.id = id;
        this.name = name.trim();
        this.grades = new ArrayList<GradeItem>();
    }
    
    
    
}
