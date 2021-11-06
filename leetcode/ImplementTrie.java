class TrieNode {
    private HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>(); 
    private boolean isWord; 
    private TrieNode parent; 
    private char c; 
    
    public TrieNode() {
        isWord = false;
    }
    
    public TrieNode insert(Character c) { 
        
        if (children.containsKey(c)) {
            return null;
        }
        
        TrieNode next = new TrieNode(); 
        next.parent = this; 
        next.c = c; 
        children.put(c, next); 
        return next;
    }
    
    public TrieNode getChild(Character c) { 
        return children.get(c); 
    }
    
    public void setEndsWord(boolean b) { 
        isWord = b; 
    }
    
    public boolean endsWord() {
        return isWord; 
    }
}

public class Trie {

    private TrieNode root; 
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(); 
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        // considering only lower case
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
        
        currentNode.setEndsWord(true); 
    }
    
    private TrieNode findTrieNode(TrieNode node, String key) {
        if (node == null || key.isEmpty()) 
            return node;
        return findTrieNode(node.getChild(key.charAt(0)), key.substring(1) );
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        word = word.toLowerCase(); 
        TrieNode currentNode = root;
        
        TrieNode node = findTrieNode(root, word); 
        
        if (node == null) { 
            return false; 
        } else  {
            if (node.endsWord()) {
                return true;
            }
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        prefix = prefix.toLowerCase(); 
        TrieNode currentNode = root;
        
        TrieNode node = findTrieNode(root, prefix); 
        
        if (node == null) { 
            return false; 
        } else 
            return true; 
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
