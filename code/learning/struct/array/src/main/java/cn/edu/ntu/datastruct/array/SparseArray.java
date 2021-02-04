package cn.edu.ntu.datastruct.array;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack <br>
 * @create 2020-02-26 23:23 <br>
 */
public class SparseArray {
  private static final Logger LOG = LoggerFactory.getLogger(SparseArray.class);

  @Test
  public void printOrigin() {
    // 1. create 11 * 11 array
    int chessArr[][] = new int[11][11];
    chessArr[1][2] = 1;
    chessArr[2][4] = 2;

    for (int[] row : chessArr) {
      for (int i : row) {
        System.out.printf("%d\t", i);
      }
      System.out.println();
    }
  }

  @Test
  public void parse2SparseArr() {
    // 1. create 11 *11 array
    int chessArr[][] = new int[11][11];
    chessArr[1][2] = 1;
    chessArr[2][4] = 2;
    chessArr[2][5] = 2;

    // 2. get sum value
    int sum = 0;
    for (int[] row : chessArr) {
      for (int i : row) {
        if (i != 0) {
          sum++;
        }
      }
    }

    // 3. create sparse array
    int sparseArr[][] = new int[sum + 1][3];
    sparseArr[0][0] = 11;
    sparseArr[0][1] = 11;
    sparseArr[0][2] = sum;

    // 4. put non-zero value
    int count = 0;
    for (int i = 0; i < 11; i++) {
      for (int j = 0; j < 11; j++) {
        if (chessArr[i][j] != 0) {
          count++;
          sparseArr[count][0] = i;
          sparseArr[count][1] = j;
          sparseArr[count][2] = chessArr[i][j];
        }
      }
    }

    // 5. print sparse array
    for (int[] row : sparseArr) {
      for (int i : row) {
        System.out.printf("%d\t", i);
      }
      System.out.println();
    }
  }

  @Test
  public void parseChess2SparseArr() {

    int sparswArr[][] = new int[3][3];

    sparswArr[0][0] = 11;
    sparswArr[0][1] = 11;
    sparswArr[0][2] = 2;

    sparswArr[1][0] = 1;
    sparswArr[1][1] = 2;
    sparswArr[1][2] = 1;

    sparswArr[2][0] = 2;
    sparswArr[2][1] = 4;
    sparswArr[2][2] = 2;

    int chessArr[][] = new int[sparswArr[0][0]][sparswArr[0][1]];
    for (int i = 1; i < sparswArr.length; i++) {
      chessArr[sparswArr[i][0]][sparswArr[i][1]] = sparswArr[i][2];
    }

    for (int[] row : chessArr) {
      for (int i : row) {
        System.out.printf("%d\t", i);
      }
      System.out.println();
    }
  }
}
