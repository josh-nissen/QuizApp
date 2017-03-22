package com.android.nissen.quizapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    int numRight = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void question1()
    {
        RadioButton question1 = (RadioButton) findViewById(R.id.question1a1);
        if (question1.isChecked())
            numRight++;
    }

    public void question2()
    {
        CheckBox a1 = (CheckBox) findViewById(R.id.question2a1);
        CheckBox a2 = (CheckBox) findViewById(R.id.question2a2);
        CheckBox a3 = (CheckBox) findViewById(R.id.question2a3);
        CheckBox a4 = (CheckBox) findViewById(R.id.question2a4);

        if(a2.isChecked())
            return;

        if( a1.isChecked() && a3.isChecked() && a4.isChecked())
            numRight++;
    }

    public void question3()
    {
        CheckBox a1 = (CheckBox) findViewById(R.id.question3a1);
        CheckBox a2 = (CheckBox) findViewById(R.id.question3a2);
        CheckBox a3 = (CheckBox) findViewById(R.id.question3a3);
        CheckBox a4 = (CheckBox) findViewById(R.id.question3a4);

        if (a2.isChecked() || a3.isChecked())
            return;

        if( a1.isChecked() && a4.isChecked())
            numRight++;
    }

    public void question4()
    {
        RadioButton question4 = (RadioButton) findViewById(R.id.question4a2);
        if (question4.isChecked())
            numRight++;
    }

    public void question5()
    {
        EditText question5 = (EditText) findViewById(R.id.question5a);
        String q5 = question5.getText().toString();

        if (q5.contains("www.alpacainfo.com"))
            numRight++;
    }

    public void checkAnswers(View view)
    {
        question1();
        question2();
        question3();
        question4();
        question5();
        displayCorrect();
    }

    public void displayCorrect()
    {
        AlertDialog.Builder numCorrect = new AlertDialog.Builder(MainActivity.this);
        numCorrect.setTitle("Quiz Results");
        numCorrect.setMessage("You got " + numRight + " out of 5 correct!");
        numCorrect.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        numCorrect.show();
    }

}
