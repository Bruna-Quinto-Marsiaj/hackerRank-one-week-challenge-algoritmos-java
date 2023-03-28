
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

class BalancedBrackets {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        // Write your code here
        Stack<Character> str = new Stack();
        String ans = "YES";
        String no = "NO";
        boolean answer = true;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '{' || ch == '[' || ch == '('){
                str.push(ch);
                continue;
            }
            if(str.isEmpty()){
                return no;

            }
            if(ch == ')'){
                if(str.peek() == '('){
                    str.pop();
                }else{
                    answer = false;
                    break;
                }
            }
            if(ch == ']'){
                if(str.peek() == '['){
                    str.pop();
                }else{
                    answer = false;
                    break;
                }
            }
            if(ch == '}'){
                if(str.peek() == '{'){
                    str.pop();
                }else{
                    answer = false;
                    break;
                }
            }


        }
        if(!str.isEmpty()){
            answer = false;
        }
        if(answer)
            return ans;
        else
            return no;


    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = BalancedBrackets.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
