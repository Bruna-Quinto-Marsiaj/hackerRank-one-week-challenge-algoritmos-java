
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



class Result008 {

    /*
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. 2D_INTEGER_ARRAY edges
     *  4. INTEGER s
     */

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        // Write your code here
        // Cria uma matriz de adjacência
        int[][] adjMatrix = new int[n][n];
        edges.forEach(e -> {
            int u = e.get(0) - 1;
            int v = e.get(1) - 1;
            adjMatrix[u][v] = adjMatrix[v][u] = 1;
        });

        // Executa a busca em largura a partir do vértice inicial
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(s - 1);

        boolean[] visited = new boolean[n];
        visited[s - 1] = true;

        int[] distance = IntStream.range(0, n)
                .map(i -> i == s - 1 ? 0 : Integer.MAX_VALUE)
                .toArray();

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v = 0; v < n; v++) {
                if (adjMatrix[u][v] == 1 && !visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                    distance[v] = distance[u] + 6;
                }
            }
        }

        // Cria e retorna a lista de distâncias calculadas
        return IntStream.range(0, n)
                .filter(i -> i != s - 1)
                .mapToObj(i -> distance[i] == Integer.MAX_VALUE ? -1 : distance[i])
                .collect(Collectors.toList());
    }
}


public class BreadFirstsearchShortest {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                List<List<Integer>> edges = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        edges.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = Result008.bfs(n, m, edges, s);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

