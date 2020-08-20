import java.io.*;
import java.util.*;
/*
 * https://codeforces.com/contest/1191/problem/A
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter wr = new PrintWriter(System.out);

        int hp = Integer.parseInt(br.readLine().trim());
        int rem = hp % 4;
        int change = 0;
        char[] ctg = {'D', 'A', 'C', 'B'};

        for (int i = 1; i <= 2; i++) {
            int new_rem = (hp + i) % 4;

            if (ctg[rem] > ctg[new_rem]) {
                rem = new_rem;
                change = i;
            }
        }

        wr.println(change + " " + ctg[rem]);

        wr.close();
        br.close();
    }
}
/*
 ** Test cases
 - 33
   0 A
 - 98
   1 B
 - 43
   2 A
 */
