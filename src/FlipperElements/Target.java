package FlipperElements;

import Mediator.Mediator;
import Visitor.Visitor;

public class Target implements FlipperElement, FlipperElementWithScore {

    private String id;
    private int elementScore = 0;
    private Mediator mediator;
    private int elementHitCount = 0;

    //todo punktevisitor: allTargetsTouched muss riesigen Bonus bringen, das ist nicht leicht zu kriegen!
    //todo resetvisitor: muss bei neuem ball alle target elementStatus wieder auf true setzen
    private Integer allTargetsTouched = 0;
    private Boolean elementStatus = true;

    public Target(String id, Mediator mediator) {
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
    }

    public void setAllTargetsTouched() {
        this.allTargetsTouched += 1;
    }

    ;

    @Override
    public Boolean getElementStatus() {
        return this.elementStatus;
    }

    @Override
    public void elementGotHit() {
        if (elementStatus) {
            //Gegen Aufruf setter ersetzt ->  this.elementHitCount += 1;
            this.setElementHitCount(1);
            this.setElementScoreValue(40);
            System.out.println("Baaam, Target +40 Points!");
            this.mediator.directBall(this);
        } else {
            this.mediator.redirectBall(100);
        }

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
