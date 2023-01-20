package States;

public class Ready implements State {
    private final Flipper context;

    public Ready(Flipper context) {
        System.out.println("You are now ready to play");
        this.context = context;
    }

    @Override
    public void playButtonPressed() {
        System.out.println("States.Ready, steady ....");
        context.decreaseCredit();
        context.setState(new Playing(this.context));
        ((Playing)context.getState()).shootBall();
        //context.setState(new States.EndState(context));
    }

    @Override
    public void insertCoin() {

        //@ToDo: Credit-Implementierung aufnehmen?
        // -> das passiert im States.Flipper. Die Methode wird nur vererbt, falls man noch eine spezifische Action braucht
    }
}
