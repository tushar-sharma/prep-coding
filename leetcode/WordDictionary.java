/**
 * url : https://leetcode.com/problems/add-and-search-word-data-structure-design/
 */

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

class TrieNode{
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord;
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word){

        Map<Character, TrieNode> children = root.children;
        TrieNode current = null;

        for (int i = 0; i < word.length(); i++) {

            char key = word.charAt(i);

            if (children.containsKey(key)) {
                current = children.get(key);
            } else{
                current = new TrieNode();
                children.put(key, current);
            }

            children = current.children;

            if(i == (word.length() - 1)) {
                current.isWord = true;
            }
        }
    }

    public boolean search(String word) {

        return searchNode(word, root, 0);

    }

    public boolean searchNode(String word,
                               TrieNode current,
                               int len) {
        boolean res = false;

        if (current == null) {
            return false;
        }

        else if (len == word.length()) {
            if (current.isWord) {
                res = res || true;
            }
        }

        else if (word.charAt(len) == '.') {

            for (Map.Entry<Character, TrieNode> entry : current.children.entrySet()) {
                res = res || searchNode(word,
                                  entry.getValue(),
                                  len + 1);
            }

        } else {

            if(current.children.containsKey(word.charAt(len))) {
                res = res ||  searchNode(word,
                           current.children.get(word.charAt(len)),
                           len + 1);
            }
        }

        return res;

    }

    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("at");
        obj.addWord("and");
        obj.addWord("an");
        obj.addWord("add");

        System.out.println(obj.search("a"));
        System.out.println(obj.search(".at"));

        obj.addWord("bat");

        System.out.println(obj.search(".at"));
        System.out.println(obj.search("b.t"));


    }

}
