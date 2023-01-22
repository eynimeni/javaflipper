package States;

import AbstractFactory.DisplayText;

public class Ready implements State {
    private final Flipper flipper;

    public Ready(Flipper flipper) {

        DisplayText displayText = flipper.getDisplayTextFactory().createMessage("readytoplay");
        displayText.createText();
        this.flipper = flipper;
    }

    @Override
    public void playButtonPressed() {
        System.out.println("States.Ready, steady ....");
        flipper.decreaseCredit();
        flipper.setState(new Playing(this.flipper));
        ((Playing) flipper.getState()).shootBall();
    }

    @Override
    public void insertCoin() {}
}
