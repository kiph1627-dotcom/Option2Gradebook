
package src;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
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
            System.out.print("Enter choice: ");
            int choice;
            try
            {
                choice = input.nextInt();
                input.nextLine();
            }
            catch(IllegalArgumentException e)
            {
                System.out.println("Invalid input. Please enter a number from 1 to 8.");
                input.nextLine();
                continue;
            }
            

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
                    break;
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
                case 6:
                    
        String path = "data/sample_data.txt";
        int studentsLoaded = 0;
        int gradesLoaded = 0;
        try
        {
            Scanner fileScanner = new Scanner(new File(path));
            while (fileScanner.hasNextLine())
            {
                String line = fileScanner.nextLine().trim();
                if (line.isEmpty())
                {
                    continue;
                }
                String[] parts = line.split(",");
                try
                {
                    if (parts[0].equals("STUDENT"))
                    {
                        int newId = Integer.parseInt(parts[1]);
                        String newName = parts[2];
                        manager.addStudent(new GradebookStudent(newId, newName));
                        studentsLoaded++;
                    }
                    else if (parts[0].equals("GRADE"))
                    {
                        int gradeId = Integer.parseInt(parts[1]);
                        String gradeTitle = parts[2];
                        double gradeScore = Double.parseDouble(parts[3]);
                        manager.addGradeToStudent(gradeId, gradeTitle, gradeScore);
                        gradesLoaded++;
                    }
                }
                catch (Exception badLine)
                {
                    System.out.println("Skipping bad line: " + line);
                }
            }
                fileScanner.close();
                System.out.println("Data loaded successfully.");
                System.out.println("Students loaded: " + studentsLoaded);
                System.out.println("Grades loaded: " + gradesLoaded);
            }
            catch (FileNotFoundException notFound)
            {
                System.out.println("Could not find file: " + path);
                System.out.println("Gradebook was not changed.");
            }
            break; 

            }
        }
    }
}
