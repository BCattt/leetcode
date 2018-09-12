/* 
 * Convert a string into zigzag pattern by giving row numbers.
 */
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>

/**
 * Convert a given string <code>s</code> with <code>numRows</code> into
 * zigzag pattern. 
 * 
 * ATTENTION: the caller is in responsible for relasing the result by calling free
 * 
 * @param s input string to be converted
 * @param numRows number of rows to convert
 * 
 * @return converted string
 */
char *convert(char *s, int numRows) {
  int row;
  int col;
  int len = strlen(s);
  static char result[1000]  = {0};
  memset(result, 0, len + 1);
  /* one row, just copy the source to the result and return */
  if (numRows == 1) {
    memcpy(result, s, len + 1);
    return result;
  }
  
  int pos;  /* current charactter position */
  int cPos = 0; /* copy position */
  int step = 2 * (numRows - 1);
  // calculate how many columns will be in the matrix
  int columns = len > numRows ? ceil((len - numRows) / (step * 1.0)) + 1 : 1;
  printf("len = [%d], numRows = [%d] Columns = [%d]\n", len, numRows, columns);
  for (row = 0; row < numRows; ++row) {
    if (0 == row % (numRows - 1)) {
      for (col = 0; col < columns; ++col) {
        pos = row + col * step;
        if (pos < len) {
          result[cPos++] = s[pos];
        }
      }
    } else {
      for (col = 0; col < columns; ++col) {
        pos = row + col * step;
        if (pos < len) {
          result[cPos++] = s[pos];
        }
        pos += step - 2 * row;
        if (pos < len) {
          result[cPos++] = s[pos];
        }
      }
    } /* else */
  } /* for (row = 0; row < numRows; ++row) */
  return result;
}

int main(int argc, char *argv[]) {
  
  char *result = convert("AB", 1);
  printf("result = [%s]\n", result);
  
  //free(result);
  result = convert("PAYPALISHIRING", 3);
  printf("result = [%s]\n", result);
  result = convert("PAYPALISHIRING", 4);
  printf("result = [%s]\n", result);
  //free(result);
  return 0;
}