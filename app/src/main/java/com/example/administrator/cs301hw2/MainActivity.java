package com.example.administrator.cs301hw2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


/* https://www.youtube.com/watch?v=SaXYFHYGLj4 */

public class MainActivity extends ActionBarActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener {

    private Button addPlayer;
    private Button addTeam;
    private Button playButton;

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

    private TextView teamWinStat;
    private TextView teamLossStat;
    private TextView teamDrawStat;

    private ImageView playerPic;

    private Spinner teamSpinner;

    public HashMap<String, Team> teamHash;
    public HashMap<String, Player> playerHash;

    ArrayList<String> playerList;
    ArrayList<String> teamList;
    ArrayList<ImageView> playerImageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupPlayButton();
        setupAddPlayer();
        setupAddTeam();
        setupTeamSpinner();
        setupTeam();
        setupPlayer();

        playerHash=new HashMap<String,Player>();
        playerHash.put("", new Player());

        teamHash=new HashMap<String,Team>();
        teamHash.put("", new Team());

        playerList = new ArrayList<String>();
        playerList.add("");

        teamList = new ArrayList<String>();
        teamList.add("");
    }

    private void setupTeam() {
        teamName = (EditText) findViewById(R.id.teamName);
        teamWins = (EditText) findViewById(R.id.teamWins);
        teamLoss = (EditText) findViewById(R.id.teamLoss);
        teamDraw = (EditText) findViewById(R.id.teamDraw);

        teamWinStat = (TextView) findViewById(R.id.teamWinStat);
        teamLossStat = (TextView) findViewById(R.id.teamLossStat);
        teamDrawStat = (TextView) findViewById(R.id.teamDrawStat);
    }

    private void setupPlayer() {
        playerName = (EditText) findViewById(R.id.playerName);
        playerNum = (EditText) findViewById(R.id.playerNum);
        playerGoals = (EditText) findViewById(R.id.playerGoals);
        playerAssists = (EditText) findViewById(R.id.playerAssists);
        playerPen = (EditText) findViewById(R.id.playerPen);
        playerPos = (EditText) findViewById(R.id.playerPos);
    }

    private void setupTeamSpinner() {
        teamSpinner = (Spinner) findViewById(R.id.teamSpinner);
        ArrayAdapter<String> teamAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,teamList);
        teamSpinner.setAdapter(teamAdapter);
        teamSpinner.setOnItemSelectedListener(this);
    }

    private void setupAddTeam() {
        addTeam = (Button) findViewById(R.id.addTeam);
        addTeam.setOnClickListener(this);
    }

    private void setupAddPlayer() {
        addPlayer = (Button) findViewById(R.id.addPlayer);
        addPlayer.setOnClickListener(this);
    }

    private void setupPlayButton() {
        playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        if (v == playButton) {
            startActivity(new Intent(MainActivity.this, SecondaryActivity.class));
        }

        if (v == addPlayer) {
            if (String.valueOf(playerNum.getText()) == "" ||
                    String.valueOf(playerName.getText()) == "" ||
                    String.valueOf(playerGoals.getText()) == "" ||
                    String.valueOf(playerAssists.getText()) == "" ||
                    String.valueOf(playerPen.getText()) == "" ||
                    String.valueOf(playerPos.getText()) == "") {
                return;
            }

            if (playerList.indexOf(String.valueOf(playerName.getText())) == -1) {
                Player pTemp = new Player();
                pTemp.playerName = String.valueOf(playerName.getText());
                pTemp.playerNum = String.valueOf(playerNum.getText());
                pTemp.playerGoals = String.valueOf(playerGoals.getText());
                pTemp.playerAssists = String.valueOf(playerAssists.getText());
                pTemp.playerPen = String.valueOf(playerPen.getText());
                pTemp.playerPos = String.valueOf(playerPos.getText());

                playerHash.put(String.valueOf(playerName.getText()), pTemp);

                playerList.add(String.valueOf(playerName.getText()));
                System.out.println(pTemp.playerName + " " + pTemp.playerPos);
            }
        }

        if (v == addTeam) {
            if(String.valueOf(teamName.getText()) == "" ||
                    String.valueOf(teamWins.getText()) == "" ||
                    String.valueOf(teamLoss.getText()) == "" ||
                    String.valueOf(teamDraw.getText()) == "") {
                return;
            }

            if(teamList.indexOf( String.valueOf(teamName.getText()) ) == -1 ) {
                Team tTemp = new Team();
                tTemp.teamName = String.valueOf(teamName.getText());
                tTemp.teamWins = String.valueOf(teamWins.getText());
                tTemp.teamLoss = String.valueOf(teamLoss.getText());
                tTemp.teamDraw = String.valueOf(teamDraw.getText());

                teamHash.put(String.valueOf(teamName.getText()), tTemp);

                teamList.add(String.valueOf(teamName.getText()));
            }
            else
            {
                teamHash.get(String.valueOf(teamName.getText())).teamName =String.valueOf(teamName.getText());
                if( String.valueOf(teamName.getText()) != null) {
                    teamName.setText(String.valueOf(teamName.getText()));
                }
                else {
                    teamName.setText("");
                }

                teamHash.get(String.valueOf(teamWins.getText())).teamWins =String.valueOf(teamWins.getText());
                if( String.valueOf(teamWins.getText()) != null) {
                    teamWins.setText(String.valueOf(teamWins.getText()));
                }
                else {
                    teamWins.setText("");
                }

                teamHash.get(String.valueOf(teamLoss.getText())).teamLoss =String.valueOf(teamLoss.getText());
                if( String.valueOf(teamLoss.getText()) != null) {
                    teamLoss.setText(String.valueOf(teamLoss.getText()));
                }
                else {
                    teamLoss.setText("");
                }

                teamHash.get(String.valueOf(teamDraw.getText())).teamDraw =String.valueOf(teamDraw.getText());
                if( String.valueOf(teamDraw.getText()) != null) {
                    teamDraw.setText(String.valueOf(teamDraw.getText()));
                }
                else {
                    teamDraw.setText("");
                }

            }
        }
        teamSpinner.setSelection(teamList.indexOf(String.valueOf(teamName.getText())));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        teamWins.setText(teamSpinner.getSelectedItem().toString());
        //String a = null;
        if( teamHash.get(teamSpinner.getSelectedItem().toString()).teamName != null && teamSpinner.getSelectedItem().toString() != "") {
            teamName.setText(teamHash.get(teamSpinner.getSelectedItem().toString()).teamName);
        }
        else
        {
            teamName.setText("");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
