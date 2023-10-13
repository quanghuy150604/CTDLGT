import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        // Write your code here
        Stack<Character> a = new Stack<>();
        for (char b : s.toCharArray()){
            if (b == '(' || b == '[' || b == '{'){
                a.push(b);
            }
            else if (b == ')'){
                if (a.empty()) return "NO";
                if (a.peek() == '(') {
                    a.pop();
                }
                else {
                    return "NO";
                }
            }
            else if (b == '}'){
                if (a.empty()) return "NO";
                if (a.peek() == '{') {
                    a.pop();
                }
                else {
                    return "NO";
                }
            }
            else if (b == ']'){
                if (a.empty()) return "NO";
                if (a.peek() == '[') {
                    a.pop();
                }
                else {
                    return "NO";
                }
            }
        }

        if (!a.empty()) return "NO";

        return "YES";

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

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
