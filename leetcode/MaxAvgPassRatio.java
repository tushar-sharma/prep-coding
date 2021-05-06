class Solution {

    private class Ratio {
        private Double delta;
        private int pass;
        private int total;

        public Ratio(Double delta, int pass, int total) {
            this.delta = delta;
            this.pass = pass;
            this.total = total;
        }
    }

    public static Double getRatio(int pass , int total) {
            double ratio1 = (double) pass / total;
            double ratio2 = (double) (pass + 1) / (total + 1);
            return ratio2 - ratio1;
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {

        Queue<Ratio> pq = new PriorityQueue<Ratio>( (a,b) -> b.delta.compareTo(a.delta));

        Double delta = 0.0;

        for (int i = 0; i < classes.length; i++) {

            delta = getRatio(classes[i][0], classes[i][1]);

            pq.add(new Ratio(delta, classes[i][0], classes[i][1]));
        }

        while (extraStudents > 0) {
            Ratio ratio = pq.poll();
            int pass = ratio.pass + 1;
            int total = ratio.total  + 1;

            delta = getRatio(pass, total);

            pq.add(new Ratio(delta, pass, total));

            extraStudents--;
        }

        Double sum = 0.0;
        while(!pq.isEmpty()) {

            Ratio obj = pq.poll();

            sum += (double) obj.pass  / obj.total;

        }


        return sum / classes.length;


    }
}
