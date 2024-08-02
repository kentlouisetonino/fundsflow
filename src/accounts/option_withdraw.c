#include "../displays/ansi_color.h"
#include "../displays/clear_terminal.h"
#include "../displays/escape_sequence.h"
#include "account_type.h"

void option_withdraw(bank_account *accounts) {
  int account_number = 0;
  int invalid_account_number = 0;
  int invalid_withdraw_amount = 0;
  int try_again = 0;
  int withdraw = 0;
  bank_account account;
  char *garbage_buffer = malloc(sizeof(char) * 100);

  while (1) {
    // Clean up the terminal.
    clear_terminal();
    add_new_line();
    add_new_line();

    // Display description.
    add_new_tab();
    printf("%s-----------------------------------------%s", BLUE, RESET);
    add_new_line();
    add_new_line();
    add_new_tab();
    add_new_tab();
    add_new_tab();
    printf("%s Withdraw%s", GREEN, RESET);
    add_new_line();
    add_new_line();
    add_new_tab();
    printf("%s-----------------------------------------%s", BLUE, RESET);
    add_new_line();
    add_new_line();

    // Display the error message.
    if (invalid_account_number) {
      add_new_tab();
      printf("%sAccount number does not exist.%s", RED, RESET);
      add_new_line();
      add_new_line();

      // Ask user to try again.
      add_new_tab();
      printf("Try again (1-yes/0-no)?: ");
      scanf("%d", &try_again);
      fgets(garbage_buffer, 100, stdin);

      if (try_again == 1) {
        account_number = 0;
        invalid_account_number = 0;
        invalid_withdraw_amount = 0;
        withdraw = 0;
        continue;
      } else {
        break;
      }
    }

    // Display the error message if deposit amount is invalid.
    if (invalid_withdraw_amount) {
      add_new_tab();
      printf("%sInvalid withdraw amount (> 0).%s", RED, RESET);
      add_new_line();
      add_new_line();

      // Ask user to try again.
      add_new_tab();
      printf("Try again (1-yes/0-no)?: ");
      scanf("%d", &try_again);
      fgets(garbage_buffer, 100, stdin);

      if (try_again == 1) {
        account_number = 0;
        invalid_account_number = 0;
        invalid_withdraw_amount = 0;
        withdraw = 0;
        continue;
      } else {
        break;
      }
    }

    // Ask the account number.
    add_new_tab();
    printf("Enter the account number: ");
    scanf("%d", &account_number);
    fgets(garbage_buffer, 100, stdin);

    // Check if account number is valid.
    if (account_number == 0) {
      invalid_account_number = 1;
      invalid_account_number = 0;
      account_number = 0;
      withdraw = 0;
      continue;
    }

    // Check if account number exist.
    for (int i = 0; i < 50; i++) {
      if (accounts[i].account_number == account_number) {
        invalid_account_number = 0;
        account = accounts[i];
        break;
      } else {
        invalid_account_number = 1;
      }
    }

    // Check again if valid account number.
    if (invalid_account_number) {
      account_number = 0;
      continue;
    }

    // Ask the deposit amount.
    add_new_tab();
    printf("Enter amount to withdraw: ");
    scanf("%d", &withdraw);
    fgets(garbage_buffer, 100, stdin);
    if (withdraw == 0) {
      invalid_account_number = 0;
      invalid_withdraw_amount = 1;
      withdraw = 0;
      continue;
    }

    // Check if account number exist.
    for (int i = 0; i < 50; i++) {
      if (accounts[i].account_number == account_number) {
        bank_account updated_account = accounts[i];
        updated_account.balance = updated_account.balance - withdraw;
        accounts[i] = updated_account;
        account = updated_account;
        break;
      }
    }

    // Display other account information.
    add_new_tab();
    printf("%sAccount Name:%s %s%s%s", BLUE, RESET, GREEN, account.account_name,
           RESET);
    add_new_line();
    double current_balance = account.balance + (account.balance * 0.05);
    add_new_tab();
    printf("%sNew Balance:%s %s%lf%s", BLUE, RESET, GREEN, current_balance,
           RESET);
    add_new_line();
    add_new_line();

    // Ask user to try again.
    add_new_tab();
    printf("Try again (1-yes/0-no)?: ");
    scanf("%d", &try_again);
    fgets(garbage_buffer, 100, stdin);

    if (try_again == 1) {
      account_number = 0;
      invalid_account_number = 0;
      continue;
    } else {
      break;
    }
  }
}
