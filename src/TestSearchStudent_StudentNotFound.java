import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
class TestSearchStudent_StudentNotFound {
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
    public void testSearchStudentNotFound() {
        String input = "9999\n"; // Non-existent ID
        Scanner scanner = new Scanner(input);

        // Simulate search
        Student.SearchStudent(scanner, Id, StudentName, StudentAge, StudentEmail, StudentCourse);


    }
}