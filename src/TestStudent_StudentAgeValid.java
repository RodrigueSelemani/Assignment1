import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TestStudentAge {

    private ArrayList<Integer> StudentAge;

    @BeforeEach
    public void setUp() {
        StudentAge = new ArrayList<>();
    }

    @Test
    void testStudent_studentAgeValid() {
        // Simulate input for valid age
        String input = "20\n";
        Scanner scanner = new Scanner(input);

        boolean correctAge = false;
        int StudAge = 0;

        while (!correctAge) {
            System.out.println("Enter the Student Age:");
            StudAge = scanner.nextInt();
            scanner.nextLine();

            if (StudAge < 16 || StudAge > 30) {
                System.out.println("Invalid age, please try again. Age should be between 16 and 30.");
            } else {
                correctAge = true;
            }
        }

        // Once the age is validated, add it to the list
        StudentAge.add(StudAge);

        // Validate if the age is correctly added
        assertTrue(StudentAge.contains(20), "The valid age should be added to the list.");
    }
}
