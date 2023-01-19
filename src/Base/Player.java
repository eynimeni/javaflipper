package Base;

public class Player {

    private final String playerName;
    private final Game game;

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
