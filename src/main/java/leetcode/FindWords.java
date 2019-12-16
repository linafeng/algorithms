package leetcode;

import java.util.*;

public class FindWords {
    public static void main(String[] args) {
        String[]  words = new String[]{"oath", "pea", "eat", "rain"};
        char[][] board =new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};

        FindWords FindWords=new FindWords();
        List<String> words1 = FindWords.findWords(board, words);
        System.out.println(Arrays.toString(words1.toArray()));

    }

    public List<String> findWords(char[][] board, String[] words) {
        //构建字典树
        WordTrie myTrie = new WordTrie();
        TrieNode root = myTrie.root;
        for (String s : words)
            myTrie.insert(s);
        return new LinkedList<String>(findWordsByTrie(board,root));
    }

    public List<String> findWordsByTrie(char[][] board,TrieNode root) {
        //使用set防止重复
        Set<String> result = new HashSet<>();
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        //遍历整个二维数组
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                find(board, visited, i, j, row, col, result, root);
            }
        }
        return new LinkedList<String>(result);
    }


    private void find(char[][] board, boolean[][] visited, int i, int j, int row, int col, Set<String> result, TrieNode cur) {
        //边界以及是否已经访问判断
        if (i < 0 || i >= row || j < 0 || j >= col || visited[i][j])
            return;
        cur = cur.child[board[i][j] - 'a'];
        if (cur == null) return;
        visited[i][j] = true;
        //找到单词加入
        if (cur.isLeaf) {
            result.add(cur.val);
        }
        find(board, visited, i + 1, j, row, col, result, cur);
        find(board, visited, i, j + 1, row, col, result, cur);
        find(board, visited, i, j - 1, row, col, result, cur);
        find(board, visited, i - 1, j, row, col, result, cur);

        visited[i][j] = false;
    }


}

//字典树
class WordTrie {
    public TrieNode root = new TrieNode();

    public void insert(String s) {
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            if (cur.child[c - 'a'] == null) {
                cur.child[c - 'a'] = new TrieNode();
                cur = cur.child[c - 'a'];
            } else
                cur = cur.child[c - 'a'];
        }
        cur.isLeaf = true;
        cur.val = s;
    }
}

//字典树结点
class TrieNode {
    public String val;
    public TrieNode[] child = new TrieNode[26];
    public boolean isLeaf = false;

    TrieNode() {

    }
}

