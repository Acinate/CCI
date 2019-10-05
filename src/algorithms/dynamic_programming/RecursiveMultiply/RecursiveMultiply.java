package algorithms.dynamic_programming.RecursiveMultiply;

public class RecursiveMultiply {
    public int minProduct(int a, int b) {
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;
        return minProductHelper(smaller, bigger);
    }

    int minProductHelper(int smaller, int bigger) {
        if (smaller == 0) {
            return 0;
        } else if (smaller == 1) {
            return bigger;
        }

        /* Compute half. If uneven, compute other half. If even, double it. */
        int s = smaller >> 1;
        int side1 = minProductHelper(s, bigger);
        int side2 = side1;
        if (smaller % 2 == 1) {
            side2 = minProductHelper(smaller - s, bigger);
        }

        return side1 + side2;
    }
}
