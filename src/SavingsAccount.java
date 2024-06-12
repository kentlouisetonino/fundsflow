package src;

public class SavingsAccount extends BankAccount {
  // Attributes.
  public int accountNumber;
  public double balance;
  public double interestRate;

  // Constructor.
  public SavingsAccount(int accountNumber, double balance,
                        double interestRate) {
    this.accountNumber = accountNumber;
    this.balance = balance;
    this.interestRate = interestRate;
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
  public void interestRate(double interestRate) {
    this.interestRate = interestRate;
  }

  // TODO: Inquire for the current balance.
  public double balanceInquiry() { return balance; }

  // TODO: Process the withdrawal.
  public void withdraw() {}

  // TODO: Validate account number.
  public void validateAccountNumber() {}

  // TODO: Close account.
  public void closeAccount() {}
}
