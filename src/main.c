#include "./displays/app_description.h"
#include "./displays/clear_terminal.h"
#include "./displays/escape_sequence.h"
#include <stdio.h>

int main(void) {
  // Clear the terminal.
  clear_terminal();
  add_new_line();
  add_new_line();

  // Show CLI tool description.
  app_description();
  add_new_line();
  add_new_line();

  return 0;
}
