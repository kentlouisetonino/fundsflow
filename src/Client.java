package src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Client {
  public static void main(String args[]) {
    // Handler for inputs.
    Scanner mainOptionSc = new Scanner(System.in);

    // Handle the save accounts.
    ArrayList<SavingsAccount> sAccountList = new ArrayList<SavingsAccount>();

    // Variables needed.
    int mainOption;
    boolean invalidMainInput = false;

    while (true) {
      // Cleanup the terminal.
      Client.clearTerminal();
      Client.addNewline();
      Client.addNewline();
      Client.addNewline();

      // TODO: Remove this testing once features are completed.
      for (int i = 0; i < sAccountList.size(); i++) {
        System.out.println(sAccountList.get(i).getAccountNumber());
      }

      // Show the app description and options.
      Client.displayMainMenu(sAccountList.size() > 0);

      // Show error description.
      if (invalidMainInput) {
        Client.addNewline();
        System.out.println("\tInvalid input, please try again.");
      }

      try {
        // Ask the option.
        Client.addNewline();
        System.out.print("\tInput option: ");
        mainOption = mainOptionSc.nextInt();
        invalidMainInput = false;
      } catch (InputMismatchException e) {
        invalidMainInput = true;
        mainOptionSc.next();
        continue;
      }

      // Exit right away.
      if (mainOption == 2 && sAccountList.isEmpty()) {
        Client.clearTerminal();
        break;
      }

      // Add new account.
      if (mainOption == 1) {
        SavingsAccount addedAccount = Client.option1();
        sAccountList.add(addedAccount);
      }

      // Deposit money.
      if (mainOption == 2) {
        Client.option2(sAccountList);
      }

      // Balance inquiry.
      if (mainOption == 3) {
        Client.option3(sAccountList);
      }

      // Withdraw money.
      if (mainOption == 4) {
        Client.option4(sAccountList);
      }

      // Exit application.
      if (mainOption == 7) {
        Client.clearTerminal();
        break;
      }
    }
  }

  // New account handler.
  static SavingsAccount option1() {
    // Input handler.
    Scanner sc = new Scanner(System.in);

    // For generating random number.
    Random random = new Random();
    String generateNumber = String.format("%04d", random.nextInt(10000));

    // Error checker.
    boolean hasError = false;
    boolean invalidInitialDeposit = false;

    // Necessary variables in creating a new account.
    String accountName;
    String address;
    String birthday;
    String contactNumber;
    double initialDeposit;
    int accountNumber = Integer.valueOf(generateNumber);

    while (true) {
      try {
        // Cleanup the terminal.
        Client.clearTerminal();
        Client.addNewline();
        Client.addNewline();
        Client.addNewline();

        // Display the description.
        System.out.println("\t-------------------------------");
        System.out.println("\t\tCreate New Account");
        System.out.println("\t-------------------------------");

        // Display error message;
        if (hasError) {
          Client.addNewline();
          System.out.println("\t* Invalid input. Please try again. *");
        }

        // Error message for deposit problem.
        if (invalidInitialDeposit) {
          Client.addNewline();
          System.out.println("\t* Deposit should be >= to 5000. *");
        }

        // Generate account number.
        Client.addNewline();
        System.out.println("\tAccount Number: " + accountNumber);

        // Ask the name.
        System.out.print("\tAccount Name: ");
        accountName = sc.nextLine();

        // Ask the address.
        System.out.print("\tAccount Address: ");
        address = sc.nextLine();

        // Ask the birthday.
        System.out.print("\tBirthday (yyyy/MM/DD): ");
        birthday = sc.nextLine();

        // Ask the contact number.
        System.out.print("\tContact Number: ");
        contactNumber = sc.nextLine();

        // Ask the deposit amount.
        System.out.print("\tInitial Deposit: ");
        initialDeposit = sc.nextDouble();

        if (initialDeposit < 5000) {
          invalidInitialDeposit = true;
          sc.nextLine();
          continue;
        }

        // If no errors break the loop.
        hasError = false;
        invalidInitialDeposit = false;
        break;
      } catch (InputMismatchException e) {
        hasError = true;
        sc.nextLine();
        continue;
      }
    }

    // Create an instance of a savings account.
    SavingsAccount sAccount =
        new SavingsAccount(accountName, address, birthday, contactNumber,
                           accountNumber, initialDeposit);

    // Return value.
    return sAccount;
  }

  // This method will handle the adding of new account.
  static void option2(ArrayList<SavingsAccount> sAccounts) {
    // Input handler.
    Scanner sc = new Scanner(System.in);

    // Error checker.
    boolean hasError = false;
    boolean notFound = false;

    // Check if want inquire other account.
    String tryAgain;

    // Variables needed.
    SavingsAccount savingsAccount = null;
    int accountNumber;

    while (true) {
      try {
        // Cleanup the terminal.
        Client.clearTerminal();
        Client.addNewline();
        Client.addNewline();
        Client.addNewline();

        // Display the description.
        System.out.println("\t-------------------------------");
        System.out.println("\t\tBalance Inquiry");
        System.out.println("\t-------------------------------");

        // Check if account number exist.
        if (notFound) {
          Client.addNewline();
          System.out.println("\t* Account number not found. *");
        }

        // Check if there is an error in previous input.
        if (hasError) {
          Client.addNewline();
          System.out.println("\t* Invalid account number. *");
        }

        // Ask the account number.
        Client.addNewline();
        System.out.print("\tEnter account number: ");
        accountNumber = sc.nextInt();

        // Check the account.
        for (int i = 0; i < sAccounts.size(); i++) {
          if (sAccounts.get(i).getAccountNumber() == accountNumber) {
            savingsAccount = sAccounts.get(i);
          }
        }

        // Check if savings account is null.
        if (savingsAccount == null) {
          notFound = true;
          hasError = false;
          accountNumber = 0;
          sc.nextLine();
          continue;
        }

        // If not null, display the savings account information.
        String accountName = savingsAccount.getAccountName();
        double currentBalance = savingsAccount.balanceInquiry();
        System.out.println("\tAccount Name: " + accountName);
        System.out.println("\tCurrent Balance: " + currentBalance);

        // Ask if want to check another account.
        Client.addNewline();
        System.out.print("\tCheck different account (y/n): ");
        tryAgain = sc.next();

        // Handle the response.
        if (tryAgain.contains("y")) {
          notFound = false;
          hasError = false;
          accountNumber = 0;
          savingsAccount = null;
          sc.nextLine();
          continue;
        } else {
          break;
        }

      } catch (InputMismatchException e) {
        hasError = true;
        sc.nextLine();
        continue;
      }
    }
  }

  // This method will handle the deposit.
  static void option3(ArrayList<SavingsAccount> sAccounts) {
    // Input handler.
    Scanner sc = new Scanner(System.in);

    // Error checker.
    boolean hasError = false;
    boolean notFound = false;

    // Check if want inquire other account.
    String tryAgain;

    // Variables needed.
    SavingsAccount savingsAccount = null;
    int accountNumber;
    double deposit;

    while (true) {
      try {
        // Cleanup the terminal.
        Client.clearTerminal();
        Client.addNewline();
        Client.addNewline();
        Client.addNewline();

        // Display the description.
        System.out.println("\t-------------------------------");
        System.out.println("\t\t"
                           + "     "
                           + "Deposit");
        System.out.println("\t-------------------------------");

        // Check if account number exist.
        if (notFound) {
          Client.addNewline();
          System.out.println("\t* Account number not found. *");
        }

        // Check if there is an error in previous input.
        if (hasError) {
          Client.addNewline();
          System.out.println("\t* Invalid account number. *");
        }

        // Ask the account number.
        Client.addNewline();
        System.out.print("\tEnter account number: ");
        accountNumber = sc.nextInt();

        // Check the account.
        for (int i = 0; i < sAccounts.size(); i++) {
          if (sAccounts.get(i).getAccountNumber() == accountNumber) {
            savingsAccount = sAccounts.get(i);
          }
        }

        // Check if savings account is null.
        if (savingsAccount == null) {
          notFound = true;
          hasError = false;
          accountNumber = 0;
          sc.nextLine();
          continue;
        }

        // Ask the deposit amount.
        System.out.print("\tDeposit amount: ");
        deposit = sc.nextDouble();

        // Save the new balance.
        // Save the new interest rate.
        double currentBalance = savingsAccount.getBalance();
        double newBalance = currentBalance + deposit;
        double newInterestRate = newBalance * 0.05;
        savingsAccount.setBalance(newBalance);
        savingsAccount.setInterestRate(newInterestRate);

        // If not null, display the savings account information.
        String accountName = savingsAccount.getAccountName();
        double balanceInquiry = savingsAccount.balanceInquiry();
        System.out.println("\tAccount Name: " + accountName);
        System.out.println("\tNew Balance: " + balanceInquiry);

        // Ask if want to check another account.
        Client.addNewline();
        System.out.print("\tDeposit again (y/n): ");
        tryAgain = sc.next();

        // Handle the response.
        if (tryAgain.contains("y")) {
          notFound = false;
          hasError = false;
          accountNumber = 0;
          savingsAccount = null;
          sc.nextLine();
          continue;
        } else {
          break;
        }

      } catch (InputMismatchException e) {
        hasError = true;
        sc.nextLine();
        continue;
      }
    }
  }

  // This method will handle the withdraw.
  static void option4(ArrayList<SavingsAccount> sAccounts) {
    // Input handler.
    Scanner sc = new Scanner(System.in);

    // Error checker.
    boolean hasError = false;
    boolean notFound = false;
    boolean invalidAmount = false;
    boolean invalidBalance = false;

    // Check if want inquire other account.
    String tryAgain;

    // Variables needed.
    SavingsAccount savingsAccount = null;
    int accountNumber;
    double withdraw;

    while (true) {
      try {
        // Cleanup the terminal.
        Client.clearTerminal();
        Client.addNewline();
        Client.addNewline();
        Client.addNewline();

        // Display the description.
        System.out.println("\t-------------------------------");
        System.out.println("\t\t"
                           + "    "
                           + "Withdraw");
        System.out.println("\t-------------------------------");

        // Check if account number exist.
        if (notFound) {
          Client.addNewline();
          System.out.println("\t* Account number not found. *");
        }

        // Check if there is an error in previous input.
        if (hasError) {
          Client.addNewline();
          System.out.println("\t* Invalid account number. *");
        }

        // If amount withdrawn is invalid.
        if (invalidAmount) {
          Client.addNewline();
          System.out.println("\t* Invalid (amount >= 100). *");
        }

        // Check if invalid final balance.
        // Should be greater than or equal to 5000.
        if (invalidBalance) {
          Client.addNewline();
          System.out.println("\t* Invalid (balance >= 5000). *");
        }

        // Ask the account number.
        Client.addNewline();
        System.out.print("\tEnter account number: ");
        accountNumber = sc.nextInt();

        // Check the account.
        for (int i = 0; i < sAccounts.size(); i++) {
          if (sAccounts.get(i).getAccountNumber() == accountNumber) {
            savingsAccount = sAccounts.get(i);
          }
        }

        // Check if savings account is null.
        if (savingsAccount == null) {
          notFound = true;
          hasError = false;
          invalidAmount = false;
          invalidBalance = false;
          accountNumber = 0;
          sc.nextLine();
          continue;
        }

        // Ask the deposit amount.
        System.out.print("\tWithdraw amount: ");
        withdraw = sc.nextDouble();

        // Make sure the withdrawn amount is not less than 100.
        if (withdraw < 100) {
          notFound = false;
          hasError = false;
          invalidAmount = true;
          invalidBalance = false;
          accountNumber = 0;
          sc.nextLine();
          continue;
        }

        // Double check the maintaining balance.
        // Should be not less than 5000.
        double currentBalance = savingsAccount.getBalance();
        double newBalance = currentBalance - withdraw;
        if (newBalance < 5000) {
          notFound = false;
          hasError = false;
          invalidAmount = false;
          invalidBalance = true;
          accountNumber = 0;
          sc.nextLine();
          continue;
        }

        // Save the new balance.
        // Save the new interest rate.
        double newInterestRate = newBalance * 0.05;
        savingsAccount.setBalance(newBalance);
        savingsAccount.setInterestRate(newInterestRate);

        // If not null, display the savings account information.
        String accountName = savingsAccount.getAccountName();
        double balanceInquiry = savingsAccount.balanceInquiry();
        System.out.println("\tAccount Name: " + accountName);
        System.out.println("\tNew Balance: " + balanceInquiry);

        // Ask if want to check another account.
        Client.addNewline();
        System.out.print("\tWithdraw amount again (y/n): ");
        tryAgain = sc.next();

        // Handle the response.
        if (tryAgain.contains("y")) {
          notFound = false;
          hasError = false;
          invalidAmount = false;
          invalidBalance = false;
          accountNumber = 0;
          savingsAccount = null;
          sc.nextLine();
          continue;
        } else {
          break;
        }
      } catch (InputMismatchException e) {
        notFound = false;
        hasError = true;
        invalidAmount = false;
        invalidBalance = false;
        accountNumber = 0;
        savingsAccount = null;
        sc.nextLine();
        continue;
      }
    }
  }

  // Display the options.
  static void displayMainMenu(boolean hasAccounts) {
    System.out.println("\t-------------------------------");
    System.out.println("\t\tBank Main Menu");
    System.out.println("\t-------------------------------");
    Client.addNewline();

    // Options.
    System.out.println("\t[ 1 ] New Account");

    // Show only if accounts array is not empty.
    if (hasAccounts) {
      System.out.println("\t[ 2 ] Balance Inquiry");
      System.out.println("\t[ 3 ] Deposit");
      System.out.println("\t[ 4 ] Withdraw");
      System.out.println("\t[ 5 ] Client Profile");
      System.out.println("\t[ 6 ] Close Account");
      System.out.println("\t[ 7 ] Exit");
    } else {
      System.out.println("\t[ 2 ] Exit");
    }
  }

  // Method to add a new line.
  static void addNewline() { System.out.println(); }

  // Clean up the screen.
  static void clearTerminal() {
    try {
      String os = System.getProperty("os.name").toLowerCase();

      if (os.contains("windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
        // For Linux, macOS, and other Unix-like systems.
        System.out.print("\033[H\033[2J");
        System.out.flush();
      }
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }
}
