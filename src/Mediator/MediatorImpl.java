package Mediator;

import FlipperElements.*;

import javax.lang.model.element.Element;
import java.util.List;
import java.util.Random;
import java.util.SplittableRandom;

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
        System.out.println("    " + flipperElement.getId() + " got hit");

        if (flipperElement instanceof Bumper) {
            //wenn bumper mind 3 mal getroffen werden, gibt es bonuspunkte
            if (((Bumper) flipperElement).getElementHitCount() > 2) {
                ((Bumper) flipperElement).turnOnSpecialBonusPoints();
            }
            redirectBall(90);

        }
        ;
        if (flipperElement instanceof FlipperElementsComposition) {
            //todo hier hinein eine logik, wie die composition tut
            redirectBall(60);
        }
        ;
        if (flipperElement instanceof KickersHoles) {
            //kicker0 lenkt fix zur rampe
            if (flipperElement.getId().equals("kicker0")) {
                this.ramp0.elementGotHit();
            }
            else {
                redirectBall(80);
            }
        }
        ;
        if (flipperElement instanceof Ramp) {
            redirectBall(97);
        }
        ;
        if (flipperElement instanceof Slingshot) {
            this.ramp0.setElementStatus(true);
            redirectBall(80);
        }
        ;
        if (flipperElement instanceof Target) {
            if(flipperElement.getId().equals("target0")){
                this.target0.setElementStatus(false);
                redirectBall(55);
            };
            if(flipperElement.getId().equals("target1")){
                this.target0.setElementStatus(false);
                redirectBall(55);
            };
            if(flipperElement.getId().equals("target2")){
                this.target0.setElementStatus(false);
                redirectBall(55);
            }
        }
        ;
    }

    public void targetWasHitAction(String target, FlipperElement flipperElement) {
        if(flipperElement.getId().equals(target)){
            this.target0.setElementStatus(false);
            redirectBall(55);
        }
    }

    public void redirectBall(Integer probabilityOfSuccessInPercent) {

        SplittableRandom random = new SplittableRandom();
        Integer randomInt = random.nextInt(1, 101);
        boolean successfullRedirection = randomInt <= probabilityOfSuccessInPercent;

        if (successfullRedirection) {
            hitNextRandomElement();
        } else {
            printFallingDownMessage();
        }

    }

    public void printFallingDownMessage() {
        String fallingDownMessage = "Watch out! Ball falling down!";
        System.out.println(fallingDownMessage);
    }

    public void hitNextRandomElement() {
        FlipperElement element = getRandomFlipperElement(this.flipperElementList);
        element.elementGotHit();
    }

    public FlipperElement getRandomFlipperElement(List<FlipperElement> elements) {
        return elements.get(new Random().nextInt(elements.size()));
    }

}
