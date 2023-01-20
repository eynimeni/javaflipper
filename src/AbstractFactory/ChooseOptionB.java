package AbstractFactory;

public class ChooseOptionB implements DisplayText {

    @Override
    public void createText() {

        //Textstyle: Crawford2
        String text = """
                  ____  _        ___   ____  _____   ___         __  __ __   ___    ___   _____   ___\s
                 |    \\| |      /  _] /    |/ ___/  /  _]       /  ]|  |  | /   \\  /   \\ / ___/  /  _]
                 |  o  ) |     /  [_ |  o  (   \\_  /  [_       /  / |  |  ||     ||     (   \\_  /  [_\s
                 |   _/| |___ |    _]|     |\\__  ||    _]     /  /  |  _  ||  O  ||  O  |\\__  ||    _]
                 |  |  |     ||   [_ |  _  |/  \\ ||   [_     /   \\_ |  |  ||     ||     |/  \\ ||   [_\s
                 |  |  |     ||     ||  |  |\\    ||     |    \\     ||  |  ||     ||     |\\    ||     |
                 |__|  |_____||_____||__|__| \\___||_____|     \\____||__|__| \\___/  \\___/  \\___||_____|
                                                                                                     \s
                  __ __   ___   __ __  ____        ___   ____  ______  ____  ___   ____   __         \s
                 |  |  | /   \\ |  |  ||    \\      /   \\ |    \\|      ||    |/   \\ |    \\ |  |        \s
                 |  |  ||     ||  |  ||  D  )    |     ||  o  )      | |  ||     ||  _  ||  |        \s
                 |  ~  ||  O  ||  |  ||    /     |  O  ||   _/|_|  |_| |  ||  O  ||  |  ||__|        \s
                 |___, ||     ||  :  ||    \\     |     ||  |    |  |   |  ||     ||  |  | __         \s
                 |     ||     ||     ||  .  \\    |     ||  |    |  |   |  ||     ||  |  ||  |        \s
                 |____/  \\___/  \\__,_||__|\\_|     \\___/ |__|    |__|  |____|\\___/ |__|__||__|        \s
                                                                                                     \s
                """;

        //System.out.println(textVar3 + "\n " + play + "\n " + addCredit + "\n " + displayCredit + "\n " + endGame);
        System.out.print(text+ " 1: Play \n 2: Add Credit \n 3: Display Credit \n 4: End Game \n\n (enter here): ");
    }

}
