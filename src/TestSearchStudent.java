import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TestSearchStudent {

    private ArrayList<Integer> Id;
    private ArrayList<String> StudentName;
    private ArrayList<Integer> StudentAge;
    private ArrayList<String> StudentEmail;
    private ArrayList<String> StudentCourse;

    @BeforeEach
    public void setUp() {
        Id = new ArrayList<>();
        StudentName = new ArrayList<>();
        StudentAge = new ArrayList<>();
        StudentEmail = new ArrayList<>();
        StudentCourse = new ArrayList<>();
    }

    @Test
    void  testSearchStudentFound() {
        // Prepare data
        Id.add(1001);
        StudentName.add("John Doe");
        StudentAge.add(22);
        StudentEmail.add("john.doe@example.com");
        StudentCourse.add("Computer Science");

        String input = "1001\n"; // ID to search
        Scanner scanner = new Scanner(input);

        // Simulate search
        Student.SearchStudent(scanner, Id, StudentName, StudentAge, StudentEmail, StudentCourse);

        // We can validate the search behavior here but because it prints directly to console, this test won't validate it.
        // We could refactor the method to return the student data and validate it here.
    }


}