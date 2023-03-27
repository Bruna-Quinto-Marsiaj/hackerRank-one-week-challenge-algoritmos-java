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

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int countPositive = 0, countNegative =0, countZero = 0;
        for(Integer i: arr){
            if(i==0) countZero += 1;
            else if (i>0) countPositive += 1;
            else countNegative +=1;
        }
        System.out.printf("%.6f%n", (double) countPositive / arr.size());
        System.out.printf("%.6f%n", (double) countNegative / arr.size());
        System.out.printf("%.6f%n", (double) countZero / arr.size());


    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        //int n = 6;
        //List<Integer> arr = Arrays.asList(-4,3,-9,0,4,1);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
