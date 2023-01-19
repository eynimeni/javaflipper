package FlipperElements;

public interface FlipperElement {

    String getId();

    void setElementStatus(Boolean elementStatus);

    Boolean getElementStatus();

    void elementGotHit();

    void luckyStrike(FlipperElementsComposition composition);
    void badAssStrike(FlipperElementsComposition composition);
    void strikeExtreme(FlipperElementsComposition composition);

}
