package FlipperElements;

import Mediator.Mediator;
import Visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

//Upon receiving a request, a container delegates the work to its sub-elements, processes intermediate results and then returns the final result to the client.
    //@ToDo: -> ich glaube daher, dass der Aufruf der Composition-Methoden zum Aufruf der Methoden der jeweiligen Elemente in der ArrayList führen muss.

//@ToDo: muss wohl auch noch das Interface FlipperElementsWithScroe implementieren!


//Verwenden sie auch das Kompositum-Muster zusammen mit dem
//Kommando-Muster, um komplexere Befehle (Makro-Befehle) zu
//erstellen.
//Zum Beispiel können sie ein Hole derart konfigurieren, sodass ein
//Befehl für die Punktevergabe zuständig ist und ein weiterer Befehl den
//Spieler bzw. die Spielerin zwischen 1, 2 und 3 wählen lässt, wobei es
//beim Erraten Zusatzpunkte gibt.


public class FlipperElementsComposition implements FlipperElement{

    private String id;
    private Boolean elementStatus = true;
    private List<FlipperElement> flipperElementsList = new ArrayList<>();

    private Mediator mediator;

    public FlipperElementsComposition(String id, Mediator mediator){

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
       //@ToDo: anpassen wenn Logik der einzelnen Komponenten implenentiert ist. Composition muss Methoden der Kindelemente durchlaufen und aggregiert deren Aktionen/Ergebnisse
        this.elementStatus = elementStatus;
    }

    @Override
    public Boolean getElementStatus() {
        //@ToDo: anpassen wenn Logik der einzelnen Komponenten implenentiert ist. Composition muss Methoden der Kindelemente durchlaufen und aggregiert deren Aktionen/Ergebnisse
        return this.elementStatus;
    }

    @Override
    public void elementGotHit() {
        //@ToDo: anpassen wenn Logik der einzelnen Komponenten implenentiert ist. Composition muss Methoden der Kindelemente durchlaufen und aggregiert deren Aktionen/Ergebnisse
        this.mediator.directBall(this);

    }

    //FlipperElement zu kombiniertem FlipperElement hinzufügen
    public void add(FlipperElement flipperElement){
        this.flipperElementsList.add(flipperElement);
    }

    //FlipperElement aus kombiniertem FlipperElement entfernen
    public void remove(FlipperElement flipperElement){
        this.flipperElementsList.remove(flipperElement);
    }

    public List<FlipperElement> getFlipperElementsList(){
        return this.flipperElementsList;
    }

    //@ToDo: Wenn Interface implementiert ist, dann diese Methode auch zu implementieren/aktivieren für Visitor!
    /*public void acceptVisitor(Visitor visitor) {
        visitor.visitFlipperElementsComposition(this);
    }*/
}
