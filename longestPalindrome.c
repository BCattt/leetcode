/* 
 * Given a string s, find the longest palindromic substring s. *
 * You may assume that the maximum length of s is 1000         *
 *   The method is quit strake through, just move the current 
 * index of s from 0 to length - 1, and test the longest palindrom
 * for each position, and get the longest palindrom *
 */
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char *longestPalindrome(char *s) {
  int sPos = 0, ePos = 0,cPos = 0;
  int len = strlen(s);
  int maxLen = 0, maxS = 0;
  int curLen = 0;
  while (cPos < len) {
    // set curLen = 1
    curLen = 1;
    sPos = ePos = cPos;
    
    // discard same characters on the left
    while (--sPos >= 0 && *(s + sPos) == *(s + cPos)) {
      ++curLen;
    }
    // discard same characters on the right
    while (++ePos <= len - 1 && *(s + ePos) == *(s + cPos)) {
      ++curLen;
    }
    while (sPos >= 0 && ePos <= len -1) {
      if (*(s + sPos) == *(s + ePos)) {
        curLen += 2;
      } else {
        break;
      }
      --sPos;
      ++ePos;
    } // while (sPos > 0 && ePos < len - 1)
    if (curLen > maxLen) {
      maxS = sPos + 1;
      maxLen = curLen;
    }
    ++cPos; 
  } // while (cPos < len - 1)
  static char dest[1000 + 1] = {0};
  memcpy(dest, s + maxS, maxLen);
  dest[maxLen] = 0;
  return dest;
}

int main(int argc, char *argv[]) {
  char s[1000 + 1] = {0};
  while(gets(s)) {
    if (0 == strcmp("q", s) || 0 == strcmp("Q", s)) {
      exit(0);
    }
    printf("%s = %s\n", s, longestPalindrome(s));
  }
  return 0;
}