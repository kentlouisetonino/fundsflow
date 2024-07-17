#include "./accounts/account_type.h"
#include "./accounts/option_balance_inquiry.h"
#include "./accounts/option_deposit.h"
#include "./accounts/option_new_account.h"
#include "./displays/app_description.h"
#include "./displays/app_options.h"
#include "./displays/clear_terminal.h"
#include "./displays/escape_sequence.h"
#include "./inputs/main_option_input.h"
#include <stdio.h>

int main(void) {
  int main_option = 0;
  bank_account accounts[50] = {};

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
    app_options();
    add_new_line();
    add_new_line();

    // Ask the input.
    main_option = main_option_input();

    // Create a new account.
    if (main_option == 1) {
      for (int i = 0; i < 50; i++) {
        if (accounts[i].account_number == 0) {
          accounts[i] = option_new_account();
          break;
        }
      }

      continue;
    }

    // Get the balance inquiry.
    if (main_option == 2) {
      option_balance_inquiry(accounts);
      continue;
    }

    // Deposit to account.
    if (main_option == 3) {
      option_deposit(accounts);
      continue;
    }

    break;
  }

  return 0;
}
