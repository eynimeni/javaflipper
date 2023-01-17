package FlipperElements;

import Mediator.Mediator;

public class Bumper extends FlipperComponent implements FlipperElement, FlipperElementWithScore {

    private String id;
    private Integer elementScore = 0;

    private Mediator mediator;
    private Integer elementHitCount = 0;
    private Boolean elementStatus = true;

    /*@ToDo: Delete Comment, when Mediator-Class is available;
    public Bumper(Mediator mediator, String id){
        this.mediator = mediator;
        this.id = id;
    }
    */

    //@ToDo: wenn Mediator vorhanden löschen!
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

    }

    @Override
    public void notifyMediator(FlipperElement flipperElement) {

    }
}
