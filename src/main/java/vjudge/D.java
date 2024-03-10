package vjudge;

import java.util.Scanner;

class D {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    int c = scanner.nextInt();
    for (int index = 1; index <= c; ++index) {
      int n = scanner.nextInt();
      int P = scanner.nextInt();
      int Q = scanner.nextInt();

      int[] a = new int[n];
      for ( int i = 0; i < n; i++) a[i] = scanner.nextInt();

      int mx = 0;
      for (int i = 0; i < n; i++) {
        int counter = 0, sumOfWeight = 0;
        for (int j = i; j < n; j++) {
          if (counter + 1 <= P && sumOfWeight + a[j] <= Q) {
            sumOfWeight += a[j];
            counter++;
            mx = Math.max(mx, counter);
          }
          else break;
        }
      }
      System.out.println("Case " + index + ": " + mx);
    }
  }
}
