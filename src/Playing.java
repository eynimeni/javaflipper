public class Playing implements State{
    private Context context;
    public Playing(Context context) {
        System.out.println("Now Playing!");
    }

    @Override
    public void playButtonPressed() {
        System.out.println("Authors of the Software are Tom and Magdalena");
        //aus Info irgendwo auslesen?
    }

    @Override
    public void insertCoin() {
        context.addCredit();
    }
}
