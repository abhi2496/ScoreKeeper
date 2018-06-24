package com.example.abhishekkoranne.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int runsTeamA = 0;
    int wicketsTeamA = 0;
    int runsTeamB = 0;
    int wicketsTeamB = 0;
    LinearLayout teamB;
    LinearLayout teamA;
    TextView mssgs;
    EditText etTeamA;
    EditText etTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teamB = findViewById(R.id.teamB);
        teamA = findViewById(R.id.teamA);
        mssgs = findViewById(R.id.mssgs);
        etTeamA = findViewById(R.id.etTeamA);
        etTeamB = findViewById(R.id.etTeamB);

        setViewAndChildrenEnabled(teamB, false);
    }

    public void extraForTeamA(View v) {
        runsTeamA = runsTeamA + 1;
        displayRunsForTeamA(runsTeamA);
    }

    public void oneForTeamA(View v) {
        runsTeamA = runsTeamA + 1;
        displayRunsForTeamA(runsTeamA);
    }

    public void twoForTeamA(View v) {
        runsTeamA = runsTeamA + 2;
        displayRunsForTeamA(runsTeamA);
    }

    public void threeForTeamA(View v) {
        runsTeamA = runsTeamA + 3;
        displayRunsForTeamA(runsTeamA);
    }

    public void fourForTeamA(View v) {
        runsTeamA = runsTeamA + 4;
        displayRunsForTeamA(runsTeamA);
    }

    public void sixForTeamA(View v) {
        runsTeamA = runsTeamA + 6;
        displayRunsForTeamA(runsTeamA);
    }

    public void wicketForTeamA(View v) {
        if (wicketsTeamA < 10) {
            wicketsTeamA = wicketsTeamA + 1;
        }
        displayWicketsForTeamA(wicketsTeamA);
        if (wicketsTeamA == 10) {
            String nameTeamA = etTeamA.getText().toString();
            mssgs.setText(nameTeamA+" All Out!");
            setViewAndChildrenEnabled(teamA, false);
            setViewAndChildrenEnabled(teamB, true);
        }
    }

    public void displayRunsForTeamA(int score) {
        TextView runs = findViewById(R.id.team_a_runs);
        runs.setText(String.valueOf(score));
    }

    public void displayWicketsForTeamA(int score) {
        TextView wickets = findViewById(R.id.team_a_wickets);
        wickets.setText(String.valueOf(score));
    }

    public void endForTeamA(View v) {
        setViewAndChildrenEnabled(teamB, true);
        setViewAndChildrenEnabled(teamA, false);
    }

    public void extraForTeamB(View v) {
        runsTeamB = runsTeamB + 1;
        displayRunsForTeamB(runsTeamB);
    }

    public void oneForTeamB(View v) {
        runsTeamB = runsTeamB + 1;
        displayRunsForTeamB(runsTeamB);
    }

    public void twoForTeamB(View v) {
        runsTeamB = runsTeamB + 2;
        displayRunsForTeamB(runsTeamB);
    }

    public void threeForTeamB(View v) {
        runsTeamB = runsTeamB + 3;
        displayRunsForTeamB(runsTeamB);
    }

    public void fourForTeamB(View v) {
        runsTeamB = runsTeamB + 4;
        displayRunsForTeamB(runsTeamB);
    }

    public void sixForTeamB(View v) {
        runsTeamB = runsTeamB + 6;
        displayRunsForTeamB(runsTeamB);
    }

    public void wicketForTeamB(View v) {
        if (wicketsTeamB < 10) {
            wicketsTeamB = wicketsTeamB + 1;
        }
        displayWicketsForTeamB(wicketsTeamB);
        if (wicketsTeamB == 10) {
            String nameTeamB = etTeamB.getText().toString();
            endForTeamB(v);
        }
    }


    public void displayRunsForTeamB(int score) {
        TextView runs = findViewById(R.id.team_b_runs);
        runs.setText(String.valueOf(score));
    }

    public void displayWicketsForTeamB(int score) {
        TextView wickets = findViewById(R.id.team_b_wickets);
        wickets.setText(String.valueOf(score));
    }

    public void resetScore(View v) {
        runsTeamA = 0;
        runsTeamB = 0;
        wicketsTeamA = 0;
        wicketsTeamB = 0;
        displayRunsForTeamA(runsTeamA);
        displayRunsForTeamB(runsTeamB);
        displayWicketsForTeamA(wicketsTeamA);
        displayWicketsForTeamB(wicketsTeamB);
        setViewAndChildrenEnabled(teamA, true);
        setViewAndChildrenEnabled(teamB, false);
        mssgs.setText("");
        etTeamA.setText("");
        etTeamB.setText("");
    }

    public void endForTeamB(View view) {
        String nameTeamA = etTeamA.getText().toString();
        String nameTeamB = etTeamB.getText().toString();
        if (runsTeamA < runsTeamB) {
            mssgs.setText(nameTeamB+" Won!");
        } else if (runsTeamA == runsTeamB) {
            mssgs.setText(R.string.tie);
        } else {
            mssgs.setText(nameTeamA + " Won!");
        }
        setViewAndChildrenEnabled(teamA, false);
        setViewAndChildrenEnabled(teamB, false);

    }

    private static void setViewAndChildrenEnabled(View view, boolean enabled) {
        view.setEnabled(enabled);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                setViewAndChildrenEnabled(child, enabled);
            }
        }
    }
}