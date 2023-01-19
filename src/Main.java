import States.Flipper;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n>>Welcome to our States.Flipper!<<");
        //@ToDo: final context zu flipper refactorn ;-)
        Flipper context = Flipper.getSingleFlipperInstance();
        boolean playing = true;
        String input;

        System.out.print("Please choose your Playername: ");
        input = inputScanner();
        context.addPlayer(input);

        while (playing) {
            System.out.println("\n*******");
            System.out.println("Please \"" + context.getCurrentPlayer().getPlayerName() + "\" choose your option! \n 1: Play \n 2: Add Credit \n 3: Display Credit \n 4: End Base.Game");

            input = inputScanner();

            switch (input) {
                case ("1") -> context.pressPlayButton();
                case ("2") -> context.insertCoin();
                case ("3") -> context.displayCredit();
                case ("4") -> {
                    System.out.println("Are you sure you want to quit? Y/N");
                    if(context.getCredit() > 0 ){
                        System.out.println("Your Credit of "+context.getCredit() +" will be lost."); }
                    Scanner scanner1 = new Scanner(System.in);
                    if (Objects.equals(scanner1.next(), "Y")) {
                        System.out.println("We hope you enjoyed your game!");
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