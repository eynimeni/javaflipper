package States;

public class NoCredit implements State {
    private final Flipper context;

    public NoCredit(Flipper context) {
        this.context = context;
    }

    @Override
    public void playButtonPressed() {
        System.out.println("Unfortunately there is no credit. Consider inserting a coin.");
    }

    @Override
    public void insertCoin() {

        //Wechsel in den Ready-State ab der 1. Münze.
        context.setState(new Ready(this.context));

        //@ToDo: Credit-Implementierung aufnehmen?
        //-> Credit wird in der Flipper Klasse getrackt

    }
}
