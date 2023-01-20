import AbstractFactory.*;
import States.Flipper;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean playing = true;
        String input;
        AbstractFactory<DisplayText> factory;

        System.out.print("Please choose Theme \"A\" or \"B\" for textual outputs: ");
        input = inputScanner();

        if(input.equalsIgnoreCase("A")){
            factory = new DisplayTextFactoryVariantA();
        }
        else if(input.equalsIgnoreCase("B")){
            factory = new DisplayTextFactoryVariantB();
        }
        else{
            System.out.print("Choosing went wrong, using default theme!");
            factory = new DisplayTextFactoryVariantA();
        }

        DisplayText displayText = factory.createMessage("welcome");
        displayText.createText();
        //System.out.println("\n>>Welcome to our States.Flipper!<<");

        //@ToDo: final context zu flipper refactorn ;-)
        Flipper context = Flipper.getSingleFlipperInstance();

        displayText = factory.createMessage("playername");
        displayText.createText();
        //System.out.print("Please choose your Playername: ");
        input = inputScanner();
        context.addPlayer(input);

        while (playing) {
            //System.out.println("\n*******");
            displayText = factory.createMessage("options");
            displayText.createText();
            //System.out.println("Please \"" + context.getCurrentPlayer().getPlayerName() + "\" choose your option! \n 1: Play \n 2: Add Credit \n 3: Display Credit \n 4: End Base.Game");
            input = inputScanner();

            switch (input) {
                case ("1") -> context.pressPlayButton();
                case ("2") -> context.insertCoin();
                case ("3") -> context.displayCredit();
                case ("4") -> {
                    displayText = factory.createMessage("quit");
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
                        displayText = factory.createMessage("bye");
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