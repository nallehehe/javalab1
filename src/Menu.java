public class Menu {
    public void managerMenu(){
        System.out.println("[1] - Pay employees");
        System.out.println("[2] - Create invoice");
        System.out.println("[3] - Pay one or more invoices");
        System.out.println("[4] - Exit");
    }

    public void EmployeeMenu(){
        System.out.println("How many employees would you like to pay?");
    }

    public void invoiceCreator(){
        System.out.println("What's the total sum of the new invoice?");
    }

    public void invoicePayer() {
        System.out.println("How many invoices would you like to pay?");
    }
}
