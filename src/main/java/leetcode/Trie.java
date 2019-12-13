package leetcode;

import java.util.HashMap;

class Trie {
    public static HashMap<Character,HashMap> map;

    public static void main(String[] args) {

        Trie obj = new Trie();
        map.put('s',null);
        map.put(null,new HashMap());
        System.out.println(map.get(null)!=null);
        obj.insert("apple");
        boolean param_2 = obj.search("apple");
        boolean param_3 = obj.startsWith("app");
        System.out.println(param_2);
        System.out.println(param_3);
    }

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        map = new HashMap();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        HashMap<Character,HashMap> hashmap=map;
        for(char c:chars){
            if(hashmap.get(c)!=null){
                hashmap=hashmap.get(c);
            }else{
                hashmap.put(c,new HashMap());
                hashmap=hashmap.get(c);
            }
        }
        hashmap.put(null,new HashMap());

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        HashMap<Character,HashMap> hashmap=map;
        for(char c:chars){
            if(hashmap.get(c)!=null){
                hashmap=hashmap.get(c);
            }else{
                return false;
            }
        }
        return (hashmap.get(null)!=null);

    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        HashMap<Character,HashMap> hashmap=map;
        for(char c:chars){
            if(hashmap.get(c)!=null){
                hashmap=hashmap.get(c);
            }else{
                return false;
            }
        }
        return true;
    }
}
