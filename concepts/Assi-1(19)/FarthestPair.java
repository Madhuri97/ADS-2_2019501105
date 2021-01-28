/**
 * Farthest pair (in one dimension). Write a program that,
 * given an array a[] of N double values, finds a farthest
 * pair : two values whose difference is no smaller than 
 * the difference between any other pair. The running time 
 * of your program should be linear in the worst case. 
 * (Analysis of Algorithms)
 */

public class FarthestPair {
    static class pair {
        double min;
        double max;
    }
    static pair Fpair(double[] a) {
        pair p = new pair();
        int i;
        int N = a.length;
        for(i = 0; i < N - 1; i++) {
            if(N == 0) {
                p.max = a[i];
                p.min = a[i];
            } else if(a[i] < a[i + 1]) {
                p.min = a[i];
                p.max = a[i+1];
            } else {
                p.max = a[i];
                p.min = a[i+1];
            } if(a[i] > p.max) {
                p.max = a[i];
            } else if (a[i] < p.min) {
                p.min = a[i];
            }
        }
        return p;
    }

    public static void main(String[] args) {
        double a[] = {3.1, 8.0, 2.3, 9.0, 1.0};
        pair p = Fpair(a);
        System.out.println("minimum value in array is: " + p.min);
        System.out.println("maximum value in array is: " + p.max);
        System.out.println("(" + p.min + ", " + p.max + ")");
    }
} 
