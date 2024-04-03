package test;

import java.util.Arrays;
import java.util.Scanner;

public class TestGreedy {
  public static int findMaximumMealsEat(int time, int[] meals) {
    int quantityTime = 0, amountMeals = 0;
    Arrays.sort(meals);

    for (int i=0; i < meals.length; i++) {
      if ((quantityTime + meals[i]) > time) {
        break;
      } else {
        quantityTime += meals[i];
        amountMeals += 1;
      }
    }
    return amountMeals;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int M = scanner.nextInt();
    int[] meals = new int[N];
    for (int i = 0; i < N; i++) {
      meals[i] = scanner.nextInt();
    }

    System.out.println(findMaximumMealsEat(M, meals));
  }
}
