package Mediator;

import FlipperElements.FlipperElement;
import FlipperElements.FlipperElementWithScore;

import java.util.List;

public interface Mediator {

    public void directBall(FlipperElement flipperElement);

    void setElements(List<FlipperElement> flipperElements);
}
