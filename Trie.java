public class Trie {

    private TrieNode root;

    Trie(){
        this.root = new TrieNode(); // root is empty in this data structure
    }

    private class TrieNode{
        private TrieNode [] children;
        private boolean isWord;

        TrieNode(){
            this.children = new TrieNode[26]; // 26 because we are english words
            this.isWord = false;
        }
    }

    public void insert(String word){

        if (word == null || word.equals(" ")){
            throw new IllegalArgumentException("Invalid value entered");
        }

        word = word.toLowerCase();

        TrieNode current = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if (current.children[index] == null){
                TrieNode node = new TrieNode();
                current.children[index] = node;
                current = node;
            }
            else{
                current = current.children[index];
            }
        }
        current.isWord = true;
    }

    public static void main(String[] args) {

        Trie t = new Trie();
        t.insert("Rasha");
        t.insert("Faheem");
        t.insert("Taimoor");
        t.insert("Khalid");

        System.out.println("Words are entered successfully");
    }
}
