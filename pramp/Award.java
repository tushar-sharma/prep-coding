class Award {

    public static double checkBalance(double[] grantsArray, double mid, double newBudget) {

        double sum = 0;

        for (int i = 0; i < grantsArray.length; i++) {
            if (grantsArray[i] <= mid) {
                sum += grantsArray[i];
            } else {
                sum += mid;
            }
        }

        return (double) sum - newBudget;
    }

    public static double calculateCap(double low, double high, double[] grantsArray, double newBudget)
    {

        double mid = (low) + (high -low ) / 2;

        double balance = checkBalance(grantsArray, mid, newBudget);

        if (balance == 0.0) {
            return mid;
        } else if (balance > 0) {
            return calculateCap(low, mid, grantsArray, newBudget);
        } else {
            return calculateCap(mid, high, grantsArray, newBudget);
        }

    }


    public static double findGrantsCap(double[] grantsArray, double newBudget) {

        double cap = 0;

        cap = calculateCap(0, newBudget, grantsArray, newBudget);

        return cap;
    }

    public static void main(String[] args) {
        System.out.println(findGrantsCap(new double[]{2, 100, 50, 120, 1000}, 190));

        System.out.println(findGrantsCap(new double[]{2, 4, 6}, 3));
    }
}
