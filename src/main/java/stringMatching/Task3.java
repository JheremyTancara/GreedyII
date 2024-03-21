package stringMatching;

import java.util.Scanner;

/**
 * This class provides functionality to find the longest suffix of a substring of text T
 * that matches the longest prefix of a given pattern P, for each length specified in a list of numbers.
 */
public class Task3 {

  /**
   * This method calculates the length of the longest prefix of the pattern.
   *
   * @param pattern The input pattern.
   * @return The length of the longest prefix.
   */

  private static int longestPrefixLength(String pattern) {
    int length = 0;
    for (int i = 1; i < pattern.length(); i++) {
      if (pattern.substring(0, i).equals(pattern.substring(pattern.length() - i))) {
        length = i;
      }
    }
    return length;
  }

  /**
   * This method finds the length of the longest match between a suffix of the text and a prefix of the pattern.
   *
   * @param text The input text.
   * @param pattern The input pattern.
   * @param prefixLength The length of the longest prefix of the pattern.
   * @return The length of the longest match.
   */

  private static int longestMatchLength(String text, String pattern, int prefixLength) {
    for (int i = prefixLength; i > 0; i--) {
      String suffix = text.substring(text.length() - i);
      String prefix = pattern.substring(0, i);
      if (suffix.equals(prefix)) {
        return i;
      }
    }
    return 0;
  }

  /**
   * This method reads input data, calculates the length of the longest match, and prints the results.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String T = scanner.next();
    String P = scanner.next();
    int x = scanner.nextInt();

    int[] numbers = new int[x];
    for (int i = 0; i < x; i++) {
      numbers[i] = scanner.nextInt();
    }

    int prefixLength = longestPrefixLength(P);

    for (int i = 0; i < x; i++) {
      int length = numbers[i];
      String substring = T.substring(0, length);
      int matchLength = longestMatchLength(substring, P, prefixLength);
      System.out.println(matchLength);
    }
  }
}
