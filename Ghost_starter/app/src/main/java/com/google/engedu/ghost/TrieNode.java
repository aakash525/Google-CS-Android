/* Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.engedu.ghost;

import java.util.*;

public class TrieNode {
    char data;
    boolean is_end_of_string;
    HashMap<Character, TrieNode> nodes;
    String actualWord;
    List<String> retval=new ArrayList<String>();

    public TrieNode(){
        is_end_of_string = false;
        nodes = new HashMap<Character, TrieNode>();
    }

    public TrieNode(char data) {
        this.data = data;
        is_end_of_string = false;
        nodes = new HashMap<Character, TrieNode>();
    }

    public TrieNode children(char data) {
        return nodes.get(data);
    }

    private HashMap<Character, TrieNode> getAllchildren() {
        return nodes;
    }

    public boolean isChildExist(char c) {
        return children(c) != null;
    }

    public void add(String s) {
        if (s == null || s.trim().length() == 0) {
            return;
        }
        TrieNode current = this;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!current.isChildExist(c)) {
                TrieNode node = new TrieNode(c);
                current.nodes.put(c, node);
            }
            current = current.children(c);
        }
        current.actualWord=s;
        current.is_end_of_string = true;
    }

    public boolean isWord(String s) {
        TrieNode current = getLastNode(s);
        return current!=null?current.is_end_of_string:false;
    }

    private TrieNode getLastNode(String s) {
        TrieNode current = this;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!current.isChildExist(c)) {
                return null;
            }
            current = current.children(c);
        }
        return current;
    }

    public List<String> search(String s) {
        TrieNode current = getLastNode(s);
        if(current!=null){
            if(current.is_end_of_string){
                retval.add(s);
            }
            current.getAllChildrens(retval);

        }
        return retval;
    }

    public String getAnyWordStartingWith(String s) {
        List<String> retval=new ArrayList<String>();
        TrieNode current = getLastNode(s);
        if(current!=null){
            if(current.is_end_of_string){
                retval.add(s);
            }
            current.getAllChildrens(retval);

        }
        if(!retval.isEmpty())
        {
            Random rand = new Random();
            int x = rand.nextInt(retval.size());
            while((retval.get(x).length()-s.length())%2!=0)
            {
                x = rand.nextInt(retval.size());
            }
            return retval.get(x);
        }
        return null;
    }



    public String getGoodWordStartingWith(String prefix) {

        return null;
    }

    private void getAllChildrens(List<String> retval){
        TrieNode current=this;
        HashMap<Character, TrieNode> nodes=current.getAllchildren();
        Collection< TrieNode> sets=nodes.values();
        for (TrieNode trieNode : sets) {
            if(trieNode.is_end_of_string){
                retval.add(trieNode.actualWord);
            }
            trieNode.getAllChildrens(retval);
        }
    }
}