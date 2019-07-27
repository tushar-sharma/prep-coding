/**
 * Things to learn;
 *  - comparator
 *  - splitting
 * - pattern regex
 * reference : https://leetcode.com/problems/reorder-log-files/
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.*;

public class ReorderLog {


    /**
     * @param String of logs
     * @return final order of the logs
     */
    public static String[] reorderLogFiles(String[]  logs) {
        //using Comparator
        //
        //print the string[] logs
        for (int i = 0; i < logs.length; i++) {
            System.out.println(logs[i]);
        }

        System.out.println("\n\n***sorting***\n\n");


        Arrays.sort(logs, new ComparatorLogs());

        //print the string[] logs
        for (int i = 0; i < logs.length; i++) {
            System.out.println(logs[i]);
        }

        return logs;
    }

    public static void main(String[] args) {

        String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};

        reorderLogFiles(logs);
    }

    static class ComparatorLogs implements Comparator<String> {
        String regexStr = "[a-z\\s]*";
        Pattern pattern;
        @Override
        public int compare(String log1, String log2) {
            String[] log1Array = log1.split("\\s+", 2);
            String[] log2Array = log2.split("\\s+", 2);

            boolean matchLog1 = pattern.matcher(log1Array[1]).matches();
            boolean matchLog2 = pattern.matcher(log2Array[1]).matches();

            //Assume len(log1Array) > 1 && len(log2Array) > 1

            // sort them lexiographically
            if ( matchLog1 == true && matchLog2 == true) {
                int result = log1Array[1].compareTo(log2Array[1]);

                if (result == 0) {
                    //compare the identifier
                    return log1Array[0].compareTo(log2Array[0]);
                } else {
                    return result;
                }
            }
            else if (matchLog1 != matchLog2) {

                return matchLog1 ? -1 : 1;

            }

            return 0;

        }

        public ComparatorLogs() {
            pattern = Pattern.compile(regexStr);
        }

    }
}
