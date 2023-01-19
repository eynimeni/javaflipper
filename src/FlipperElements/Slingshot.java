package FlipperElements;

import Mediator.Mediator;

public class Slingshot implements FlipperElement {

    private final String id;
    private final Mediator mediator;
    private Boolean elementStatus = true;

    public Slingshot(String id, Mediator mediator){
        this.id = id;
        this.mediator = mediator;
    }

    public String getId() {
        return id;
    }

    @Override
    public void setElementStatus(Boolean elementStatus) {
        this.elementStatus = elementStatus;
    }

    @Override
    public Boolean getElementStatus() {
        return this.elementStatus;
    }

    @Override
    public void elementGotHit() {
        System.out.println("You hit a Slingshot!!");
        if(elementStatus) {
            this.mediator.directBall(this);
        }

    }

    @Override
    public void luckyStrike(FlipperElementsComposition composition) {
    }

    @Override
    public void badAssStrike(FlipperElementsComposition composition) {
        composition.increaseScore(10);
    }

    @Override
    public void strikeExtreme(FlipperElementsComposition composition) {
        composition.increaseScore(20);

    }
}
