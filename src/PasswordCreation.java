
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


class Resultuu {

    /*
     * Complete the 'newPassword' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public static String newPassword(String a, String b) {
        // Write your code here
        int i = 0, j = 0;
        char[] merged = new char[a.length() + b.length()];
        int k = 0;
        while (i < a.length() && j < b.length()){
            merged[k++] = a.charAt(i++);
            merged[k++] = b.charAt(j++);
        }
        while(i < a.length()){
            merged[k++] = a.charAt(i++);
        }
        while (j < b.length()){
            merged[k++] = b.charAt(j++);
        }
        return new String(merged);

    }

}

public class PasswordCreation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();

        String result = Resultuu.newPassword(a, b);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


