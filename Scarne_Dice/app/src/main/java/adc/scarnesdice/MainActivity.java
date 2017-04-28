package adc.scarnesdice;

import android.support.v7.app.AppCompatActivity;
import android.os.*;
import android.view.View;
import android.widget.*;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    ImageView dice;
    Button roll;
    Button hold;
    Button reset;
    TextView my;
    TextView comp;
    TextView turn;

    int my_total, my_current, comp_total, comp_current;
    long startTime;
/*
    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime;
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;

            //timerTextView.setText(String.format("%d:%02d", minutes, seconds));

            timerHandler.postDelayed(this, 500);
        }
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dice = (ImageView) findViewById(R.id.dice);
        roll = (Button) findViewById(R.id.roll);
        hold = (Button) findViewById(R.id.hold);
        reset = (Button) findViewById(R.id.reset);
        my = (TextView) findViewById(R.id.my);
        comp = (TextView) findViewById(R.id.comp);
        turn = (TextView) findViewById(R.id.turn);

        my_total = 0;
        my_current = 0;
        comp_total = 0;
        comp_current = 0;

        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roll_press();
            }
        });

        hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hold_press();
            }
        });
/*
        hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                if (b.getText().equals("stop")) {
                    timerHandler.removeCallbacks(timerRunnable);
                } else {
                    startTime = System.currentTimeMillis();
                    timerHandler.postDelayed(timerRunnable, 0);
                }
            }
        });*/

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset_press();
            }
        });
    }

    public void roll_press()
    {
        int num;

        Random rand = new Random();
        num = rand.nextInt(6) + 1;
        set_image(num);

        if(num != 1)
        {
            my_current += num;
            my_total += num;
            my.setText("Your score: " + my_total);
        }
        else
        {
            my_total = my_total - my_current;
            my_current = 0;
            my.setText("Your score: " + my_total);
            comp_turn();
        }
        win();
    }

    public void comp_turn()
    {
        int num;

        comp_current = 0;
        while(comp_current < 20)
        {
            Random rand = new Random();
            num = rand.nextInt(6) + 1;
            set_image(num);

            if(num != 1)
            {
                comp_current += num;
                comp_total += num;
                comp.setText("Computer score: " + comp_total);
                //startTime = System.currentTimeMillis();
                //timerHandler.postDelayed(timerRunnable, 500);
            }
            else
            {
                comp_total = comp_total - comp_current;
                comp_current = 0;
                comp.setText("Computer score: " + comp_total);
                roll.setEnabled(true);
                hold.setEnabled(true);
                turn.setText("");
                //timerHandler.removeCallbacks(timerRunnable);
                break;
            }
            win();
        }
        roll.setEnabled(true);
        hold.setEnabled(true);
        turn.setText("");
    }

    public void set_image(int num)
    {
        if(num == 1)
            dice.setImageResource(R.drawable.dice1);
        else
        if(num == 2)
            dice.setImageResource(R.drawable.dice2);
        else
        if(num == 3)
            dice.setImageResource(R.drawable.dice3);
        else
        if(num == 4)
            dice.setImageResource(R.drawable.dice4);
        else
        if(num == 5)
            dice.setImageResource(R.drawable.dice5);
        else
        if(num == 6)
            dice.setImageResource(R.drawable.dice6);
    }

    public void hold_press()
    {
        my_current = 0;

        roll.setEnabled(false);
        hold.setEnabled(false);
        turn.setText("Computer's turn...");

        comp_turn();
    }

    public void reset_press()
    {
        my_total = 0;
        my_current = 0;
        comp_total = 0;
        comp_current = 0;

        roll.setEnabled(true);
        hold.setEnabled(true);

        my.setText("Your score: " + 0);
        comp.setText("Computer score: " + 0);
    }

    public void win()
    {
        if(my_total > 100)
        {
            Toast.makeText(getApplicationContext(), "YOU WON!!!", Toast.LENGTH_LONG).show();
            reset_press();
        }
        if(comp_total > 100)
        {
            Toast.makeText(getApplicationContext(), "COMPUTER WON!!!", Toast.LENGTH_LONG).show();
            reset_press();
        }
    }
}
