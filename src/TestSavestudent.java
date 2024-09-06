import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class TestSavestudent {

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
    public void testSaveStudent() {
        String input = "1\n1001\nJohn Doe\n22\njohn.doe@example.com\nComputer Science\n";
        Scanner scanner = new Scanner(input);

        int initialCount = 0;
        int totalEntries = Student.SaveStudent(initialCount, scanner, Id, StudentName, StudentAge, StudentEmail, StudentCourse);

        // Assert that the student has been added correctly
        assertEquals(1, totalEntries);
        assertEquals(1, Id.size());
        assertEquals(1001, Id.get(0));
        assertEquals("John Doe", StudentName.get(0));
        assertEquals(22, StudentAge.get(0));
        assertEquals("john.doe@example.com", StudentEmail.get(0));
        assertEquals("Computer Science", StudentCourse.get(0));
    }

    @Test
    public void testSearchStudentFound() {
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

    @Test
    public void testSearchStudentNotFound() {
        String input = "9999\n"; // Non-existent ID
        Scanner scanner = new Scanner(input);

        // Simulate search
        Student.SearchStudent(scanner, Id, StudentName, StudentAge, StudentEmail, StudentCourse);

        // We can again validate the search behavior, but refactoring the method to return data will make it testable.
    }
}
