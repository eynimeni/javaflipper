package AbstractFactory;

public class DisplayTextFactoryVariantB implements AbstractFactory<DisplayText>{

    @Override
    public DisplayText createMessage(String messageType) {

        if("welcome".equalsIgnoreCase(messageType)){
            return new WelcomeMessageB();
        }
        else if("playername".equalsIgnoreCase(messageType)){
            return new EnterPlayerNameB();
        }
        else if("options".equalsIgnoreCase(messageType)){
            return new ChooseOptionB();
        }
        else if("quit".equalsIgnoreCase(messageType)){
            return new QuitGameB();
        }
        else if("loosecredit".equalsIgnoreCase(messageType)){
            return new CreditLostB();
        }
        else if("bye".equalsIgnoreCase(messageType)){
            return new GoodByeB();
        }
        else if("coindrop".equalsIgnoreCase(messageType)){
            return new CoinDropB();
        }

        System.out.print("Log: nothing matched!");
        return null;
    }
}
