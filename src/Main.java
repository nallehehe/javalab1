import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int userInput = 0;

        Menu menu = new Menu();


        while (true){

            menu.managerMenu();

            userInput = scanner.nextInt();

            if (userInput == 1){
                
            }
            else if (userInput == 2) {
                int[] employeeSalary;

                menu.invoiceCreator();

                userInput = scanner.nextInt();
            }

            else if (userInput == 3){

            }

            else if (userInput == 4){
                break;
            }
        }
    }
}