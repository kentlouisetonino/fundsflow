package src;

public class SavingsAccount extends BankAccount {
  // Attributes.
  public int accountNumber;
  public double balance;
  public double interestRate;

  // Constructor.
  public SavingsAccount(String accountName, String address, String birthday,
                        String contactNumber, int accountNumber,
                        double balance) {
    // Instantiate the bank information.
    super(accountName, address, birthday, contactNumber);

    // Assign values for the native savings account variables.
    this.accountNumber = accountNumber;
    this.balance = balance;
    this.interestRate = balance * (0.05);
  }

  // Accessor methods.
  public int getAccountNumber() { return accountNumber; }
  public double getBalance() { return balance; }
  public double interestRate() { return interestRate; }

  // Mutator methods.
  public void setAccountNumber(int accountNumber) {
    this.accountNumber = accountNumber;
  }
  public void setBalance(double balance) { this.balance = balance; }
  public void setInterestRate(double interestRate) {
    this.interestRate = interestRate;
  }

  // Inquire for the current balance.
  public double balanceInquiry() { return balance + interestRate; }

  // TODO: Process the withdrawal.
  public void withdraw() {}

  // TODO: Validate account number.
  public void validateAccountNumber() {}

  // TODO: Close account.
  public void closeAccount() {}
}
