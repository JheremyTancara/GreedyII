package stringMatching;

import java.util.HashMap;
import java.util.Map;

/**
 * This class provides a method to find the most frequent sequence in a given string.
 * It calculates the frequency of all possible subsequences and returns the one with the highest frequency.
 */
public class Task2 {

  /**
   * This method finds the most frequent sequence in the given string.
   *
   * @param S the input string
   * @return the most frequent sequence along with its frequency
   */
  public static String findMostFrequentSequence(String S) {
    Map<String, Integer> sequenceCounts = new HashMap<>();

    for (int i = 0; i < S.length(); i++) {
      for (int j = i + 1; j <= S.length(); j++) {
        String sequence = S.substring(i, j);
        sequenceCounts.put(sequence, sequenceCounts.getOrDefault(sequence, 0) + 1);
      }
    }

    String mostFrequentSequence = "";
    int maxFrequency = 0;
    for (Map.Entry<String, Integer> entry : sequenceCounts.entrySet()) {
      String sequence = entry.getKey();
      int frequency = entry.getValue();
      if (frequency > maxFrequency || (frequency == maxFrequency && sequence.length() > mostFrequentSequence.length())) {
        mostFrequentSequence = sequence;
        maxFrequency = frequency;
      }
    }

    return mostFrequentSequence + " - " + maxFrequency;
  }

  /**
   * This Main method to find the most frequent sequence in a given string.
   *
   * @param args command line arguments (not used)
   */
  public static void main(String[] args) {
    String S = "abababc";
    String result = findMostFrequentSequence(S);
    System.out.println("Output: " + result);
  }
}
