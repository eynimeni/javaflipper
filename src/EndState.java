public class EndState implements State {
    private Context context;
    public EndState(Context context) {
        this.context = context;
        System.out.println("Welcome to EndState");
    }
    // score abfragen ob gewonnen ist


    /*
        System.out.println("EndState Play Button");
        if (this.context.getCredit() > 0) {
            this.context.decreaseCredit();
            this.context.displayCredit();
            context.setState(new Playing(context));
        } else if (this.context.getCredit() == 0) {
            this.context.displayCredit();
            context.setState(new NoCredit(context));
        }
     */

    @Override
    public void playButtonPressed() {
        System.out.println("Endstate play");
    }

    @Override
    public void insertCoin() {
        System.out.println("Endstate insertCoin");

    }
}
