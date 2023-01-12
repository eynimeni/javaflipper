package States;

public class Context {
    private Integer credit = 0;
    public Context(){
        setState(new NoCredit(this));
    }
    private State state;
    public void insertCoin() {
        addCredit();
        state.insertCoin();
    }

    public void pressPlayButton() {
        System.out.println("Play Button Pressed");
        state.playButtonPressed();
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }

    public void addCredit() {
        this.credit ++;
        System.out.println("Clink-plink-clink. This coin dropped smoothly!");
        System.out.println("Your Credit is now: "+this.credit);
        state.insertCoin();
    }
    public void decreaseCredit() {
        if (this.credit > 0) {
            this.credit --;
        }
    }
    public void displayCredit() {
        System.out.println("Your Credit: "+ this.credit);
    }

    public Integer getCredit() {
        return this.credit;
    }

}

