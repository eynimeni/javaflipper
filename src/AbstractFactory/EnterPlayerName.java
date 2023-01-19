package AbstractFactory;

public class EnterPlayerName implements DisplayText {

    @Override
    public void createText() {
        String textVar1 = """
                  ____  _                            _                                                     ____  _                                                 \s
                 |  _ \\| | ___  __ _ ___  ___    ___| |__   ___   ___  ___  ___   _   _  ___  _   _ _ __  |  _ \\| | __ _ _   _  ___ _ __ _ __   __ _ _ __ ___   ___\s
                 | |_) | |/ _ \\/ _` / __|/ _ \\  / __| '_ \\ / _ \\ / _ \\/ __|/ _ \\ | | | |/ _ \\| | | | '__| | |_) | |/ _` | | | |/ _ \\ '__| '_ \\ / _` | '_ ` _ \\ / _ \\
                 |  __/| |  __/ (_| \\__ \\  __/ | (__| | | | (_) | (_) \\__ \\  __/ | |_| | (_) | |_| | |    |  __/| | (_| | |_| |  __/ |  | | | | (_| | | | | | |  __/
                 |_|   |_|\\___|\\__,_|___/\\___|  \\___|_| |_|\\___/ \\___/|___/\\___|  \\__, |\\___/ \\__,_|_|    |_|   |_|\\__,_|\\__, |\\___|_|  |_| |_|\\__,_|_| |_| |_|\\___|
                                                                                  |___/                                  |___/                                     \s               
                """;

        //Textstyle: Slant
        String textVar2 = """
                       ____  __                             __                                                       ____  __                                              \s
                      / __ \\/ /__  ____ _________     _____/ /_  ____  ____  ________     __  ______  __  _______   / __ \\/ /___ ___  _____  _________  ____ _____ ___  ___\s
                     / /_/ / / _ \\/ __ `/ ___/ _ \\   / ___/ __ \\/ __ \\/ __ \\/ ___/ _ \\   / / / / __ \\/ / / / ___/  / /_/ / / __ `/ / / / _ \\/ ___/ __ \\/ __ `/ __ `__ \\/ _ \\
                    / ____/ /  __/ /_/ (__  )  __/  / /__/ / / / /_/ / /_/ (__  )  __/  / /_/ / /_/ / /_/ / /     / ____/ / /_/ / /_/ /  __/ /  / / / / /_/ / / / / / /  __/
                   /_/   /_/\\___/\\__,_/____/\\___/   \\___/_/ /_/\\____/\\____/____/\\___/   \\__, /\\____/\\__,_/_/     /_/   /_/\\__,_/\\__, /\\___/_/  /_/ /_/\\__,_/_/ /_/ /_/\\___/\s
                                                                                       /____/                                  /____/                                      \s
                """;

        System.out.print(textVar2+"\n(enter here): ");

    }

}