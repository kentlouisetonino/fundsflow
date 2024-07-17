#include "./ansi_color.h"
#include "./escape_sequence.h"
#include <stdio.h>

void app_description(void) {
  add_new_tab();
  printf("%s-----------------------------------------%s", BLUE, RESET);
  add_new_line();
  add_new_line();
  add_new_tab();
  add_new_tab();
  add_new_tab();
  printf("%sFundsFlow%s", GREEN, RESET);
  add_new_line();
  add_new_line();
  add_new_tab();
  add_new_tab();
  printf("A simple banking system.");
  add_new_line();
  add_new_line();
  add_new_tab();
  printf("%s-----------------------------------------%s", BLUE, RESET);
}
