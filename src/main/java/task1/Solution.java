package task1;

import java.util.Scanner;

public class Solution {
  private static boolean[][] visited;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int grid[][] = new int[n][m];
    for(int grid_i=0; grid_i < n; grid_i++){
      for(int grid_j=0; grid_j < m; grid_j++){
        grid[grid_i][grid_j] = in.nextInt();
      }
    }

    if (!inRange(n) && !inRange(m)) {
      throw new IllegalArgumentException();
    }

    visited =  new boolean[n][m];

    int max = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1 && !visited[i][j]) {
          int count = dfs(i, j);
          if (max < count) {
            max = count;
          }
        }
      }
    }

    System.out.println(max);

  }

  private static int dfs(int row, int col) {
    int count = 0;
    for (int i = -1; i < 1; i++) {
      for (int j = -1; j < 1; j++) {
        int curRow = row + i;
        int curCol = col + j;
        if (curRow > 0 && curCol > 0 && !visited[curRow][curCol]) {

        }
      }

    }
  }

  private static boolean inRange(Integer n) {
    return n > 0 && n < 10;
  }
}
