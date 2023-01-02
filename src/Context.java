public class Context {
    private State state;
    private Integer credit;
    public Context(){
        setState(new NoCredit(this));
    }


    public void insertCoin() {
        state.insertCoin();
    }

    public void pressPlayButton() {
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
        System.out.println("Ihr Kredit beträgt nun: "+this.credit);
    }

    public void decreaseCredit() {
        if (this.credit > 0) {
            this.credit --;
        }
    }
}

