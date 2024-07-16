#include "../displays/ansi_color.h"
#include "../displays/clear_terminal.h"
#include "../displays/escape_sequence.h"
#include "./account_type.h"
#include <stdio.h>
#include <stdlib.h>

bank_account get_new_account(void) {
  // Required account information.
  int account_number = 1000 + (rand() % 9000);
  char *account_name = NULL;
  char *account_address = NULL;
  char *account_birthday = NULL;
  int contact_number;
  double deposit;

  // Hanlde the unnecessary input buffer.
  char *garbage_buffer = malloc(sizeof(char) * 100);

  // Error messages.
  int invalid_contact_number = 0;
  int invalid_deposit = 0;

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

    // Display error message.
    if (invalid_contact_number) {
      add_new_tab();
      printf("%sInvalid contact number.%s", RED, RESET);
      add_new_line();
      add_new_line();
    }
    if (invalid_deposit) {
      add_new_tab();
      printf("%sInvalid deposit (should be >= 5000).%s", RED, RESET);
      add_new_line();
      add_new_line();
    }

    // Account number.
    add_new_tab();
    printf("%sAccount Number:%s %d", BLUE, RESET, account_number);
    add_new_line();

    // Account name.
    add_new_tab();
    printf("%sAccount Name:%s ", BLUE, RESET);
    scanf("%s", account_name);
    fgets(garbage_buffer, 100, stdin);

    // Account address;
    add_new_tab();
    printf("%sAccount Address:%s ", BLUE, RESET);
    scanf("%s", account_address);
    fgets(garbage_buffer, 100, stdin);

    // Account birthday.
    add_new_tab();
    printf("%sBirthday (yyyy/MM/DD):%s ", BLUE, RESET);
    scanf("%s", account_birthday);
    fgets(garbage_buffer, 100, stdin);

    // Account contact number.
    add_new_tab();
    printf("%sContact Number:%s ", BLUE, RESET);
    scanf("%d", &contact_number);
    fgets(garbage_buffer, 100, stdin);
    if (contact_number <= 0) {
      account_name = NULL;
      account_address = NULL;
      account_birthday = NULL;
      contact_number = 0;
      deposit = 0;
      invalid_contact_number = 1;
      invalid_deposit = 0;
      continue;
    }

    // Account initial deposit.
    add_new_tab();
    printf("%sInitial Deposit:%s ", BLUE, RESET);
    scanf("%lf", &deposit);
    fgets(garbage_buffer, 100, stdin);
    if ((int)deposit <= 0) {
      account_name = NULL;
      account_address = NULL;
      account_birthday = NULL;
      contact_number = 0;
      deposit = 0;
      invalid_contact_number = 0;
      invalid_deposit = 1;
      continue;
    }

    break;
  }

  // Create a new object value based on bank account struct.
  bank_account new_account = {
      account_number,   account_name,   account_address,
      account_birthday, contact_number, deposit,
  };

  return new_account;
}
