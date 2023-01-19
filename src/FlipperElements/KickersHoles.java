package FlipperElements;

import Mediator.Mediator;
import Visitor.Visitor;

//@Kickers und Holes sind dasselbe.
public class KickersHoles implements FlipperElement, FlipperElementWithScore {

    private final String id;
    private int elementScore = 0;

    private final Mediator mediator;
    private int elementHitCount = 0;
    private Boolean elementStatus = true;

    /*@ToDo: Delete Comment, when Mediator-Class is available;
    public KickersHoles(Mediator mediator){
        this.mediator = mediator;
    }
    */

    //@ToDo: wenn Mediator vorhanden löschen!
    public KickersHoles(String id, Mediator mediator){

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

    @Override
    public Boolean getElementStatus() {
        return this.elementStatus;
    }

    @Override
    public void elementGotHit() {
        if(elementStatus) {
            //Gegen Aufruf setter ersetzt -> this.elementHitCount += 1;
            this.setElementHitCount(1);
            this.setElementScoreValue(20);
            System.out.println("Baaam, Kicker/Hole +20 Points!");
            this.mediator.directBall(this);
        }
    }


    @Override
    public void luckyStrike(FlipperElementsComposition composition) {
        composition.setElementScoreValue(20);
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
       return visitor.visitKickersHoles(this);
    }
}
