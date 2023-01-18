package Base;

import java.util.Random;

public class Game {

    private String gameId;
    private int totalScore;
    private int lastGamesScore;

    public Game(String playerName){
        this.gameId = createGameID(playerName);
        this.totalScore = 0;
        this.lastGamesScore = 0;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore += totalScore;
    }

    public Integer getLastGamesScore() {
        return lastGamesScore;
    }

    public void setLastGamesScore(Integer lastGamesScore) {
        this.lastGamesScore = lastGamesScore;
    }

    private String createGameID(String playerName){

        Random random = new Random();
        int randomInt = random.nextInt(10000);

        return playerName+randomInt;

    }
}
