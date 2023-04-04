
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


class Resultggb {

    /*
     * Complete the 'anagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int anagram(String s) {
        // Write your code here
        int n = s.length();
        if (n % 2 != 0){
            return -1;
        }
        String s1 = s.substring(0, n/2);
        String s2 = s.substring(n/2);
        Map<Character, Integer> freq = new HashMap<>();

        s1.chars(). forEach(c -> freq.put((char) c, freq.getOrDefault((char) c, 0) + 1));
        int changes = 0;

        for(int i = 0; i < s2.length(); i++){
            char c = s2.charAt(i);
            if(!freq.containsKey(c) || freq.get(c) == 0){
                changes++;
            } else {
                freq.put(c, freq.get(c) - 1);
            }
        }
        return changes;

    }

}

public class Anagram2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Resultggb.anagram(s);

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

