package src;
import java.util.Scanner;
public class GradebookApp 
{
    public static void main(String[] args)
    {
        GradebookManager manager = new GradebookManager();
        Scanner input = new Scanner(System.in);

        while(true)
        {
            System.out.println("==== Gradebook Manager ====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade to Student");
            System.out.println("3. View All Students");
            System.out.println("4. View Student Details");
            System.out.println("5. Search Student by ID");
            System.out.println("6. Load Data from File");
            System.out.println("7. Save Data to File");
            System.out.println("8. Exit");
            System.out.print("Enter choice: _");
            int choice = input.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.println("Enter an id");
                    int id = input.nextInt();
                    input.nextLine();
                    System.out.println("Enter a name");
                    String name = input.nextLine();
                    GradebookStudent s1 = new GradebookStudent(id, name);
                    boolean added = manager.addStudent(s1);

                    if (added)
                    {
                        System.out.println("The student was added succesfully!");
                    }
                    else
                    {
                        System.out.println("Someone with that id already exists");
                    }
                    break;

                case 2:
                    System.out.println("Enter an id");
                    id = input.nextInt();
                    input.nextLine();
                    System.out.println("Enter a name");
                    String title = input.nextLine();
                    System.out.println("Enter the students score");
                    double score = input.nextDouble();
                    added = manager.addGradeToStudent(id, title, score);
                    if (added)
                    {
                        System.out.println("Grade added to Student succesfully!");
                    }
                    else
                    {
                        System.out.println("No Student matches that id");
                    }
                    break;
                
                case 3:
                    System.out.println(manager.viewAllStudents());
                    break;

                case 4:
                    System.out.println("Enter an id");
                    id = input.nextInt();
                    GradebookStudent s = manager.findById(id);
                    if (s != null)
                    {
                        System.out.println(s);
                        for (GradeItem g : s.getGrades())
                        {
                            System.out.println(g);
                        }
                    }
                    else
                    {
                        System.out.println("No student found with that id");
                    }
                case 5:
                    System.out.println("Enter an id");
                    id = input.nextInt();
                    GradebookStudent s3 = manager.findById(id);
                    if (s3 == null)
                    {
                        System.out.println("No student found with that id");
                    }
                    else
                    {
                        System.out.println(s3);
                    }

            }
        }
    }
}
