package src;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Client {
  public static void main(String args[]) {
    Scanner mainOptionSc = new Scanner(System.in);

    // Handle the save accounts.
    ArrayList<SavingsAccount> sAccountList = new ArrayList<SavingsAccount>();

    // Variables needed.
    int mainOption;
    boolean invalidMainInput = false;

    while (true) {
      // Testing.
      System.out.println(sAccountList);

      // Show the app description and options.
      Client.addNewline();
      Client.displayMainMenu();

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

      // Update the view.
      Client.addNewline();
      if (mainOption == 1) {
        sAccountList.add(Client.option1());
      }
    }
  }

  // Display the options.
  static void displayMainMenu() {
    System.out.println("\t-------------------------------");
    System.out.println("\t\tBank Main Menu");
    System.out.println("\t-------------------------------");
    Client.addNewline();

    // Options.
    System.out.println("\t[ 1 ] New Account");
    System.out.println("\t[ 2 ] Balance Inquiry");
    System.out.println("\t[ 3 ] Deposit");
    System.out.println("\t[ 4 ] Withdraw");
    System.out.println("\t[ 5 ] Client Profile");
    System.out.println("\t[ 6 ] Close Account");
    System.out.println("\t[ 7 ] Exit");
  }

  // New account handler.
  static SavingsAccount option1() {
    // Input handler.
    Scanner sc = new Scanner(System.in);

    // For generating random number.
    Random random = new Random();
    String generateNumber = String.format("%04d", random.nextInt(10000));

    // Check error checker.
    boolean hasError = false;

    // Necessary variables in creating a new account.
    String accountName;
    String address;
    String birthday;
    String contactNumber;
    double balance;
    int accountNumber = Integer.valueOf(generateNumber);

    while (true) {
      try {
        // Display the description.
        System.out.println("\t-------------------------------");
        System.out.println("\t\tCreate New Account");
        System.out.println("\t-------------------------------");
        Client.addNewline();

        // Display error message;
        if (hasError) {
          System.out.println("\tInvalid input. Please try again.");
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

        // Ask the balance amount.
        System.out.print("\tBalance: ");
        balance = sc.nextDouble();

        // If no errors break the loop.
        hasError = false;
        break;
      } catch (InputMismatchException e) {
        hasError = true;
        sc.nextLine();
        continue;
      }
    }

    // Create an instance of a savings account.
    SavingsAccount sAccount = new SavingsAccount(
        accountName, address, birthday, contactNumber, accountNumber, balance);

    // Return value.
    return sAccount;
  }

  // Method to add a new line.
  static void addNewline() { System.out.println(); }
}
