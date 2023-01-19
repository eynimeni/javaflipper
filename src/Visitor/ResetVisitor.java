package Visitor;

import FlipperElements.*;

public class ResetVisitor implements Visitor{

    @Override
    public int visitBumper(Bumper bumper) {

        resetElementScoreAndHitCount(bumper);
        bumper.setElementStatus(true);
        bumper.setSpecialBonusPoints(false);

        //2x Bumper = 2
        return 1;
    }

    @Override
    public int visitKickersHoles(KickersHoles kickersHoles) {

        resetElementScoreAndHitCount(kickersHoles);
        //2x Kickers = 4
        return 2;
    }

    @Override
    public int visitRamp(Ramp ramp) {
        resetElementScoreAndHitCount(ramp);
        // 1x ramp
        return 3;
    }
    @Override
    public int visitTarget(Target target) {
        resetElementScoreAndHitCount(target);
        //3x target = 12
        return 4;
    }

    @Override
    public int visitFlipperElementsComposition(FlipperElementsComposition flipperElementsComposition) {
        resetElementScoreAndHitCount(flipperElementsComposition);
        return 5;
    }

    private void resetElementScoreAndHitCount(FlipperElementWithScore flipperElement){
        flipperElement.resetElementScoreValue();
        flipperElement.resetElementHitCount();
    }

}
