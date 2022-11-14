import java.util.Scanner;

public class Account {
    //variables for account
    String customerName;
    String customerId;
    Scanner input = new Scanner(System.in);
    String option = "";
    double balance;
    double currentTransamt;

    Account(String cname, String cusID){
        this.customerName = cname;
        this.customerId = cusID;
    }

    public void deposit(double depoAmt){
        balance += depoAmt;
        currentTransamt = depoAmt;
    }

    public void withdraw(double withAmt){
        balance -= withAmt;
        currentTransamt = -withAmt;
    }

    public void calculateInterest(int years){
        double interest = 0.185;
        double newBalance = (balance * interest * years) + balance;
        System.out.println("\nThe current interest rate is: " + interest*100 + "%\n");
        System.out.println("Your balance after " + years + " years is " + newBalance + "\n");
    }
    public void clearScreen(){
        System.out.print("Press enter to continue...");
        option = input.nextLine();
        System.out.print("\033[H\033[2J");  
        System.out.flush();   
    }

    public void showMenu(){
        do{
        System.out.println("Welcome " + customerName+ "!");
        System.out.println("Your ID  is: " + customerId + "\n");
        System.out.println("What would you like to do?\n");
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit\n");
        
            System.out.print("Enter an option: ");
            option = input.nextLine();
            
            

            switch (option.toUpperCase()){
                case "A":

                System.out.println("\n========================");
                System.out.println("Balance = $" + balance);
                System.out.println("========================\n");
                clearScreen();
                break;

                case "B":
                System.out.print("Enter an amount to deposit: ");
                try {
                    double depoAmt = Double.parseDouble(input.nextLine());
                    deposit(depoAmt);
                    System.out.println("\n$" + depoAmt + " has been deposited to your account.\n");
                    clearScreen();
                } catch (Exception e) {
                    System.out.println("\nInvalid input try again\n");
                    clearScreen();
                }
                break;

                case "C":
                System.out.print("Enter an amount to withdraw: ");
                try {
                    double withAmt = Double.parseDouble(input.nextLine());
                    withdraw(withAmt);
                    System.out.println("\n$" + withAmt + " has been withdrawn to your account.\n");
                    System.out.println("Remaining balance: $"+ balance + "\n");
                    clearScreen();   
                } catch (Exception e) {
                    System.out.println("\nInvalid input try again\n");
                    clearScreen();
                }
                break;

                case "D":
                if(currentTransamt < 0){
                    System.out.println("\nAmount Withdrawn: " + -(currentTransamt) + "\n");
                    clearScreen();
                }
                else if(currentTransamt > 0){
                    System.out.println("\nAmount Deposited: " + currentTransamt + "\n");
                    clearScreen();
                }
                else{
                    System.out.println("\nNo transactions yet\n");
                    clearScreen();
                }
                break;

                case "E":
                System.out.print("Enter a number of years: ");
                try {
                    int years = Integer.parseInt(input.nextLine());
                    calculateInterest(years);
                    clearScreen();  
                } catch (Exception e) {
                    System.out.println("\nInvalid input try again\n");
                    clearScreen();
                }
                break;

                case "F":
                System.out.println("\nThank you for banking with us");
                break;

                default:
                System.out.println("Invalid option. Try Again.\n");
                break;
            }
        }while(!option.equalsIgnoreCase("F"));
    }
}
