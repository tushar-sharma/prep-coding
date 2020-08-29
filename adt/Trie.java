import java.util.Map;
import java.util.HashMap;

class TrieNode{

    boolean isWord;
    char key;
    Map<Character, TrieNode> children = new HashMap<>();
}

class Trie{

    private static TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    //add each letter of the word to the trie
    public static void addWord(String word) {

        Map<Character, TrieNode> children = root.children;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            TrieNode current;

            if (children.containsKey(c)) {
                current = children.get(c);
            } else{
                current = new TrieNode();
                children.put(c, current);
            }

            children  = current.children;

            if (i == word.length() - 1) {
                //set node as last node
                current.isWord = true;
            }
        }
    }

    public boolean search(String word) {

        TrieNode current = searchNode(word);

        if (current != null && current.isWord) {
            return true;
        } else {
            return false;
        }
    }

    public TrieNode searchNode(String word) {
        Map<Character, TrieNode> children = root.children;

        TrieNode current = null;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (children.containsKey(c)) {
                current = children.get(c);
                children = current.children;
            } else {
                return null;
            }
        }

        return current;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.addWord("amy");
        trie.addWord("ann");

        System.out.println(trie.search("ann"));
    }
}
