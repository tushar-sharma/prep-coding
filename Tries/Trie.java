import java.util.HashMap;

public class Trie {


    private class TrieNode {

        private boolean isWord;
        private HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        Character key;

        /**
         * Insert "Key" character in the trie data structure
         *
         * @param key
         *
         * @return the newly created TrieNode, or null if the node already contains character "key"
         */
        public TrieNode insert(Character key) {
            if (children.containsKey(key)) {
                return null;
            }

            TrieNode next = new TrieNode();
            next.key = key;
            children.put(key, next);

            return next;
        }

        public TrieNode getChild(Character c) {
            return children.get(c);
        }

        public String getText() {
            StringBuilder text = new StringBuilder();
            text.append(c);

        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void addWord(String word) {

        word = word.toLowerCase();
        TrieNode currentNode = root;

        for (Character c : word.toCharArray()) {

            TrieNode child = currentNode.getChild(c);
            if (child == null) {
                currentNode = currentNode.insert(c);
            } else {
                currentNode = child;
            }
        }
    }

    public void printNode(TrieNode curr) {
        if (curr == null) {
            return;
        }

        System.out.println(curr.getText());

    }

    public static void main(String[] args) {

        Trie current = new Trie();

        current.addWord("String");

    }
}
