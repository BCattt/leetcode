#include <string.h>
#include <stdio.h>

char findTheDifference(char* s, char* t) {
  int slen = strlen(s);
  int i;
  for (i = 0; i < slen; ++i) {
    if (t[i] != s[i]) {
      printf("i = [%d]\n", i);
      return t[i];
    }
  }
  printf("i = [%d]\n", i);
  return t[i];
}

int main(int argc, char *argv[]) {
  printf("diff = [%c]\n", findTheDifference("abcd", "abcde"));
  return 0;
}