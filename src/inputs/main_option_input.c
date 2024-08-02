#include "../displays/ansi_color.h"
#include "../displays/escape_sequence.h"
#include <stdlib.h>

int main_option_input(void) {
  int input = 0;
  char *garbage_buffer = malloc(sizeof(char) * 100);

  // Ask the input.
  add_new_tab();
  printf("%sInput option:%s ", BLUE, RESET);
  scanf("%d", &input);
  fgets(garbage_buffer, 100, stdin);

  if (input == 0) {
    return 0;
  } else {
    return input;
  }
}
