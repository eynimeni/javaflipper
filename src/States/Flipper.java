package States;

/*
@ToDo: Arbeitskommentare:
    Hab mich ja an diesen Inputs orientiert https://refactoring.guru/design-patterns/state. Ich denke, dass die Context-Klasse schon unsere Flipperklasse ist.
    Wg. diesem Statement: "Instead of implementing all behaviors on its own, the original object, called context, stores a reference to one of the state objects that represents its current state, and delegates all the state-related work to that object."
    Schlage daher vor, dass wir:
    - Die Context-Klasse zur Flipperklasse refactorn
    //->done!
    - Sie als Singleton aus der Main erzeugen, weil es nur 1 Flipperautomaten ja an sich gibt.
    //->ja, das passiert schon!
    - Flipper-Klasse kommt dann auch aus dem Statespackage wieder raus. Steht mal auf selber Ebene wie die Main.
    //->hier gibt es vielleicht ein Problem mit der Vererbung des Interfaces (zumindest schreit die IDE), drum hab ich es mal gelassen.
    ----
    Erster Schritt? Flipper mal sehr rudimentär programmieren, so dass Status und Statuswechsel korrekt funktioneren?
    Dann Spiellogik via Playing Klasse und Kompositum, Mediator etc?
 */

public class Flipper {

    //@ToDo: Ist der Credit nicht auch vom Status abhängig? NoCredit -> Credit = 0, Ready/Playing/EndState -> Credit >= 1 und gehört als Attribut inkl. dazugehöriger Methoden in den State? Oder als globale Variable zum Flipper?
    private Integer credit = 0;
    private State state;

    /*@ToDo: Vorschlag für weitere Attribute der Flipperklasse.
    public flipperElement: FlipperElement //Hält als Liste oder Array alle FlipperElemente, aus denen der Flipper/das Spielfeld besteht
    public players: Player[] //Array der Spieler, die schon gespielt haben. Auch Eingabe eines neuen Spielers soll möglich sein. Total-Score = 0, Last-Game-Score = 0 zu beginn.
    */

    public Flipper() {
        setState(new NoCredit(this));
    }

    public void insertCoin() {
        addCredit();
        state.insertCoin();
    }

    public void pressPlayButton() {
        System.out.println("Play Button Pressed");
        state.playButtonPressed();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void addCredit() {
        this.credit++;
        System.out.println("Clink-plink-clink. This coin dropped smoothly!");
        System.out.println("Your Credit is now: " + this.credit);
        state.insertCoin();
    }

    //@ToDo: passiert bei jedem Spielstart, also Wechsel vom Ready in den Playing State, da ja pro Credit 1 Spiel mit 3 Kugeln, oder?
    public void decreaseCredit() {
        if (this.credit > 0) {
            this.credit--;
        }
    }

    public void displayCredit() {
        System.out.println("Your Credit: " + this.credit);
    }

    public Integer getCredit() {
        return this.credit;
    }

}

