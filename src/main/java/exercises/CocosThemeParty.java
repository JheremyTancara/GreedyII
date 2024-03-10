package exercises;

import java.util.Arrays;
import java.util.Scanner;

public class CocosThemeParty {

  public static int maximizeEnjoyment(int n, int[] happiness) {
    Arrays.sort(happiness);

    int[] sortedArray = new int[n];
    int left = 0, right = n - 1, maxEnjoyment = 0;;

    for (int i = 0; i < n; i++) {
      if (i % 2 == 0) {
        sortedArray[i] = happiness[left];
        left++;
      } else {
        sortedArray[i] = happiness[right];
        right--;
      }
    }

    for (int i = 1; i < n; i++) {
      int enjoyment = Math.abs(sortedArray[i] - sortedArray[i - 1]);
      maxEnjoyment += enjoyment;
    }
    return maxEnjoyment;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int[] happinessLevels = new int[N];
    for (int i = 0; i < N; i++) {
      happinessLevels[i] = scanner.nextInt();
    }

    int result = maximizeEnjoyment(N, happinessLevels);
    System.out.println(result);
  }
}
