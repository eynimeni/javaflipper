package FlipperElements;

public class Bumper extends FlipperElementWithScore implements FlipperElement {

    private String id;
    private Integer elementScore = 0;
    //@ToDo: Delete Comment, when Mediator-Class is available; private Mediator mediator = null;
    private Integer elementHitCount = 0;
    private Boolean elementStatus = true;

    /*@ToDo: Delete Comment, when Mediator-Class is available;
    public Bumper(Mediator mediator, String id){
        this.mediator = mediator;
        this.id = id;
    }
    */

    //@ToDo: wenn Mediator vorhanden löschen!
    public Bumper(String id){
        this.id = id;
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
}
