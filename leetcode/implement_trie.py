from dataclasses import dataclass, field

@dataclass
class Node:

    __children : dict = field(default_factory=lambda: defaultdict(list))
    __end_word : bool = False

    @property
    def children(self):
        return self.__children

    @property
    def end_word(self) -> bool:
        return self.__end_word

    @end_word.setter
    def end_word(self, end_word) -> None:
        self.__end_word = end_word


class Trie:

    def __init__(self):
        self.__root = Node()


    def insert(self, word: str) -> None:

        current = self.__root

        for c in word:
            children = current.children

            if c not in children:
                children[c] = Node()

            current = children[c]

        current.end_word = True


    def search(self, word: str) -> bool:
        current = self.__root

        for c in word:
            children = current.children

            if c not in children:
                return False

            current = children[c]

        return current.end_word

    def startsWith(self, prefix: str) -> bool:
        current = self.__root

        for c in prefix:
            children = current.children

            if c not in children:
                return False

            current = children[c]

        return True
