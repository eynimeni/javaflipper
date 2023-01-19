package States;/*
@ToDo: Arbeitskommentare:
    Hab mich ja an diesen Inputs orientiert https://refactoring.guru/design-patterns/state. Ich denke, dass die Context-Klasse schon unsere Flipperklasse ist.
    Wg. diesem Statement: "Instead of implementing all behaviors on its own, the original object, called context, stores a reference to one of the state objects that represents its current state, and delegates all the state-related work to that object."
    Schlage daher vor, dass wir:
    - States.Flipper-Klasse kommt dann auch aus dem Statespackage wieder raus. Steht mal auf selber Ebene wie die Main.
        //->hier gibt es vielleicht ein Problem mit der Vererbung des Interfaces (zumindest schreit die IDE), drum hab ich es mal gelassen.
        // Ok, sehen wir uns noch an.
    ----
    Erster Schritt? States.Flipper mal sehr rudimentär programmieren, so dass Status und Statuswechsel korrekt funktioneren?
    Dann Spiellogik via Playing Klasse und Kompositum, Mediator etc?
 */

//TODO aufpassen, dass diese Klasse nicht zu überladen wird - evt. etwas kapseln in neuer Klasse

import Base.Player;

import FlipperElements.*;
import Mediator.Mediator;
import Mediator.MediatorImpl;


import java.util.ArrayList;
import java.util.List;

public class Flipper {

    private static Flipper singletonFlipper;
    //@ToDo: Ist der Credit nicht auch vom Status abhängig? NoCredit -> Credit = 0, Ready/Playing/EndState -> Credit >= 1 und gehört als Attribut inkl. dazugehöriger Methoden in den State? Oder als globale Variable zum States.Flipper?
    //-> dafür brauchen wir keine Variable, diese Logik ist im Endstate. Nach dem Spiel wird geschaut ob noch Credit da ist, dann entweder -> No Credit oder Ready State.

    private Integer credit = 0;
    private State state;
    //States.Flipper hält in der Liste die FlipperElemente
    private List<FlipperElement> flipperElements;
    Mediator mediator = new MediatorImpl();
    //Liste, um Player zu speichern.
    private List<Player> players = new ArrayList<>();
    //Aktueller Spieler, muss bei Spielerwechsel geändert werden. Diese Funktion gibt es aber noch nicht @ToDo: implementieren?
    private Player currentPlayer;


    private Flipper() {

        //FlipperStatus beim Instanzieren setzen
        setState(new NoCredit(this));

        //FlipperElemente für FLipper erzeugen
        this.flipperElements = createFlipperElements();
        this.mediator.setElements(this.flipperElements);



        //todo mediator die Liste übergeben! eine art getter in den mediator schreiben und hier aufrufen


    }

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
    //-> ja genau, es passiert, wenn im ready state der play button gedrückt wird!
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
            Bumper bumper = new Bumper("bumper"+i, this.mediator);
            tmpFlipperElements.add(bumper);
        }
        System.out.println("Log: FlipperElement-Liste enthält aktuell \"" +tmpFlipperElements.size()+ "\".");

        for(int i = 0; i<3; i++){
            Target target = new Target("target"+i, this.mediator);
            tmpFlipperElements.add(target);
        }
        System.out.println("Log: FlipperElement-Liste enthält aktuell \"" +tmpFlipperElements.size()+ "\".");

        for(int i = 0; i<2; i++){
            KickersHoles kickersHoles = new KickersHoles("kicker"+i, this.mediator);
            tmpFlipperElements.add(kickersHoles);
        }
        System.out.println("Log: FlipperElement-Liste enthält aktuell \"" +tmpFlipperElements.size()+ "\".");

        for(int i = 0; i<1; i++){
            Ramp ramp = new Ramp("ramp"+i, this.mediator);
            tmpFlipperElements.add(ramp);
        }
        System.out.println("Log: FlipperElement-Liste enthält aktuell \"" +tmpFlipperElements.size()+ "\".");

        for(int i = 0; i<2; i++){
            Slingshot slingshot = new Slingshot("slingshot"+i, this.mediator);
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

        FlipperElementsComposition flipperElementsComposition = new FlipperElementsComposition("composition1", this.mediator);

        Bumper bumper = new Bumper("compBumper", this.mediator);
        flipperElementsComposition.add(bumper);

        Target target = new Target("compTarget", this.mediator);
        flipperElementsComposition.add(target);

        for(int i = 0; i<2; i++){
            Slingshot slingshot = new Slingshot("compSlingshot"+i, this.mediator);
            flipperElementsComposition.add(slingshot);
        }

        return flipperElementsComposition;
    }


    //Getter Methode um Liste zu übergeben an Playing State
    public List<FlipperElement> getFlipperElementsList() {
       return this.flipperElements;
    }


    public void addPlayer(String playerName){

        Player tmpPlayer = createPlayer(playerName);
        System.out.println("Log: Player " +tmpPlayer.getPlayerName()+ ", Total Score = " +tmpPlayer.getGame().getTotalScore()+ "/last Game's Score = " +tmpPlayer.getGame().getLastGamesScore());

        this.players.add(tmpPlayer);
        this.currentPlayer = tmpPlayer;
    }

    private Player createPlayer(String playerName){

        Player player = new Player(playerName);
        return player;

    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }


}


