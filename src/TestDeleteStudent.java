import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TestDeleteStudent {
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
    void deleteStudent() {
        // Add a student to the lists
        Id.add(343);
        StudentName.add("Jane Smith");
        StudentAge.add(20);
        StudentEmail.add("jane.smith@example.com");
        StudentCourse.add("Mathematics");

        // Simulate input
        String input = "343\n"; // ID to delete
        Scanner scanner = new Scanner(input);

        // Call the delete method
        Student.DeleteStudent(scanner, Id, StudentName, StudentAge, StudentEmail, StudentCourse);

        // Verify that the student with ID 343 has been removed
        assertFalse(Id.contains(343), "Student ID 343 should have been removed.");
        assertFalse(StudentName.contains("Jane Smith"), "Student Name Jane Smith should have been removed.");
        assertFalse(StudentAge.contains(20), "Student Age 20 should have been removed.");
        assertFalse(StudentEmail.contains("jane.smith@example.com"), "Student Email jane.smith@example.com should have been removed.");
        assertFalse(StudentCourse.contains("Mathematics"), "Student Course Mathematics should have been removed.");
    }
}
