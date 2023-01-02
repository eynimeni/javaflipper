public class NoCredit implements State{
    private Context context;
    public NoCredit(Context context) {
        this.context = context;
    }

    @Override
    public void playButtonPressed() {
        System.out.println("Unfortunately there is no credit. Consider inserting a coin.");
    }

    public void insertCoin() {
        context.setState(new Ready(context));
    }
}
