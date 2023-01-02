public class Ready implements State{
    private Context context;
    public Ready(Context context) {
        System.out.println("Sie sind nun bereit zu spielen");
        this.context = context;
    }

    @Override
    public void playButtonPressed() {
        System.out.println("Auf die Plätze, fertig ....");
        context.decreaseCredit();
        context.setState(new Playing(context));
    }

    @Override
    public void insertCoin() {
        context.addCredit();

    }
}
