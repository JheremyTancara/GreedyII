package vjudge;

import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();
    for (int price = 0; price < t; price++) {
      int n = scanner.nextInt();
      int[] prices = new int[n];

      for (int i = 0; i < n; i++) {
        prices[i] = scanner.nextInt();
      }
      int maxDiscount = calculateMaxDiscountGreedy(n, prices);
      System.out.println(maxDiscount);
    }
  }

  public static int calculateMaxDiscountOptimal(int n, int[] prices) {
    Arrays.sort(prices);
    int maxDiscount = 0;
    for (int i = n - 1; i >= 2; i -= 3) {
      maxDiscount += prices[i - 2];
    }
    return maxDiscount;
  }

  public static int calculateMaxDiscountGreedy(int n, int[] prices) {
    Arrays.sort(prices);
    int maxDiscount = 0;

    for (int i = n - 1; i >= 2; i -= 3) {
      int groupMin = findGroupMin(prices, i - 2, i);
      maxDiscount += groupMin;
    }

    return maxDiscount;
  }

  private static int findGroupMin(int[] prices, int start, int end) {
    int groupMin = Integer.MAX_VALUE;

    for (int i = start; i <= end; i++) {
      if (prices[i] < groupMin) {
        groupMin = prices[i];
      }
    }
    return groupMin;
  }

  @FunctionalInterface
  public interface VoidMethod {
    void run();
  }

  public static long nanoTime(VoidMethod methodToMesure) {
    long startTime = System.nanoTime();
    methodToMesure.run();
    long endTime = System.nanoTime();
    return endTime - startTime;
  }
}
