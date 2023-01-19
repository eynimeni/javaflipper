package AbstractFactory;

public class GoodBye implements DisplayText {

    @Override
    public void createText() {

        //Textstyle: JS Stick Letters
        String text = """
                        ___          __   __   ___         __      \s
                  |  | |__     |__| /  \\ |__) |__     \\ / /  \\ |  |\s
                  |/\\| |___    |  | \\__/ |    |___     |  \\__/ \\__/\s
                                                                   \s
                      ___            __       ___  __              \s
                     |__  |\\ |    | /  \\ \\ / |__  |  \\             \s
                     |___ | \\| \\__/ \\__/  |  |___ |__/             \s
                                                                   \s
                       __        __      __              ___   /   \s
                  \\ / /  \\ |  | |__)    / _`  /\\   |\\/| |__   /    \s
                   |  \\__/ \\__/ |  \\    \\__> /~~\\  |  | |___ .     \s
                                                                   \s
                """;

        System.out.print(text);
    }

}
