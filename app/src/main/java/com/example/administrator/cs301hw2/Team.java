package com.example.administrator.cs301hw2;

import java.io.Serializable;

/**
 * Created by wagnern17 on 9/28/2015.
 */
public class Team implements Serializable {

    String teamName;
    String teamWins;
    String teamLoss;
    String teamDraw;

    protected Team() {
        teamName = "FC Faker";
        teamWins = "0";
        teamLoss = "0";
        teamDraw = "7";
    }

}
