package States;

import AbstractFactory.DisplayText;
import FlipperElements.FlipperElement;
import FlipperElements.FlipperElementWithScore;
import Visitor.ResetVisitor;

import java.util.List;

public class EndState implements State {
    private final Flipper flipper;

    public EndState(Flipper context) {
        this.flipper = context;

        DisplayText displayText = flipper.getDisplayTextFactory().createMessage("endstate");
        displayText.createText();

    }

    @Override
    public void playButtonPressed() {
        System.out.println("Log: EndState.playButtonPressed() should never happen?!");

    }


    @Override
    public void insertCoin() {
        System.out.println("Log: EndState.insertCoin() should never happen?!");

    }

    public void theEnd(){

        System.out.println(">>> Your next choice depends on your credit and is automatically considered for you!");

        //ResetVisitor ausführen
        this.resetFlipperElements();

        if(flipper.getCredit() > 0){
            //System.out.print("Log: Credit left, so State ist \"Ready\"!");
            this.flipper.setState(new Ready(this.flipper));
        }
        else{
            //System.out.print("Log: No Credit left, so State ist \"NoCredit\"!");
            this.flipper.setState(new NoCredit(this.flipper));
        }

    }

    //Läuft am Ende eines Spiels = nach dem 3. Ball.
    private void resetFlipperElements(){

        int chkSum = 0;
        ResetVisitor visitor = new ResetVisitor();
        List<FlipperElement> flipperElementList = this.flipper.getFlipperElementsList();

        for (FlipperElement flipperElement : flipperElementList) {
            if (flipperElement instanceof FlipperElementWithScore) {

                chkSum += ((FlipperElementWithScore) flipperElement).acceptVisitor(visitor);
            }
        }

        // System.out.println("Checksum from Reset ist: " +chkSum);
        if (chkSum == 26){
            System.out.println("Log: All FlipperElements successfully reseted!");
        }
        else {
            System.out.println("Log: Something went wrong while resetting!");
        }

    }
}
