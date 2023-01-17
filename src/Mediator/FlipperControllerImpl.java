package Mediator;

import FlipperElements.FlipperElementWithScore;

public class FlipperControllerImpl implements FlipperController {
    @Override
    public void elementGotHit(String message, FlipperElementWithScore flipperElementWithScore) {
        System.out.println(flipperElementWithScore.getId() + " caused " + message);
    }
}
