package fundamentals.programmingmodel;

import java.util.List;

/**
 * The BinarySearch class provides a static method for binary searching for an
 * integer in a sorted array of integers.
 * @author zack.zhang
 *
 */
public class BinarySearch {

    /**
     * Returns the index of the specified key in the specified array.
     * @param key the search key
     * @param a the array of integers, must be sorted in ascending order
     * @return index of key in array if present return -1
     */
    public static int rank(int key, List<Integer> a) {

        int low = 0;
        int high = a.size() - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (key > a.get(mid)) {
                low = mid + 1;
            } else if (key < a.get(mid)) {
                high = mid - 1;
            } else {
                return mid;
            }

        }
        return -1;
    }
}