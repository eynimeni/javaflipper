package FlipperElements;

import Mediator.Mediator;
import Visitor.Visitor;

public class Ramp implements FlipperElement, FlipperElementWithScore {


    private String id;
    private int elementScore = 0;
    private Mediator mediator;
    private int elementHitCount = 0;
    private Boolean elementStatus = false;


    public Ramp(String id, Mediator mediator) {

        this.id = id;
        this.mediator = mediator;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void setElementScoreValue(Integer elementScoreValue) {
        this.elementScore += elementScoreValue;
    }

    @Override
    public int getElementScore() {
        return elementScore;
    }

    @Override
    public void resetElementScoreValue(){
        this.elementScore = 0;
    }

    @Override
    public void setElementHitCount(Integer elementHitCount) {
        this.elementHitCount += elementHitCount;
    }

    @Override
    public int getElementHitCount() {
        return this.elementHitCount;
    }

    @Override
    public void resetElementHitCount(){
        this.elementHitCount = 0;
    }

    @Override
    public void setElementStatus(Boolean elementStatus) {
        this.elementStatus = elementStatus;
        System.out.println("Ramp open: " + this.elementStatus);
    }

    @Override
    public Boolean getElementStatus() {
        return this.elementStatus;
    }

    @Override
    public void elementGotHit() {
        if (elementStatus) {
            //Gegen Aufruf setter ersetzt -> this.elementHitCount += 1;
            this.setElementHitCount(1);
            this.setElementScoreValue(100);
            System.out.println("Baaam, Ramp +20 Points!");
            this.mediator.directBall(this);
        } else {
            System.out.println("Ramp is closed");
            this.mediator.printFallingDownMessage();
        }

    }

    @Override
    public int acceptVisitor(Visitor visitor) {
        return visitor.visitRamp(this);
    }
}
