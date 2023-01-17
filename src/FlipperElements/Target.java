package FlipperElements;

import Mediator.Mediator;

public class Target implements FlipperElement, FlipperElementWithScore {

    private String id;
    private Integer elementScore = 0;
    private Mediator mediator;
    private Integer elementHitCount = 0;

    //todo punktevisitor: allTargetsTouched muss riesigen Bonus bringen, das ist nicht leicht zu kriegen!
    //todo resetvisitor: muss bei neuem ball alle target elementStatus wieder auf true setzen
    private Integer allTargetsTouched = 0;
    private Boolean elementStatus = true;

    public Target(String id, Mediator mediator){
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
        this.elementScore = elementScoreValue;
    }

    @Override
    public void setElementHitCount(Integer elementHitCount) {
        this.elementHitCount = elementHitCount;
    }

    @Override
    public Integer getElementHitCount() {
        return this.elementHitCount;
    }

    @Override
    public void setElementStatus(Boolean elementStatus) {
        this.elementStatus = elementStatus;
    }

    public void setAllTargetsTouched() {
      this.allTargetsTouched += 1;
    };

    @Override
    public Boolean getElementStatus() {
        return this.elementStatus;
    }

    @Override
    public void elementGotHit() {
        if(elementStatus) {
            this.elementHitCount += 1;
            this.mediator.directBall(this);
        } else {
            this.mediator.redirectBall(100);
        }


    }


}
