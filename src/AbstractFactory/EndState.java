package AbstractFactory;

public class EndState implements DisplayText{

    @Override
    public void createText() {
        //Textstyle = Doom

        String text = """
                ____     _____          _   _____ _        _           ____
                \\ \\ \\   |  ___|        | | /  ___| |      | |         / / /
                 \\ \\ \\  | |__ _ __   __| | \\ `--.| |_ __ _| |_ ___   / / /\s
                  > > > |  __| '_ \\ / _` |  `--. \\ __/ _` | __/ _ \\ < < < \s
                 / / /  | |__| | | | (_| | /\\__/ / || (_| | ||  __/  \\ \\ \\\s
                /_/_/   \\____/_| |_|\\__,_| \\____/ \\__\\__,_|\\__\\___|   \\_\\_\\
                                                                          \s
                                                                          \s
                """;

        System.out.print(text);
    }
}
