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
import java.util.*;

public class SimpleDictionary implements GhostDictionary {
    private ArrayList<String> words;

    public SimpleDictionary(Reader reader) throws IOException {
        BufferedReader in = new BufferedReader(reader);
        words = new ArrayList<>();
        String line = null;
        while((line = in.readLine()) != null) {
            String word = line.trim();
            if (word.length() >= MIN_WORD_LENGTH)
                words.add(line.trim());
        }
    }

    @Override
    public boolean isWord(String word) {
        return words.contains(word);
    }

    public String display_text(int n)
    {
        return words.get(n);
    }

    public String search(String prefix)
    {
        int low, mid, high, c;
        String txt;

        low = 0;
        high = words.size() - 1;
        while(low <= high)
        {
            mid = low + (high - low)/2;
            txt = words.get(mid);

            c = txt.startsWith(prefix) ? 0 : prefix.compareTo(txt);
            if(c == 0)
                return txt;
            else
            if(c > 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }

    @Override
    public String getAnyWordStartingWith(String prefix) {
        String txt = null;
        Random rand = new Random();

        if(prefix == null)
        {
            txt = words.get(rand.nextInt(words.size()));
            return txt.substring(0,4);
        }
        else
        if(prefix != null)
            return search(prefix);
        else
            return null;
    }

    @Override
    public String getGoodWordStartingWith(String prefix) {
        String selected = null;
        return selected;
    }
}
