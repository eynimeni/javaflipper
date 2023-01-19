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
        //@ToDo: anpassen wenn Logik der einzelnen Komponenten implementiert ist. Composition muss Methoden der Kindelemente durchlaufen und aggregiert deren Aktionen/Ergebnisse

        //hier hinein vielleicht ein command pattern probieren!
        //aber die elemente können ja nicht alle das selbe erben...
        // natürlich kann man auch einfach hier eine punkte- und durchlauflogik machen.
        // einzelne elemente werden getroffen.
        // aber es wäre eine gute gelegenheit, das command zu probieren.
        // It’s enough to put a single field into the base Button class that stores a reference to a command object and make the button execute that command on a click.

        //CompositumCommand command = new CompositumCommand()
        //methode in interface FlipperElement compositumCommandGetHit
        //klasse: getHit dorthin compositum übergeben, einzelne elemente anlegen (for each)
        //dann die logik überlegen: wenn gotHit (welches Element? oder das wievielte Mal das ganze Kompositum?) -> was passier dann?
        //erstmal ganze logik schreiben und dann fallspielerein
        //auch einbauen: raten welche zahl -> gewinn von extra punkten



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
