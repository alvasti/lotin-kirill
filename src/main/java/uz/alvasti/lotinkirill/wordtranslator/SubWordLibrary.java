package uz.alvasti.lotinkirill.wordtranslator;

public class SubWordLibrary implements Translate{

    @Override
    public String translateToLatin(String word) {


        for (String[] strings : subWordsCyrillicInitial) {
            String cyrillic = strings[0];
            String latin = strings[1];
            word = word.replaceAll(cyrillic, latin);
        }
        return word;
    }

    @Override
    public String translateToCyrillic(String word) {
        for (String[] strings : subWordsLatinInitial) {
            String latin = strings[0];
            String cyrillic = strings[1];
            word = word.replaceAll(latin, cyrillic);
        }
        return word;
    }

    private final String[][] subWordsLatinInitial = {
            {"o'jaz", "ўъжаз"},
            {"o‘jiza", "ўъжиза"},
            {"o‘tabar", "ўътабар"},
            {"o‘tadil", "ўътадил"},
            {"aye", "ае"},
            {"Iye", "Ие"},
            {"iye", "ие"},
            {"eye", "ее"},
            {"yoye", "ёе"},
            {"oye", "ое"},
            {"uye", "уе"},
            {"o‘ye", "ўе"},
            {"yuye", "юе"},
            {"yaye", "яе"},
            {"AYE", "АЕ"},
            {"IYE", "ИЕ"},
            {"Aye", "Ае"},
            {"OYE", "ОЕ"},
            {"UYE", "УЕ"},
            {"O‘YE", "ЎЕ"},
            {"YUYE", "ЮЕ"},
            {"YAYE", "ЯЕ"},
            {"bs", "бц"},
            {"vs", "вц"},
            {"gs", "гц"},
            {"ds", "дц"},
            {"js", "жц"},
            {"zs", "зц"},
            {"ys", "йц"},
            {"ks", "кц"},
            {"ls", "лц"},
            {"ms", "мц"},
            {"ns", "нц"},
            {"ps", "пц"},
            {"rs", "рц"},
            {"Ss", "Сц"},
            {"ss", "сц"},
            {"ts", "тц"},
            {"fs", "фц"},
            {"xs", "хц"},
            {"tss", "цц"},
            {"chs", "чц"},
            {"shs", "шц"},
            {"s", "ьц"}
    };

    public final String[][] subWordsCyrillicInitial = {
            {"ўъжаз", "o'jaz"},
            {"ўъжиза", "o‘jiza"},
            {"ўътабар", "o‘tabar"},
            {"ўътадил", "o‘tadil"},
            {"ае", "aye"},
            {"Ие", "Iye"},
            {"ие", "iye"},
            {"ее", "eye"},
            {"ёе", "yoye"},
            {"ое", "oye"},
            {"уе", "uye"},
            {"ўе", "o‘ye"},
            {"юе", "yuye"},
            {"яе", "yaye"},
            {"АЕ", "AYE"},
            {"ИЕ", "IYE"},
            {"Ае", "Aye"},
            {"ОЕ", "OYE"},
            {"УЕ", "UYE"},
            {"ЎЕ", "O‘YE"},
            {"ЮЕ", "YUYE"},
            {"ЯЕ", "YAYE"},
            {"бц", "bs"},
            {"вц", "vs"},
            {"гц", "gs"},
            {"дц", "ds"},
            {"жц", "js"},
            {"зц", "zs"},
            {"йц", "ys"},
            {"кц", "ks"},
            {"лц", "ls"},
            {"мц", "ms"},
            {"нц", "ns"},
            {"пц", "ps"},
            {"рц", "rs"},
            {"Сц", "Ss"},
            {"сц", "ss"},
            {"тц", "ts"},
            {"фц", "fs"},
            {"хц", "xs"},
            {"цц", "tss"},
            {"чц", "chs"},
            {"шц", "shs"},
            {"ьц", "s"}
    };


//    "ц"  ts
//{" е", " ye"},
    //"ъ" "’" "ъ"
    //"ь" ""
    //q,g', x, h, o', yo, yu, ya, Ь,
}
