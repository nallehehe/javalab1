import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int userInput = 0;

        Menu menu = new Menu();

        double accountBalance = 100000;

        boolean payment = false;

        while (true)
        {
            //https://stackoverflow.com/questions/69568202/how-to-prevent-the-programm-for-crashing-because-of-a-wrong-input
            try {
                menu.managerMenu();

                userInput = scanner.nextInt();

                if (userInput == 1){
                    System.out.println("Total account balance: " + accountBalance + " kr");
                    menu.EmployeeMenu();
                    userInput = scanner.nextInt();
                    double tax = 0.70;

                    int[] arr = new int[userInput];

                    for (int i = 0; i < userInput; i++) {
                        System.out.println("Employee #" + (i + 1) + " salary: ");
                        arr[i] = scanner.nextInt();
                    }

                    System.out.println("You have now paid: ");
                    System.out.println("Total account balance: " + accountBalance);
                    for (int i = 0; i < userInput; i++) {
                        System.out.print("Employee #" + (i + 1) + " - Before tax: " + arr[i] + " kr" + " After tax: " + (arr[i] * tax) + " kr\n");
                    }
                }
                else if (userInput == 2) {
                    menu.invoiceCreator();
                    userInput = scanner.nextInt();

                    double vat = userInput * 0.25;
                    double afterTax = userInput - vat;

                    accountBalance += afterTax;

                    System.out.println("Total sum: " + userInput + " kr \n" + "Total VAT: " + (vat) + " kr" + "\nNet amount: " + (afterTax) + " kr" + "\nTotal account balance: " + accountBalance + " kr");
                }

                else if (userInput == 3){
                    System.out.println("Total account balance: " + accountBalance + " kr");
                    menu.invoicePayer();
                    userInput = scanner.nextInt();

                    double invoiceVat = 0.75;

                    int[] arr = new int [userInput];
                    boolean[] successfulPayment = new boolean [userInput];

                    System.out.println("Total account balance: " + accountBalance + " kr");
                    for (int i = 0; i < userInput; i++) {

                        System.out.println("Invoice #" + (i + 1) + " payment: ");
                        arr[i] = scanner.nextInt();

                        double afterVat = arr[i] * invoiceVat;

                        if (accountBalance >= afterVat) {
                            accountBalance -= afterVat;
                            successfulPayment[i] = true;
                        }
                        else {
                            successfulPayment[i] = false;
                            System.out.println("There are not sufficient enough funds to pay for invoice #" + (i + 1) + ".");
                        }
                    }

                    if (payment = true) {
                        System.out.println("You have now paid: ");
                        for (int i = 0; i < userInput; i++) {
                            if (successfulPayment[i]) {
                                System.out.print("Invoice #" + (i + 1) + " - Before tax: " + arr[i] + " kr" + " After tax: " + (arr[i] * invoiceVat) + " kr\n");
                            }
                        }
                        System.out.println("Total account balance: " + (accountBalance) + " kr");
                    }
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