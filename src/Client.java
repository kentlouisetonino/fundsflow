package src;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Client {
  public static void main(String args[]) {
    Scanner mainOptionSc = new Scanner(System.in);

    // Handle the save accounts.
    SavingsAccount savingsAccount[] = new SavingsAccount[100];

    // Variables needed.
    int mainOption;
    boolean invalidMainInput = false;

    while (true) {
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
        Client.option1();
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
  static void option1() {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    // Necessary variables in creating a new account.
    String accountName;
    String address;
    String birthday;
    String contactNumber;
    double balance;

    // Display the description.
    System.out.println("\t-------------------------------");
    System.out.println("\t\tCreate New Account");
    System.out.println("\t-------------------------------");
    Client.addNewline();

    // Generate account number.
    String id = String.format("%04d", random.nextInt(10000));
    System.out.println("\tAccount Number: " + id);

    // Ask the name.
    System.out.print("\tAccount Name: ");
    accountName = sc.next();

    // Ask the address.
    System.out.print("\tAccount Address: ");
    address = sc.next();

    // Ask the birthday.
    System.out.print("\tBirthday (yyyy/MM/DD): ");
    birthday = sc.next();

    // Ask the contact number.
    System.out.print("\tContact Number: ");
    contactNumber = sc.next();

    // Ask the balance amount.
    System.out.print("\tBalance: ");
    balance = sc.nextDouble();

    // Display the output.
    Client.addNewline();
    System.out.println(id);
    System.out.println(accountName);
    System.out.println(address);
    System.out.println(birthday);
    System.out.println(contactNumber);
    System.out.println(balance);
  }

  // Method to add a new line.
  static void addNewline() { System.out.println(); }
}
