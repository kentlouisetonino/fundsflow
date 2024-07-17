#include "./escape_sequence.h"
#include <stdio.h>

void app_options(void) {
  add_new_tab();
  printf("[ 1 ] New Account");
  add_new_line();
  add_new_tab();
  printf("[ 2 ] Balance Inquiry");
  add_new_line();
  add_new_tab();
  printf("[ 3 ] Deposit");
  add_new_line();
  add_new_tab();
  printf("[ 4 ] Withdraw");
  add_new_line();
  add_new_tab();
  printf("[ 5 ] Client Profile");
  add_new_line();
  add_new_tab();
  printf("[ 6 ] Close Account");
  add_new_line();
  add_new_tab();
  printf("[ 7 ] Exit");
}
