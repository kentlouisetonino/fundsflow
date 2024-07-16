#include "../displays/ansi_color.h"
#include "../displays/clear_terminal.h"
#include "../displays/escape_sequence.h"
#include "./account_type.h"
#include "stdlib.h"

void get_balance_inquiry(bank_account accounts[]) {
  int account_number = 0;
  int invalid_account_number = 0;
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
    printf("%s    Create New Account%s", GREEN, RESET);
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
    }

    // Ask the account number.
    add_new_tab();
    printf("Enter the account number: ");
    scanf("%d", &account_number);
    fgets(garbage_buffer, 100, stdin);

    if (account_number == 0) {
      invalid_account_number = 1;
      account_number = 0;
      continue;
    }

    // Check if account number exist.
    for (int i = 0; i < 50; i++) {
      if (accounts[i].account_number == account_number) {
        invalid_account_number = 0;
        break;
      } else {
        invalid_account_number = 1;
      }
    }

    if (invalid_account_number) {
      account_number = 0;
      continue;
    }

    break;
  }
}
