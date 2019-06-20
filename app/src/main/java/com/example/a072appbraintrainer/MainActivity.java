package com.example.a072appbraintrainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {



    ArrayList<Integer> answers=new ArrayList<Integer>(); /// INCORRECT ANSWER ARRAYLISTS
    int correctAnsLoc;
    Integer score=0;
    int rounds=10;


    // Start Page
    public void invisible(View view)
    {
        LinearLayout lout1 = (LinearLayout) findViewById(R.id.frontpage);
        lout1.setVisibility(View.INVISIBLE);
        setGame();
        LinearLayout lout2 = (LinearLayout) findViewById(R.id.game);
        lout2.setVisibility(View.VISIBLE);
        score=0;

    }
    public void reset()
    {
        score=0;
        rounds=10;
        TextView score1=(TextView)findViewById(R.id.scoree);
        score1.setText(Integer.toString(score));

        TextView message1=(TextView)findViewById(R.id.messagee);
        message1.setText("Welcome!!");

        LinearLayout lout1 = (LinearLayout) findViewById(R.id.frontpage);
        lout1.setVisibility(View.VISIBLE);
        LinearLayout lout2 = (LinearLayout) findViewById(R.id.game);
        lout2.setVisibility(View.INVISIBLE);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void setGame()
    {





        Random rand=new Random(); /// Filling INCORRECT ANSWER ARRAYLISTS
        int a=rand.nextInt(21);
        int b=rand.nextInt(21);
        correctAnsLoc=rand.nextInt(4);

        if(!answers.isEmpty())
        {
            answers.clear();
        }

        for(int i=0;i<4;i++)
        {
            if(i==correctAnsLoc)
            {
                answers.add(a+b);
                continue;
            }
            int incorrectAns=rand.nextInt(41);
            while(incorrectAns==(a+b))
            {
                incorrectAns=rand.nextInt(41);
            }
            answers.add(incorrectAns);

        }                             /// Filling INCORRECT ANSWER ARRAYLISTS OVER


        // UPDATE THE BUTTONS
        TextView ques=(TextView)findViewById(R.id.ques);
        String Q=Integer.toString(a)+" + "+Integer.toString(b);
        ques.setText(Q);
        Button btn1=(Button)findViewById(R.id.btn1);
        Button btn2=(Button)findViewById(R.id.btn2);
        Button btn3=(Button)findViewById(R.id.btn3);
        Button btn4=(Button)findViewById(R.id.btn4);

        String i1=Integer.toString(answers.get(0));
        btn1.setText(i1);

        String i2=Integer.toString(answers.get(1));
        btn2.setText(i2);

        String i3=Integer.toString(answers.get(2));
        btn3.setText(i3);

        String i4=Integer.toString(answers.get(3));
        btn4.setText(i4);
    }








    public void verify(View view)
    {
        TextView score1=(TextView)findViewById(R.id.scoree);
        TextView message1=(TextView)findViewById(R.id.messagee);

        String message=" HELLO ";


        if(view.getTag().toString().equals(Integer.toString(correctAnsLoc)))
        {
            message="Great!!Correct";
            score++;
        }
        else
        {
            message="Alas..! Correct ans is ";
            int correct=answers.get(correctAnsLoc);
             message=message+"  "+Integer.toString(correct);


        }

        score1.setText(Integer.toString(score));
        message1.setText(message);
        rounds--;
        if(rounds!=0)
        {
            setGame();
        }
        else
            {
                reset();
            }





    }



    // Answers
}
