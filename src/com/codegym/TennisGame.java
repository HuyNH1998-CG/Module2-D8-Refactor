package com.codegym;

public class TennisGame {

    public char BAR = '-';
    String score = "";


    public String getScore(int playerOneScore, int playerTwoScore) {
        if (playerOneScore == playerTwoScore) {
            equalScore(playerOneScore);
        } else if (playerOneScore >= 4 || playerTwoScore >= 4) {
            fourOrMorePoint(playerOneScore, playerTwoScore);
        } else {
            calculatePoint(playerOneScore, playerTwoScore);
        }
        return score;
    }

    public void equalScore(int playerOneScore) {
        switch (playerOneScore) {
            case 0 -> score = "Love-All";
            case 1 -> score = "Fifteen-All";
            case 2 -> score = "Thirty-All";
            case 3 -> score = "Forty-All";
            default -> score = "Deuce";
        }
    }

    public void fourOrMorePoint(int playerOneScore, int playerTwoScore) {
        int minusResult = playerOneScore - playerTwoScore;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
    }

    public void calculatePoint(int playerOneScore, int playerTwoScore) {
        int checkScore;
        score = "";
        for (int i = 1; i < 3; i++) {
            if (i == 1) checkScore = playerOneScore;
            else {
                score += BAR;
                checkScore = playerTwoScore;
            }
            switch (checkScore) {
                case 0 -> score += "Love";

                case 1 -> score += "Fifteen";

                case 2 -> score += "Thirty";

                case 3 -> score += "Forty";
            }
        }
    }
}