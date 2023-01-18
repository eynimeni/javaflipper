package FlipperElements;

//FlipperElementsWithScore ist Abstrakte Klasse für jene FlipperElemente, die eine Wertigkeit haben und im Spiel Punkte liefern.
//-> ist jetzt ein Interface geworden, damit die abstrakte Klasse des Mediators vererbt werden kann (man kann nur von 1 Klasse, jedoch von mehreren Interfaces erben)

import Visitor.Visitor;

public interface FlipperElementWithScore {

    //Die Punkte festlegen, die man bei einem Treffer des Elements als Spieler erhält
    void setElementScoreValue(Integer elementScoreValue);

    int getElementScore();

    void resetElementScoreValue();

    //Setzt in einem Spiel, wie oft bisher das Element getroffen worden ist.
    void setElementHitCount(Integer elementHitCount);

    //Abfragen, wie oft ein Element getroffen worden ist.
    int getElementHitCount();

    void resetElementHitCount();

    //Methode für Visitor Pattern
    int acceptVisitor(Visitor visitor);

}
