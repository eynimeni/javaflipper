package Mediator;

import FlipperElements.FlipperElement;

import java.util.List;

public interface Mediator {

    //@ToDo: fix or delete ... MediatorImpl getSingleMediatorInstance();

    void directBall(FlipperElement flipperElement);

    void setElements(List<FlipperElement> flipperElements);

    void printFallingDownMessage();

    void redirectBall(int probabilityOfSuccessInPercent);
}
