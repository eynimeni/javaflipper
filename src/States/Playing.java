package States;

/*
@ToDo: Arbeitskommentare:
    Hier passiert am meisten Logik, würd ich meinen, oder "Concrete States provide their own implementations for the state-specific methods."?
    Methoden für:
    - Wenn man von Ready in den Playing Status gelangt, autom. Laden der 1. Kugel.
    - Credit wird durch Statuswechsel zu Playing um 1 verringert.
    - Kugel abschießen, so lange es Kugeln gibt möglich
    - Nach Abschießen der Kugel, durchläuft diese das Spielfeld und trifft die unterschiedlichen Flipper-Elemente (Bumper, Slingshot ...)
        * Hierzu soll dann die Spiellogik implementiert werden, die das Zusammenspiel und die entstehenden Punkte steuert und ermittelt -> Mediator- /Visitor-Pattern?
        * Betätigen der Flipperhebel in Spiellogik auch "random" simulieren. Oder den User per Eingabe dazu auffordern?
    - Kugel rollt ins "Aus" -> Kugelanzahl prüfen. Wenn Kugelanzahl > 0, dann wieder autom. nächste Kugel laden.
        * Wenn "3. Kugel ins Aus gelangt" -> Wechsel in EndState

 */

import java.util.Objects;
import java.util.Scanner;

public class Playing implements State {
    private Context context;
    //@ToDo: Definition 1 Credit = 3 Kugeln
    private Integer ballCount = 1;

    public Playing(Context context) {
        this.context = context;
        System.out.println("States.Playing!");

        shootBall();

        //changeState() greift noch nicht richtig.
        //change state kann nicht im constructor kommen, sonst funktioniert es nicht (warum??)
        // nur wenn es von context aufgerufen wird greift es, also in playButtonPressed oder CoinInsert
        //oder vom ready state als ablauf nach dem playing (ist aber auch keine gute lösung)
        //deswegen behelfsmäßig mal bei den button-press-funktionen


        // aus der angabe: zu jeden zeitpunkt möglich, knopf zu drücken... ??? interrupt??

    }

    public void shootBall() {

        if (this.ballCount < 4) {
            System.out.println("Do you want to shoot the ball? Y/N");
            Scanner scanner = new Scanner(System.in);
            String shooting = scanner.next();

            if (Objects.equals(shooting, "Y")) {
                System.out.println("Ball Number: " + this.ballCount + "/3");
                this.ballCount++;
                this.shootBall();
            }
        } else {
            System.out.println("Those were all your balls");
            System.out.println("What is your next choice?");
        }

    }

    //@ToDo: sowohl Flipper (Context) als auch Statusklassen, sollen Statuswechsel durchführen können: "Both context and concrete states can set the next state of the context and perform the actual state transition by replacing the state object linked to the context.".
    public void changeState() {
        context.setState(new EndState(context));
    }

    @Override
    public void playButtonPressed() {
        System.out.println("States.Playing States.State - Authors of the Software are Tom and Magdalena");
        changeState();
    }

    @Override
    public void insertCoin() {
        //@ToDo: warum ändert sich hier der Status? Münzeinwurf verschafft ja nur mehr Credit. Play-State -> End-State nur wenn 3. Ball verloren gegangen ist, oder?
        context.setState(new Ready(context));
        changeState();

        //@ToDo: Credit-Implementierung aufnehmen?
    }
}
