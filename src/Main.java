import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> Id = new ArrayList<>();
        ArrayList<String> StudentName = new ArrayList<>();
        ArrayList<Integer> StudentAge = new ArrayList<>();
        ArrayList<String> StudentEmail = new ArrayList<>();
        ArrayList<String> StudentCourse = new ArrayList<>();


        // Read data from the file when the application starts
        Student.loadDataFromFile(Id, StudentName, StudentAge, StudentEmail, StudentCourse);

        //Header Section
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("*****************************");

        int menuSelection = 0;
        int EntryAmnt = Id.size(); // Start with existing data count

        while (menuSelection != 5) {
            System.out.println("Please select one of the following menu items:");
            System.out.println("(1) Capture a new Student.");
            System.out.println("(2) Search for a student.");
            System.out.println("(3) Delete a Student.");
            System.out.println("(4) Print Student Report.");
            System.out.println("(5) Exit Application.");
            menuSelection = scanner.nextInt();

            if (menuSelection == 1) {
                EntryAmnt = Student.SaveStudent(EntryAmnt, scanner, Id, StudentName, StudentAge, StudentEmail, StudentCourse);
                Student.saveDataToFile(Id, StudentName, StudentAge, StudentEmail, StudentCourse); // Save data to file after adding
            } else if (menuSelection == 2) {
                Student.SearchStudent(scanner, Id, StudentName, StudentAge, StudentEmail, StudentCourse);
            } else if (menuSelection == 3) {
                Student.DeleteStudent(scanner, Id, StudentName, StudentAge, StudentEmail, StudentCourse);
                Student.saveDataToFile(Id, StudentName, StudentAge, StudentEmail, StudentCourse); // Save data to file after deleting
            } else if (menuSelection == 4) {
                Student.PrintStudentReport(EntryAmnt, Id, StudentName, StudentAge, StudentEmail, StudentCourse);
            } else if (menuSelection == 5) {
                Student.ExitStudentApplication();
            } else {
                System.out.println("Invalid option, please try again.");
            }
        }
    }


}
