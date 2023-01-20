package AbstractFactory;

public class ChooseOption implements DisplayText {

    @Override
    public void createText() {
        //Bewusst so gelassen!
        String text = "\n 1: Play \n 2: Add Credit \n 3: Display Credit \n 4: End Game \n\n (enter here): ";
        System.out.print(text);
    }

}
