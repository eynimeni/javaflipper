package Visitor;

import FlipperElements.*;

public class ScoreVisitor implements Visitor{

    @Override
    public int visitBumper(Bumper bumper) {
        int bumperScore = calculateScore(bumper);
        resetHitCount(bumper);
        return bumperScore;
    }

    @Override
    public int visitKickersHoles(KickersHoles kickersHoles) {
        int kickersHolesScore = calculateScore(kickersHoles);
        resetHitCount(kickersHoles);
        return kickersHolesScore;
    }

    @Override
    public int visitRamp(Ramp ramp) {
        int rampScore = calculateScore(ramp);
        resetHitCount(ramp);
        return rampScore;
    }

    @Override
    public int visitTarget(Target target) {
        int visitTarget = calculateScore(target);
        resetHitCount(target);
        return visitTarget;
    }

    @Override
    public int visitFlipperElementsComposition(FlipperElementsComposition flipperElementsComposition) {
        return calculateScore((FlipperElementWithScore) flipperElementsComposition); //@ToDo: Type-Cast aufheben, wenn FlipperElementsCompoisition auch FlipperElementWithScoreInterface implementiert. Sonst auch Anpassung notwendig!
    }

    //todo komplexere logik für punkteberechnung, zb Bonuspunkte bei targets, bumper

    private int calculateScore(FlipperElementWithScore flipperElement){

        int score = flipperElement.getElementScore();
        int hitCount = flipperElement.getElementHitCount();

        return score*hitCount;
    }
    private void resetHitCount(FlipperElementWithScore flipperElementWithScore) {
        flipperElementWithScore.resetElementHitCount();
    }

}
