package codsoft.tasks;

import java.util.Scanner;

public class ATMInterface {
    private double balance;

    public ATMInterface(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Deposited: ₹" + amount);
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("✅ Withdrawn: ₹" + amount);
        } else {
            System.out.println("❌ Insufficient balance or invalid amount.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATMInterface atm = new ATMInterface(1000); // starting balance ₹1000

        int choice;
        do {
            System.out.println("\n==== ATM Menu ====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose option (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("💰 Balance: ₹" + atm.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("🔒 Exiting ATM. Thank you!");
                    break;
                default:
                    System.out.println("❌ Invalid option. Try again.");
            }

        } while (choice != 4);

        scanner.close();
    }
}
