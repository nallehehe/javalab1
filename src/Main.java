import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int userInput = 0;

        //bestämde mig för att skapa en meny klass som höll alla meny val och annat så min kod var lättare läst
        Menu menu = new Menu();

        double accountBalance = 100000;

        while (true)
        {
            //https://stackoverflow.com/questions/69568202/how-to-prevent-the-programm-for-crashing-because-of-a-wrong-input
            /*en try catch för enkel felhantering så programmet inte kraschar när fel input skrivs in men även ber användaren skriva in
            vad som krävs för att använda programmet*/
            try {
                //
                menu.managerMenu();

                userInput = scanner.nextInt();

                /*första funktionen där en int array skapas med en storlek baserat på vad användaren har matat in för siffra
                  som används i både första och tredje funktionen*/
                if (userInput == 1){
                    menu.EmployeeMenu();
                    userInput = scanner.nextInt();
                    double tax = 0.70;

                    int[] arr = new int[userInput];

                    /*går igenom int arrayen och ber användaren mata in vad för lön varje anställd ska ha
                      och då sparar varje den inmatade siffran i varje index position tills alla är fyllda*/
                    for (int i = 0; i < userInput; i++) {
                        System.out.println("Employee #" + (i + 1) + " salary: ");
                        arr[i] = scanner.nextInt();
                    }

                    /*går nu igenom den infyllda arrayen där man ser vilken anställd som fick betalt vad för och efter skatt*/
                    System.out.println("You have now paid: ");
                    for (int i = 0; i < userInput; i++) {
                        System.out.print("Employee #" + (i + 1) + " - Before tax: " + arr[i] + " kr" + " After tax: " + (arr[i] * tax) + " kr\n");
                    }
                }

                /*andra funktionen påverkar då den redan satta kontobalansen i början av programmet
                  där programmet frågar om hur mycket fakturan kostar och då används (+=) operatorn
                  för att plussa på vad användaren matat in efter momsen och tillslut visar vad den totala summan är
                  totala momsen, nettosumman och vad kontobalansen blir efteråt*/
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

                    /*den tredje funktionen använder två arrays utav sig, en int och en boolean som
                      tar in den inmatade siffran och skapar sin storlek efter den

                      varför använde jag mig utav två arrays?

                      jag ville bara ha ett sätt att kunna separera vad som gick igenom mitt if-villkor
                      och vad som inte gjorde det för med endast en array verkade det inte möjligt (vad jag vet och google vet)
                      det är främst bara ett estetiskt val och hur jag personligen tänker att ett program
                      hade fungerat där de separerar det som lyckades och det som olyckades*/

                    int[] arr = new int [userInput];
                    boolean[] successfulPayment = new boolean [userInput];

                    /*denna for-loopen liknar lite den första funktionens for-loop där jag vill gå igenom
                      alla element i arrayen men nu eftersom jag behöver även tänka på kontobalansen så
                      räknar jag redan ut vad varje element faktiskt blir efter man tagit ur momsen
                      och sen använder mig utav (-=) för att minusa kontobalansen det som faktiskt går igenom
                      mitt if villkor*/

                    System.out.println("Total account balance: " + accountBalance + " kr");
                    for (int i = 0; i < userInput; i++) {

                        System.out.println("Invoice #" + (i + 1) + " payment: ");
                        arr[i] = scanner.nextInt();

                        double afterVat = arr[i] * invoiceVat;

                        /*här använder jag mig utav boolean arrayen med hjälp av min if där
                          de siffror som går igenom mitt if-villkor blir satta till sanna men
                          alla siffror som är större än kontobalansen efter momsen blir satta till false
                          och får en print som säger om det finns tillräckligt med pengar för den fakturan eller inte*/
                        if (accountBalance >= afterVat) {
                            accountBalance -= afterVat;
                            successfulPayment[i] = true;
                        }
                        else {
                            successfulPayment[i] = false;
                            System.out.println("There are not sufficient enough funds to pay for invoice #" + (i + 1) + ".");
                        }
                    }

                    /*denna for-loopen går då igenom arrayen med ett if-villkor som kollar alla element som blev
                      satta till true och då skriver ut vad som faktiskt gick igenom det tidigare if-villkoret
                      med faktura numret, före och efter moms och sen den totala kontobalansen efter allt*/
                    System.out.println("You have now paid: ");
                    for (int i = 0; i < userInput; i++) {
                        if (successfulPayment[i]) {
                            System.out.print("Invoice #" + (i + 1) + " - Before VAT: " + arr[i] + " kr" + " After VAT: " + (arr[i] * invoiceVat) + " kr\n");
                        }
                    }
                    System.out.println("Total account balance: " + (accountBalance) + " kr");
                }

                //avslutar programmet så man inte är fast
                else if (userInput == 4){
                    break;
                }

                else {
                    System.out.println("Input a number between 1-4.");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Not a valid input, try again.");
                scanner.next();
            }
        }
    }
}