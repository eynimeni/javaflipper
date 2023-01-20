package States;

import FlipperElements.FlipperElement;
import FlipperElements.FlipperElementWithScore;
import Visitor.ResetVisitor;
import Visitor.ScoreVisitor;

import java.util.*;

public class Playing implements State {
    private final Flipper context;
    private Integer ballCount = 1;
    private int gameScore = 0;

    public Playing(Flipper context) {
        this.context = context;

        System.out.println("Playing!");
        System.out.println("You have 3 Balls");

        //hier vielleicht eine Base.Game Class die Punkte speichert (und mit Spiel verbunden ist)
        //Das Spiel gehört ja immer zu einem Spieler und der Spieler ist im Flipper (context) geführt. Man kann also über den Spieler zum Game Punkte speichern. Aber schauen wir mal, ob das nicht der Visitor erledigt :-)

        //shootBall();

        //changeState() greift noch nicht richtig.
        //change state kann nicht im constructor kommen, sonst funktioniert es nicht (warum??)
        // nur wenn es von context aufgerufen wird greift es, also in playButtonPressed oder CoinInsert
        //oder vom ready state als ablauf nach dem playing (ist aber auch keine gute lösung)
        //deswegen behelfsmäßig mal bei den button-press-funktionen

        // aus der angabe: zu jeden zeitpunkt möglich, knopf zu drücken... ??? interrupt??

    }

    public void shootBall() {

        if (this.ballCount < 4) {
            System.out.println("Do you want to shoot a ball? Y/N");
            Scanner scanner = new Scanner(System.in);
            String shooting = scanner.next();

            if (Objects.equals(shooting, "Y")) {
                System.out.println("  Ball Number: " + this.ballCount + "/3");
                this.ballCount++;
                this.playBall();
                this.calculatePlayScore();
                System.out.println("Total Game Score is: >>> " + this.gameScore + " <<<");

                this.shootBall();
            }

            /*
            else {
                context.setState(new Ready(context));
            }
             */


        } else {
            System.out.println("Those were all your balls");

            //@ToDo: in End-State auslagern?
            //Wenn 1 Spiel zu Ende ist, alle 3 Bälle gespielt worden sind, wird Gamescore zum Spieler gespeichert.
            context.getCurrentPlayer().getGame().setTotalScore(gameScore);
            System.out.println("Final Game Score is >>> " + this.gameScore + " <<< (Last Game's Score: " + context.getCurrentPlayer().getGame().getLastGamesScore() + "/ Player's Total Score: " +context.getCurrentPlayer().getGame().getTotalScore()+ ")");
            context.getCurrentPlayer().getGame().setLastGamesScore(gameScore);

            //Flipper context = Flipper.getSingleFlipperInstance();
            this.context.setState(new EndState(this.context));
            ((EndState)context.getState()).theEnd();

        }

    }

    //@ToDo: sowohl States.Flipper (Context) als auch Statusklassen, sollen Statuswechsel durchführen können: "Both context and concrete states can set the next state of the context and perform the actual state transition by replacing the state object linked to the context.".
    //-> meiner Meinung nach, haben wir das eh so!

    public void changeStateToEndState() {
        context.setState(new EndState(context));
    }

    @Override
    public void playButtonPressed() {
        System.out.println("Authors of the Software are Magdalena and Tom.");

        if(context.getCredit() > 0) {
            context.decreaseCredit();
            this.ballCount = 1;
            this.shootBall();
        } else {
            System.out.println("You have no more credit left.");
            //go to nocredit?
        }

        //changeState();
    }

    @Override
    public void insertCoin() {

        //@ToDo: warum ändert sich hier der Status? Münzeinwurf verschafft ja nur mehr Credit. Play-State -> EndState nur wenn 3. Ball verloren gegangen ist, oder?
        //diese Möglichkeit hat man eh nur, wenn die 3 Bälle vorbei sind. Credit wird sowieso "automatisch" also über den Flipper aufgebucht.
        context.setState(new Ready(context));

        //@ToDo: Credit-Implementierung aufnehmen?
        // -> das passiert im States.Flipper. Die Methode wird nur vererbt, falls man noch eine spezifische Action braucht
    }

    private void playBall() {
        List<FlipperElement> flipperElementList = this.context.getFlipperElementsList();

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
        List<FlipperElement> flipperElementList = this.context.getFlipperElementsList();
        int newGameScore = 0;

        for (FlipperElement flipperElement : flipperElementList){
            if(flipperElement instanceof FlipperElementWithScore){
               newGameScore += ((FlipperElementWithScore) flipperElement).acceptVisitor(visitor);
            }
        }
        System.out.println("With this Ball you won: "+ newGameScore+" Points!!");
        gameScore += newGameScore;
    }

}
