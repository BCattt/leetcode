/* 
 * Determine whether an integer is a palindrome, without converting it
 * to a string. 
 */
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

/**
 * Determine if an integer is a plindrome (reads the same backward as forward)
 * 
 * @param x integer to be detected
 * 
 * @return true input integer is a plindrome; false otherwise
 */
bool isPalindrome(int x) {
  if (x < 0) {
    return false;
  }
  int reverse = 0;
  int src = x;
  while (src / 10) {
    reverse = reverse * 10 + src % 10;
    src /= 10;
  }
  reverse = reverse * 10 + src % 10;
  
  return (x ^ reverse) == 0;
}

int main(int argc, char *argv[]) {
  printf("isPalindrome(101) == [%s]\n", isPalindrome(101) ? "Y":"N");
  printf("isPalindrome(-101) == [%s]\n", isPalindrome(-101) ? "Y":"N");
  printf("isPalindrome(10) == [%s]\n", isPalindrome(10) ? "Y":"N");
  printf("isPalindrome(1) == [%s]\n", isPalindrome(1) ? "Y":"N");
  return 0;
}