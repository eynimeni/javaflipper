package AbstractFactory;

public interface AbstractFactory {

    //DisplayText createDisplayText();

    DisplayText createWelcomeMessage();

    DisplayText createEnterPlayerName();

    DisplayText createChooseOption();

    DisplayText createQuitText();

    DisplayText createCreditLost();

    DisplayText createGoodBye();

}
