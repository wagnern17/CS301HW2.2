package com.example.administrator.cs301hw2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


public class SecondaryActivity extends ActionBarActivity implements View.OnClickListener{

    private Button addPlayerToTeam;
    private Button updateTeamStats;
    private Button updatePlayerStats;
    private Button backButton;

    private EditText playerName;
    private EditText playerNum;
    private EditText playerGoals;
    private EditText playerAssists;
    private EditText playerPen;
    private EditText playerPos;
    private EditText teamName;
    private EditText teamWins;
    private EditText teamLoss;
    private EditText teamDraw;

    private TextView teamSpinnerSet;
    private TextView numSet;
    private TextView goalSet;
    private TextView assistsSet;
    private TextView penSet;
    private TextView posSet;
    private TextView winSet;
    private TextView lossSet;
    private TextView drawSet;
    private TextView winStatSet;
    private TextView teamWinStat;
    private TextView lossStatSet;
    private TextView TeamLossStat;
    private TextView drawStatSet;
    private TextView TeamDrawStat;
    private TextView playerSet;
    private TextView numStatsSet;
    private TextView playerNumStats;
    private TextView goalsStatsSet;
    private TextView playerGoalsStats;
    private TextView assistsStatsSet;
    private TextView playerAssistsStats;
    private TextView penStatsSet;
    private TextView playerPenStats;
    private TextView posStatsSet;
    private TextView playerPosStats;
    private TextView teamStatsSet;
    private TextView playerTeamStats;

    private ImageView playerPic;

    private Spinner teamSpinner;
    private Spinner playerSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        setupBackButton();
    }

    private void setupBackButton() {
        backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_secondary, menu);
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

    @Override
    public void onClick(View v) {
        startActivity(new Intent(SecondaryActivity.this, MainActivity.class));
    }
}
