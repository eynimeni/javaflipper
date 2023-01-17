package FlipperElements;

import Mediator.Mediator;

public class Ramp implements FlipperElement, FlipperElementWithScore {


    private String id;
    private Integer elementScore = 0;
    private Mediator mediator;
    private Integer elementHitCount = 0;
    private Boolean elementStatus = false;


    public Ramp(String id, Mediator mediator){

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
        System.out.println("Ramp open: "+ this.elementStatus);
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
        else {
            System.out.println("Ramp is closed");
            this.mediator.printFallingDownMessage();
        }

}}
