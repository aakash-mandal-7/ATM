import java.util.HashMap;
import java.util.Scanner;

class Account {
        private String accountNumber;
        private String accountHolderName;
        private double balance;

        public Account(String accountNumber, String accountHolderName) {
            this.accountNumber = accountNumber;
            this.accountHolderName = accountHolderName;
            this.balance = 1000;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getAccountHolderName() {
            return accountHolderName;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 50) {
                balance += amount;
                System.out.println("Deposited: " + amount);
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        }

        public void withdraw(double amount) {
            if (amount > 50 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdraw: " + amount);
            } else {
                System.out.println("Insufficient funds or invalid amount.");
            }
        }
    }

    class BankingSystem {
        private HashMap<String, Account> accounts = new HashMap<>();

        public void createAccount(String accountNumber, String accountHolderName) {
            if (accounts.containsKey(accountNumber)) {
                System.out.println("Account already exists.");
            } else {
                accounts.put(accountNumber, new Account(accountNumber, accountHolderName));
                System.out.println("Account created successfully.");
            }
        }

        public Account getAccount(String accountNumber) {
            return accounts.get(accountNumber);
        }
    }

    public class ATMMachine {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            BankingSystem bankingSystem = new BankingSystem();

            while (true) {
                System.out.println("Welcome to the Online Banking System");
                System.out.println("1. Create Account");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Check Balance");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter account number: ");
                        String accountNumber = scanner.nextLine();
                        System.out.print("Enter account holder name: ");
                        String accountHolderName = scanner.nextLine();
                        bankingSystem.createAccount(accountNumber, accountHolderName);
                        break;

                    case 2:
                        System.out.print("Enter account number: ");
                        accountNumber = scanner.nextLine();
                        Account depositAccount = bankingSystem.getAccount(accountNumber);
                        if (depositAccount != null) {
                            System.out.print("Enter amount to deposit: ");
                            double depositAmount = scanner.nextDouble();
                            depositAccount.deposit(depositAmount);
                        } else {
                            System.out.println("Account not found.");
                        }
                        break;

                    case 3:
                        System.out.print("Enter account number: ");
                        accountNumber = scanner.nextLine();
                        Account withdrawAccount = bankingSystem.getAccount(accountNumber);
                        if (withdrawAccount != null) {
                            System.out.print("Enter amount to withdraw: ");
                            double withdrawAmount = scanner.nextDouble();
                            withdrawAccount.withdraw(withdrawAmount);
                        } else {
                            System.out.println("Account not found.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter account number: ");
                        accountNumber = scanner.nextLine();
                        Account balanceAccount = bankingSystem.getAccount(accountNumber);
                        if (balanceAccount != null) {
                            System.out.println("Current balance: " + balanceAccount.getBalance());
                        } else {
                            System.out.println("Account not found.");
                        }
                        break;

                    case 5:
                        System.out.println("Exiting the system.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
}

