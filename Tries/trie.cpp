#include <iostream>
#include <unordered_map>

using namespace std;

struct trieNode {
    bool isWord;
    unordered_map<char, trieNode*> children;
    char key;
};

trieNode * getChild(trieNode*& curr, char c) {
    if (curr->children.find(c) == curr->children.end()) {
        return NULL;
    }
}

void addWord(trieNode*& root, string word) {

    trieNode* currentNode = root;
    char key;

    for (int i = 0; i < word.length(); i++) {
        key = word[i];
        if (getChild(currentNode, key) == NULL) {
            currentNode->children[key] = new trieNode;
        }

        currentNode = currentNode->children[key];
    }

}

int main(void) {

    string word[] = {"String"};

    trieNode* root = new trieNode;

    addWord(root, "string");
    return 0;
}
