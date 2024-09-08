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

                double accountBalance = 100000;

                userInput = scanner.nextInt();

                if (userInput == 1){
                    menu.EmployeeMenu();
                    userInput = scanner.nextInt();
                    double tax = 0.70;

                    int[] arr = new int[userInput];

                    for (int i = 0; i < userInput; i++) {
                        System.out.println("Employee #" + (i + 1) + " salary: ");
                        arr[i] = scanner.nextInt();
                    }

                    System.out.println("You have now paid: ");
                    for (int i = 0; i < userInput; i++) {
                        System.out.print("Employee #" + (i + 1) + ": Before tax: " + arr[i] + " kr " + "After tax: " + (arr[i] * tax) + " kr\n");
                    }
                }
                else if (userInput == 2) {
                    menu.invoiceCreator();
                    userInput = scanner.nextInt();

                    double vat = userInput * 0.25;
                    double afterTax = userInput - vat;
                    double addToBalance = afterTax + accountBalance;

                    System.out.println("Total sum: " + userInput + " kr \n" + "Total VAT: " + (vat) + " kr" + "\nNet amount: " + (afterTax) + " kr" + "\nTotal account balance: " + addToBalance + " kr");
                }

                else if (userInput == 3){

                }

                else if (userInput == 4){
                    break;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Not a valid input, try again.");
                scanner.next();
            }
        }
    }
}