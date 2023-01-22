package AbstractFactory;

public class DisplayTextFactoryVariantA implements AbstractFactory<DisplayText> {

    @Override
    public DisplayText createMessage(String messageType) {

        if ("welcome".equalsIgnoreCase(messageType)) {
            return new WelcomeMessage();
        } else if ("playername".equalsIgnoreCase(messageType)) {
            return new EnterPlayerName();
        } else if ("options".equalsIgnoreCase(messageType)) {
            return new ChooseOption();
        } else if ("quit".equalsIgnoreCase(messageType)) {
            return new QuitGame();
        } else if ("loosecredit".equalsIgnoreCase(messageType)) {
            return new CreditLost();
        } else if ("bye".equalsIgnoreCase(messageType)) {
            return new GoodBye();
        } else if ("coindrop".equalsIgnoreCase(messageType)) {
            return new CoinDrop();
        } else if ("nocredit".equalsIgnoreCase(messageType)) {
            return new NoCredit();
        } else if ("readytoplay".equalsIgnoreCase(messageType)) {
            return new ReadyToPlay();
        } else if ("endstate".equalsIgnoreCase(messageType)) {
            return new EndState();
        } else if ("playing".equalsIgnoreCase(messageType)) {
            return new PlayingText();
        } else if ("gamescore".equalsIgnoreCase(messageType)) {
            return new GameScore();
        }else if ("noballs".equalsIgnoreCase(messageType)) {
            return new NoBalls();
        }


        System.out.print("Log: nothing matched!");
        return null;
    }

}
