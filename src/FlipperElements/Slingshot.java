package FlipperElements;

//Slingshots = Prellkontakte bewegen die Kugel eigentlich nur in bestimmte Richtungen und liefern keine Punkte.
public class Slingshot implements FlipperElement {

    private String id;
    //@ToDo: Delete Comment, when Mediator-Class is available; private Mediator mediator = null;
    private Boolean elementStatus = true;

    /*@ToDo: Delete Comment, when Mediator-Class is available;
    public Slingshot(Mediator mediator){
        this.mediator = mediator;
    }
    */

    //@ToDo: wenn Mediator vorhanden löschen!
    public Slingshot(String id){
        this.id = id;
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
}
