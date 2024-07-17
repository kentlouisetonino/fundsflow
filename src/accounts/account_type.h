#ifndef ACCOUNT_TYPE_H
#define ACCOUNT_TYPE_H

typedef struct {
  int account_number;
  char *account_name;
  char *account_address;
  char *account_birthday;
  int contact_number;
  double balance;
} bank_account;

#endif
