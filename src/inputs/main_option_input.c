#include "../displays/ansi_color.h"
#include "../displays/escape_sequence.h"
#include <stdio.h>

int main_option_input(void) {
  int input = 0;

  // Ask the input.
  add_new_tab();
  printf("%sInput option:%s ", BLUE, RESET);
  scanf("%d", &input);

  return input;
}
