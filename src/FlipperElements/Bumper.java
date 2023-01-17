package FlipperElements;

import Mediator.Mediator;
import Visitor.Visitor;

public class Bumper implements FlipperElement, FlipperElementWithScore {

    private String id;
    private int elementScore = 0;

    private Mediator mediator;
    private int elementHitCount = 0;
    private Boolean elementStatus = true;
    private Boolean specialBonusPoints = false;
    // specialBonusPoints sollte deutlich höhere Punkte bringen

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

    @Override
    public Boolean getElementStatus() {
        return this.elementStatus;
    }

    public void setSpecialBonusPoints(Boolean specialBonusPoints) {
        this.specialBonusPoints = specialBonusPoints;
    }

    @Override
    public void elementGotHit() {
        if(elementStatus) {
            //Gegen Aufruf setter ersetzt -> this.elementHitCount += 1;
            this.setElementHitCount(1);
            this.setElementScoreValue(50);
            System.out.println("Baaam, Bumper +50 Points!");
            this.mediator.directBall(this);
        }
    }

    public void turnOnSpecialBonusPoints() {
        if (specialBonusPoints = false) {
            //Gegen Aufruf setter ersetzt -> this.specialBonusPoints = true;
            this.setSpecialBonusPoints(true);
            System.out.println("WOW - You will get Special Bonus Points for your Bumper Hitting Qualities!");
        }

    }

    @Override
    public int acceptVisitor(Visitor visitor) {
        return visitor.visitBumper(this);
    }
}
