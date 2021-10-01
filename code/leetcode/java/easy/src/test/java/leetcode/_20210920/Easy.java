package leetcode._20210920;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author asd <br>
 * @create 2021-07-12 1:26 PM <br>
 * @project leetcode <br>
 */
@Slf4j
public class Easy {
    @Test
    public void test1047() {}

    String res = "";
    private int maxLength = 0;

    public String longestWord(String[] words) {
        // https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/gong-shui-san-xie-yi-ti-shuang-jie-er-we-esm9/

        Trie tire = new Trie();
        for (String s : words) {
            tire.insert(s);
        }

        tire.dfs(tire.root);
        return tire.ans;
    }

    class Trie {

        String ans = "";

        private TrieNode root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String s) {
            TrieNode p = root;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (p.children[index] != null) {
                    p = p.children[index];
                    continue;
                }

                p.children[index] = new TrieNode();
                p = p.children[index];
            }
            p.end = true;
            p.val = s;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String s) {
            TrieNode p = root;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (p.children[index] == null) {
                    return false;
                }
                p = p.children[index];
            }

            return p.end;
        }

        public void dfs(TrieNode node) {
            if (node == null || !node.end) {
                return;
            }

            String word = node.val;
            if (word == null) {

            } else if (word.length() > ans.length()
                    || word.length() == ans.length() && word.compareTo(ans) < 0) {
                ans = word;
            }

            for (TrieNode n : node.children) {
                dfs(n);
            }
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String s) {
            TrieNode p = root;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (p.children[index] == null) {
                    return false;
                }
                p = p.children[index];
            }

            return true;
        }

        class TrieNode {
            boolean end;
            String val;
            // HashMap<Character, TrieNode> children = new HashMap<>();
            TrieNode[] children = new TrieNode[26];
        }
    }

    public String removeDuplicates(String s) {

        StringBuffer stack = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            final int length = stack.length();
            if (length == 0 || stack.charAt(length - 1) != c) {
                stack.append(c);
            } else {
                stack.deleteCharAt(length - 1);
            }
        }

        return stack.toString();
    }
}
