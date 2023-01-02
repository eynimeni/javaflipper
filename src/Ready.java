public class Ready implements State{
    private Context context;
    public Ready(Context context) {
        System.out.println("You are now ready to play");
        this.context = context;
    }
    @Override
    public void playButtonPressed() {
        System.out.println("Ready, steady ....");
        context.decreaseCredit();
        context.setState(new Playing(context));
    }
    @Override
    public void insertCoin() {
    }
}
