import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    public static int SaveStudent(int EntryAmnt, Scanner scanner, ArrayList<Integer> Id, ArrayList<String> StudentName, ArrayList<Integer> StudentAge, ArrayList<String> StudentEmail, ArrayList<String> StudentCourse) {
        // Gets the amount of students that will be registered
        System.out.println("How many students do you want to add?:");
        int newEntries = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < newEntries; i++) {
            System.out.println("Enter the Student ID:");
            int StudId = scanner.nextInt();
            Id.add(StudId);
            scanner.nextLine();

            System.out.println("Enter the Student Name:");
            String StudName = scanner.nextLine();
            StudentName.add(StudName);

            System.out.println("Enter the Student Age:");
            int StudAge = scanner.nextInt();


            boolean correctAge = false;

            while (!correctAge) {
                System.out.println("Invalid age, please try again. Age should be 16+");
                System.out.println("Enter the Student Age:");
                StudAge = scanner.nextInt();
                scanner.nextLine();

                if (StudAge <= 15 ) {
                    System.out.println("Invalid age, please try again. Age should be 16+");
                } else {
                    correctAge = true;
                }
            }

            System.out.println("Enter the Student Email:");
            String StudMail = scanner.nextLine();
            StudentEmail.add(StudMail);

            System.out.println("Enter the Student Course:");
            String StudCourse = scanner.nextLine();
            StudentCourse.add(StudCourse);
        }

        return EntryAmnt + newEntries;
    }

    public static void SearchStudent(Scanner scanner, ArrayList<Integer> Id, ArrayList<String> StudentName, ArrayList<Integer> StudentAge, ArrayList<String> StudentEmail, ArrayList<String> StudentCourse) {
        System.out.print("Enter student ID to search: ");
        int query = scanner.nextInt();
        int index = Id.indexOf(query);

        if (index != -1) {
            System.out.println("STUDENT: " + (index + 1));
            System.out.println("____________________________________________");
            System.out.println("STUDENT ID: " + Id.get(index));
            System.out.println("STUDENT NAME: " + StudentName.get(index));
            System.out.println("STUDENT AGE: " + StudentAge.get(index));
            System.out.println("STUDENT EMAIL: " + StudentEmail.get(index));
            System.out.println("STUDENT COURSE: " + StudentCourse.get(index));
            System.out.println("____________________________________________");
        } else {
            System.out.println("Student could not be found!");
        }
    }

    public static void DeleteStudent(Scanner scanner, ArrayList<Integer> Id, ArrayList<String> StudentName, ArrayList<Integer> StudentAge, ArrayList<String> StudentEmail, ArrayList<String> StudentCourse) {

        try{
            System.out.println("Enter Student ID to delete:");
            int query = scanner.nextInt();
            int index = Id.indexOf(query);

            if (index != -1) {
                Id.remove(index);
                StudentName.remove(index);
                StudentAge.remove(index);
                StudentEmail.remove(index);
                StudentCourse.remove(index);
                System.out.println("Student removed successfully.");
            } else {
                System.out.println("Student could not be found!");
            }
        }catch(Exception e){

            System.out.println("Something went wrong while deleting file!");
        }
    }

    public static void PrintStudentReport(int EntryAmnt, ArrayList<Integer> Id, ArrayList<String> StudentName, ArrayList<Integer> StudentAge, ArrayList<String> StudentEmail, ArrayList<String> StudentCourse) {

        try{
            if (EntryAmnt == 0) {
                System.out.println("No students have been registered yet.");
                return;
            }

            for (int i = 0; i < EntryAmnt; i++) {
                System.out.println("STUDENT: " + (i + 1));
                System.out.println("____________________________________________");
                System.out.println("STUDENT ID: " + Id.get(i));
                System.out.println("STUDENT NAME: " + StudentName.get(i));
                System.out.println("STUDENT AGE: " + StudentAge.get(i));
                System.out.println("STUDENT EMAIL: " + StudentEmail.get(i));
                System.out.println("STUDENT COURSE: " + StudentCourse.get(i));
                System.out.println("____________________________________________");
            }
        }catch(Exception e){
            System.out.println("End of Students' Record.");
        }
    }

    public static void ExitStudentApplication() {
        System.out.println("Exiting application...");
        System.exit(0);
    }

    // Save student data to a file
    public static void saveDataToFile(ArrayList<Integer> Id, ArrayList<String> StudentName, ArrayList<Integer> StudentAge, ArrayList<String> StudentEmail, ArrayList<String> StudentCourse) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"))) {
            for (int i = 0; i < Id.size(); i++) {
                writer.write(Id.get(i) + "," + StudentName.get(i) + "," + StudentAge.get(i) + "," + StudentEmail.get(i) + "," + StudentCourse.get(i));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving data to file.");
        }
    }

    // Load student data from a file
    public static void loadDataFromFile(ArrayList<Integer> Id, ArrayList<String> StudentName, ArrayList<Integer> StudentAge, ArrayList<String> StudentEmail, ArrayList<String> StudentCourse) {
        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Id.add(Integer.parseInt(data[0]));
                StudentName.add(data[1]);
                StudentAge.add(Integer.parseInt(data[2]));
                StudentEmail.add(data[3]);
                StudentCourse.add(data[4]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existing data found. Starting fresh.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading data from file.");
        }
    }
}
