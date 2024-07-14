#include "../displays/ansi_color.h"
#include "../displays/escape_sequence.h"
#include "./account_type.h"
#include <stdio.h>
#include <stdlib.h>

int account_create(bank_account accounts[]) {
  // Required account information.
  int account_number = 1000 + (rand() % 9000);
  char *account_name = NULL;
  char *account_address = NULL;
  char *account_birthday = NULL;
  int contact_number;
  double deposit;

  // Hanlde the unnecessary input buffer.
  char *garbage_buffer = malloc(sizeof(char) * 100);

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

  // Account initial deposit.
  add_new_tab();
  printf("%sInitial Deposit:%s ", BLUE, RESET);
  scanf("%lf", &deposit);
  fgets(garbage_buffer, 100, stdin);

  return 1;
}
