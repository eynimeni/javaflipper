package States;

/*
@ToDo: Arbeitskommentare:
    Hier passiert am meisten Logik, würd ich meinen, oder "Concrete States provide their own implementations for the state-specific methods."?
    Methoden für:
    - Wenn man von Ready in den Playing Status gelangt, autom. Laden der 1. Kugel.
    //-> ja genau, aber jeden Ball Abschuss muss man halt noch mal "händisch" machen, also bestätigen. dafür gibt es doch nochmal einen extra knopf, drum hab ich das so geschrieben
    - Credit wird durch Statuswechsel zu Playing um 1 verringert.
    //-> das ist eh schon
    - Kugel abschießen, so lange es Kugeln gibt möglich
    //-> ja genau, also 3 mal pro Münze
    - Nach Abschießen der Kugel, durchläuft diese das Spielfeld und trifft die unterschiedlichen States.Flipper-Elemente (Bumper, Slingshot ...)
        * Hierzu soll dann die Spiellogik implementiert werden, die das Zusammenspiel und die entstehenden Punkte steuert und ermittelt -> Mediator- /Visitor-Pattern?
        * Betätigen der Flipperhebel in Spiellogik auch "random" simulieren. Oder den User per Eingabe dazu auffordern?
        // da bin ich mir auch nicht sicher!!
    - Kugel rollt ins "Aus" -> Kugelanzahl prüfen. Wenn Kugelanzahl > 0, dann wieder autom. nächste Kugel laden.
        * Wenn "3. Kugel ins Aus gelangt" -> Wechsel in EndState
 */

import FlipperElements.FlipperElement;

import java.util.*;

public class Playing implements State {
    private Flipper context;
    //@ToDo: Definition 1 Credit = 3 Kugeln
    // das vielleicht irgendwo ausgeben?
    private Integer ballCount = 1;

    public Playing(Flipper context) {
        this.context = context;
        System.out.println("States.Playing!");

        //hier vielleicht eine Base.Game Class die Punkte speichert (und mit Spiel verbunden ist)

        shootBall();

        //todo hier punkte highscore zeug

        //todo check: evt ist endstate kein echter state sondern eine form von

        //changeState() greift noch nicht richtig.
        //change state kann nicht im constructor kommen, sonst funktioniert es nicht (warum??)
        // nur wenn es von context aufgerufen wird greift es, also in playButtonPressed oder CoinInsert
        //oder vom ready state als ablauf nach dem playing (ist aber auch keine gute lösung)
        //deswegen behelfsmäßig mal bei den button-press-funktionen


        // aus der angabe: zu jeden zeitpunkt möglich, knopf zu drücken... ??? interrupt??

    }

    public void shootBall() {

        if (this.ballCount < 4) {
            System.out.println("Do you want to shoot a ball? Y/N");
            Scanner scanner = new Scanner(System.in);
            String shooting = scanner.next();

            if (Objects.equals(shooting, "Y")) {
                System.out.println("Ball Number: " + this.ballCount + "/3");
                this.ballCount++;
                this.playBall();

                //todo hier wird dann der visitor auch aufgerufen und speichert die punkte

                this.shootBall();
            }
        } else {
            System.out.println("Those were all your balls");
            System.out.println("What is your next choice?");
        }

    }

    //@ToDo: sowohl States.Flipper (Context) als auch Statusklassen, sollen Statuswechsel durchführen können: "Both context and concrete states can set the next state of the context and perform the actual state transition by replacing the state object linked to the context.".
    //-> meiner Meinung nach, haben wir das eh so!

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
        context.insertCoin();
        //@ToDo: warum ändert sich hier der Status? Münzeinwurf verschafft ja nur mehr Credit. Play-State -> End-State nur wenn 3. Ball verloren gegangen ist, oder?
        context.setState(new Ready(context));
        //changeState();

        //@ToDo: Credit-Implementierung aufnehmen?
        // -> das passiert im States.Flipper. Die Methode wird nur vererbt, falls man noch eine spezifische Action braucht
    }

    public void playBall() {
        List<FlipperElement> flipperElementList = this.context.getFlipperElementsList();

        getRandomFlipperElement(flipperElementList).elementGotHit();

        System.out.println("Pinball lever trying to catch that ball!");

            SplittableRandom random = new SplittableRandom();
            boolean success = random.nextInt(1,101) <= 50;
            if(success) {
                System.out.println("OH YES! Caught it!");
                playBall();
            } else {
                System.out.println("DAMM! LOST IT!");
            }
        }

    public FlipperElement getRandomFlipperElement(List<FlipperElement> elements) {
        return elements.get(new Random().nextInt(elements.size()));
    }

}
