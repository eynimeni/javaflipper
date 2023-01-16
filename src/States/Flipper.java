package States;

/*
@ToDo: Arbeitskommentare:
    Hab mich ja an diesen Inputs orientiert https://refactoring.guru/design-patterns/state. Ich denke, dass die Context-Klasse schon unsere Flipperklasse ist.
    Wg. diesem Statement: "Instead of implementing all behaviors on its own, the original object, called context, stores a reference to one of the state objects that represents its current state, and delegates all the state-related work to that object."
    Schlage daher vor, dass wir:
    - Die Context-Klasse zur Flipperklasse refactorn
        //->done! Nice :-)
    - Sie als Singleton aus der Main erzeugen, weil es nur 1 Flipperautomaten ja an sich gibt.
        //->ja, das passiert schon!
        //Leider "NEIN", denn beim Singleton darf der Konstruktor nicht direkt aufgerufen werden. Es gibt eine Methode, die das Erzeugen übernimmt und eben nur ein Objekt erzeugt, wenn es noch keines gibt! Hab es unten auskommentiert eingebaut
    - Flipper-Klasse kommt dann auch aus dem Statespackage wieder raus. Steht mal auf selber Ebene wie die Main.
        //->hier gibt es vielleicht ein Problem mit der Vererbung des Interfaces (zumindest schreit die IDE), drum hab ich es mal gelassen.
        // Ok, sehen wir uns noch an.
    ----
    Erster Schritt? Flipper mal sehr rudimentär programmieren, so dass Status und Statuswechsel korrekt funktioneren?
    Dann Spiellogik via Playing Klasse und Kompositum, Mediator etc?
 */

import FlipperElements.*;
import java.util.ArrayList;
import java.util.List;

public class Flipper {

    private static Flipper singletonFlipper;
    //@ToDo: Ist der Credit nicht auch vom Status abhängig? NoCredit -> Credit = 0, Ready/Playing/EndState -> Credit >= 1 und gehört als Attribut inkl. dazugehöriger Methoden in den State? Oder als globale Variable zum Flipper?
    private Integer credit = 0;
    private State state;
    //Flipper hält in der Liste die FlipperElemente
    private List<FlipperElement> flipperElements;

    /*@ToDo: Vorschlag für weitere Attribute der Flipperklasse.
    public players: Player[] //Array der Spieler, die schon gespielt haben. Auch Eingabe eines neuen Spielers soll möglich sein. Total-Score = 0, Last-Game-Score = 0 zu beginn.
    */

    //@ToDo: Constructor für Singleton private machen. Wird dann über public Methode aufgerufen.
    public Flipper() {

        //FlipperStatus beim Instanzieren setzen
        setState(new NoCredit(this));

        //@ToDo: hier auch den Mediator erzeugen, und diesen dann an createFlipperElements() als Parameter mit geben, damit dieser für die Erstellung der einzelnen FlipperElements genutzt werden kann.
        //FlipperElemente für FLipper erzeugen
        this.flipperElements = createFlipperElements();
    }

    //@ToDo: aus Main zum Erzeugen des Flippers aufrufen, der dadurch zum Singleton wird
    public static Flipper getSingleFlipperInstance(){
        if (singletonFlipper == null){
            singletonFlipper = new Flipper();
        }

        return singletonFlipper;
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

    //Methode zum Erzeugen der FLipperElemente, die aus dem Constructor aufgerufen wird
    private List<FlipperElement> createFlipperElements(){

        List<FlipperElement> tmpFlipperElements = new ArrayList<>();
        System.out.println("\nLog: Erstellung FLipperElements gestartet ... FlipperElement-Liste enthält aktuell \"" +tmpFlipperElements.size()+ "\".");


        //@ToDo: man könnte hier mit einer Random-Funktion die Anzahl der zu erstellenden FlipperElemente jeweils noch freier gestalten

        for(int i = 0; i<2; i++){
            //@ToDo: für Verwendung mit Mediator muss Constructorparamenter angepasst werden!
            Bumper bumper = new Bumper("bumper"+i);
            tmpFlipperElements.add(bumper);
        }
        System.out.println("Log: FlipperElement-Liste enthält aktuell \"" +tmpFlipperElements.size()+ "\".");

        for(int i = 0; i<3; i++){
            //@ToDo: für Verwendung mit Mediator muss Constructorparamenter angepasst werden!
            Target target = new Target("target"+i);
            tmpFlipperElements.add(target);
        }
        System.out.println("Log: FlipperElement-Liste enthält aktuell \"" +tmpFlipperElements.size()+ "\".");

        for(int i = 0; i<2; i++){
            //@ToDo: für Verwendung mit Mediator muss Constructorparamenter angepasst werden!
            KickersHoles kickersHoles = new KickersHoles("kicker"+i);
            tmpFlipperElements.add(kickersHoles);
        }
        System.out.println("Log: FlipperElement-Liste enthält aktuell \"" +tmpFlipperElements.size()+ "\".");

        for(int i = 0; i<1; i++){
            //@ToDo: für Verwendung mit Mediator muss Constructorparamenter angepasst werden!
            Ramp ramp = new Ramp("ramp"+i);
            tmpFlipperElements.add(ramp);
        }
        System.out.println("Log: FlipperElement-Liste enthält aktuell \"" +tmpFlipperElements.size()+ "\".");

        for(int i = 0; i<2; i++){
            //@ToDo: für Verwendung mit Mediator muss Constructorparamenter angepasst werden!
            Slingshot slingshot = new Slingshot("slingshot"+i);
            tmpFlipperElements.add(slingshot);
        }
        System.out.println("Log: FlipperElement-Liste enthält aktuell \"" +tmpFlipperElements.size()+ "\".");

        tmpFlipperElements.add(createFlipperElementsComposition());
        System.out.println("Log: FlipperElement-Liste enthält aktuell \"" +tmpFlipperElements.size()+ "\".");

        System.out.println("Log: FlipperElement-Liste enthält aktuell:");
        for (FlipperElement flipperElement : tmpFlipperElements) {
            System.out.println(" - FlipperElement ID: " + flipperElement.getId());

            if (flipperElement instanceof FlipperElementsComposition) {

                for (FlipperElement compFlipperElement : ((FlipperElementsComposition) flipperElement).getFlipperElementsList()) {
                    System.out.println("    - FlipperElementComposition: " + compFlipperElement.getId());
                }
            }

        }

        System.out.println("Log: ... Erstellung FLipperElements beendet!\n");

        return  tmpFlipperElements;

    }

    //Methode um eine Composition aus FlipperElementen zu erzeugen. Wird über createFlipperElements() aufgerufen
    private FlipperElementsComposition createFlipperElementsComposition(){

        FlipperElementsComposition flipperElementsComposition = new FlipperElementsComposition("composition1");

        //@ToDo: für Verwendung mit Mediator muss Constructorparamenter angepasst werden!
        Bumper bumper = new Bumper("compBumper");
        flipperElementsComposition.add(bumper);

        //@ToDo: für Verwendung mit Mediator muss Constructorparamenter angepasst werden!
        Target target = new Target("compTarget");
        flipperElementsComposition.add(target);

        for(int i = 0; i<2; i++){
            //@ToDo: für Verwendung mit Mediator muss Constructorparamenter angepasst werden!
            Slingshot slingshot = new Slingshot("compSlingshot"+i);
            flipperElementsComposition.add(slingshot);
        }

        return flipperElementsComposition;
    }

}

