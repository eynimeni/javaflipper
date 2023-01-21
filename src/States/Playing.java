package States;

import AbstractFactory.AbstractFactory;
import AbstractFactory.DisplayText;
import FlipperElements.FlipperElement;
import FlipperElements.FlipperElementWithScore;
import Visitor.ScoreVisitor;

import java.util.*;

public class Playing implements State {
    private final Flipper flipper;
    private final AbstractFactory<DisplayText> factory;
    private Integer ballCount = 1;
    private int gameScore = 0;

    public Playing(Flipper flipper) {
        this.flipper = flipper;
        this.factory = flipper.getDisplayTextFactory();

        DisplayText displayText = factory.createMessage("playing");
        displayText.createText();
        //System.out.println("Playing!");
        System.out.println(">>> You have 3 Balls");

    }

    public void shootBall() {

        if (this.ballCount < 4) {
            System.out.print("\nDo you want to shoot a ball? Y/N: " );
            Scanner scanner = new Scanner(System.in);
            String shooting = scanner.next();

            if (Objects.equals(shooting, "Y")) {
                System.out.println("  Ball Number: " + this.ballCount + "/3");
                this.ballCount++;
                this.playBall();
                this.calculatePlayScore();

                delayGame();
                DisplayText displayText = factory.createMessage("gamescore");
                displayText.createText();
                System.out.println("Total Game Score is: >>> " + this.gameScore + " <<<");

                this.shootBall();
            }


        } else {

            DisplayText displayText = factory.createMessage("noballs");
            displayText.createText();
            System.out.println(">>> Those were all your balls!");
            delayGame();

            //Wenn 1 Spiel zu Ende ist, alle 3 Bälle gespielt worden sind, wird Gamescore zum Spieler gespeichert.
            flipper.getCurrentPlayer().getGame().setTotalScore(gameScore);
            System.out.println("\n **************************************" +
                    "**** Final Game Score is >>> " + this.gameScore + " <<< " +
                    "**** (Last Game's Score: " + flipper.getCurrentPlayer().getGame().getLastGamesScore() + "/ Player's Total Score: " + flipper.getCurrentPlayer().getGame().getTotalScore()+ ")" +
                    " **************************************\n");
            delayGame();
            flipper.getCurrentPlayer().getGame().setLastGamesScore(gameScore);

            this.flipper.setState(new EndState(this.flipper));
            ((EndState) flipper.getState()).theEnd();

        }

    }

    @Override
    public void playButtonPressed() {
        System.out.println("Authors of the Software are Magdalena and Tom.");

        if(flipper.getCredit() > 0) {
            flipper.decreaseCredit();
            this.ballCount = 1;
            this.shootBall();
        } else {
            System.out.println(" >>> You have no more credit left.");
        }
    }

    @Override
    public void insertCoin() {
        //Dazu kommt man im Playing gar nicht!
        //context.setState(new Ready(context));

    }

    private void playBall() {
        List<FlipperElement> flipperElementList = this.flipper.getFlipperElementsList();

        //The first Random FlipperElement gets hit
        getRandomFlipperElement(flipperElementList).elementGotHit();

        System.out.println("    Pinball lever trying to catch that ball!");

            SplittableRandom random = new SplittableRandom();
            boolean success = random.nextInt(1,101) <= 50;
            if(success) {
                System.out.println("    OH YES! Caught it!");
                playBall();
            } else {
                System.out.println("    DAMM! LOST IT!");
            }
        }

    private FlipperElement getRandomFlipperElement(List<FlipperElement> elements) {
        return elements.get(new Random().nextInt(elements.size()));
    }

    //Läuft nach jedem Ballverlust und nutzt den ScoreVisitor
    private void calculatePlayScore(){

        ScoreVisitor visitor = new ScoreVisitor();
        List<FlipperElement> flipperElementList = this.flipper.getFlipperElementsList();
        int newGameScore = 0;

        for (FlipperElement flipperElement : flipperElementList){
            if(flipperElement instanceof FlipperElementWithScore){
               newGameScore += ((FlipperElementWithScore) flipperElement).acceptVisitor(visitor);
            }
        }
        System.out.println(">>> With this Ball you won: "+ newGameScore+" Points!!");
        gameScore += newGameScore;
    }

    private static void delayGame() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.print("InterruptedException: " + e);
        }
    }

}
