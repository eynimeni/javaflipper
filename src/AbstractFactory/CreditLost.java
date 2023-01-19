package AbstractFactory;

public class CreditLost implements DisplayText {

    @Override
    public void createText() {

        //Textstyle: Bolger
        String text = """
                 Y88b    /                                 e88~-_                         888 ,e,   d8                        ,e, 888 888       888                       888                   d8    d8b \s
                  Y88b  /   e88~-_  888  888 888-~\\       d888   \\ 888-~\\  e88~~8e   e88~\\888  "  _d88__       Y88b    e    /  "  888 888       888-~88e   e88~~8e        888  e88~-_   d88~\\ _d88__ !Y88!\s
                   Y88b/   d888   i 888  888 888          8888     888    d888  88b d888  888 888  888          Y88b  d8b  /  888 888 888       888  888b d888  88b       888 d888   i C888    888    Y8Y \s
                    Y8Y    8888   | 888  888 888          8888     888    8888__888 8888  888 888  888           Y888/Y88b/   888 888 888       888  8888 8888__888       888 8888   |  Y88b   888     8  \s
                     Y     Y888   ' 888  888 888          Y888   / 888    Y888    , Y888  888 888  888            Y8/  Y8/    888 888 888       888  888P Y888    ,       888 Y888   '   888D  888     e  \s
                    /       "88_-~  "88_-888 888           "88_-~  888     "88___/   "88_/888 888  "88_/           Y    Y     888 888 888       888-_88"   "88___/        888  "88_-~  \\_88P   "88_/  "8" \s
                                                                                                                                                                                                          \s
                """;

        System.out.print(text + "\n(enter Y/N here): ");

    }

}
