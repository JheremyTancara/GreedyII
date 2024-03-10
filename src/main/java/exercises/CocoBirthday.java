package exercises;

import java.util.Arrays;
import java.util.Scanner;

public class CocoBirthday {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int[] happiness = new int[n];

    for (int i = 0; i < n; i++) {
      happiness[i] = scanner.nextInt();
    }

    int quantityMaxGuest = Guests(n, happiness);
    System.out.println(quantityMaxGuest);
  }

  public static int Guests(int n, int[] happiness) {
    Arrays.sort(happiness);
    int maxGuests = 0;
    for (int i = 0; i < n; i++) {
      if (happiness[i] - i > 0) {
        maxGuests++;
      } else {
        break;
      }
    }
    return maxGuests;
  }
}
