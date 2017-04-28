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

import java.io.*;
import java.util.ArrayList;


public class FastDictionary implements GhostDictionary {

    private TrieNode root;
    private ArrayList<String> words;

    public FastDictionary(Reader wordListStream) throws IOException {
        BufferedReader in = new BufferedReader(wordListStream);
        words = new ArrayList<>();
        root = new TrieNode();
        String line = null;
        while((line = in.readLine()) != null) {
            String word = line.trim();
            if (word.length() >= MIN_WORD_LENGTH)
            {
                root.add(line.trim());
                words.add(line.trim());
            }
        }
    }
    @Override
    public boolean isWord(String word) {
        return root.isWord(word);
    }

    public String display_text(int n)
    {
        return words.get(n);
    }

    @Override
    public String getAnyWordStartingWith(String prefix) {
        return root.getAnyWordStartingWith(prefix);
    }

    @Override
    public String getGoodWordStartingWith(String prefix) {
        return root.getGoodWordStartingWith(prefix);
    }
}
