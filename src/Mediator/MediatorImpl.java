package Mediator;

import FlipperElements.*;

//todo: nachdem ich hier nur auf die einzelnen, bereits konkret gebauten elemente zugreife (und nicht weiß, welches das nächste sein wird) ->
//Frage: wie kann ich in einem anderen Element etwas verändern?

/*
Consider storing references to all components inside the mediator. This way, you could call any component from the mediator’s methods.

You can go even further and make the mediator responsible for the creation and destruction of component objects. After this, the mediator may resemble a factory or a facade.


 */


public class MediatorImpl implements Mediator {


    @Override
    public void directBall(FlipperElement flipperElement) {
        System.out.println(flipperElement.getId() + " got hit");

        if (flipperElement instanceof Bumper) {

            //wenn mind 3 bumper getroffen werden, gibt es bonuspunkte
            if(((Bumper) flipperElement).getElementHitCount() >2){
                ((Bumper) flipperElement).turnOnSpecialBonusPoints();
            }
            System.out.println("you hit a Bumper");
        };
        if (flipperElement instanceof FlipperElementsComposition) {
            //todo hier hinein eine logik, dass die rampe aktiviert wird () wenn vorher ein slingshot getroffen wurde
           // ramp.setElementStatus(true)


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

    }


    public void reactOnSlingshot() {


    };


}
