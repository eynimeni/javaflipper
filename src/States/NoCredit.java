package States;

public class NoCredit implements State {
    private Context context;

    public NoCredit(Context context) {
        this.context = context;
    }

    @Override
    public void playButtonPressed() {
        System.out.println("Unfortunately there is no credit. Consider inserting a coin.");
    }

    @Override
    public void insertCoin() {

        //Wechsel in den Ready-State ab der 1. Münze.
        context.setState(new Ready(context));

        //@ToDo: Credit-Implementierung aufnehmen?

    }
}
