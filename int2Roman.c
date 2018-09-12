/* 
 * Convert a integer to roman number.
 * Roman numerals are represented by seven different symbols:
 * Symbol     Value
 * I            1
 * V            5
 * X            10
 * L            50
 * C            100
 * D            500
 * M            1000
 */
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>

/**
 * Convet a given integer <code>num</code> to 
 * roman equivalent form.
 * 
 * @param num integer to be converted
 * 
 * @return roman equivalent form string representation
 */
char* int2Roman(int num) {
  static char roman[15 + 1] = {0};
  static int romans[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
  static char *romanStr[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
  int i = 0, n = 0, numT = num, j = 0;
  roman[0] = '\0';
  for ( ; i < 13 && numT != 0; ++i) {
    n = numT / romans[i];
    numT %= romans[i];
    for (j = 0; j < n; ++j) {
      strcat(roman, romanStr[i]);
    }
  }
  return roman;
  
}

int main(int argc, char *argv[]) {
  int num = 1;
  printf("[%d] = [%s]\n", num, int2Roman(num));
  num = 2;
  printf("[%d] = [%s]\n", num, int2Roman(num));
  num = 3;
  printf("[%d] = [%s]\n", num, int2Roman(num));
  num = 4;
  printf("[%d] = [%s]\n", num, int2Roman(num));
  num = 9;
  printf("[%d] = [%s]\n", num, int2Roman(num));
  num = 10;
  printf("[%d] = [%s]\n", num, int2Roman(num));
  num = 40;
  printf("[%d] = [%s]\n", num, int2Roman(num));
  num = 49;
  printf("[%d] = [%s]\n", num, int2Roman(num));
  num = 50;
  printf("[%d] = [%s]\n", num, int2Roman(num));
  num = 58;
  printf("[%d] = [%s]\n", num, int2Roman(num));
  num = 90;
  printf("[%d] = [%s]\n", num, int2Roman(num));
  num = 100;
  printf("[%d] = [%s]\n", num, int2Roman(num));
  num = 149;
  printf("[%d] = [%s]\n", num, int2Roman(num));
  num = 150;
  printf("[%d] = [%s]\n", num, int2Roman(num));
  num = 151;
  printf("[%d] = [%s]\n", num, int2Roman(num));
  num = 159;
  printf("[%d] = [%s]\n", num, int2Roman(num));
  num = 200;
  printf("[%d] = [%s]\n", num, int2Roman(num));
  num = 249;
  printf("[%d] = [%s]\n", num, int2Roman(num));
  num = 490;
  printf("[%d] = [%s]\n", num, int2Roman(num));
  num = 500;
  printf("[%d] = [%s]\n", num, int2Roman(num));
  num = 900;
  printf("[%d] = [%s]\n", num, int2Roman(num));
  num = 1000;
  printf("[%d] = [%s]\n", num, int2Roman(num));
  num = 1994;
  printf("[%d] = [%s]\n", num, int2Roman(num));
  num = 3999;
  printf("[%d] = [%s]\n", num, int2Roman(num));
  return 0;
}