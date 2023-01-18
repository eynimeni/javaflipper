package Visitor;

import FlipperElements.*;

public interface Visitor {

    int visitBumper(Bumper bumper);
    int visitKickersHoles(KickersHoles kickersHoles);
    int visitRamp(Ramp ramp);
    int visitTarget(Target target);
    int visitFlipperElementsComposition(FlipperElementsComposition flipperElementsComposition);

}
