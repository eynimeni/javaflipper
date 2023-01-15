package States;

public class Ready implements State {
    private Context context;

    public Ready(Context context) {
        System.out.println("You are now ready to play");
        this.context = context;
    }


    @Override
    public void playButtonPressed() {
        System.out.println("States.Ready, steady ....");
        context.decreaseCredit();
        context.setState(new Playing(context));
        //context.setState(new States.EndState(context));
    }

    @Override
    public void insertCoin() {

        //@ToDo: Credit-Implementierung aufnehmen?
    }
}
