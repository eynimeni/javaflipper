package FlipperElements;

import Mediator.Mediator;

//Slingshots = Prellkontakte bewegen die Kugel eigentlich nur in bestimmte Richtungen und liefern keine Punkte.
public class Slingshot extends FlipperComponent implements FlipperElement {

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

    }

    @Override
    public void notifyMediator(FlipperElement flipperElement) {

    }
}
