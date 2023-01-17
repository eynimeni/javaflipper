package FlipperElements;

import java.util.ArrayList;
import java.util.List;

//Upon receiving a request, a container delegates the work to its sub-elements, processes intermediate results and then returns the final result to the client.
    //@ToDo: -> ich glaube daher, dass der Aufruf der Composition-Methoden zum Aufruf der Methoden der jeweiligen Elemente in der ArrayList führen muss.

public class FlipperElementsComposition extends FlipperComponent implements FlipperElement{

    private String id;
    private Boolean elementStatus = true;
    private List<FlipperElement> flipperElementsList = new ArrayList<>();

    //@ToDo: wenn Mediator vorhanden löschen!
    public FlipperElementsComposition(String id){
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

}
