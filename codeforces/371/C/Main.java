import java.io.*;
import java.util.*;
/**
 * https://codeforces.com/group/KIrM1Owd8u/contest/267294/problem/A
 */
public class Main{

    public static long maximumHamburgers(String recipe,
                                       int[] number_of_items,
                                       int[] price_of_items,
                                       long money) {

        int[] req_items = new int[3];

        for (Character ch  : recipe.toCharArray()) {
            if (ch == 'B') {
                req_items[0] += 1;
            }
            else if (ch == 'S') {
                req_items[1] += 1;
            } else if (ch == 'C') {
                req_items[2] += 1;
            }
        }

        long num_hamburgers = 0;

        long left = 0;
        long right = Long.MAX_VALUE / 100000;

        while (left + 1 < right) {
            long mid = left + (right - left) / 2;

            long xb = Math.max(0, mid * req_items[0] - number_of_items[0]);
            long xs = Math.max(0, mid * req_items[1] - number_of_items[1]);
            long xc = Math.max(0, mid * req_items[2] - number_of_items[2]);

            if((xb * price_of_items[0]) + (xs * price_of_items[1]) + (xc * price_of_items[2]) <= money) {
                left = mid;
            }
            else
                right = mid;
        }

        return left;
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter wr = new PrintWriter(System.out);

        String recipe = br.readLine();

        String[] arr_number = br.readLine().split(" ");
        int[] number_of_items = new int[3];
        number_of_items[0] = Integer.parseInt(arr_number[0]);
        number_of_items[1]  = Integer.parseInt(arr_number[1]);
        number_of_items[2] = Integer.parseInt(arr_number[2]);

        String[] arr_price = br.readLine().split(" ");
        int[] price_of_items = new int[3];
        price_of_items[0] = Integer.parseInt(arr_price[0]);
        price_of_items[1]  = Integer.parseInt(arr_price[1]);
        price_of_items[2] = Integer.parseInt(arr_price[2]);

        long money = Long.parseLong(br.readLine());

        long maximum = maximumHamburgers(recipe,
                                        number_of_items,
                                        price_of_items,
                                        money);

        wr.println(maximum);
        wr.close();
        br.close();
    }
}
