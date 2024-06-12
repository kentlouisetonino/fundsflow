package src;

import java.util.Scanner;

public class Client {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int option;

    while (true) {
      // Show the app description and options.
      Client.addNewline();
      Client.displayMainMenu();

      // Ask the option.
      Client.addNewline();
      System.out.print("\tInput option: ");
      option = sc.nextInt();

      // Testing.
      Client.addNewline();
      System.out.println(option);
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

  // Method to add a new line.
  static void addNewline() { System.out.println(); }

  // Handling the option 1 (new account).
}
