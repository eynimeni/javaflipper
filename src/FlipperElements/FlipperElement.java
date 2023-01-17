package FlipperElements;

//Alle FlipperElement müssen dieses Interface implementieren!

public interface FlipperElement {

    //Info: Den Mediator zum konkreten FlipperElement zur Realisierung des Mediator-Patterns via Konstruktor des FlipperElements setzen

    //@ToDo: Setter aufnehmen
    String getId();

    //@ToDo: kann sein, dass wir den Status gar nicht brauchen?
    //ALle Elemente haben einen Status: true = kann angespielt werden, false = kann nicht angespielt werden
    //todo überlegen, evt. haben nicht alle einen status

    void setElementStatus(Boolean elementStatus);

    //Status eines Elements abfragen, um Möglichkeit des Anspielens zu ermitteln
    Boolean getElementStatus();

    //Wenn ein Element getroffen worden ist, soll über den Mediator in Erfahrung gebracht werden, was als nächstes passiert.
    void elementGotHit();

    void notifyMediator(FlipperElement flipperElement);

}
