/*
 * https://leetcode.com/problems/replace-words/
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

class TrieNode {
     Map<Character, TrieNode> children = new HashMap<>();
     boolean isWord;
}

class ReplaceWords {

    class Trie{
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }


        public String searchReplace(String word) {

            TrieNode current = null;
            StringBuilder sb = new StringBuilder();

            Map<Character, TrieNode> children = root.children;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (children.containsKey(c)) {
                    current = children.get(c);
                    sb.append(c);
                    if (current.isWord) {
                        return sb.toString();
                    }
                } else{
                    if (current != null && current.isWord) {
                        return sb.toString();
                    } else {
                        return null;
                    }
                }
                children = current.children;
            }

            if (current == null) {
                return null;
            } else{
                return sb.toString();
            }

        }

        public void addWord(String word) {
            Map<Character, TrieNode> children = root.children;

            TrieNode current = null;


            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (children.containsKey(c)) {
                    current = children.get(c);
                } else {
                    current = new TrieNode();
                    children.put(c, current);
                }

                children = current.children;

                if (i == word.length() -1) {
                    current.isWord = true;
                }
            }
        }
    }

    public String replaceWords(List<String> dict, String sentence) {

        //make a Trie of dictionary
        Trie trie = new Trie();

        Iterator<String> iter = dict.iterator();

        while(iter.hasNext()) {
            trie.addWord(iter.next());
        }
        //for each words in a sentence search if root exist
        //replace if exist
        //
        String[] spltSentence = sentence.split("\\s+");

        for (int i = 0; i < spltSentence.length; i++) {
            String text = trie.searchReplace(spltSentence[i]);

            if (text != null) {
                spltSentence[i] = text;
            }
        }

        return String.join(" ", spltSentence);
    }

    public static void main(String[] args) {
        ReplaceWords obj = new ReplaceWords();

        String testSentence = "the cattle was rattled by the battery";
        List<String> testList = new ArrayList();
        testList.add("cat");
        testList.add("bat");
        testList.add("rat");

        System.out.println(obj.replaceWords(testList, testSentence));

    }

}
