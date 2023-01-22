package States;

import AbstractFactory.*;
import AbstractFactory.DisplayText;
import Base.Player;

import FlipperElements.*;
import Mediator.*;

import java.util.ArrayList;
import java.util.List;

public class Flipper {

    private static Flipper singletonFlipper;
    private AbstractFactory<DisplayText> factory = null;
    private DisplayText displayText;
    private Integer credit = 0;
    private State state;
    private final List<FlipperElement> flipperElements;
    private final Mediator mediator = new MediatorImpl();
    private final List<Player> players = new ArrayList<>();
    private Player currentPlayer;

    //Private Constructor wg. Singleton
    private Flipper() {
        setState(new NoCredit(this));

        this.flipperElements = createFlipperElements();
        //@ToDo: fix or delete! this.mediator = mediator.getSingleMediatorInstance();
        this.mediator.setElements(this.flipperElements);
    }

    //Public Methode für Singleton-Erzeugung
    public static Flipper getSingleFlipperInstance() {
        if (singletonFlipper == null) {
            singletonFlipper = new Flipper();
        }
        return singletonFlipper;
    }

    public void createDisplayTextFactory(String factoryVariant){

        if(factoryVariant.equalsIgnoreCase("A")){
            this.factory = new DisplayTextFactoryVariantA();
        }
        else if(factoryVariant.equalsIgnoreCase("B")){
            this.factory = new DisplayTextFactoryVariantB();
        }
    }

    public AbstractFactory<DisplayText> getDisplayTextFactory(){
        return this.factory;
    }

    public void insertCoin() {
        addCredit();
    }

    public void addCredit() {
        this.credit++;
        displayText = this.getDisplayTextFactory().createMessage("coindrop");
        displayText.createText();
        //System.out.println("Clink-plink-clink. This coin dropped smoothly!");
        System.out.println(">>> Your Credit is now: " + this.credit);
        state.insertCoin();

    }

    public void pressPlayButton() {
        System.out.println(">>> Play Button Pressed");
        state.playButtonPressed();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    //Wird jedesmal aufgerufen, wenn im ReadyState der PlayButton gedrückt wird!
    public void decreaseCredit() {
        if (this.credit > 0) {
            this.credit--;
        }
    }

    public void displayCredit() {
        System.out.println(">>> Your Credit: " + this.credit);

    }

    public Integer getCredit() {
        return this.credit;
    }

    //Methode zum Erzeugen der FLipperElemente, die aus dem Constructor aufgerufen wird
    private List<FlipperElement> createFlipperElements() {

        List<FlipperElement> tmpFlipperElements = new ArrayList<>();
        System.out.println("\nCreating Flipper elements started ...");

        for (int i = 0; i < 2; i++) {
            Bumper bumper = new Bumper("bumper" + i, this.mediator);
            tmpFlipperElements.add(bumper);
        }

        for (int i = 0; i < 3; i++) {
            Target target = new Target("target" + i, this.mediator);
            tmpFlipperElements.add(target);
        }

        for (int i = 0; i < 2; i++) {
            KickersHoles kickersHoles = new KickersHoles("kicker" + i, this.mediator);
            tmpFlipperElements.add(kickersHoles);
        }

        for (int i = 0; i < 1; i++) {
            Ramp ramp = new Ramp("ramp" + i, this.mediator);
            tmpFlipperElements.add(ramp);
        }

        for (int i = 0; i < 2; i++) {
            Slingshot slingshot = new Slingshot("slingshot" + i, this.mediator);
            tmpFlipperElements.add(slingshot);
        }

        tmpFlipperElements.add(createFlipperElementsComposition());

        //Logoutput for FlipperElementcreation to be prooved.
            /*for (FlipperElement flipperElement : tmpFlipperElements) {
                System.out.println(" - FlipperElement ID: " + flipperElement.getId());

                if (flipperElement instanceof FlipperElementsComposition) {

                    for (FlipperElement compFlipperElement : ((FlipperElementsComposition) flipperElement).getFlipperElementsList()) {
                        System.out.println("    - FlipperElementComposition: " + compFlipperElement.getId());
                    }
                }
            }*/

        System.out.println("... Building Flipper Elements completed!\n... FlipperElement-List contains \"" + tmpFlipperElements.size() + "\" elements.");
        //Factory hier noch nicht verfügbar, wird erst danach erzeugt!
        System.out.println(
                """
                 ____   __      ___         _                                 _  __ _            _     ___ _ _                    _    ____
                 \\ \\ \\  \\ \\    / / |_  __ _| |_   __ _   _ __  __ _ __ _ _ _ (_)/ _(_)__ ___ _ _| |_  | __| (_)_ __ _ __  ___ _ _| |  / / /
                  > > >  \\ \\/\\/ /| ' \\/ _` |  _| / _` | | '  \\/ _` / _` | ' \\| |  _| / _/ -_) ' \\  _| | _|| | | '_ \\ '_ \\/ -_) '_|_| < < <\s
                 /_/_/    \\_/\\_/ |_||_\\__,_|\\__| \\__,_| |_|_|_\\__,_\\__, |_||_|_|_| |_\\__\\___|_||_\\__| |_| |_|_| .__/ .__/\\___|_| (_)  \\_\\_\\
                                                                   |___/                                      |_|  |_|                    \s
               """
        );

        return tmpFlipperElements;
    }

    //Methode um eine Composition aus FlipperElementen zu erzeugen. Wird über createFlipperElements() aufgerufen
    private FlipperElementsComposition createFlipperElementsComposition() {

        FlipperElementsComposition flipperElementsComposition = new FlipperElementsComposition("composition1", this.mediator);

        Bumper bumper = new Bumper("compBumper", this.mediator);
        flipperElementsComposition.add(bumper);

        Target target = new Target("compTarget", this.mediator);
        flipperElementsComposition.add(target);

        for (int i = 0; i < 2; i++) {
            Slingshot slingshot = new Slingshot("compSlingshot" + i, this.mediator);
            flipperElementsComposition.add(slingshot);
        }
        return flipperElementsComposition;
    }

    //Methode, um die FLipperelemente des Flippers zu erhalten.
    public List<FlipperElement> getFlipperElementsList() {
        return this.flipperElements;
    }

    //Spieler erzeugen
    public void addPlayer(String playerName) {

        Player tmpPlayer = new Player(playerName);

        //Logoutput for rechecking
        //System.out.println("Log: Player " + tmpPlayer.getPlayerName() + ", Total Score = " + tmpPlayer.getGame().getTotalScore() + "/last Game's Score = " + tmpPlayer.getGame().getLastGamesScore());

        this.players.add(tmpPlayer);
        this.currentPlayer = tmpPlayer;
    }

    //Liefert den aktuellen Spieler
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

}


