class TrieNode:
    def __init__(self):
        self.child = {}
        self.is_end = False

class Solution:
    def replaceWords(self, dictionary, sentence):
        root = TrieNode()

        for word in dictionary:
            current = root
            for ch in word:
                if ch not in current.child:
                    current.child[ch] = TrieNode()
                current = current.child[ch]
            current.is_end = True

        def find_root(word):
            current = root
            prefix = ""

            for ch in word:
                if ch not in current.child:
                    return word

                current = current.child[ch]
                prefix += ch

                if current.is_end:
                    return prefix

            return word

        words = sentence.split()
        result = []

        for word in words:
            result.append(find_root(word))

        result = " ".join(result)
        return result