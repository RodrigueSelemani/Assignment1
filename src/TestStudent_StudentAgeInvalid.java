import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TestStudentAgeInvalid {

    private ArrayList<Integer> StudentAge;

    @BeforeEach
    public void setUp() {
        StudentAge = new ArrayList<>();
    }

    @Test
    void testStudent_studentAgeInvalid() {
        // Simulate input for invalid age
        String input = "35\n"; // Invalid age (greater than 30)
        Scanner scanner = new Scanner(input);

        boolean correctAge = false;
        int StudAge = 0;

        while (!correctAge) {
            System.out.println("Enter the Student Age:");
            StudAge = scanner.nextInt();
            scanner.nextLine();

            if (StudAge < 16 ) {
                System.out.println("Invalid age, please try again. Age should be between 16 and 30.");
                // Invalid age should not be added to the list
            } else {
                correctAge = true;
                StudentAge.add(StudAge);
            }
        }

        // The invalid age should not be added to the list
        assertFalse(StudentAge.contains(35), "The invalid age should not be added to the list.");
    }
}
