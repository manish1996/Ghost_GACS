package com.google.engedu.ghost;

import java.util.HashMap;


public class TrieNode {
    private HashMap<Character, TrieNode> children;
    private boolean isWord;

    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }

    public void add(String s) {
        HashMap<Character, TrieNode> temp_child=children;
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            TrieNode trienode;
            if(temp_child.containsKey(c)){
                trienode=temp_child.get(c);
            }
            else{
                trienode=new TrieNode();
                temp_child.put(c,trienode);
            }
            temp_child=trienode.children;
            if(i==s.length()-1)
                trienode.isWord=true;
        }


    }

    public boolean isWord(String s)
    {
        TrieNode trieNode=searchNode(s);
        if(trieNode!=null && trieNode.isWord)
        {
            return true;
        }
        else
      return false;
    }

    public TrieNode searchNode(String s){
        HashMap<Character,TrieNode> temp_child=children;
        TrieNode trieNode=null;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(temp_child.containsKey(c)){
                trieNode=temp_child.get(c);
                temp_child=trieNode.children;
            }
            else
                return null;
        }
        return trieNode;
    }

    public String getAnyWordStartingWith(String s) {
        TrieNode trienode=searchNode(s);
        String result =s;
        HashMap<Character,TrieNode> temp_child;
        if(trienode==null)
            return null;
        else{
            while(!trienode.isWord)
            {
                // temp_child.keySet().size();
                temp_child=trienode.children;
                Character next=(Character)temp_child.keySet().toArray()[0];
                result=result+next;
                trienode=temp_child.get(next);
            }
        }

        return result;
    }

    public String getGoodWordStartingWith(String s)
    {
        return null;
    }
}
