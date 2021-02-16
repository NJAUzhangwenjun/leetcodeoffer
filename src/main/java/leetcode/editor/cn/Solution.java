package leetcode.editor.cn;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Result {


  public static String RemoveLetters(String s, List<Character> letters) {

    for (Character letter : letters) {
      s = s.replaceAll(String.valueOf(letter), "");
    }
    return s;
  }


  /*
   * Complete the 'sumOfAdjacentElements' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY array as parameter.
   */

  public static int sumOfAdjacentElements(List<Integer> array) {
     ArrayList<Integer> list = new ArrayList<>(array);
     ArrayList<Integer> ret = new ArrayList<>();

    while (ret.size() > 2) {
      list = new ArrayList<>(ret);
      ret = new ArrayList<>();
      for (int i = 0; i < list.size(); i += 2) {
        final int sum = list.get(i) + (i + 1) < list.size() ? list.get(i + 1) : 0;
        ret.add(sum);
      }
    }
    return ret.get(0) * ret.get(0) + ret.get(1) * ret.get(1);
  }
}

public class Solution {

  public static void main(String[] args) {
    final String qwertyrytu = Result.RemoveLetters("qwertyrytu", new ArrayList<Character>(Arrays.asList(new Character[]{'q', 'w'})));
    System.out.println("qwertyrytu = " + qwertyrytu);
    //
  }

  public static void main1(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int arrayCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> array =
        IntStream.range(0, arrayCount)
            .mapToObj(
                i -> {
                  try {
                    return bufferedReader.readLine().replaceAll("\\s+$", "");
                  } catch (IOException ex) {
                    throw new RuntimeException(ex);
                  }
                })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

    int result = Result.sumOfAdjacentElements(array);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
