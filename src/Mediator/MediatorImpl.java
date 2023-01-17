package Mediator;

import FlipperElements.*;

import javax.lang.model.element.Element;
import java.util.List;
import java.util.Random;

//todo: nachdem ich hier nur auf die einzelnen, bereits konkret gebauten elemente zugreife (und nicht weiß, welches das nächste sein wird) ->
//Frage: wie kann ich in einem anderen Element etwas verändern?

/*
Consider storing references to all components inside the mediator. This way, you could call any component from the mediator’s methods.
You can go even further and make the mediator responsible for the creation and destruction of component objects. After this, the mediator may resemble a factory or a facade.

 */

public class MediatorImpl implements Mediator {


    private Bumper bumper0;
    private Bumper bumper1;

    private Target target0;
    private Target target1;
    private Target target2;
    private KickersHoles kicker0;
    private KickersHoles kicker1;
    private Ramp ramp0;
    private Slingshot slingshot0;
    private Slingshot slingshot1;
    private FlipperElementsComposition composition1;

    private List<FlipperElement> flipperElementList;

    public void setElements(List<FlipperElement> flipperElementList) {
        this.flipperElementList = flipperElementList;

         this.bumper0 = (Bumper) flipperElementList.get(0);
         this.bumper1 = (Bumper) flipperElementList.get(1);
         this.target0 = (Target) flipperElementList.get(2);
         this.target1 = (Target) flipperElementList.get(3);
         this.target2 = (Target) flipperElementList.get(4);
         this.kicker0 = (KickersHoles) flipperElementList.get(5);
         this.kicker1 = (KickersHoles) flipperElementList.get(6);
         this.ramp0 = (Ramp) flipperElementList.get(7);
         this.slingshot0 = (Slingshot) flipperElementList.get(8);
         this.slingshot1 = (Slingshot) flipperElementList.get(9);
    }


    @Override
    public void directBall(FlipperElement flipperElement) {
        System.out.println(flipperElement.getId() + " got hit");

        if (flipperElement instanceof Bumper) {
            //wenn bumper mind 3 mal getroffen werden, gibt es bonuspunkte
            if(((Bumper) flipperElement).getElementHitCount() >2){
                ((Bumper) flipperElement).turnOnSpecialBonusPoints();
            }



            System.out.println("you hit a Bumper");



        };
        if (flipperElement instanceof FlipperElementsComposition) {
            //todo hier hinein eine logik, wie die composition tut
            System.out.println("you hit a composition");
        };
        if (flipperElement instanceof KickersHoles) {
            System.out.println("you hit a kicker");
        };
        if (flipperElement instanceof Ramp) {

            System.out.println("you hit a ramp");
        };
        if (flipperElement instanceof Slingshot) {
            this.ramp0.setElementStatus(true);
            System.out.println("Ramp is now open!");
        };
        if (flipperElement instanceof Target) {
            System.out.println("you hit a target");
        };

    }

    public void hitNextRandomElement() {
        FlipperElement element = getRandomFlipperElement(this.flipperElementList);
        element.elementGotHit();
    }

    public FlipperElement getRandomFlipperElement(List<FlipperElement> elements) {
        return elements.get(new Random().nextInt(elements.size()));
    }

    public void reactOnSlingshot() {


    };


}
