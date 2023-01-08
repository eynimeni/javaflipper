import java.util.Objects;
import java.util.Scanner;

public class Playing implements State{
    private Context context;
    private Integer ballCount = 1;
    public Playing(Context context) {
        this.context = context;
        System.out.println("Playing!");

        shootBall();

        //changeState() greift noch nicht richtig.
        //change state kann nicht im constructor kommen, sonst funktioniert es nicht (warum??)
        // nur wenn es von context aufgerufen wird greift es, also in playButtonPressed oder CoinInsert
        //oder vom ready state als ablauf nach dem playing (ist aber auch keine gute lösung)
        //deswegen behelfsmäßig mal bei den button-press-funktionen


        // aus der angabe: zu jeden zeitpunkt möglich, knopf zu drücken... ??? interrupt??

    }

    public void shootBall() {

        if (this.ballCount < 4) {
            System.out.println("Do you want to shoot the ball? Y/N");
            Scanner scanner = new Scanner(System.in);
            String shooting = scanner.next();

            if (Objects.equals(shooting, "Y")) {
                System.out.println("Ball Number: " + this.ballCount + "/3");
                this.ballCount ++;
                this.shootBall();
            }
        } else {
            System.out.println("Those were all your balls");
            System.out.println("What is your next choice?");
        }

    }



    public void changeState() {
            context.setState(new EndState(context));
    }

    @Override
    public void playButtonPressed() {
        System.out.println("Playing State - Authors of the Software are Tom and Magdalena");
        changeState();
    }
    @Override
    public void insertCoin() {
        context.setState(new Ready(context));
        changeState();
    }
}
