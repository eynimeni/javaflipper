package AbstractFactory;

public class DisplayTextFactoryVariantA implements AbstractFactory<DisplayText> {

    @Override
    public DisplayText createMessage(String messageType) {

        if("welcome".equalsIgnoreCase(messageType)){
            return new WelcomeMessage();
        }
        else if("playername".equalsIgnoreCase(messageType)){
            return new EnterPlayerName();
        }
        else if("options".equalsIgnoreCase(messageType)){
            return new ChooseOption();
        }
        else if("quit".equalsIgnoreCase(messageType)){
            return new QuitGame();
        }
        else if("loosecredit".equalsIgnoreCase(messageType)){
            return new CreditLost();
        }
        else if("bye".equalsIgnoreCase(messageType)){
            return new GoodBye();
        }
        else if("coindrop".equalsIgnoreCase(messageType)){
            return new CoinDrop();
        }


        System.out.print("Log: nothing matched!");
        return null;
    }

    //1. Versuch
    /*@Override
    public DisplayText createDisplayText() {
        return new WelcomeMessage();
    }*/

    //AbstractFactory Implementierung 1. Ansatz
        /*
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
        */
}
