import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds");
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void displayOptions() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        Scanner scanner = new Scanner(System.in);
        double amount;

        switch (option) {
            case 1:
                System.out.print("Enter withdrawal amount: ");
                amount = scanner.nextDouble();
                if (userAccount.withdraw(amount)) {
                    System.out.println("Withdrawal successful. Remaining balance: " + userAccount.getBalance());
                }
                break;

            case 2:
                System.out.print("Enter deposit amount: ");
                amount = scanner.nextDouble();
                userAccount.deposit(amount);
                System.out.println("Deposit successful. New balance: " + userAccount.getBalance());
                break;

            case 3:
                System.out.println("Current balance: " + userAccount.getBalance());
                break;

            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }
}

public class ATM_INTERFACE {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000);

        ATM atm = new ATM(userAccount);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            atm.displayOptions();
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            atm.processOption(option);
        }
    }
}
