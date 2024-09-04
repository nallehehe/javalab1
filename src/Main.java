import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int userInput = 0;

        Menu menu = new Menu();



        while (true)
        {
            //https://stackoverflow.com/questions/69568202/how-to-prevent-the-programm-for-crashing-because-of-a-wrong-input
            try {
                menu.managerMenu();

                userInput = scanner.nextInt();

                if (userInput == 1){
                    menu.EmployeeMenu();
                    userInput = scanner.nextInt();

                    int[] arr = new int[userInput];

                    for (int i = 0; i < userInput; i++) {
                        System.out.println("Employee #" + (i + 1) + " salary: ");
                        arr[i] = scanner.nextInt();
                    }

                    System.out.println("You have now paid: ");
                    for (int i = 0; i < userInput; i++) {
                        System.out.print("Employee #" + (i + 1) + ": " + arr[i] + " kr\n");
                    }
                }
                else if (userInput == 2) {

                }

                else if (userInput == 3){

                }

                else if (userInput == 4){
                    break;
                }

                else {
                    System.out.println("Invalid input. Enter 1, 2, 3 or 4.");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("ERROR: not a number, try again.");
                scanner.next();
            }
        }
    }
}