package States;

/*
@ToDo: Arbeitskommentare:
    - Hier alle Methoden (auch Attribute?) anführen, die für alle States auf eigene Weise zu implementieren sind.
    - Credit hier als Attribut und mit dazugehörigen Methoden abbilden?
        * Credit hoch zählen bei jedem Münzeinwurf wäre eig. über alle States dasselbe oder gibt es Unterschiede?
    ----
    Allgemeines zu den States:
    - Eig. passiert bei insertCoin in allen States dasselbe.
    - playButtonPressed zeigt nur bei NoCredit -> Ausgabe "No Credit available" und bei Ready -> Wechsel in Playing Wirkung, in den anderen beiden States eig. nicht
    - Bei einem States.Flipper kann man ja eig. jederzeit den Kugel-Abschuss-Mechnismus auslösen und die Hebel (links/rechts) zum Spielen der Kugel betätigen. Aber es passiert halt nichts, wenn man nicht im Playing ist. Weiß nicht, ob sich das auch für das State-Interface dann eignet?
 */

public interface State {
    void playButtonPressed();
    void insertCoin();

}
