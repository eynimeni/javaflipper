package Visitor;

import FlipperElements.*;

public class ScoreVisitor implements Visitor{

    @Override
    public int visitBumper(Bumper bumper) {
        int bumperScore = calculateScore(bumper);

        if (bumper.getSpecialBonusPoints()) {
            int bumperSpecialScore = bumperScore * 5 + 200;
            System.out.println("And here comes your Bumper Special Score: "+ bumperSpecialScore+ " additional Points!");
            bumperScore += bumperSpecialScore;
            bumper.setSpecialBonusPoints(false);
        }

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
        int targetScore = calculateScore(target);

        if(target.getAllTargetsTouched() > 0) {
            int targetSpecialBonus = targetScore * target.getAllTargetsTouched() * 20;
            System.out.println("Great, you touched all targets! You are receiving "+ targetSpecialBonus + " additional Points!");
            targetScore += targetSpecialBonus;
            target.setAllTargetsTouched(0);
        }

        resetHitCount(target);
        return targetScore;
    }

    @Override
    public int visitFlipperElementsComposition(FlipperElementsComposition flipperElementsComposition) {
        flipperElementsComposition.resetHitCount();

        return flipperElementsComposition.getElementScore();
    }

    private int calculateScore(FlipperElementWithScore flipperElement){

        int score = flipperElement.getElementScore();
        int hitCount = flipperElement.getElementHitCount();

        return score*hitCount;
    }
    private void resetHitCount(FlipperElementWithScore flipperElementWithScore) {
        flipperElementWithScore.resetElementHitCount();
    }

}
