class Node {
    private Map<Character, Node> children = new HashMap<>();
    private boolean isWord;

    public Map<Character, Node> getChildren() {
        return children;
    }

    public void setEndOfWord(boolean isWord) {
        this.isWord = isWord;
    }

    public boolean isEndOfWord() {
        return isWord;
    }
}

class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void addWord(String word) {
        Node current = root;

        for (char c : word.toCharArray()) {

            current = current.getChildren().computeIfAbsent(c , x -> new Node());
        }

        current.setEndOfWord(true);
    }

    public boolean search(String word) {

        boolean[] found = new boolean[word.length() + 1];
        found[0] = true;

        for (int i = 0; i < word.length(); i++) {

            if (found[i]) {
                Node current = root;

                for (int j = i; j < word.length(); j++ ){

                    if (current == null) {
                        break;
                    }

                    current = current.getChildren().get(word.charAt(j));

                    if (current != null && current.isEndOfWord()) {
                        found[j + 1] = true;
                    }

                }
            }
        }

        return found[word.length()];

    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        Trie trie = new Trie();

        for (String word : wordDict) {
            trie.addWord(word);
        }

        return trie.search(s);
     }
}
