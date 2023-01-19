package FlipperElements;

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
