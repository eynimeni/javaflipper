package Base;

public class Player {

    private String playerName;
    private Game game;

    public Player(String playerName){
        this.playerName = playerName;
        this.game = new Game(playerName);
    }

    public String getPlayerName() {
        return playerName;
    }

    public Game getGame() {
        return game;
    }
}
