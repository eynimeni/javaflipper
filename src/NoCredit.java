public class NoCredit implements State{
    private Context context;
    public NoCredit(Context context) {
        this.context = context;
    }

    @Override
    public void playButtonPressed() {
        System.out.println("Leider ist kein Kredit vorhanden");
    }

    public void insertCoin() {
        System.out.println("Klingeling, die Münze fällt in den Schacht.");
        context.setState(new Ready(context));
    }
}
