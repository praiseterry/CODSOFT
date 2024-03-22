import java.util.Scanner;

class BankAccount {
    private int balance;

    // Constructor to initialize the bank account with an initial amount
    public BankAccount(int initialAmount) {
        this.balance = initialAmount;
    }

    // Method to return the current balance
    public int balance() {
        return balance;
    }

    // Method to deposit money into the account
    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of " + amount + "Rs was successful");
        } else {
            System.out.println("Invalid entry! Please choose a number above 0");
        }
    }

    // Method to withdraw money from the account
    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of " + amount + "Rs was successful");
        } else {
            System.out.println("Invalid entry!! Insufficient balance or negative value entered");
        }
    }
}

class ATM {
    private BankAccount account;

    // Constructor to initialize ATM with a bank account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Method to display ATM options
    public void display() {
        System.out.println("Select Options:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Leave");
    }

    // Method to run the ATM interface
    public void run() {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            display();
            System.out.println("Pick an option:");
            option = sc.nextInt();
            
            switch (option) {
                case 1:
                    System.out.println("Enter amount to deposit:");
                    int depositAmount = sc.nextInt();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw:");
                    int withdrawAmount = sc.nextInt();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current balance: " + account.balance());
                    break;
                case 4:
                    System.out.println("Thanks for banking with us!");
                    break;
                default:
                    System.out.println("Invalid entry! Please enter only the given options.");   
            }
        } while (option != 4);
        sc.close();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount userAccount = new BankAccount(30000);
        ATM atm = new ATM(userAccount);
        System.out.println("Welcome to Jain Bank ATM");
        System.out.println("Enter Your PIN:");
        String pin = sc.nextLine();
        if (pin.equals("1234")) {
            atm.run();
        } else {
            System.out.println("Wrong PIN!");
        }
        sc.close();
    }
}
