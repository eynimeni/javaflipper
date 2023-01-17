package Mediator;

import FlipperElements.FlipperElement;
import FlipperElements.FlipperElementWithScore;

public class MediatorImpl implements Mediator {
    @Override
    public void directBall(FlipperElement flipperElement) {
        System.out.println(flipperElement.getId() + " got hit");


        //beispiel:
        /*
        element wird angespielt
        bumper1.elementGotHit(
         */
    }



    public void reactOnSlingshot() {


    };


}
