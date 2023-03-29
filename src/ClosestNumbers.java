
import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

class Result007 {

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        int minAbs = Integer.MAX_VALUE; //Minimum absolute difference
        List<Integer> pairs = new ArrayList<>();

        for(int i = 0; i < arr.size() - 1; i++) {
            int absDiff;

            if((arr.get(i) < 0 && arr.get(i+1) < 0) || (arr.get(i) > 0 && arr.get(i+1) > 0)) {
                absDiff = Math.abs(arr.get(i) - arr.get(i+1)); //Absolute difference
            } else {
                absDiff = Math.abs(arr.get(i)) + Math.abs(arr.get(i+1)); //Absolute difference
            }

            if(absDiff < minAbs) { //New minAbs
                minAbs = absDiff;
                pairs.clear(); //Clear pairs
                pairs.add(arr.get(i)); //Add pair
                pairs.add(arr.get(i+1));
            } else if(absDiff == minAbs) { //Multiple minAbs
                pairs.add(arr.get(i)); //Add pair
                pairs.add(arr.get(i+1));
            }
        }

        return pairs;
    }

}

public class ClosestNumbers  {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        List<Integer> result = Result007.closestNumbers(arr);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
