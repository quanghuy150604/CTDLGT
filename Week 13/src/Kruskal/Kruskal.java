package Kruskal;


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'kruskals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts WEIGHTED_INTEGER_GRAPH g as parameter.
     */

    /*
     * For the weighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i]. The weight of the edge is <name>Weight[i].
     *
     */

    public static int kruskals(int numOfNodes, List<Integer> from, List<Integer> to, List<Integer> weight) {
        List<Tree> edges = new ArrayList<>();

        for (int i = 0; i < from.size(); i++) {
            edges.add(new Tree(from.get(i), to.get(i), weight.get(i)));
        }

        Collections.sort(edges);

        int result = doKruskal(edges, numOfNodes, edges.size());
        return result;
    }

    public static int doKruskal(List<Tree> edges, int numOfNodes, int numOfEdges) {
        int[] parentArray = new int[numOfNodes + 1];
        int result = 0;

        for (int i = 1; i <= numOfNodes; i++) {
            parentArray[i] = i;
        }

        for (int j = 0; j < numOfEdges; j++) {
            int x = findParent(parentArray, edges.get(j).start);
            int y = findParent(parentArray, edges.get(j).end);

            if (x != y) {
                doUnion(parentArray, x, y);
                result += edges.get(j).weight;
            }
        }

        return result;
    }

    public static void doUnion(int[] parentArray, int x, int y) {
        int rootX = findParent(parentArray, x);
        int rootY = findParent(parentArray, y);
        parentArray[rootX] = rootY;
    }

    public static int findParent(int[] parentArray, int i) {
        if (parentArray[i] == i) {
            return i;
        }
        return findParent(parentArray, parentArray[i]);
    }

}
class Tree implements Comparable<Tree> {
    int start;
    int end;
    int weight;

    Tree(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Tree other) {
        if (this.weight > other.weight) {
            return 1;
        } else if (this.weight < other.weight) {
            return -1;
        } else {
            return Integer.compare(this.start + this.end + this.weight, other.start + other.end + other.weight);
        }
    }

    @Override
    public String toString() {
        return this.start + " " + this.end + " " + this.weight;
    }
}
public class Kruskal {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int gNodes = Integer.parseInt(gNodesEdges[0]);
        int gEdges = Integer.parseInt(gNodesEdges[1]);

        List<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();

        IntStream.range(0, gEdges).forEach(i -> {
            try {
                String[] gFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                gFrom.add(Integer.parseInt(gFromToWeight[0]));
                gTo.add(Integer.parseInt(gFromToWeight[1]));
                gWeight.add(Integer.parseInt(gFromToWeight[2]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = Result.kruskals(gNodes, gFrom, gTo, gWeight);

        // Write your code here.
        bufferedWriter.write(String.valueOf(res));

        bufferedReader.close();
        bufferedWriter.close();
    }
}