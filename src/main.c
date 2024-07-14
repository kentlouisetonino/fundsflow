#include "./accounts/account_create.h"
#include "./accounts/account_type.h"
#include "./displays/app_description.h"
#include "./displays/app_options.h"
#include "./displays/clear_terminal.h"
#include "./displays/escape_sequence.h"
#include "./inputs/main_option_input.h"
#include <stdio.h>

int main(void) {
  int main_option = 0;
  bank_account accounts[10] = {};
  int has_error = 0;

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

    if (main_option == 1) {
      clear_terminal();
      add_new_line();
      add_new_line();
      has_error = account_create(accounts);
      add_new_line();
    }

    break;
  }

  return 0;
}
