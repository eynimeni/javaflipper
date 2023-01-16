package FlipperElements;

//FlipperElementsWithScore ist Abstrakte Klasse für jene FlipperElemente, die eine Wertigkeit haben und im Spiel Punkte liefern.

public abstract  class FlipperElementWithScore implements FlipperElement {

    //Die Punkte festlegen, die man bei einem Treffer des Elements als Spieler erhält
    abstract void setElementScoreValue(Integer elementScoreValue);

    //Setzt in einem Spiel, wie oft bisher das Element getroffen worden ist.
    abstract void setElementHitCount(Integer elementHitCount);

    //Abfragen, wie oft ein Element getroffen worden ist.
    abstract  Integer getElementHitCount();

}
