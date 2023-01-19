package FlipperElements;

import Mediator.Mediator;
import Visitor.Visitor;

//Slingshots = Prellkontakte bewegen die Kugel eigentlich nur in bestimmte Richtungen und liefern keine Punkte.
public class Slingshot implements FlipperElement {

    private String id;
    private Mediator mediator;
    private Boolean elementStatus = true;

    /*@ToDo: Delete Comment, when Mediator-Class is available;
    public Slingshot(Mediator mediator){
        this.mediator = mediator;
    }
    */

    //@ToDo: wenn Mediator vorhanden löschen!
    public Slingshot(String id, Mediator mediator){
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
            this.mediator.directBall(this);
        }

    }

    @Override
    public void luckyStrike(FlipperElementsComposition composition) {
    }

    @Override
    public void badAssStrike(FlipperElementsComposition composition) {
        composition.increaseScore(10);
    }

    @Override
    public void strikeExtreme(FlipperElementsComposition composition) {
        composition.increaseScore(20);

    }
}
