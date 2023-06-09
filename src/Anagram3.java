import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Resultggbd {

    /*
     * Complete the 'anagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int anagram(String s) {
        // Write your code here
        int n = s.length();
        if (n % 2 != 0) {
            return -1;
        }
        int[] freq = new int[26];
        for (int i = 0; i < n / 2; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        int changes = 0;
        for (int i = n / 2; i < n; i++) {
            int index = s.charAt(i) - 'a';
            if (freq[index] == 0) {
                changes++;
            } else {
                freq[index]--;
            }
        }
        return changes;

    }

}

public class Anagram3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Resultggbd.anagram(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}


