package AbstractFactory;

public class EnterPlayerNameB implements DisplayText {

    @Override
    public void createText() {
        //Textstyle: Crawford2
        String text = """
                 ____  _        ___   ____  _____   ___         __  __ __   ___    ___   _____   ___      __ __   ___   __ __  ____ \s
                |    \\| |      /  _] /    |/ ___/  /  _]       /  ]|  |  | /   \\  /   \\ / ___/  /  _]    |  |  | /   \\ |  |  ||    \\\s
                |  o  ) |     /  [_ |  o  (   \\_  /  [_       /  / |  |  ||     ||     (   \\_  /  [_     |  |  ||     ||  |  ||  D  )
                |   _/| |___ |    _]|     |\\__  ||    _]     /  /  |  _  ||  O  ||  O  |\\__  ||    _]    |  ~  ||  O  ||  |  ||    /\s
                |  |  |     ||   [_ |  _  |/  \\ ||   [_     /   \\_ |  |  ||     ||     |/  \\ ||   [_     |___, ||     ||  :  ||    \\\s
                |  |  |     ||     ||  |  |\\    ||     |    \\     ||  |  ||     ||     |\\    ||     |    |     ||     ||     ||  .  \\
                |__|  |_____||_____||__|__| \\___||_____|     \\____||__|__| \\___/  \\___/  \\___||_____|    |____/  \\___/  \\__,_||__|\\_|
                                                                                                                                    \s
                 ____  _       ____  __ __    ___  ____   ____    ____  ___ ___    ___  __                                          \s
                |    \\| |     /    ||  |  |  /  _]|    \\ |    \\  /    ||   |   |  /  _]|  |                                         \s
                |  o  ) |    |  o  ||  |  | /  [_ |  D  )|  _  ||  o  || _   _ | /  [_ |  |                                         \s
                |   _/| |___ |     ||  ~  ||    _]|    / |  |  ||     ||  \\_/  ||    _]|__|                                         \s
                |  |  |     ||  _  ||___, ||   [_ |    \\ |  |  ||  _  ||   |   ||   [_  __                                          \s
                |  |  |     ||  |  ||     ||     ||  .  \\|  |  ||  |  ||   |   ||     ||  |                                         \s
                |__|  |_____||__|__||____/ |_____||__|\\_||__|__||__|__||___|___||_____||__|                                         \s
                                                                                                                                    \s
                """;
                //"Please choose your Playername!";
        System.out.print(text + "\n(enter here): ");

    }

}
