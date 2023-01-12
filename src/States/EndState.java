package States;

public class EndState implements State {
    private Context context;
    public EndState(Context context) {
        this.context = context;
        System.out.println("Welcome to States.EndState");
    }
    // score abfragen ob gewonnen ist


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
        System.out.println("Endstate play");

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
        System.out.println("Endstate insertCoin");

    }
}
