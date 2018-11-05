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
 */
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

/**
 * Test if the given string <code>s</code> matches
 *  regular expression specified by <code>p</code>.
 * we could classify the patterns into three types:
 *  (1) normal pattern: a pttern contains no wildcard(./*);
 *  (2) wildcard: a pttern contains *(., e*, .*)
 * 
 * @param s string to be matched
 * @param p match pattern
 * 
 * @return true if s matches p; false otherwise.
 */
bool isMatch(char *s, char *p) {
  // used to save the apperance of a character. If a character 
  // is followed by *, then this character could be appeared in
  // the string any times. So, we just save this, until we reach
  // a pattern in the regular expression out of * 
  static char appearence[26] = { 0 };
  // If the previous pattern is a wildcard, we could only close the
  // wildcard pattern until we meet a normal pattern. 
  bool wildcard = false;
  /*
   * Traverse the original 
   */
  int iS = 0, iP = 0;
  while (true) {
    // move forward to skip all same characters
    while (*(s + iS) && *(p + iP) && *(s + iS) == *(p + iP)) {
      ++iS;
      ++iP;
    }
    // now we reached the first different character
    // or all characters end (matched)
    if (*(s + iS) == '\0' && *(p + iP) == '\0') {
      return true;
    }
    // regular expression not end
    if (*(p + iP) == '\0') {
      return false;
    }

    char cP = *(p + iP);
    // Now, current p is not equal to current s, 
    // so the regular expression should have a pattern to 
    // make it match
    // If current pattern is .
    if (cP == '.') {
      wildcard = true;
      // look forward to next character to see if it is valid character
      // if it is, the 
      if (*(p + iP + 1) == '*') {
        // each character could appear any times
        memset(appearence, 2, 26);
        iP += 2;
      } else {
        // each character could appearn only once
        memset(appearence, 2, 26);
        ++iP;
      }
    // next character is *
    } else if (cP == '*') {
      // have previous element, will repeat it
      if (iP > 0) {
        wildcard = true;
        // previous pattern could appear any times
        appearence[*(p + iP - 1) - 'a' ] = 2;
      }
      // move p forward
      ++iP; 
    // p currently is a normal character, test if the next is *
    } else {
      if (*(p + iP + 1) == '*') {
        // wildcard pattern appeared, this character could appear any times
        wildcard = true;
        appearence[cP - 'a'] = 2;
        iP += 2;
      } else {
        // normal pattern, we will use backtracking technology to match this pattern
        // we will match the whole normal pattern, when any one of the pattern is not
        // matched, we will move the string forward to redo the match, until all characters
        // are matched
        int normPatEnd = iP;
        int curP = iP;
        int curS = iS;
        while ((cP = *(p + ++normPatEnd)) && cP != '*' && cP != '.');
        // we should reduce normPatEnd by one to get the normal pattern
        --normPatEnd;
        // we will match normal pattern in reverse order (back -> front)
        // to reduce the backtracking of wildcard extensions. 
        int curIs = iS + (normPatEnd - iP);
        while (curP != normPatEnd) {

        }
        return false;
      }
    }
  } // while (true)
  return true;
}

char * bool2Str(bool bl) {
  return bl ? "true" : "false";
}

int main(int argc, char *argv[]) {
  char *s = "", *p = "";
  printf("isMatch(\"%s\", \"%s\") = [%s]\n", s, p, bool2Str(isMatch(s, p)));
  s = ""; 
  p = ".*";
  printf("isMatch(\"%s\", \"%s\") = [%s]\n", s, p, bool2Str(isMatch(s, p)));
  s = "a";
  p = "a*";
  printf("isMatch(\"%s\", \"%s\") = [%s]\n", s, p, bool2Str(isMatch(s, p)));
  s = "ab"; 
  p = ".*";
  printf("isMatch(\"%s\", \"%s\") = [%s]\n", s, p, bool2Str(isMatch(s, p)));
  s = "aa";
  p = "a";
  printf("isMatch(\"%s\", \"%s\") = [%s]\n", s, p, bool2Str(isMatch(s, p)));
  s = "ab";
  p = "a.*";
  printf("isMatch(\"%s\", \"%s\") = [%s]\n", s, p, bool2Str(isMatch(s, p)));
  s = "ab";
  p = "a.*b";
  printf("isMatch(\"%s\", \"%s\") = [%s]\n", s, p, bool2Str(isMatch(s, p)));
  s = "aaa";
  p = "a*a";
  printf("isMatch(\"%s\", \"%s\") = [%s]\n", s, p, bool2Str(isMatch(s, p)));
  s = "aaa";
  p = ".*a";
  printf("isMatch(\"%s\", \"%s\") = [%s]\n", s, p, bool2Str(isMatch(s, p)));
   s = "aaa";
  p = "a*a*a*a*a*";
  printf("isMatch(\"%s\", \"%s\") = [%s]\n", s, p, bool2Str(isMatch(s, p)));
  s = "aaa";
  p = "a*a*a*a*a";
  printf("isMatch(\"%s\", \"%s\") = [%s]\n", s, p, bool2Str(isMatch(s, p)));
  s = "aab";
  p = "c*a*b";
  printf("isMatch(\"%s\", \"%s\") = [%s]\n", s, p, bool2Str(isMatch(s, p)));
  s = "mississippi";
  p = "mis*is*p*.";
  printf("isMatch(\"%s\", \"%s\") = [%s]\n", s, p, bool2Str(isMatch(s, p)));
  return 0;
}