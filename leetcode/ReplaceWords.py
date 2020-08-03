"""
problem : https://leetcode.com/problems/replace-words/
"""
class TrieNode(object):
    def __init__(self):
        self.isWord = False
        self.children = {}

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def addWord(self, word):
        children = self.root.children
        current = None

        for i in xrange(0, len(word)):
            c = word[i]

            if c in children:
                current = children.get(c)
            else:
                current = TrieNode()
                children[c] = current

            children = current.children

            if i == (len(word) - 1):
                current.isWord = True


    def searchReplace(self, word):
        current = None
        children = self.root.children
        text = ""

        for i in xrange(0, len(word)):

            c = word[i]

            if c in children:
                current = children[c]
                text += c

                if current.isWord:
                    return text
            else:
                if current != None and current.isWord:
                    return text
                else:
                    return None

            children = current.children

        if current == None:
            return None
        else:
            return text


class Solution(object):


    def replaceWords(self, keys, sentence):
        """
        :type dict: List[str]
        :type sentence: str
        :rtype: str
        """

        trie = Trie()

        for key in keys:
            trie.addWord(key)

        sentences = sentence.split()
        output = []

        for s in sentences:
            text = trie.searchReplace(s)

            if text:
                output.append(text)
            else:
                output.append(s)

        return ' '.join(output)

