package Visitor;

import FlipperElements.*;

public class ScoreVisitor implements Visitor{

    @Override
    public int visitBumper(Bumper bumper) {
        return calculateScore(bumper);
    }

    @Override
    public int visitKickersHoles(KickersHoles kickersHoles) {
        return calculateScore(kickersHoles);
    }

    @Override
    public int visitRamp(Ramp ramp) {
        return calculateScore(ramp);
    }

    @Override
    public int visitTarget(Target target) {
        return calculateScore(target);
    }

    @Override
    public int visitFlipperElementsComposition(FlipperElementsComposition flipperElementsComposition) {
        return calculateScore((FlipperElementWithScore) flipperElementsComposition); //@ToDo: Type-Cast aufheben, wenn FlipperElementsCompoisition auch FlipperElementWithScoreInterface implementiert. Sonst auch Anpassung notwendig!
    }

    private int calculateScore(FlipperElementWithScore flipperElement){

        int score = flipperElement.getElementScore();
        int hitCount = flipperElement.getElementHitCount();

        return score*hitCount;

    }

}
