package States;

import AbstractFactory.DisplayText;

public class NoCredit implements State {
    private final Flipper flipper;

    public NoCredit(Flipper flipper) {
        this.flipper = flipper;
    }

    @Override
    public void playButtonPressed() {

        DisplayText displayText = this.flipper.getDisplayTextFactory().createMessage("nocredit");
        displayText.createText();
        System.out.println("Unfortunately there is no credit. Consider inserting a coin.");
    }

    @Override
    public void insertCoin() {

        //Wechsel in den Ready-State
        flipper.setState(new Ready(this.flipper));

    }
}
