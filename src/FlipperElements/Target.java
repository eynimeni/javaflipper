package FlipperElements;

import Mediator.Mediator;
import Visitor.Visitor;

public class Target implements FlipperElement, FlipperElementWithScore {

    private final String id;
    private int elementScore = 0;
    private final Mediator mediator;
    private int elementHitCount = 0;

    private Integer allTargetsTouched = 0;
    private Boolean elementStatus = true;

    public Target(String id, Mediator mediator) {
        this.id = id;
        this.mediator = mediator;
    }

    public String getId() {
        return id;
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
    }

    public void setAllTargetsTouched() {
        this.allTargetsTouched += 1;
    }

    @Override
    public Boolean getElementStatus() {
        return this.elementStatus;
    }

    @Override
    public void elementGotHit() {
        if (elementStatus) {
            this.setElementHitCount(1);
            this.setElementScoreValue(40);
            System.out.println("Baaam, Target +40 Points!");
            this.mediator.directBall(this);
        } else {
            this.mediator.redirectBall(100);
        }

    }

    @Override
    public void luckyStrike(FlipperElementsComposition composition) {
        composition.increaseScore(20);
    }

    @Override
    public void badAssStrike(FlipperElementsComposition composition) {

        Integer additionalScore = this.elementScore *2;
        composition.increaseScore(additionalScore);
    }

    @Override
    public void strikeExtreme(FlipperElementsComposition composition) {
        composition.increaseScore(this.elementScore);

    }

    @Override
    public int acceptVisitor(Visitor visitor) {
        return visitor.visitTarget(this);
    }

    public Integer getAllTargetsTouched() {
        return allTargetsTouched;
    }

    public void setAllTargetsTouched(Integer allTargetsTouched) {
        this.allTargetsTouched = allTargetsTouched;
    }
}
