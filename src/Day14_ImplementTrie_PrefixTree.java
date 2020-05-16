/*
 Implement Trie (Prefix Tree)

 Solution
 Implement a trie with insert, search, and startsWith methods.

 Example:
    Trie trie = new Trie();
    trie.insert("apple");
    trie.search("apple");   // returns true
    trie.search("app");     // returns false
    trie.startsWith("app"); // returns true
    trie.insert("app");
    trie.search("app");     // returns true
 */

public class Day14_ImplementTrie_PrefixTree {
    private TrieNode root;
    private boolean startWith;

    public Day14_ImplementTrie_PrefixTree() {
        root = new TrieNode();
    }

    public void Insert(String word) {
        Insert(word,root,0);
    }

    private void Insert(String word, TrieNode root, int idx){
        if(idx==word.length()){
            root.isWord=true;
            return;
        }
        int index = word.charAt(idx)-'a';
        if(root.children[index]==null)
            root.children[index]=new TrieNode();
        Insert(word, root.children[index], idx+1);
    }

    public boolean Search(String word) {
        return Search(word, root, 0);
    }

    private boolean Search(String word, TrieNode root, int idx){
        if(idx==word.length()) {
            startWith = true;
            return root.isWord;
        }
        int index = word.charAt(idx)-'a';
        if(root.children[index]==null) {
            startWith = false;
            return false;
        }

        return  Search(word,root.children[index],idx+1);
    }

    public boolean StartsWith(String prefix) {
        Search(prefix);
        return startWith;
    }
}

class TrieNode {
    // Initialize your data structure here.
    public TrieNode[] children;
    public boolean isWord;
    public TrieNode() {
        children = new TrieNode[26];
    }
}
