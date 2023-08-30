class WordDictionary {
    class Node {
        char val;
        boolean isWord;
        Node[] subVal;

        Node(char val) {
            this.val = val;
            this.subVal = new Node[26];
        }
    }

    Node dict;

    public WordDictionary() {
        dict = new Node(' ');
    }
    
    public void addWord(String word) {
        Node curr = dict;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.subVal[c - 'a'] == null)
                curr.subVal[c - 'a'] = new Node(c);
            curr = curr.subVal[c - 'a'];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        return dfs(dict, 0, word);
    }

    private boolean dfs(Node node, int idx, String word) {
        if (node == null) return false;
        Node curr = node;
        for (int i = idx; i < word.length(); i++) {
            if (curr == null) return false;
            char c = word.charAt(i);
            if (c != '.') {
                if (curr.subVal[c - 'a'] == null) return false;
                curr = curr.subVal[c - 'a'];
            } if (c == '.') {
                i++;
                for (int j = 0; j < 26; j++) {
                    if(dfs(curr.subVal[j], i, word)) return true;
                }
                return false;
            }
        }
        return curr != null && curr.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */