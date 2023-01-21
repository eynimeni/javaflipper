import AbstractFactory.*;
import States.Flipper;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean playing = true;
        String input = "";
        //in Flipper verschoben -> AbstractFactory<DisplayText> factory = null;
        DisplayText displayText;
        Flipper flipper = Flipper.getSingleFlipperInstance();

        delayGame();

        while (!input.equals("A") && !input.equals("B")) {
            System.out.print("\n>>> Please choose a Theme: \n" +
                    """
                              ________                           ___\s
                             /_  __/ /_  ___  ____ ___  ___     /   |
                              / / / __ \\/ _ \\/ __ `__ \\/ _ \\   / /| |
                             / / / / / /  __/ / / / / /  __/  / ___ |
                            /_/ /_/ /_/\\___/_/ /_/ /_/\\___/  /_/  |_|
                                                                    \s
                            """ +
                    "or\n" +
                    """
                             ______  __ __    ___  ___ ___    ___      ____ \s
                            |      ||  |  |  /  _]|   |   |  /  _]    |    \\\s
                            |      ||  |  | /  [_ | _   _ | /  [_     |  o  )
                            |_|  |_||  _  ||    _]|  \\_/  ||    _]    |     |
                              |  |  |  |  ||   [_ |   |   ||   [_     |  O  |
                              |  |  |  |  ||     ||   |   ||     |    |     |
                              |__|  |__|__||_____||___|___||_____|    |_____|
                                                                            \s
                            """ +
                    "(enter A/B here): "
            );
            input = inputScanner();
            flipper.createDisplayTextFactory(input);

            //in Flipper verschoben ->
            /*if(input.equalsIgnoreCase("A")){
                factory = new DisplayTextFactoryVariantA();
            }
            else if(input.equalsIgnoreCase("B")){
                factory = new DisplayTextFactoryVariantB();
            }*/
        }

        displayText = flipper.getDisplayTextFactory().createMessage("welcome");
        displayText.createText();
        delayGame();

        displayText = flipper.getDisplayTextFactory().createMessage("playername");
        displayText.createText();
        input = inputScanner();
        flipper.addPlayer(input);
        System.out.println(">>> Welcome \"" + flipper.getCurrentPlayer().getPlayerName() + "\"!");
        delayGame();


        while (playing) {

            //@ToDo: final noch auskommentieren!
            System.out.println("\n **** CHECK --> State is: " + flipper.getState() + " ***");

            displayText = flipper.getDisplayTextFactory().createMessage("options");
            displayText.createText();
            input = inputScanner();

            switch (input) {
                case ("1") -> flipper.pressPlayButton();
                case ("2") -> flipper.insertCoin();
                case ("3") -> flipper.displayCredit();
                case ("4") -> {
                    displayText = flipper.getDisplayTextFactory().createMessage("quit");
                    displayText.createText();

                    if (flipper.getCredit() > 0) {
                        /*@ToDo: use or no use -> displayText = factory.createCreditLost();
                        displayText.createText();*/
                        System.out.println("Your Credit of " + flipper.getCredit() + " will be lost.");
                    }

                    System.out.print("\n(enter Y/N here): ");
                    Scanner scanner1 = new Scanner(System.in);

                    if (Objects.equals(scanner1.next(), "Y")) {
                        displayText = flipper.getDisplayTextFactory().createMessage("bye");
                        displayText.createText();
                        playing = false;
                    }
                }
            }
        }
    }

    private static String inputScanner() {

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }

    private static void delayGame() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.print("InterruptedException: " + e);
        }
    }

}