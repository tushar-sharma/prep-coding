#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;
/*resources
Konrad Rudolph algorithm - https://stackoverflow.com/questions/13685687/how-to-print-all-words-in-a-trie,
*/
struct trieNode {
    bool isWord;
    unordered_map<char, trieNode*> children;
    char key;
    unsigned frequency;
    string text;
};

trieNode * getChild(trieNode*& curr, char c) {
    //if not found
    if (curr->children.find(c) == curr->children.end()) {
        return NULL;
    } else {
        return curr;
    }
}
/**
 * Createa a new Trie node
 *
 * @param
 */
trieNode *createNode(trieNode* parent, char key, bool isWord) {

    trieNode *child =  new trieNode;
    child->isWord = false;
    child->key = '\0';
    child->frequency = 0;

    if (parent != NULL) {
        parent->isWord = isWord;
        parent->key = key;
        parent->children[key] = child;
        parent->frequency = 0;
    } else {
        parent = child;
    }

    return parent;
}

void addWord(trieNode*& curr, string word) {

    trieNode* currentNode = curr;
    char key;
    bool isWord = false;


    for (int i = 0; i < word.length(); i++) {

        key = word[i];
        //check if key exist
        if (getChild(currentNode, key) == NULL) {
            currentNode = createNode(currentNode, key, isWord);
        }

        currentNode = currentNode->children[key];
    }

    currentNode->isWord = true;
    currentNode->frequency = currentNode->frequency + 1;
    currentNode->text = word;
}

void printWord(trieNode*& curr , string& prefix) {
    trieNode* currentNode = curr;

    if (currentNode->isWord == true) {
        cout<<prefix<<endl;
    }

    for (auto child : currentNode->children)  {

        prefix.push_back(child.first);
        printWord(child.second, prefix);
        prefix.pop_back();
    }
}

void preorder(trieNode*& root, int& max_count, vector<string>& prefix) {

    trieNode* currentNode = root;

     for (auto child : currentNode->children) {

         if (max_count < child.second->frequency) {

            prefix.clear();

            max_count = child.second->frequency;
            prefix.push_back(child.second->text);
        }

         if (max_count == child.second->frequency) {
            prefix.push_back(child.second->text);
         }

        preorder(child.second, max_count, prefix);
    }
}


int main(void) {

    string words[] = {"geeks", "for", "geeks", "a",
                "portal", "to", "learn", "can",
                "be", "computer", "science",
                 "zoom", "yup", "fire", "in",
                 "be", "data", "geeks"};


    trieNode* root = createNode(NULL, '\0', false);

    for(size_t i = 0; i < sizeof(words) / sizeof(words[0]); i++) {
        addWord(root, words[i]);
    }

    vector<string> prefix;
    int max_count = 0;
    //printWord(root, prefix);
    preorder(root, max_count, prefix);

    cout<<"Most frequent words are : "<<endl;
    for (int i = 0; i < prefix.size(); i++) {
        cout<<prefix[i]<<endl;
    }


    return 0;
}
