import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TestStudent_StudentAgeInvalidNotANumber {

    private ArrayList<Integer> StudentAge;

    @BeforeEach
    public void setUp() {
        StudentAge = new ArrayList<>();
    }

    @Test
    void testStudent_studentAgeInvalidNotANumber() {
        // Simulate input that is not a number
        String input = "abc\n"; // Invalid non-numeric input
        Scanner scanner = new Scanner(input);

        boolean correctAge = false;
        int StudAge = 0;

        while (!correctAge) {
            System.out.println("Enter the Student Age:");
            if (scanner.hasNextInt()) {
                StudAge = scanner.nextInt();
                scanner.nextLine();

                if (StudAge < 16 || StudAge > 30) {
                    System.out.println("Invalid age, please try again. Age should be between 16 and 30.");
                } else {
                    correctAge = true;
                    // Add valid age to the list
                    StudentAge.add(StudAge);
                }
            } else {
                // Non-numeric input, skip invalid input
                System.out.println("Invalid input, please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }

        // Since the input was not a number, nothing should be added to the list
        assertTrue(StudentAge.isEmpty(), "No age should be added if input is not a number.");
    }
}
