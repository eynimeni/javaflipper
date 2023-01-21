package AbstractFactory;

public class WelcomeMessage implements DisplayText {

    @Override
    public void createText() {

        //https://www.google.com/search?client=safari&rls=en&q=java+print+ascii+art&ie=UTF-8&oe=UTF-8#fpstate=ive&vld=cid:b945bf44,vid:EDDJZ4dWM5c

        //Textstyle: ANSI Regular
        String text = """
                    ██     ██ ███████ ██       ██████  ██████  ███    ███ ███████     ████████  ██████       ██████  ██    ██ ██████ \s
                    ██     ██ ██      ██      ██      ██    ██ ████  ████ ██             ██    ██    ██     ██    ██ ██    ██ ██   ██\s
                    ██  █  ██ █████   ██      ██      ██    ██ ██ ████ ██ █████          ██    ██    ██     ██    ██ ██    ██ ██████ \s
                    ██ ███ ██ ██      ██      ██      ██    ██ ██  ██  ██ ██             ██    ██    ██     ██    ██ ██    ██ ██   ██\s
                     ███ ███  ███████ ███████  ██████  ██████  ██      ██ ███████        ██     ██████       ██████   ██████  ██   ██\s
                                                                                                                                     \s
                                                                                                                                     \s
                    ███████ ████████  █████  ████████ ███████     ███████ ██      ██ ██████  ██████  ███████ ██████                  \s
                    ██         ██    ██   ██    ██    ██          ██      ██      ██ ██   ██ ██   ██ ██      ██   ██                 \s
                    ███████    ██    ███████    ██    █████       █████   ██      ██ ██████  ██████  █████   ██████                  \s
                         ██    ██    ██   ██    ██    ██          ██      ██      ██ ██      ██      ██      ██   ██                 \s
                    ███████    ██    ██   ██    ██    ███████     ██      ███████ ██ ██      ██      ███████ ██   ██                 \s
                                                                                                                                     \s
                                                                                                                                     \s
                """;

        System.out.println("\n" + text); //"Welcome to our States Flipper";

    }

}
