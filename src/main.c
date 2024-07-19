#include "./accounts/account_type.h"
#include "./accounts/option_balance_inquiry.h"
#include "./accounts/option_client_profile.h"
#include "./accounts/option_deposit.h"
#include "./accounts/option_new_account.h"
#include "./accounts/option_withdraw.h"
#include "./displays/app_description.h"
#include "./displays/app_options.h"
#include "./displays/clear_terminal.h"
#include "./displays/escape_sequence.h"
#include "./inputs/main_option_input.h"
#include <stdio.h>

int main(void) {
  int main_option = 0;
  bank_account accounts[50] = {};
  int accounts_empty = 1;

  while (1) {
    // Clear the terminal.
    clear_terminal();
    add_new_line();
    add_new_line();

    // Show CLI tool description.
    app_description();
    add_new_line();
    add_new_line();

    // Show CLI tool options.
    accounts_empty = accounts[0].account_number == 0;
    app_options(accounts_empty);
    add_new_line();
    add_new_line();

    // Ask the input.
    main_option = main_option_input();

    // Create a new account.
    if (main_option == 1) {
      option_new_account(accounts);
      accounts_empty = 0;
      continue;
    }

    // Get the balance inquiry.
    if (!accounts_empty && main_option == 2) {
      option_balance_inquiry(accounts);
      continue;
    }

    // Deposit to account.
    if (!accounts_empty && main_option == 3) {
      option_deposit(accounts);
      continue;
    }

    // Withdraw amount from the account.
    if (!accounts_empty && main_option == 4) {
      option_withdraw(accounts);
      continue;
    }

    // Client profile of the account.
    if (!accounts_empty && main_option == 5) {
      option_client_profile(accounts);
      continue;
    }

    break;
  }

  return 0;
}
