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



class Result010 {

    /*
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int palindromeIndex(String s) {
        // Write your code here
        if (isPalindrome(s)) { return -1; }

        int index = IntStream.range(0, s.length() / 2)
                .filter(i -> s.charAt(i) != s.charAt(s.length() - 1 - i))
                .findFirst().orElse(-1);

        if (index == -1) { return -1; }

        String left = s.substring(0, index) + s.substring(index + 1);
        if (isPalindrome(left)) { return index; }

        String right = s.substring(0, s.length() - 1 - index) + s.substring(s.length() - index);
        if (isPalindrome(right)) { return s.length() - 1 - index; }

        return -1;
    }

    static boolean isPalindrome(String s) {
        return IntStream.range(0, s.length() / 2)
                .allMatch(i -> s.charAt(i) == s.charAt(s.length() - 1 - i));
    }
}



public class PalindromeIndex {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result010.palindromeIndex(s);

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
