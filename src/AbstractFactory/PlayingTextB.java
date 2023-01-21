package AbstractFactory;

public class PlayingTextB implements DisplayText{

    @Override
    public void createText() {

        //Textstlye = Dancing Font
        String text = """
                  ____      _         _      __   __             _   _     ____  \s
                U|  _"\\ u  |"|    U  /"\\  u  \\ \\ / /    ___     | \\ |"| U /"___|u\s
                \\| |_) |/U | | u   \\/ _ \\/    \\ V /    |_"_|   <|  \\| |>\\| |  _ /\s
                 |  __/   \\| |/__  / ___ \\   U_|"|_u    | |    U| |\\  |u | |_| | \s
                 |_|       |_____|/_/   \\_\\    |_|    U/| |\\u   |_| \\_|   \\____| \s
                 ||>>_     //  \\\\  \\\\    >>.-,//|(_.-,_|___|_,-.||   \\\\,-._)(|_  \s
                (__)__)   (_")("_)(__)  (__)\\_) (__)\\_)-' '-(_/ (_")  (_/(__)__) \s
                """;

        System.out.print(text);
    }
}
