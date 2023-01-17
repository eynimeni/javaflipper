package Mediator;

import FlipperElements.*;

public class MediatorImpl implements Mediator {


    @Override
    public void directBall(FlipperElement flipperElement) {
        System.out.println(flipperElement.getId() + " got hit");

        if (flipperElement instanceof Bumper) {
            System.out.println("you hit a Bumper");
        };
        if (flipperElement instanceof FlipperElementsComposition) {
            System.out.println("you hit a composition");
        };
        if (flipperElement instanceof KickersHoles) {
            System.out.println("you hit a kicker");
        };
        if (flipperElement instanceof Ramp) {
            System.out.println("you hit a ramp");
        };
        if (flipperElement instanceof Slingshot) {
            System.out.println("you hit a slingshot");
        };
        if (flipperElement instanceof Target) {
            System.out.println("you hit a target");
        };

//todo: wie krieg ich hier die elemente rein, damit ich weiter spiel
        //vielleicht lenkt der ball gar nicht weiter, sondern verändert nur etwas
        //in der tat wird das im playing festgelegt, wie viele elemente getroffen werden
        // und welche, alle durch random
        //und hier wird nur geschaut, ob es was auslöst oder nicht!
    }


    public void reactOnSlingshot() {


    };


}
