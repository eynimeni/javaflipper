package States;

/*
@ToDo: Arbeitskommentare:
    Finde aus der Angabe geht nicht klar hervor, was hier passiert. Daher mein Vorschlag:
    - Wenn man die 3. Kugel eines Spiels verliert, gelangt man in den EndState.
    - Dann wird der Spielscore angezeigt. Diesen sollten wir dann zum Spieler auch sichern.
    - Mit einer "Eingabe (Enter?)" gelangt man danach entweder in den Ready State, wenn noch Credit vorhanden ist oder in den NoCredit State.
    - Spiel beenden, obwohl man Credit hat, gibt es ja eig. bei einem States.Flipper nicht. Man bekommt ja sein Geld nicht zurück. Macht es vllt. auch für unser Übungsbeispiel einfacher?

    todo -> mMn muss man das beenden nicht umbauen, wie gesagt, ich würde keinen extra endstate mehr machen, sondern alles als ende von playing
 */


import FlipperElements.FlipperElement;
import FlipperElements.FlipperElementWithScore;
import Visitor.ResetVisitor;

import java.util.List;

public class EndState implements State {
    private final Flipper context;

    public EndState(Flipper context) {
        this.context = context;
        System.out.println("This is the End ...");

        //theEnd();
    }

    //@ToDo: Nach Spielende Score anzeigen zum Spieler


    /*
        System.out.println("States.EndState Play Button");
        if (this.context.getCredit() > 0) {
            this.context.decreaseCredit();
            this.context.displayCredit();
            context.setState(new States.Playing(context));
        } else if (this.context.getCredit() == 0) {
            this.context.displayCredit();
            context.setState(new States.NoCredit(context));
        }
     */

    @Override
    public void playButtonPressed() {
        System.out.println("Log: EndState.playButtonPressed() should have never happend?!");

              /*
                this.context.displayCredit();
        if (this.context.getCredit() == 0) {
            System.out.println("No more credit");
            context.setState(new States.NoCredit(context));
        } else if (this.context.getCredit() > 0) {
            System.out.println("Some credit left");
            context.setState(new States.Ready(context));
        }
         */

    }


    @Override
    public void insertCoin() {
        System.out.println("Log: EndState.insertCoin() should have never happend?!");

    }

    public void theEnd(){

        System.out.println("Your next choice depends on your credit and is automatically considered for you!");

        //ResetVisitor ausführen
        this.resetFlipperElements();

        if(context.getCredit() > 0){
            System.out.print("Log: Credit left, so State ist \"Ready\"!");
            this.context.setState(new Ready(this.context));
        }
        else{
            System.out.print("Log: No Credit left, so State ist \"NoCredit\"!");
            this.context.setState(new NoCredit(this.context));
        }

    }

    //Läuft am Ende eines Spiels = nach dem 3. Ball.
    private void resetFlipperElements(){

        int chkSum = 0;
        ResetVisitor visitor = new ResetVisitor();
        List<FlipperElement> flipperElementList = this.context.getFlipperElementsList();

        for (FlipperElement flipperElement : flipperElementList) {
            if (flipperElement instanceof FlipperElementWithScore) {

                chkSum += ((FlipperElementWithScore) flipperElement).acceptVisitor(visitor);
            }
        }

        // System.out.println("Checksum from Reset ist: " +chkSum);
        if (chkSum == 26){
            System.out.println("All FlipperElements successfully reseted!");
        }
        else {
            System.out.println("Something went wrong while resetting!");
        }

    }
}
