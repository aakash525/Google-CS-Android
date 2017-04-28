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

package com.google.engedu.anagrams;

import java.io.*;
import java.util.*;

public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private Random random = new Random();
    HashSet wordlist = new HashSet();
    String word;

    public AnagramDictionary(Reader reader) throws IOException {
        int i = 0;
        BufferedReader in = new BufferedReader(reader);
        String line;
        while((line = in.readLine()) != null) {
            word = line.trim();
            wordlist.add(word);
            i++;
        }
    }

    public boolean isGoodWord(String word, String base) {

        if(!word.contains(base) && wordlist.contains(word.toLowerCase()))
            return true;
        else
            return false;
    }

    public List<String> getAnagrams(String targetWord) {
        ArrayList<String> result = new ArrayList<String>();

        char[] chars1 = targetWord.toString().toCharArray();
        Arrays.sort(chars1);
        String arr1 = chars1.toString();

        Iterator itr = wordlist.iterator();
        while(itr.hasNext()){
            char[] chars2 = itr.next().toString().toCharArray();
            Arrays.sort(chars2);
            String arr2 = chars2.toString();

            if(arr1.equals(arr2))
                result.add(arr1);
        }

        return result;
    }

    public List<String> getAnagramsWithOneMoreLetter(String word) {
        ArrayList<String> result = new ArrayList<String>();


        return result;
    }

    public String pickGoodStarterWord() {
        return "stop";
    }
}
