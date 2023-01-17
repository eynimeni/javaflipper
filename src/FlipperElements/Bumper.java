package FlipperElements;

import Mediator.Mediator;

public class Bumper implements FlipperElement, FlipperElementWithScore {

    private String id;
    private Integer elementScore = 0;

    private Mediator mediator;
    private Integer elementHitCount = 0;
    private Boolean elementStatus = true;
    private Boolean specialBonusPoints = false;

    public Bumper(String id, Mediator mediator){
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

    @Override
    public Boolean getElementStatus() {
        return this.elementStatus;
    }

    @Override
    public void elementGotHit() {
        if(elementStatus) {
            this.elementHitCount += 1;
            this.mediator.directBall(this);
        }
    }

    @Override
    public void notifyMediator(FlipperElement flipperElement) {
    }

    public void turnOnSpecialBonusPoints() {
        if (specialBonusPoints = false) {
            this.specialBonusPoints = true;
            System.out.println("WOW - You will get Special Bonus Points for your Bumper Hitting Qualities!");
        }

    }

}
