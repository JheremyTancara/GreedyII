package vjudge;

import java.util.Arrays;
import java.util.Scanner;

public class C {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      int n = scanner.nextInt();
      int m = scanner.nextInt();
      if (n == 0 && m == 0) break;

      int[] A = new int[20005];
      int[] B = new int[20005];

      for (int i = 0; i < n; i++) {
        A[i] = scanner.nextInt();
      }

      for (int i = 0; i < m; i++) {
        B[i] = scanner.nextInt();
      }

      Arrays.sort(A, 0, n);
      Arrays.sort(B, 0, m);

      int cur = 0;
      int cost = 0;

      for (int i = 0; i < m; ++i) {
        if (B[i] >= A[cur]) {
          cost += B[i];
          if (++cur == n)
            break;
        }
      }

      if (cur < n)
        System.out.println("Loowater is doomed!");
      else
        System.out.println(cost);
    }
  }
}
