package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_start, btn_answer0, btn_answer1, btn_answer2, btn_answer3;
    TextView tv_score, tv_questions, tv_timer, tv_bottomMsg;
    ProgressBar prog_timer;
    Game g = new Game();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = findViewById(R.id.btn_start);
        btn_answer0 = findViewById(R.id.btn_answer0);
        btn_answer1 = findViewById(R.id.btn_answer1);
        btn_answer2 = findViewById(R.id.btn_answer2);
        btn_answer3 = findViewById(R.id.btn_answer3);

        tv_score = findViewById(R.id.tv_score);
        tv_questions = findViewById(R.id.tv_questions);
        tv_timer = findViewById(R.id.tv_timer);
        tv_bottomMsg = findViewById(R.id.tv_bottomMsg);

        prog_timer = findViewById(R.id.prog_timer);

        tv_timer.setText("0Sec");
        tv_questions.setText("");
        tv_bottomMsg.setText("Press Go");

        View.OnClickListener startButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button start_button = (Button) view;
                start_button.setVisibility(View.INVISIBLE);
                nextTurn();
            }
        };
        View.OnClickListener answerButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button buttonClicked = (Button) view;
                int answerSelected = Integer.parseInt(buttonClicked.getText().toString());

                g.checkAnswer(answerSelected);
                tv_score.setText(Integer.toString(g.getScore()));
                nextTurn();
            }
        };

        btn_start.setOnClickListener(startButtonClickListener);

        btn_answer0.setOnClickListener(answerButtonClickListener);
        btn_answer1.setOnClickListener(answerButtonClickListener);
        btn_answer2.setOnClickListener(answerButtonClickListener);
        btn_answer3.setOnClickListener(answerButtonClickListener);
    }

    private void nextTurn(){
        //create a new Question
        //set text on answer buttons
        //enable answer buttons
        //start the timer
        g.makeNewQuestion();
        int [] answer = g.getCurrentQuestion().getAnswerArray();
        btn_answer0.setText(Integer.toString(answer[0]));
        btn_answer1.setText(Integer.toString(answer[1]));
        btn_answer2.setText(Integer.toString(answer[2]));
        btn_answer3.setText(Integer.toString(answer[3]));

        btn_answer0.setEnabled(true);
        btn_answer1.setEnabled(true);
        btn_answer2.setEnabled(true);
        btn_answer3.setEnabled(true);

        tv_questions.setText(g.getCurrentQuestion().getQuestionPhrase());
        tv_bottomMsg.setText(g.getNumCorrect() + "/" + (g.getTotalQuestions() - 1));
    }
}