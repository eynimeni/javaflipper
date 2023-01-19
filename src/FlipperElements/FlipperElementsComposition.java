package FlipperElements;

import Mediator.Mediator;
import Visitor.Visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlipperElementsComposition implements FlipperElement, FlipperElementWithScore{
    private final String id;
    private Boolean elementStatus = true;
    private final List<FlipperElement> flipperElementsList = new ArrayList<>();
    private final Mediator mediator;
    private Integer hitCount = 0;

    private Integer score = 0;

    public FlipperElementsComposition(String id, Mediator mediator){

        this.id = id;
        this.mediator = mediator;
    }

    public String getId() {
        return id;
    }

    public void resetHitCount() {
        this.hitCount = 0;
    }

    @Override
    public void setElementStatus(Boolean elementStatus) {
        this.elementStatus = elementStatus;
    }

    @Override
    public Boolean getElementStatus() {
        return this.elementStatus;
    }

    @Override
    public void elementGotHit() {
        this.hitCount +=1;

        System.out.println("You hit the Composition!");
        executeStrike();

        this.mediator.directBall(this);
    }



    private void executeStrike() {

        switch (this.hitCount) {
            case 1 -> {
                System.out.println("Lucky Strike!");
                for (FlipperElement element : this.flipperElementsList
                ) {
                    element.luckyStrike(this);
                    System.out.println("Lucky Strike hit " + element.getId());
                }
                System.out.println("+ " + getElementScore() + (" Points!!"));
            }
            case 2 -> {
                System.out.println("Bad Ass Strike");
                for (int i = 0; i < 4; i++) {
                    FlipperElement element = this.flipperElementsList.get(new Random().nextInt(this.flipperElementsList.size()));
                    element.badAssStrike(this);
                    System.out.println("Bad Ass Strike hit " + element.getId());
                }
                System.out.println("+ " + getElementScore() + (" Points!!"));
            }
            default -> {
                System.out.println("Strike Extreme!");
                for (FlipperElement element : this.flipperElementsList
                ) {
                    element.strikeExtreme(this);
                    System.out.println("Strike Extreme hit " + element.getId());
                }
                System.out.println("+ " + getElementScore() + (" Points!!"));
            }
        }
    }

    @Override
    public void luckyStrike(FlipperElementsComposition composition) {
    }

    @Override
    public void badAssStrike(FlipperElementsComposition composition) {
    }

    @Override
    public void strikeExtreme(FlipperElementsComposition composition) {

    }

    //FlipperElement zu kombiniertem FlipperElement hinzufügen
    public void add(FlipperElement flipperElement){
        this.flipperElementsList.add(flipperElement);
    }

    public List<FlipperElement> getFlipperElementsList(){
        return this.flipperElementsList;
    }

    @Override
    public void setElementScoreValue(Integer elementScoreValue) {
        this.score = elementScoreValue;
    }

    @Override
    public int getElementScore() {
        return this.score;
    }

    @Override
    public void resetElementScoreValue() {
        this.score = 0;
    }

    @Override
    public void setElementHitCount(Integer elementHitCount) {
        this.hitCount = 0;
    }

    @Override
    public int getElementHitCount() {
        return this.hitCount;
    }

    @Override
    public void resetElementHitCount() {
        this.hitCount = 0;

    }
    @Override
    public int acceptVisitor(Visitor visitor) {
       return visitor.visitFlipperElementsComposition(this);
    }

    public void increaseScore(Integer additionalScore) {
        this.score += additionalScore;
    }


}
