#include "./escape_sequence.h"
#include <stdio.h>

void app_options(int accounts_empty) {
  int exit = accounts_empty ? 2 : 7;

  // Option 1.
  add_new_tab();
  printf("[ 1 ] New Account");
  add_new_line();

  if (!accounts_empty) {
    // Option 2.
    add_new_tab();
    printf("[ 2 ] Balance Inquiry");
    add_new_line();

    // Option 3.
    add_new_tab();
    printf("[ 3 ] Deposit");
    add_new_line();

    // Option 4.
    add_new_tab();
    printf("[ 4 ] Withdraw");
    add_new_line();

    // Option 5.
    add_new_tab();
    printf("[ 5 ] Client Profile");
    add_new_line();

    // Option 6.
    add_new_tab();
    printf("[ 6 ] Close Account");
    add_new_line();
  }

  // Exit.
  add_new_tab();
  printf("[ %d ] Exit", exit);
}
