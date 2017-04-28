package adc.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Calc extends AppCompatActivity {

    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,add,sub,div,mul,ce,eq,clear;
    TextView text1,text2;

    String s1,s2;
    char ch;
    int op=0,chk=0,flag=0,clr=0;
    long num1=0,num2=0,result=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_layout);

        b0 = (Button) findViewById(R.id.b0);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        b9 = (Button) findViewById(R.id.b9);
        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.sub);
        div = (Button) findViewById(R.id.div);
        mul = (Button) findViewById(R.id.mul);
        ce = (Button) findViewById(R.id.ce);
        eq = (Button) findViewById(R.id.eq);
        clear = (Button) findViewById(R.id.clear);

        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);

        b0.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(op == 0)
                {
                    if(s1 == null || s1 == "0")
                        s1 = "0";
                    else
                        s1 = s1 + "0";

                    text2.setText(s1);
                    flag = 1;
                }
                else
                {
                    if(s2 == null || s2 == "0")
                        s2 = "0";
                    else
                        s2 = s2 + "0";

                    text2.setText(s1 + " " + ch + " " + s2);
                }
                clr = 0;
            }
        });

        b1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(op == 0)
                {
                    if(s1 == null || s1 == "0")
                        s1 = "1";
                    else
                        s1 = s1 + "1";

                    text2.setText(s1);
                    flag = 1;
                }
                else
                {
                    if(s2 == null || s2 == "0")
                        s2 = "1";
                    else
                        s2 = s2 + "1";

                    text2.setText(s1 + " " + ch + " " + s2);
                }
                clr = 0;
            }
        });

        b2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(op == 0)
                {
                    if(s1 == null || s1 == "0")
                        s1 = "2";
                    else
                        s1 = s1 + "2";

                    text2.setText(s1);
                    flag = 1;
                }
                else
                {
                    if(s2 == null || s2 == "0")
                        s2 = "2";
                    else
                        s2 = s2 + "2";

                    text2.setText(s1 + " " + ch + " " + s2);
                }
                clr = 0;
            }
        });

        b3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(op == 0)
                {
                    if(s1 == null || s1 == "0")
                        s1 = "3";
                    else
                        s1 = s1 + "3";

                    text2.setText(s1);
                    flag = 1;
                }
                else
                {
                    if(s2 == null || s2 == "0")
                        s2 = "3";
                    else
                        s2 = s2 + "3";

                    text2.setText(s1 + " " + ch + " " + s2);
                }
                clr = 0;
            }
        });

        b4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(op == 0)
                {
                    if(s1 == null || s1 == "0")
                        s1 = "4";
                    else
                        s1 = s1 + "4";

                    text2.setText(s1);
                    flag = 1;
                }
                else
                {
                    if(s2 == null || s2 == "0")
                        s2 = "4";
                    else
                        s2 = s2 + "4";

                    text2.setText(s1 + " " + ch + " " + s2);
                }
                clr = 0;
            }
        });

        b5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(op == 0)
                {
                    if(s1 == null || s1 == "0")
                        s1 = "5";
                    else
                        s1 = s1 + "5";

                    text2.setText(s1);
                    flag = 1;
                }
                else
                {
                    if(s2 == null || s2 == "0")
                        s2 = "5";
                    else
                        s2 = s2 + "5";

                    text2.setText(s1 + " " + ch + " " + s2);
                }
                clr = 0;
            }
        });

        b6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(op == 0)
                {
                    if(s1 == null || s1 == "0")
                        s1 = "6";
                    else
                        s1 = s1 + "6";

                    text2.setText(s1);
                    flag = 1;
                }
                else
                {
                    if(s2 == null || s2 == "0")
                        s2 = "6";
                    else
                        s2 = s2 + "6";

                    text2.setText(s1 + " " + ch + " " + s2);
                }
                clr = 0;
            }
        });

        b7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(op == 0)
                {
                    if(s1 == null || s1 == "0")
                        s1 = "7";
                    else
                        s1 = s1 + "7";

                    text2.setText(s1);
                    flag = 1;
                }
                else
                {
                    if(s2 == null || s2 == "0")
                        s2 = "7";
                    else
                        s2 = s2 + "7";

                    text2.setText(s1 + " " + ch + " " + s2);
                }
                clr = 0;
            }
        });

        b8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(op == 0)
                {
                    if(s1 == null || s1 == "0")
                        s1 = "8";
                    else
                        s1 = s1 + "8";

                    text2.setText(s1);
                    flag = 1;
                }
                else
                {
                    if(s2 == null || s2 == "0")
                        s2 = "8";
                    else
                        s2 = s2 + "8";

                    text2.setText(s1 + " " + ch + " " + s2);
                }
                clr = 0;
            }
        });

        b9.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(op == 0)
                {
                    if(s1 == null || s1 == "0")
                        s1 = "9";
                    else
                        s1 = s1 + "9";

                    text2.setText(s1);
                    flag = 1;
                }
                else
                {
                    if(s2 == null || s2 == "0")
                        s2 = "9";
                    else
                        s2 = s2 + "9";

                    text2.setText(s1 + " " + ch + " " + s2);
                }
                clr = 0;
            }
        });

        add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(flag == 1)
                {
                    if(result != -1 && clr != 1)
                    {
                        num1 = result;
                        s1 = String.valueOf(num1);
                        num2 = 0;
                        s2 = "";
                        result = -1;
                    }
                    op = 1;
                    ch = '+';
                    text2.setText(s1 + " " + ch);
                    chk = 0;
                }
            }
        });

        sub.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(flag == 1)
                {
                    if(result != -1 && clr != 1)
                    {
                        num1 = result;
                        s1 = String.valueOf(num1);
                        num2 = 0;
                        s2 = "";
                        result = -1;
                    }
                    op = 2;
                    ch = '-';
                    text2.setText(s1 + " " + ch);
                    chk = 0;
                }
            }
        });

        div.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(flag == 1)
                {
                    if(result != -1 && clr != 1)
                    {
                        num1 = result;
                        s1 = String.valueOf(num1);
                        num2 = 0;
                        s2 = "";
                        result = -1;
                    }
                    op = 3;
                    ch = '/';
                    text2.setText(s1 + " " + ch);
                    chk = 0;
                }
            }
        });

        mul.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(flag == 1)
                {
                    if(result != -1 && clr != 1)
                    {
                        num1 = result;
                        s1 = String.valueOf(num1);
                        num2 = 0;
                        s2 = "";
                        result = -1;
                    }
                    op = 4;
                    ch = '*';
                    text2.setText(s1 + " " + ch);
                    chk = 0;
                }
            }
        });

        ce.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                text1.setText("");
                text2.setText("");
                s1 = "";
                s2 = "";
                op = 0;
                chk = 0;
                clr = 0;
                flag = 0;
                ch = '\0';
                num1 = 0;
                num2 = 0;
                result = -1;
            }
        });

        eq.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                clr = 0;
                if(s2 != null || op == 0)
                {
                    num1 = Long.parseLong(s1);
                    num2 = Long.parseLong(s2);

                    if(op == 1)
                        result = num1 + num2;
                    else
                    if(op == 2)
                        result = num1 - num2;
                    else
                    if(op == 3)
                        result = num1 / num2;
                    else
                    if(op == 4)
                        result = num1 * num2;

                    chk = 1;
                    text1.setText(text2.getText());
                    text2.setText(String.valueOf(result));
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                clr = 1;
                if(chk == 1)
                {
                    text2.setText(text1.getText());
                    text1.setText("");
                    chk = 0;
                }
                else
                {
                    if(s1 != null)
                        num1 = Long.parseLong(s1);
                    else
                        num1 = 0;

                    if(s2 != null)
                        num2 = Long.parseLong(s2);
                    else
                        num2 = 0;

                    if(num2 != 0)
                    {
                        num2 = num2 / 10;
                        s2 = String.valueOf(num2);
                        text2.setText(s1 + " " + ch + " " + s2);
                    }
                    else
                    if(op != 0)
                    {
                        op = 0;
                        ch = '\0';
                        text2.setText(s1);
                    }
                    else
                    if(num1 != 0)
                    {
                        num1 = num1 / 10;
                        s1 = String.valueOf(num1);
                        text2.setText(s1);
                    }
                    else
                    {
                        flag = 0;
                    }
                }
            }
        });
    }
}
