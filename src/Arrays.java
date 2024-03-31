import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Arrays {

    protected void input_arr()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Enter your Array size: ");
        int size = scanner.nextInt();

        int[] grades = new int[size];

        System.out.println("Please Enter your Grades: ");

        for(int i = 0; i< size; i++)
        {
            grades[i] = scanner.nextInt();
        }

        scanner.close();

        for(int i = 0; i< size; i++)
        {
            System.out.println(grades[i]);
        }
    }

    protected void read_from_file()
    {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("Students.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        List<String> students = new ArrayList<String>();

        System.out.println("The Students are: ");

        try {
            while (scanner.hasNextLine()) {
                students.add(scanner.nextLine());
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        for (String var : students)
        {
            System.out.println(var);
        }
    }
}
