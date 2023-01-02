public class Playing implements State{
    private Context context;
    private Integer ballCount;
    public Playing(Context context) {
        this.context = context;
        this.ballCount = 1;
        System.out.println("Now Playing!");

        while (this.ballCount < 4) {
            System.out.println("Ball Number: " + this.ballCount + "/3");
            this.ballCount ++;
        }
        changeState();
    }

    public void changeState() {
        context.setState(new EndState(context));
    }

    @Override
    public void playButtonPressed() {
        changeState();
        /*
                this.context.displayCredit();
        if (this.context.getCredit() == 0) {
            System.out.println("No more credit");
            context.setState(new NoCredit(context));
        } else if (this.context.getCredit() > 0) {
            System.out.println("Some credit left");
            context.setState(new Ready(context));
        }
         */

        System.out.println("Still in Playing State - Authors of the Software are Tom and Magdalena");

    }
    @Override
    public void insertCoin() {
    }
}
