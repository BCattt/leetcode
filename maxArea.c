/* 
 * Given n non-ngeative integers, a1, a2, ... , an, where each represents
 * a point at coordinate(i, ai). n vertical lines are drawn such that the 
 * two endpoints of line i is at(i, ai) and (i, 0). Find two lines, which 
 * together with x-axis forms a container, such that the container contains
 * the most water. 
 * 
 *  Note: you may not slant the container and n is at least 2.
 */
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>

/**
 * Decide the maximum area of <code>heightSize</code> numbers as
 * <code>height</code> array. 
 * 
 * @param height height array
 * @param heightSize array size
 * 
 * @return maximum area could be constructed by the array
 */
int maxArea(int *height, int heightSize) {
  // The maximum area apperas on the i * an, so we just need to
  // make the i and an as long as possible. We make two pointers
  // one(s) move from a1, and one(e) move from an, and calculate
  // a area; we then move s or e based on as and ae: when as < ae,
  // we move as to find a taller as; when as > ae, we move ae to 
  // find a taller ae. Until as met ae, should we end the search. 
  int s = 0, e = heightSize - 1;
  int maxA = 0, area = 0;
  while (s < e) {
    if (*(height + s) < *(height + e)) {
      area = *(height + s) * (e - s);
      ++s;
    } else {
      area = *(height + e) * (e - s);
      --e;
    }
    if (area > maxA) {
      maxA = area;
    }
  }
  return maxA;
}

int main(int argc, char *argv[]) {
  int height[] = {1, 8, 3, 4};
  printf("MaxArea = [%d]\n", maxArea(height, sizeof(height) / sizeof(int)));
  return 0;
}