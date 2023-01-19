package AbstractFactory;

public class ConcreteFactory implements AbstractFactory {

    /*@Override
    public DisplayText createDisplayText() {
        return new WelcomeMessage();
    }*/

    @Override
    public DisplayText createWelcomeMessage() {
        return new WelcomeMessage();
    }

    @Override
    public DisplayText createEnterPlayerName() {
        return new EnterPlayerName();
    }

    @Override
    public DisplayText createChooseOption() {
        return new ChooseOption();
    }

    public DisplayText createQuitText() {
        return new QuitGame();
    }

    //Wird aktuell nicht verwendet!
    @Override
    public DisplayText createCreditLost() {
        return new CreditLost();
    }

    @Override
    public DisplayText createGoodBye() {
        return new GoodBye();
    }
}
