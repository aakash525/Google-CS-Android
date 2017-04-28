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

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

import static android.R.attr.fingerprintAuthDrawable;
import static android.R.attr.keycode;
import static android.R.attr.label;
import static com.google.engedu.ghost.R.id.gameStatus;
import static com.google.engedu.ghost.R.id.ghostText;


public class GhostActivity extends AppCompatActivity {
    private static final String COMPUTER_TURN = "Computer's turn";
    private static final String USER_TURN = "Your turn";
    private GhostDictionary dictionary;
    private SimpleDictionary simple;
    private FastDictionary fast;
    private boolean userTurn = false;
    private Random random = new Random();
    private int len, chk = 0;

    TextView text, label;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghost);

        text = (TextView) findViewById(R.id.ghostText);
        label = (TextView) findViewById((R.id.gameStatus));
        b1 = (Button) findViewById(R.id.challenge);
        b2 = (Button) findViewById(R.id.restart);

        try {
            InputStream inputStream = getAssets().open("words.txt");
            //simple = new SimpleDictionary(new InputStreamReader(inputStream));
            fast = new FastDictionary(new InputStreamReader(inputStream));
        }
        catch (IOException e)
        {   }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chk = 1;
                b1.setEnabled(false);
                String str = null;
                String txt = (String) text.getText();
                //if(txt.length() >= 4 && simple.isWord(txt))
                if(txt.length() >= 4 && fast.isWord(txt))
                {
                    label.setText("You Won");
                    return;
                }
                else
                {
                    str = fast.getAnyWordStartingWith(txt);
                    //str = simple.getAnyWordStartingWith(txt);
                    if(str != null)
                    {
                        text.setText(str);
                        label.setText("Computer Won");
                    }
                    else
                        label.setText("You Won");
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chk = 0;
                b1.setEnabled(true);
                onStart(v);
            }
        });

        onStart(null);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        String str1 = null;
        String str2 = null;

        super.onSaveInstanceState(savedInstanceState);

        str1 = (String) text.getText();
        str2 = (String) label.getText();
        savedInstanceState.putString("text", str1);
        savedInstanceState.putString("label", str2);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState)
    {
        String str1 = null;
        String str2 = null;

        super.onRestoreInstanceState(savedInstanceState);

        str1 = savedInstanceState.getString("text");
        str2 = savedInstanceState.getString("label");
        text.setText(str1);
        label.setText(str2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ghost, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Handler for the "Reset" button.
     * Randomly determines whether the game starts with a user turn or a computer turn.
     * @param view
     * @return true
     */
    public boolean onStart(View view) {
        //userTurn = random.nextBoolean();
        userTurn = true;
        //text.setText("usua");
        startText();
        len = 4;
        TextView label = (TextView) findViewById(R.id.gameStatus);
        if (userTurn) {
            label.setText(USER_TURN);
        } else {
            label.setText(COMPUTER_TURN);
            computerTurn();
        }
        return true;
    }

    public void startText()
    {
        int n;
        Random rand = new Random();

        while(true)
        {
            n = rand.nextInt(10000);
            //String txt = simple.display_text(n);
            String txt = fast.display_text(n);
            //if(txt.length() >= 4 && !simple.isWord(txt.substring(0,4)))
            if(txt.length() >= 4 && !fast.isWord(txt.substring(0,4)))
            {
                text.setText(txt.substring(0,4));
                break;
            }
        }
    }

    public void hideSoftKeyboard() {
        if(getCurrentFocus()!=null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
        }
    }

    public void showSoftKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        view.requestFocus();
        inputMethodManager.showSoftInput(view, 0);
    }

    private void computerTurn() {
        // Do computer turn stuff then make it the user's turn again
        String txt = (String) text.getText();
        //if(simple.isWord(txt) && txt.length() >= 4)
        if(fast.isWord(txt) && txt.length() >= 4)
        {
            chk = 1;
            b1.setEnabled(false);
            label.setText("Computer Won");
        }
        else
        {
            //txt = simple.getAnyWordStartingWith(txt);
            txt = fast.getAnyWordStartingWith(txt);
            if(txt == null)
            {
                chk = 1;
                b1.setEnabled(false);
                label.setText("Computer Won");
            }
            else
            {
                len++;
                text.setText(txt.substring(0,len));
                userTurn = true;
                label.setText(USER_TURN);
            }
        }
    }

    /**
     * Handler for user key presses.
     * @param keyCode
     * @param event
     * @return whether the key stroke was handled.
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event)
    {
        String prefix = (String) text.getText();
        char ch=(char)(keyCode+68);
        if(ch >= 'a' && ch <= 'z' && chk == 0)
        {
            prefix=prefix+ch;
            len++;
            text.setText(prefix);
            label.setText(COMPUTER_TURN);
            computerTurn();
        }
        else
            Toast.makeText(getApplicationContext(), "Wrong Input", Toast.LENGTH_SHORT).show();

        return super.onKeyUp(keyCode, event);
    }
}
