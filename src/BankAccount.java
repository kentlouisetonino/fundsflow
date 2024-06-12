package src;

public class BankAccount {
  // Attributes.
  public String accountName;
  public String address;
  public String birthday;
  public String contactNumber;

  // Constructor.
  public BankAccount(String accountName, String address, String birthday,
                     String contactNumber) {
    this.accountName = accountName;
    this.address = address;
    this.birthday = birthday;
    this.contactNumber = contactNumber;
  }

  // Accessor methods.
  public String getAccountName() { return accountName; }
  public String getAddress() { return address; }
  public String getBirthday() { return birthday; }
  public String getContactNumber() { return contactNumber; }

  // Mutator methods.
  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }
  public void setAddress(String address) { this.address = address; }
  public void setBirthday(String birthday) { this.birthday = birthday; }
  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  // Get the client details.
  public void getClientDetails() {
    System.out.println("Account Name: " + accountName);
    System.out.println("Account Address: " + address);
    System.out.println("Account Birthday: " + birthday);
    System.out.println("Account Contact Number: " + contactNumber);
  }
}
