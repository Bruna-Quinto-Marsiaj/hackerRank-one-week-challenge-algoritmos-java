

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
import java.util.concurrent.atomic.AtomicInteger;

class Resulty {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        AtomicInteger countPositive = new AtomicInteger(0);
        AtomicInteger countNegative = new AtomicInteger(0);
        AtomicInteger countZero = new AtomicInteger(0);

        arr.forEach(i -> {
            if(i == 0){
                countZero.incrementAndGet();
            } else if (i > 0){
                countPositive.incrementAndGet();
            } else {
                countNegative.incrementAndGet();
            }
        });

        double size = arr.size();
        double proportionPositive = countPositive.get() / size;
        double proportionNegative = countNegative.get() / size;
        double proportionZero = countZero.get() / size;

        System.out.printf("%.6f%n", proportionPositive);
        System.out.printf("%.6f%n", proportionNegative);
        System.out.printf("%.6f%n", proportionZero);
    }

}

public class PlusMinusCleanCode {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}

