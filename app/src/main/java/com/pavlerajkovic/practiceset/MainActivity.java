package com.pavlerajkovic.practiceset;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int scoreTeamA = 0;
    private int scoreTeamB = 0;
    private int gameNo = 0;

    private Button onePointTeamA;
    private Button twoPointsTeamA;
    private Button threePointsTeamA;

    private Button onePointTeamB;
    private Button twoPointsTeamB;
    private Button threePointsTeamB;

    private TextView textScoreTeamA;
    private TextView textScoreTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onePointTeamA = findViewById(R.id.team_a_one_point);
        twoPointsTeamA = findViewById(R.id.team_a_two_points);
        threePointsTeamA = findViewById(R.id.team_a_three_points);

        onePointTeamB = findViewById(R.id.team_b_one_point);
        twoPointsTeamB = findViewById(R.id.team_b_two_points);
        threePointsTeamB = findViewById(R.id.team_b_three_points);

        textScoreTeamA = findViewById(R.id.team_a_score);
        textScoreTeamB = findViewById(R.id.team_b_score);
    }

    public void startNewGame(View view) {
        if(gameNo != 0) {
            if(scoreTeamA > scoreTeamB)
                Toast.makeText(this, "Team A Won!", Toast.LENGTH_LONG).show();
            else if(scoreTeamB > scoreTeamA)
                Toast.makeText(this, "Team B Won!", Toast.LENGTH_LONG).show();
            else Toast.makeText(this, "It's a Draw.", Toast.LENGTH_LONG).show();
        }

        scoreTeamA = scoreTeamB = 0;
        textScoreTeamA.setText("0");
        textScoreTeamB.setText("0");

        disableButtons(1);
        disableButtons(2);

        if(Math.random() < 0.5) enableButtons(1);
        else enableButtons(2);

        gameNo++;
    }

    public void enableButtons(int team) {
        double randomNumber = Math.random();

        if(team == 1) {
            if(randomNumber < 0.1504) {
                enableButton(onePointTeamA);
                enableButton(twoPointsTeamA);
                enableButton(threePointsTeamA);
            } else if(randomNumber < 0.3682) {
                enableButton(twoPointsTeamA);
                enableButton(threePointsTeamA);
            } else {
                enableButton(twoPointsTeamA);
            }
        }

        if(team == 2) {
            if(randomNumber < 0.1655) {
                enableButton(onePointTeamB);
                enableButton(twoPointsTeamB);
                enableButton(threePointsTeamB);
            } else if(randomNumber < 0.3722) {
                enableButton(twoPointsTeamB);
                enableButton(threePointsTeamB);
            } else {
                enableButton(twoPointsTeamB);
            }
        }
    }

    public void disableButtons(int team) {
        if(team == 1) {
            disableButton(onePointTeamA);
            disableButton(twoPointsTeamA);
            disableButton(threePointsTeamA);
        }
        if(team == 2) {
            disableButton(onePointTeamB);
            disableButton(twoPointsTeamB);
            disableButton(threePointsTeamB);
        }
    }

    public void enableButton(Button button) {
        button.setEnabled(true);
        button.setBackgroundColor(getResources().getColor(R.color.colorAccent));
    }

    public void disableButton(Button button) {
        button.setEnabled(false);
        button.setBackgroundColor(getResources().getColor(R.color.colorGray));
    }

    public void scoreTeamA(View view) {
        if(view.getId() == R.id.team_a_one_point) {
            if(Math.random() < 0.817)
                updateScore(1, 1);
        } else if(view.getId() == R.id.team_a_two_points) {
            if(Math.random() < 0.558)
                updateScore(1, 2);
        } else if(view.getId() == R.id.team_a_three_points) {
            if(Math.random() < 0.383)
                updateScore(1, 3);
        }

        disableButtons(1);
        enableButtons(2);
    }

    public void scoreTeamB(View view) {
        if(view.getId() == R.id.team_b_one_point) {
            if(Math.random() < 0.714)
                updateScore(2, 1);
        } else if(view.getId() == R.id.team_b_two_points) {
            if(Math.random() < 0.517)
                updateScore(2, 2);
        } else if (view.getId() == R.id.team_b_three_points) {
            if(Math.random() < 0.345)
                updateScore(2, 3);
        }

        disableButtons(2);
        enableButtons(1);
    }

    public void updateScore(int team, int points) {
        if(team == 1) {
            scoreTeamA += points;
            textScoreTeamA.setText(String.valueOf(scoreTeamA));
        }
        else {
            scoreTeamB += points;
            textScoreTeamB.setText(String.valueOf(scoreTeamB));
        }
    }

}

