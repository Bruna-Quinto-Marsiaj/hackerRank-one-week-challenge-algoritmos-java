
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

class Result2 {

    /*
     * Complete the 'noPrefix' function below.
     *
     * The function accepts STRING_ARRAY words as parameter.
     */

    public static void noPrefix(List<String> words) {
        // Write your code here
        Trie trie = new Trie();
        boolean good = true;
        for (String word : words) {
            if (trie.insert(word)) {
                System.out.println("BAD SET");
                System.out.println(word);
                good = false;
                break;
            }
        }
        if (good)
            System.out.println("GOOD SET");
    }
}

class Trie {
    int LEN = 'j' - 'a' + 1;
    Node root = new Node();

    class Node {
        Node [] children;
        boolean wordleaf;

        Node() {
            children = new Node[LEN];
            wordleaf = false;
        }
    }

    // return true if prefix, otherwise false
    boolean insert(String str) {
        return insert(str, root);
    }

    boolean insert(String str, Node node) {
        if (str == null || str.length() < 1) return false;
        char c = str.charAt(0);
        Node child = node.children[c - 'a'];
        if (child == null) {
            // extend
            child = new Node();
            node.children[c - 'a'] = child;
        }
        // support both prefix cases, such as (a, ab) and (ab, a)
        else if (child.wordleaf || str.length() == 1) {
            return true;
        }

        if (str.length() == 1) {
            child.wordleaf = true;
            return false;
        }
        return insert(str.substring(1), child);
    }

}

public class  NoPrefixSet  {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> words = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        Result2.noPrefix(words);

        bufferedReader.close();
    }
}
