package com.example.administrator.cs301hw2;

import java.io.Serializable;

/**
 * Created by wagnern17 on 9/28/2015.
 */
public class Player implements Serializable {

    String playerName;
    String playerNum;
    String playerGoals;
    String playerAssists;
    String playerPen;
    String playerPos;
    String playerTeam;

    protected Player() {

        playerName = "John Doe";
        playerNum = "0";
        playerGoals = "1";
        playerAssists = "1";
        playerPen = "2";
        playerPos = "3";
        playerTeam = "5";

    }
}
