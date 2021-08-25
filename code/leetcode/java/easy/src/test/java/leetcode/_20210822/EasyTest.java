package leetcode._20210822;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zack <br>
 * @create 2021-08-15<br>
 * @project leetcode <br>
 */
@Slf4j
public class EasyTest {

    @Test
    public void test3() {

        lengthOfLongestSubstring("tmmzuxt");
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();

        int res = 0;
        int valid = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (window.getOrDefault(c, 0) <= 0) {
                valid++;
                res = Math.max(valid, res);
            }
            window.put(c, window.getOrDefault(c, 0) + 1);

            // 收缩 left 边界
            while (window.get(c) > 1) {
                char removed = s.charAt(left);
                left++;
                window.put(removed, window.getOrDefault(removed, 0) - 1);
                valid = right - left;
            }
        }

        return res;
    }

    @Test
    public void test76() {

        minWindow("ADOBECODEBANC", "ABC");
    }

    public String minWindow(String s, String t) {
        // init template
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.compute(t.charAt(i), (k, v) -> v == null ? 1 : ++v);
            // need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        // int startIndex=0;
        String res = null;
        int valid = 0;
        int left = 0, right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 收缩 left 边界
            while (valid == need.keySet().size()) {
                // 收割结果
                // [left, right]
                String tempResult = s.substring(left, right);
                if (res == null) {
                    res = tempResult;
                } else {
                    if (res.length() > tempResult.length()) {
                        res = tempResult;
                    }
                }

                char removed = s.charAt(left);
                left++;
                if (need.containsKey(removed)) {
                    if (window.get(removed).equals((need.get(removed)))) {
                        valid--;
                    }
                    window.put(removed, window.getOrDefault(removed, 0) - 1);
                }
            }
        }

        return res;
    }

    void slidingWindow(String s, String t) {
        // init template
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        // TODO: result variable
        int valid = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 收缩 left 边界
            while (valid == need.keySet().size()) {
                // TODO: 收割结果

                char removed = s.charAt(left);
                left++;
                if (need.containsKey(removed)) {
                    if (window.get(removed).equals((need.get(removed)))) {
                        valid--;
                    }
                    window.put(removed, window.getOrDefault(removed, 0) - 1);
                }
            }
        }
    }

    @Test
    public void test832() {
        int[][] a = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        flipAndInvertImage(a);
    }

    public int[][] flipAndInvertImage(int[][] image) {

        int rows = image.length;
        int cloumns = image[0].length - 1;
        for (int i = 0; i < rows; i++) {
            int l = 0, r = cloumns;
            while (l < r) {
                int temp = image[i][l];
                image[i][l] = image[i][r];
                image[i][r] = temp;
                l++;
                r--;
            }

            // for (int j =0; j<=cloumns; j++) {
            //     image[i][j] = image[i][j] ^ 1;
            // }
        }

        return image;
    }

    @Test
    public void test824() {
        toGoatLatin("I speak Goat Latin");
    }

    public String toGoatLatin(String S) {
        Set<Character> vowel = new HashSet();
        for (char c : new char[] {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}) {
            vowel.add(c);
        }

        StringBuilder res = new StringBuilder();
        StringBuilder word = new StringBuilder();
        int t = 1;
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(c);
                continue;
            }

            if (word.length() > 0) {
                char first = word.charAt(0);
                if (!vowel.contains(first)) {
                    word.delete(0, 1);
                    word.append(first);
                }
                word.append("ma");
                for (int i = 0; i < t; i++) {
                    word.append("a");
                }
                t++;
                res.append(word);

                word = new StringBuilder();
            }

            if (!Character.isLetter(c)) {
                res.append(c);
            }
        }

        return res.toString().substring(0, res.length() - 1);
    }

    @Test
    public void test771() {
        numJewelsInStones("aA", "aAAbbbb");
    }

    public int numJewelsInStones(String J, String S) {

        StringBuilder res = new StringBuilder();
        StringBuilder word = new StringBuilder();
        word.charAt(0);

        res.append(word);

        int len = J.length();
        int[] type = new int[64];
        for (int i = 0; i < len; i++) {
            type[J.charAt(i) - 'A'] = 1;
        }
        int ans = 0;
        len = S.length();
        for (int i = 0; i < len; i++) {
            ans += type[S.charAt(i) - 'A'];
        }
        return ans;
    }
}
