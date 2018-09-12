/* 
 * Regular expression matching. 
 * Patterns supported here is limited, 
 * '.' Matches any signal character
 * '*' Matches zero or more of the preceding element
 * The matching should cover the entire input string. 
 * 
 * The input string could be empty or contains only lowercase letters a-z
 * The pattern could be empty and contains only lowercase letters a-z, and 
 * characters . or *;
 * 
 */
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

/**
 * Test if the given string <code>s</code> matches
 *  regular expression specified by <code>p</code>.
 * 
 * @param s string to be tested
 * @param p test pattern
 * 
 * @return true if s matches p; false otherwise.
 */
bool isMatch(char *s, char *p) {
 /*
  * Traverse the original 
  */
}

int main(int argc, char *argv[]) {
  printf("isPalindrome(101) == [%s]\n", isPalindrome(101) ? "Y":"N");
  printf("isPalindrome(-101) == [%s]\n", isPalindrome(-101) ? "Y":"N");
  printf("isPalindrome(10) == [%s]\n", isPalindrome(10) ? "Y":"N");
  printf("isPalindrome(1) == [%s]\n", isPalindrome(1) ? "Y":"N");
  return 0;
}