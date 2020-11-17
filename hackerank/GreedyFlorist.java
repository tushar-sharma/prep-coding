import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {


        int numberOfFlowers = c.length;
        int remFlowers = numberOfFlowers;

        int minimumCost = 0;

        if (c.length == k){
            for (int i = 0; i < c.length; i++) {
                minimumCost += c[i];
            }
        } else {

            Map<Integer, Integer> map = new HashMap<>();

            Arrays.sort(c);

            int i;

            for (i =0; i < k; i++) {
                map.put(i, 1);
            }

            for (i = c.length - 1; i >= (c.length - k); i--) {
                minimumCost += c[i];
                numberOfFlowers--;
            }

            int index =0;
            while (numberOfFlowers-- > 0) {
                   if(index >= k) {
                      index = 0;
                  }
                  minimumCost += ((map.get(index) + 1) * c[i--]);
                  map.put(index, map.get(index) + 1);
                  index++;
            }

        }

        return minimumCost;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        bufferedWriter.write(String.valueOf(minimumCost));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

