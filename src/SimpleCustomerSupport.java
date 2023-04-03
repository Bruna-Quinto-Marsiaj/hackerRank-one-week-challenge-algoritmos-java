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


class Resultvv {

    /*
     * Complete the 'matchingBraces' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY braces as parameter.
     */

    public static List<String> matchingBraces(List<String> braces) {
        // Write your code here
        List<String> result = new ArrayList<>();
        for (String str : braces) {
            Stack<Character> stack = new Stack<>();
            boolean isBalanced = true;
            for (char c : str.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        isBalanced = false;
                        break;
                    } else {
                        char top = stack.pop();
                        if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                            isBalanced = false;
                            break;
                        }
                    }
                }
            }
            if (!stack.isEmpty()) {
                isBalanced = false;
            }
            result.add(isBalanced ? "YES" : "NO");
        }
        return result;
    }

}

public class SimpleCustomerSupport {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int bracesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> braces = IntStream.range(0, bracesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Resultvv.matchingBraces(braces);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}



