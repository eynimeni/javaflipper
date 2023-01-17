package FlipperElements;

import Mediator.Mediator;

//@Kickers und Holes sind dasselbe.
public class KickersHoles implements FlipperElement, FlipperElementWithScore {

    private String id;
    private Integer elementScore = 0;

    private Mediator mediator;
    private Integer elementHitCount = 0;
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
}
