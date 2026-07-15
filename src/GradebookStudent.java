package src;


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

    public int getID()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
         if (name == null || name.trim().isEmpty()) 
         {
            throw new IllegalArgumentException("Student name must not be null or empty.");
        }
        this.name = name.trim();
    }
    public void addGrade(GradeItem grade)
    {
        if (grade == null) {
        throw new IllegalArgumentException("Grade cannot be null.");
        }
        grades.add(grade);
    }
   public ArrayList<GradeItem> getGrades() 
    { 
    return new ArrayList<GradeItem>(grades); 
    }

    public double averageGrade()
    {
        if (grades.isEmpty())
        {
            return 0.0;
        }
        double total = 0.0;
        for(GradeItem g : grades)
        {
            total += g.getScore();
        }
        return total/grades.size();
    }
      @Override
    public String toString() {
        String avgText;
        if (grades.isEmpty()) {
            avgText = "no grades yet";
        } else {
            avgText = String.format("%.2f", averageGrade());
        }
        return "ID: " + id + " | Name: " + name + " | Average: " + avgText;
    }

    

    
    
}

