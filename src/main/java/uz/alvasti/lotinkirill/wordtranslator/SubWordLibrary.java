package uz.alvasti.lotinkirill.wordtranslator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class SubWordLibrary implements Translate {

    public SubWordLibrary() {
    }

    @Override
    public String translateToLatin(String word) {


        for (var strings : subWordsCyrillicInitialPattern) {
            var cyrillic = strings.getPattern();
            String latin = strings.getWord();
            word = word.replaceAll(cyrillic.pattern(), latin);
        }
        return word;
    }

    @Override
    public String translateToCyrillic(String word) {
        for (var strings : subWordsLatinInitialPattern) {
            var latin = strings.getPattern();
            String cyrillic = strings.getWord();
            word = word.replaceAll(latin.pattern(), cyrillic);
        }
        return word;
    }

    private static final String[][] subWordsLatinInitial = {
            {"oʻjaz", "ўъжаз"},
            {"OʻJAZ", "ЎЪЖАЗ"},
            {"oʻjiza", "ўъжиза"},
            {"OʻJIZA", "ЎЪЖИЗА"},
            {"oʻtabar", "ўътабар"},
            {"OʻTABAR", "ЎЪТАБАР"},
            {"oʻtadil", "ўътадил"},
            {"OʻTADIL", "ЎЪТАДИЛ"},
            {"aye", "ае"},
            {"aYe", "аЕ"},
            {"aYE", "аЕ"},
            {"Aye", "Ае"},
            {"AYe", "АЕ"},
            {"AYE", "АЕ"},
            {"iye", "ие"},
            {"iYe", "иЕ"},
            {"iyE", "иЕ"},
            {"iYE", "иЕ"},
            {"Iye", "Ие"},
            {"IYE", "ИЕ"},
            {"eye", "ее"},
            {"eYe", "еЕ"},
            {"eYE", "еЕ"},
            {"EYE", "ЕЕ"},
            {"ye", "е"},
            {"Ye", "Е"},
            {"YE", "Е"},
            {"sh", "ш"},
            {"SH", "Ш"},
            {"Sh", "Ш"},
            {"yu", "ю"},
            {"Yu", "Ю"},
            {"YU", "Ю"},
            {"ya", "я"},
            {"Ya", "Я"},
            {"YA", "Я"},
            {"yo", "ё"},
            {"Yo", "Ё"},
            {"YO", "Ё"},
            {"yoʻ", "йў"},
            {"Yoʻ", "Йў"},
            {"yOʻ", "йЎ"},
            {"YOʻ", "ЙЎ"},
            {"yoye", "ёе"},
            {"YOYE", "ЁЕ"},
            {"oye", "ое"},
            {"OYE", "ОЕ"},
            {"uye", "уе"},
            {"UYE", "УЕ"},
            {"oʻye", "ўе"},
            {"OʻYE", "ЎЕ"},
            {"yuye", "юе"},
            {"YUYE", "ЮЕ"},
            {"yaye", "яе"},
            {"YAYE", "ЯЕ"},
            {"tss", "цц"},
            {"TSS", "ЦЦ"},
            {"Tss", "Цц"},
            {"bsiya", "бция"},
            {"BSIYA", "БЦИЯ"},
            {"Bsion", "Бцион"},
            {"bsion", "бцион"},
            {"BSION", "БЦИОН"},
            {"ksiya", "кция"},
            {"Ksiya", "Кция"},
            {"KSIYA", "КЦИЯ"},
            {"ksion", "кцион"},
            {"KSION", "КЦИОН"},
            {"nsiya", "нция"},
            {"Nsiya", "Нция"},
            {"NSIYA", "НЦИЯ"},
            {"nsion", "нцион"},
            {"NSION", "НЦИОН"},
            {"rsiya", "рция"},
            {"Rsiya", "Рция"},
            {"RSIYA", "РЦИЯ"},
            {"rsion", "рцион"},
            {"Rsion", "Рцион"},
            {"RSION", "РЦИОН"},
            {"psiya", "пция"},
            {"Psiya", "Пция"},
            {"PSIYA", "ПЦИЯ"},
            {"psion", "пцион"},
            {"Psion", "Пцион"},
            {"PSION", "ПЦИОН"},
            {"tsiya", "ция"},
            {"Tsiya", "Ция"},
            {"TSIYA", "ЦИЯ"},
            {"tsist", "цист"},
            {"Tsist", "Цист"},
            {"TSIST", "ЦИСТ"},
            {"tsizm", "цизм"},
            {"Tsizm", "Цизм"},
            {"TSIZM", "ЦИЗМ"},
            {"tsit", "цит"},
            {"Tsit", "Цит"},
            {"TSIT", "ЦИТ"},
            {"tsevt", "цевт"},
            {"Tsevt", "Цевт"},
            {"TSEVT", "ЦЕВТ"},
            {"tsept", "цепт"},
            {"Tsept", "Цепт"},
            {"TSEPT", "ЦЕПТ"},
            {"tser", "цер"},
            {"Tser", "Цер"},
            {"TSER", "ЦЕР"},
            {"tsia", "циа"},
            {"Tsia", "Циа"},
            {"TSIA", "ЦИА"},
            {"sia", "циа"},
            {"Sia", "Циа"},
            {"SIA", "ЦИА"},
            {"tsikl", "цикл"},
            {"Tsikl", "Цикл"},
            {"TSIKL", "ЦИКЛ"},
            {"Tsio", "Цио"},
            {"tsio", "цио"},
            {"TSIO", "ЦИО"},
            {"tsiu", "циу"},
            {"Tsiu", "Циу"},
            {"TSIU", "ЦИУ"},
            {"siu", "циу"},
            {"Siu", "Циу"},
            {"SIU", "ЦИУ"},
            {"SʼH", "СҲ"},
            {"Sʼh", "Сҳ"},
            {"sʼh", "сҳ"},
            {"syom", "съём"},
            {"Syom", "Съём"},
            {"SYOM", "СЪЁМ"}
    };

    public static final String[][] subWordsCyrillicInitial = {
            {"ўъжаз", "oʻjaz"},
            {"ЎЪЖАЗ", "OʻJAZ"},
            {"ўъжиза", "oʻjiza"},
            {"ЎЪЖИЗА", "OʻJIZA"},
            {"ўътабар", "oʻtabar"},
            {"ЎЪТАБАР", "OʻTABAR"},
            {"ўътадил", "oʻtadil"},
            {"ЎЪТАДИЛ", "OʻTADIL"},
            {"ае", "aye"},
            {"аЕ", "aYe"},
            {"Ае", "Aye"},
            {"АЕ", "AYE"},
            {"ие", "iye"},
            {"иЕ", "iYE"},
            {"Ие", "Iye"},
            {"ИЕ", "IYE"},
            {"ее", "eye"},
            {"еЕ", "eYE"},
            {"Ее", "Yee"},
            {"ЕЕ", "EYE"},
//            {"е", "ye"},
//            {"Е", "Ye"},
            {"ш", "sh"},
//            {"Ш", "SH"},
            {"ю", "yu"},
            {"Ю", "Yu"},
            {"я", "ya"},
            {"Я", "Ya"},
            {"ё", "yo"},
            {"Ё", "Yo"},
            {"йў", "yoʻ"},
            {"йЎ", "yOʻ"},
            {"Йў", "Yoʻ"},
            {"ЙЎ", "YOʻ"},
            {"ёе", "yoye"},
            {"ЁЕ", "YOYE"},
            {"ое", "oye"},
            {"Ое", "Oye"},
            {"ОЕ", "OYE"},
            {"уе", "uye"},
            {"Yе", "Uye"},
            {"УЕ", "UYE"},
            {"ўе", "oʻye"},
            {"Ўе", "Oʻye"},
            {"ЎЕ", "OʻYE"},
            {"юе", "yuye"},
            {"ЮЕ", "YUYE"},
            {"яе", "yaye"},
            {"ЯЕ", "YAYE"},
            {"бц", "bs"},
            {"Бц", "Bs"},
            {"БЦ", "BS"},
            {"вц", "vs"},
            {"Вц", "Vs"},
            {"ВЦ", "VS"},
            {"гц", "gs"},
            {"Гц", "Gs"},
            {"ГЦ", "GS"},
            {"дц", "ds"},
            {"Дц", "Ds"},
            {"ДЦ", "DS"},
            {"жц", "js"},
            {"Жц", "Js"},
            {"ЖЦ", "JS"},
            {"зц", "zs"},
            {"Зц", "Zs"},
            {"ЗЦ", "ZS"},
            {"йц", "ys"},
            {"Йц", "Ys"},
            {"ЙЦ", "YS"},
            {"кц", "ks"},
            {"Кц", "Ks"},
            {"КЦ", "KS"},
            {"лц", "ls"},
            {"Лц", "Ls"},
            {"ЛЦ", "LS"},
            {"мц", "ms"},
            {"Мц", "Ms"},
            {"МЦ", "MS"},
            {"нц", "ns"},
            {"Нц", "Ns"},
            {"НЦ", "NS"},
            {"пц", "ps"},
            {"Пц", "Ps"},
            {"ПЦ", "PS"},
            {"рц", "rs"},
            {"Рц", "Rs"},
            {"РЦ", "RS"},
            {"Сц", "Ss"},
            {"сц", "ss"},
            {"сЦ", "sS"},
            {"СЦ", "SS"},
            {"тц", "ts"},
            {"Тц", "Ts"},
            {"ТЦ", "TS"},
            {"фц", "fs"},
            {"Фц", "Fs"},
            {"ФЦ", "FS"},
            {"хц", "xs"},
            {"Хц", "Xs"},
            {"ХЦ", "XS"},
            {"цц", "tss"},
            {"Цц", "Tss"},
            {"ЦЦ", "TSS"},
            {"чц", "chs"},
            {"Чц", "Chs"},
            {"ЧЦ", "CHS"},
            {"шц", "shs"},
            {"Шц", "Shs"},
            {"ШЦ", "SHS"},
            {"бция", "bsiya"},
            {"Бция", "Bsiya"},
            {"БЦИЯ", "BSIYA"},
            {"бцион", "bsion"},
            {"Бцион", "Bsion"},
            {"БЦИОН", "BSION"},
            {"Кция", "Ksiya"},
            {"КЦИЯ", "KSIYA"},
            {"кцион", "ksion"},
            {"Кцион", "Ksion"},
            {"КЦИОН", "KSION"},
            {"Нция", "Nsiya"},
            {"НЦИЯ", "NSIYA"},
            {"нцион", "nsion"},
            {"Нцион", "Nsion"},
            {"НЦИОН", "NSION"},
            {"рция", "rsiya"},
            {"Рция", "Rsiya"},
            {"РЦИЯ", "RSIYA"},
            {"рцион", "rsion"},
            {"Рцион", "Rsion"},
            {"РЦИОН", "RSION"},
            {"пция", "psiya"},
            {"Пция", "Psiya"},
            {"ПЦИЯ", "PSIYA"},
            {"пцион", "psion"},
            {"Пцион", "Psion"},
            {"ПЦИОН", "PSION"},
            {"ция", "tsiya"},
            {"Ция", "Tsiya"},
            {"ЦИЯ", "TSIYA"},
            {"цист", "tsist"},
            {"Цист", "Tsist"},
            {"ЦИСТ", "TSIST"},
            {"цизм", "tsizm"},
            {"Цизм", "Tsizm"},
            {"ЦИЗМ", "TSIZM"},
            {"цит", "tsit"},
            {"Цит", "Tsit"},
            {"ЦИТ", "TSIT"},
            {"цевт", "tsevt"},
            {"Цевт", "Tsevt"},
            {"ЦЕВТ", "TSEVT"},
            {"цепт", "tsept"},
            {"Цепт", "Tsept"},
            {"ЦЕПТ", "TSEPT"},
            {"цер", "tser"},
            {"Цер", "Tser"},
            {"ЦЕР", "TSER"},
            {"циа", "tsia"},
            {"Циа", "Tsia"},
            {"ЦИА", "TSIA"},
            {"циа", "sia"},
            {"Циа", "Sia"},
            {"ЦИА", "SIA"},
            {"цикл", "tsikl"},
            {"Цикл", "Tsikl"},
            {"ЦИКЛ", "TSIKL"},
            {"цио", "tsio"},
            {"Цио", "Tsio"},
            {"ЦИО", "TSIO"},
            {"циу", "tsiu"},
            {"Циу", "Tsiu"},
            {"ЦИУ", "TSIU"},
            {"циу", "siu"},
            {"Циу", "Siu"},
            {"ЦИУ", "SIU"},
            {"СҲ", "S'H"},
            {"Сҳ", "S'h"},
            {"сҳ", "s'h"},
            {"съём", "syom"},
            {"Съём", "Syom"},
            {"СЪЁМ", "SYOM"},
            {"ЪЮ", "YU"},
            {"Ъю", "yu"},
            {"ъЮ", "YU"},
            {"ъю", "yu"},
            {"ЬО", "YO"},
            {"ьО", "YO"},
            {"Ьо", "yo"},
            {"ьо", "yo"},
            {"ЬЕ", "YE"},
            {"ьЕ", "YE"},
            {"ье", "ye"},
            {"Ье", "ye"},
            {"ЬЁ", "YO"},
            {"ьЁ", "YO"},
            {"Ьё", "yo"},
            {"ьё", "yo"},
            {"ЪЕ", "YE"},
            {"ъЕ", "YE"},
            {"Ъе", "ye"},
            {"ъе", "ye"},
            {"ЪЁ", "YO"},
            {"ъЁ", "YO"},
            {"Ъё", "yo"},
            {"ъё", "yo"},
            {"еъ", "e'"},
            {"еЪ", "e'"},
            {"Еъ", "E'"},
            {"ЕЪ", "E'"}
    };


//    "ц"  ts
//{" е", " ye"},
    //"ъ" "’" "ъ"
    //"ь" ""
    //q,g', x, h, o', yo, yu, ya, Ь,

    private static final List<Pair> subWordsLatinInitialPattern = new ArrayList<>();

    public static final List<Pair> subWordsCyrillicInitialPattern = new ArrayList<>();

    static {

        Arrays.sort(SubWordLibrary.subWordsCyrillicInitial, (strings, t1) -> t1[0].length() - strings[0].length());
        Arrays.sort(SubWordLibrary.subWordsLatinInitial, (strings, t1) -> t1[0].length() - strings[0].length());

        for (String[] strings : SubWordLibrary.subWordsLatinInitial) {
            subWordsLatinInitialPattern.add(new Pair(
                    Pattern.compile(strings[0]),
                    strings[1]
            ));
        }

        for (String[] strings : SubWordLibrary.subWordsCyrillicInitial) {
            subWordsCyrillicInitialPattern.add(new Pair(
                    Pattern.compile(strings[0]),
                    strings[1]
            ));
        }
    }

    static class Pair {

        private final Pattern pattern;

        private final String word;

        Pair(Pattern pattern, String word) {
            this.pattern = pattern;
            this.word = word;
        }

        public Pattern getPattern() {
            return pattern;
        }

        public String getWord() {
            return word;
        }
    }
}
