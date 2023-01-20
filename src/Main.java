import AbstractFactory.*;
import States.EndState;
import States.Flipper;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AbstractFactory factory = new ConcreteFactory();
        DisplayText displayText = factory.createWelcomeMessage();
        displayText.createText();
        //System.out.println("\n>>Welcome to our States.Flipper!<<");

        //@ToDo: final context zu flipper refactorn ;-)
        Flipper context = Flipper.getSingleFlipperInstance();
        boolean playing = true;
        String input;

        displayText = factory.createEnterPlayerName();
        displayText.createText();
        //System.out.print("Please choose your Playername: ");
        input = inputScanner();
        context.addPlayer(input);

        //&& !context.getState().equals(EndState.class)
        while (playing) {
            //System.out.println("\n*******");
            System.out.print("CHECK --> State is: " +context.getState());
            displayText = factory.createChooseOption();
            displayText.createText();
            //System.out.println("Please \"" + context.getCurrentPlayer().getPlayerName() + "\" choose your option! \n 1: Play \n 2: Add Credit \n 3: Display Credit \n 4: End Base.Game");
            input = inputScanner();

            switch (input) {
                case ("1") -> context.pressPlayButton();
                case ("2") -> context.insertCoin();
                case ("3") -> context.displayCredit();
                case ("4") -> {
                    displayText = factory.createQuitText();
                    displayText.createText();
                    //System.out.println("Are you sure you want to quit? Y/N");

                    if(context.getCredit() > 0 ){
                        /*displayText = factory.createCreditLost();
                        displayText.createText();*/
                        System.out.println("Your Credit of "+context.getCredit() +" will be lost.");
                        }

                    System.out.print("\n(enter Y/N here): ");
                    Scanner scanner1 = new Scanner(System.in);

                    if (Objects.equals(scanner1.next(), "Y")) {
                        displayText = factory.createGoodBye();
                        displayText.createText();
                        //System.out.println("We hope you enjoyed your game!");
                        playing = false;
                    }
                }
            }
        }
    }

    private static String inputScanner(){

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }

}