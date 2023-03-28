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


class TruckTour {

    /*
     * Complete the 'truckTour' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
     */

    public static int truckTour(List<List<Integer>> petrolpumps) {
        // Write your code here
        int size = petrolpumps.size();
        long petrol ;
        long distance ;
        boolean isPassed  ;
        for(int i = 0 ;i < size; i++){
            petrol = 0;
            distance = 0;
            isPassed = true;
            for(int j = i ;j < size; j++){
                petrol += petrolpumps.get(j).get(0);
                distance += petrolpumps.get(j).get(1);
                if(distance > petrol ){
                    isPassed = false;
                    break;
                }

            }

            for(int x = 0;x < i;x++){
                petrol += petrolpumps.get(x).get(0);
                distance += petrolpumps.get(x).get(1);
                if(distance > petrol ){
                    isPassed = false;
                    break;
                }
            }

            if(isPassed){
                return i ;
            }
        }
        return -1;
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> petrolpumps = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                petrolpumps.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = TruckTour.truckTour(petrolpumps);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
