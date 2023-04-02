
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

 class Resultzz {

     /*
      * Complete the 'timeConversion' function below.
      *
      * The function is expected to return a STRING.
      * The function accepts STRING s as parameter.
      */

     public static String timeConversion(String s) {
         // Write your code here
         String[] time = s.split(":");
         int hours = Integer.parseInt(time[0]);
         String minutes = time[1];
         String seconds = time[2].substring(0, 2);
         String dayEve = time[2].substring(2, 4);

         if (dayEve.equals("PM") && hours != 12){
             hours += 12;
         } else if (dayEve.equals("AM") && hours == 12){
             hours = 0;
         }

         StringJoiner joiner = new StringJoiner(":");
         joiner.add(String.format("%02d", hours))
                 .add(minutes)
                 .add(seconds);

         return joiner.toString();


     }

 }

 public class TimeConvertionCleanCode {
     public static void main(String[] args) throws IOException {
         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

         String s = bufferedReader.readLine();

         String result = Resultzz.timeConversion(s);

         bufferedWriter.write(result);
         bufferedWriter.newLine();

         bufferedReader.close();
         bufferedWriter.close();
     }
 }
