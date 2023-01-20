package AbstractFactory;

public interface AbstractFactory <T>{

    T createMessage(String messageType);

    //1. Versuch
    //DisplayText createDisplayText();

    //AbstractFactory Implementierung 1. Ansatz
        /*
        DisplayText createWelcomeMessage();

        DisplayText createEnterPlayerName();

        DisplayText createChooseOption();

        DisplayText createQuitText();

        DisplayText createCreditLost();

        DisplayText createGoodBye();
        */

}
