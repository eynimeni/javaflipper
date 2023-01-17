package States;

/*
@ToDo: Arbeitskommentare:
    Finde aus der Angabe geht nicht klar hervor, was hier passiert. Daher mein Vorschlag:
    - Wenn man die 3. Kugel eines Spiels verliert, gelangt man in den EndState.
    - Dann wird der Spielscore angezeigt. Diesen sollten wir dann zum Spieler auch sichern.
    - Mit einer "Eingabe (Enter?)" gelangt man danach entweder in den Ready State, wenn noch Credit vorhanden ist oder in den NoCredit State.
    - Spiel beenden, obwohl man Credit hat, gibt es ja eig. bei einem States.Flipper nicht. Man bekommt ja sein Geld nicht zurück. Macht es vllt. auch für unser Übungsbeispiel einfacher?
 */


public class EndState implements State {
    private Flipper context;

    public EndState(Flipper context) {
        this.context = context;
        System.out.println("Welcome to States.EndState");
    }

    //@ToDo: Nach Spielende Score anzeigen zum Spieler


    /*
        System.out.println("States.EndState Play Button");
        if (this.context.getCredit() > 0) {
            this.context.decreaseCredit();
            this.context.displayCredit();
            context.setState(new States.Playing(context));
        } else if (this.context.getCredit() == 0) {
            this.context.displayCredit();
            context.setState(new States.NoCredit(context));
        }
     */

    @Override
    public void playButtonPressed() {
        System.out.println("Endstate play");

              /*
                this.context.displayCredit();
        if (this.context.getCredit() == 0) {
            System.out.println("No more credit");
            context.setState(new States.NoCredit(context));
        } else if (this.context.getCredit() > 0) {
            System.out.println("Some credit left");
            context.setState(new States.Ready(context));
        }
         */

    }


    @Override
    public void insertCoin() {
        System.out.println("Endstate insertCoin");

    }
}
