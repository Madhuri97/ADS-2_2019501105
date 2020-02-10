/**
 * @author Madhuri
 */
public class CircularSuffixArray {
    private static final int CUTOFF = 16;
    private int length;
    private int[] index;

    public CircularSuffixArray(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        this.length = s.length();
        this.index = new int[this.length];
        for (int i = 0; i < this.length; i++) {
            index[i] = i;
        }
        threeWayquickSort(s, 0, this.length-1, 0);
    }

    public int length() {
        return this.length;
    }

    public int index(int i) {
        if (i < 0 || i > length()) {
            throw new IndexOutOfBoundsException(" "+i);
        }
        return this.index[i];
    }

    private char charAt(String s, int shift, int start) {
        return s.charAt((start+shift) % this.length);
    }

    private boolean isLess(String s, int i, int j, int pos) {
        int shifti = index[i], shiftj = index[j];
        for (int k = pos; k < this.length; k++) {
            int ival = charAt(s, shifti, k), jval = charAt(s, shiftj, k);
            if (ival < jval) {
                return true;
            }
            if (ival > jval) {
                return false;
            }
        }
        return false;
    }

    private void exch(int i, int j) {
        int tmp = index[j];
        index[j] = index[i];
        index[i] = tmp;
    }

    private void insertionSort(String s, int lo, int hi, int pos) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && isLess(s, j, j-1, pos); j--) {
                exch(j, j - 1);
            }
        }
    }

    private void threeWayquickSort(String s, int lo, int hi, int pos) {
        if (hi-lo <= CUTOFF) {
            insertionSort(s, lo, hi, pos);
        } else {
            // exchange
            int lt = lo, gt = hi, piv = charAt(s, index[lo], pos), eq = lo+1;
            while (eq <= gt) {
                int t = charAt(s, index[eq], pos);
                if (t < piv) {
                    exch(lt++, eq++);
                } else if (t > piv) {
                    exch(eq, gt--);
                } else {
                    eq++;
                }
            }

            // recursion
            threeWayquickSort(s, lo, lt-1, pos);
            if (piv >= 0) {
                threeWayquickSort(s, lt, gt, pos+1);
            }
            threeWayquickSort(s, gt+1, hi, pos);
        }
    }
}