package AbstractFactory;

public class CoinDropB implements DisplayText{

    @Override
    public void createText() {

        //Textstyle: ANSI Regular
        String text = """
                 ██████ ██      ██ ███    ██ ██   ██       ██████  ██      ██ ███    ██ ██   ██        ██████ ██      ██ ███    ██ ██   ██ ██                                                                           \s
                ██      ██      ██ ████   ██ ██  ██        ██   ██ ██      ██ ████   ██ ██  ██        ██      ██      ██ ████   ██ ██  ██  ██                                                                           \s
                ██      ██      ██ ██ ██  ██ █████   █████ ██████  ██      ██ ██ ██  ██ █████   █████ ██      ██      ██ ██ ██  ██ █████   ██                                                                           \s
                ██      ██      ██ ██  ██ ██ ██  ██        ██      ██      ██ ██  ██ ██ ██  ██        ██      ██      ██ ██  ██ ██ ██  ██                                                                               \s
                 ██████ ███████ ██ ██   ████ ██   ██       ██      ███████ ██ ██   ████ ██   ██        ██████ ███████ ██ ██   ████ ██   ██ ██                                                                           \s
                                                                                                                                                                                                                        \s
              """;

        System.out.print(text + "\nThis coin dropped smootly!\n");
    }
}
