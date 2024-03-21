package stringMatching;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This class provides methods for pattern matching using the Rabin-Karp algorithm.
 * The Rabin-Karp algorithm is used to find all occurrences of a pattern in a text efficiently.
 */
public class Task1 {

  private static final int PRIME = 101;

  /**
   * This method Find all occurrences of a pattern in a text using the Rabin-Karp algorithm.
   *
   * @param pattern the pattern to search for
   * @param text    the text in which to search for the pattern
   * @return a list of indices where the pattern is found in the text
   */
  public static List<Integer> rabinKarp(String pattern, String text) {
    int patLen = pattern.length(), txtLen = text.length();
    long patHash = generateHash(pattern, patLen);

    return IntStream.range(0, txtLen - patLen + 1)
            .filter(i -> {
              long txtHash = generateHash(text.substring(i, i + patLen), patLen);
              return patHash == txtHash && pattern.equals(text.substring(i, i + patLen));
            })
            .boxed()
            .collect(Collectors.toList());
  }

  /**
   * This method generate a hash value for a string using the Rabin-Karp algorithm.
   *
   * @param str    the string for which to generate the hash
   * @param length the length of the string
   * @return the hash value of the string
   */
  private static long generateHash(String str, int length) {
    return IntStream.range(0, length)
            .mapToLong(i -> str.charAt(i) * (long)Math.pow(PRIME, i))
            .sum();
  }

  /**
   * The Main method to demonstrate the usage of the Rabin-Karp algorithm for pattern matching.
   * It searches for occurrences of a given pattern within a text and prints the matching substrings.
   */
  public static void main(String[] args) {
    String pattern = "aba";
    String text = "abacaba";
    List<Integer> matches = rabinKarp(pattern, text);

    System.out.println("Substrings matching the pattern:");
    matches.forEach(match -> System.out.println(text.substring(match, match + pattern.length())));
  }
}
