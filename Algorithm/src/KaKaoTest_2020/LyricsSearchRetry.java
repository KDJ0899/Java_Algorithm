/**
 * 
 */
package KaKaoTest_2020;

import java.util.Map;
import java.util.HashMap;
/**
  * @FileName : LyricsSearchRetry.java
  * @Project : Algorithm
  * @Date : 2019. 11. 30.
  * @Author : Kim DongJin
  * @Comment : 2020카카오 가사 검색 문제.효율성에서 하나만 만족 못함(트리로 만들어야 함).
  * 		   트리로 다시 푼 문제.
 */
public class LyricsSearchRetry {
    private final int R = 26;
    private class TrieNode {
        private TrieNode[] next;
        private boolean isEnd;
        private TrieNode() {
            next = new TrieNode[R];
        }
    }
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        TrieNode root = new TrieNode();
        TrieNode revRoot = new TrieNode();
        // Map<Integer, Integer> depthCount = new HashMap<>();
        for (String word: words) {
            buildTrie(root, word);
            buildReverseTrie(revRoot, word);
        }
        // 검색 키워드는 중복될 수도 있습니다.
        Map<String, Integer> memo = new HashMap<>();
        for (int i = 0; i < queries.length; ++i) {
            if (memo.containsKey(queries[i])) {
                answer[i] = memo.get(queries[i]);
            } else {
                if (queries[i].charAt(0) == '?') {
                    answer[i] = lookup(revRoot, new StringBuilder(queries[i]).reverse().toString(), 0);
                } else {
                    answer[i] = lookup(root, queries[i], 0);
                }
                memo.put(queries[i], answer[i]);                
            }
        }
        return answer;
    }

    private void buildTrie(TrieNode root, String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            if (node.next[c - 'a'] == null) node.next[c - 'a'] = new TrieNode();
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
        // depthCount.put(word.length(), depthCount.getOrDefault(word.length()) + 1);
    }
    private void buildReverseTrie(TrieNode root, String word) {
        TrieNode node = root;
        for (int i = word.length() - 1; i >= 0; --i) {
            char c = word.charAt(i);
            if (node.next[c - 'a'] == null) node.next[c - 'a'] = new TrieNode();
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
        // depthCount.put(word.length(), depthCount.getOrDefault(word.length()) + 1);
    }
    private int lookup(TrieNode node, String query, int depth) {
        if (depth == query.length()) {
            if (node.isEnd) return 1;
            return 0;
        }
        char c = query.charAt(depth);
        int count = 0;
        if (c == '?') {
            for (int i = 0; i < R; ++i) {
                if (node.next[i] != null) count += lookup(node.next[i], query, depth + 1);
            }
            return count;
        } else {
            if (node.next[c - 'a'] != null) count = lookup(node.next[c - 'a'], query, depth + 1);
        }
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
