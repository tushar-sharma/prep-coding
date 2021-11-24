class Node{
    private boolean isWord;
    private Map<Character, Node> children = new HashMap<>();

    public void setEndOfWord(boolean isWord)  {
        this.isWord = isWord;
    }

    public boolean isEndOfWord() {
        return isWord;
    }

    public Map<Character, Node> getChildren() {
        return children;
    }
}

class Trie {

    private Node root;

    public Trie() {
        root = new Node();

    }

    public void insert(String word) {
        Node current = root;

        for (char c: word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(c, x -> new Node());
        }
        current.setEndOfWord(true);
    }

    public boolean search(String word) {
        Node current = root;

        for (char c : word.toCharArray() ) {
            current = current.getChildren().get(c);

            if (current == null){
                return false;
            }

        }

        return current.isEndOfWord();
    }

    public boolean startsWith(String prefix) {
        Node current = root;

        for (char c : prefix.toCharArray() ) {
            current = current.getChildren().get(c);

            if (current == null){
                return false;
            }

        }

        return true;

    }
}
