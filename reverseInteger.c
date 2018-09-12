/* 
 * Reverse an integer
 */
#include <stdio.h>
#include <string.h>
#include <stdlib.h>


/**
 * Reverse an integer while keeping its sign. 
 * For example, 123 -> 321, -123 -> -321
 * @param x input integer (ranged from -2^31 to 2^31 -1 )
 */
int reverse(int x) {
  int sign = x > 0 ? 1 : -1;
  int src = abs(x);
  int64_t result = 0;
  while (src / 10) {
    result = result * 10 + src % 10;
    src /= 10;
  }
  result = result * 10 + src % 10;
  result = result * sign;
  if (result <= -2147483648 || result >= 2147483647) {
    return 0;
  }
  return result;
}

int main(int argc, char *argv[]) {
  printf("[%d] reversed = [%d]\n", 120, reverse(120));
  printf("[%d] reversed = [%d]\n", -120, reverse(-120));
  printf("[%d] reversed = [%d]\n", 0, reverse(0));
  printf("[%d] reversed = [%d]\n", -0, reverse(-0));
  printf("[%d] reversed = [%d]\n", 1, reverse(1));
  printf("[%d] reversed = [%d]\n", -1, reverse(-1));
  printf("[%d] reversed = [%d]\n", 1201, reverse(1201));
  printf("[%d] reversed = [%d]\n", -1201, reverse(-1201));
  printf("[%d] reversed = [%d]\n", 1534236469, reverse(1534236469));
  return 0;
}