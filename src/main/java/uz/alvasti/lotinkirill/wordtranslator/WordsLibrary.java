package uz.alvasti.lotinkirill.wordtranslator;

import uz.alvasti.lotinkirill.utils.CustomArrayUtil;

import java.util.*;

public class WordsLibrary implements Translate {

    private static Map<Integer, String> cyrillicLatinWords;
    private static Map<Integer, String> latinCyrillicWords;

    public boolean checkLatin(String word) {

        return WordsLibrary.latinCyrillicWords.containsKey(word.hashCode());
    }

    public boolean checkKirill(String word) {

        return WordsLibrary.cyrillicLatinWords.containsKey(word.hashCode());
    }

    @Override
    public String translateToLatin(String word) {

        return translateWithHashMap(WordsLibrary.cyrillicLatinWords, word);
    }

    @Override
    public String translateToCyrillic(String word) {
        return translateWithHashMap(WordsLibrary.latinCyrillicWords, word);
    }

    private String translateWithHashMap(Map<Integer, String> wordsCompabilityMap, String word){

        var wordsChar = word.toCharArray();

        boolean isHave = true;
        while (isHave) {
            isHave = false;
            int len = wordsChar.length;

            for (int i = 0; i < len && !isHave; i++) {

                for (int j = i + 1; j <= len && !isHave; j++) {

                    String s = String.valueOf(Arrays.copyOfRange(wordsChar, i, j));
                    s = wordsCompabilityMap.get(s.hashCode());

                    if (s != null) {
                        wordsChar = CustomArrayUtil.concatCharArrays(
                                Arrays.copyOfRange(wordsChar, 0, i),
                                s.toCharArray(),
                                Arrays.copyOfRange(wordsChar, j, len));
                        isHave = true;
                    }
                }
            }
        }

        return String.valueOf(wordsChar);
    }

    private static String[][] words;

    /**
     * “Ц” ҳарфи иштирок этган сўзларнинг имлоси
     *
     * @link http://xushnudbek.blogspot.com/p/blog-page_1204.html
     */
    private static final String[][] wordsInitial = {
            {"абстракция", "abstraksiya"},
            {"абцесс", "absess"},
            {"абцисса", "absissa"},
            {"авиация", "aviatsiya"},
            {"адаптация", "adaptatsiya"},
            {"адсорбция", "adsorbsiya"},
            {"акация", "akatsiya"},
            {"акклиматизация", "akklimatizatsiya"},
            {"аккредитация", "akkreditatsiya"},
            {"аккумуляция", "akkumulyatsiya"},
            {"активация", "aktivatsiya"},
            {"акцептор", "akseptor"},
            {"акцессор", "aksessor"},
            {"акциз", "aksiz"},
            {"акция", "aksiya"},
            {"аннотация", "annotatsiya"},
            {"антифрикцион", "antifriksion"},
            {"апелляция", "apellyatsiya"},
            {"апробация", "aprobatsiya"},
            {"ассимиляция", "assimilyatsiya"},
            {"ассоциация", "assotsiatsiya"},
            {"аттестация", "attestatsiya"},
            {"аукцион", "auksion"},
            {"ацетон", "atseton"},
            {"ацтек", "atstek"},
            {"Баренц", "Barens"},
            {"Вадуц", "Vaduts"},
            {"вакцина", "vaksina"},
            {"вариация", "variatsiya"},
            {"вегетация", "vegetatsiya"},
            {"Венеция", "Venetsiya"},
            {"вентиляция", "ventilyatsiya"},
            {"вибрация", "vibratsiya"},
            {"вице-", "vitse-"},
            {"гелиоцентрик", "geliotsentrik"},
            {"геоцентрик", "geotsentrik"},
            {"герц", "gers"},
            {"герцог", "gersog"},
            {"гидратация", "gidratatsiya"},
            {"глобализация", "globalizatsiya"},
            {"горчица", "gorchitsa"},
            {"гравитацион", "gravitatsion"},
            {"гравитация", "gravitatsiya"},
            {"Греция", "Gretsiya"},
            {"Даймлер-бенц", "Daymler-bens"},
            {"Данциг", "Dansig"},
            {"девальвация", "devalvatsiya"},
            {"дегустация", "degustatsiya"},
            {"дедукция", "deduksiya"},
            {"дезактивация", "dezaktivatsiya"},
            {"декламация", "deklamatsiya"},
            {"декларация", "deklaratsiya"},
            {"декорация", "dekoratsiya"},
            {"делегация", "delegatsiya"},
            {"делимитация", "delimitatsiya"},
            {"демаркация", "demarkatsiya"},
            {"денонсация", "denonsatsiya"},
            {"депортация", "deportatsiya"},
            {"деривация", "derivatsiya"},
            {"детонация", "detonatsiya"},
            {"дефицит", "defitsit"},
            {"деформация", "deformatsiya"},
            {"децибел", "detsibel"},
            {"дециметр", "detsimetr"},
            {"диверсификация", "diversifikatsiya"},
            {"дирекция", "direksiya"},
            {"дисквалификация", "diskvalifikatsiya"},
            {"дискриминация", "diskriminatsiya"},
            {"дислокация", "dislokatsiya"},
            {"диссертация", "dissertatsiya"},
            {"диссимиляция", "dissimilyatsiya"},
            {"дифференциал", "differensial"},
            {"дифференциация", "differensiatsiya"},
            {"дифференция", "differensiya"},
            {"Донецк", "Donetsk"},
            {"дотация", "dotatsiya"},
            {"доцент", "dotsent"},
            {"жиу-жицу", "jiu-jitsu"},
            {"изоляция", "izolyatsiya"},
            {"иллюстрация", "illyustratsiya"},
            {"иммобилизация", "immobilizatsiya"},
            {"импровизация", "improvizatsiya"},
            {"инвестиция", "investitsiya"},
            {"индексация", "indeksatsiya"},
            {"индукция", "induksiya"},
            {"индульгенция", "indulgensiya"},
            {"инерция", "inersiya"},
            {"инквизиция", "inkvizitsiya"},
            {"инкубация", "inkubatsiya"},
            {"инспекция", "inspeksiya"},
            {"инструкция", "instruksiya"},
            {"инсценировка", "inssenirovka"},
            {"интеграция", "integratsiya"},
            {"интервенция", "intervensiya"},
            {"интерференция", "interferensiya"},
            {"интуиция", "intuitsiya"},
            {"инфекция", "infeksiya"},
            {"инфляция", "inflyatsiya"},
            {"информацион", "informatsion"},
            {"иррационал", "irratsional"},
            {"ирригация", "irrigatsiya"},
            {"кальций", "kalsiy"},
            {"канализация", "kanalizatsiya"},
            {"канцлер", "kansler"},
            {"капитуляция", "kapitulyatsiya"},
            {"кассация", "kassatsiya"},
            {"католицизм", "katolitsizm"},
            {"квалификация", "kvalifikatsiya"},
            {"кварц", "kvars"},
            {"классификация", "klassifikatsiya"},
            {"классицизм", "klassitsizm"},
            {"коллекция", "kolleksiya"},
            {"колонизация", "kolonizatsiya"},
            {"комбинация", "kombinatsiya"},
            {"коммерция", "kommersiya"},
            {"коммуникация", "kommunikatsiya"},
            {"компенсация", "kompensatsiya"},
            {"композиция", "kompozitsiya"},
            {"конвекция", "konveksiya"},
            {"конвенция", "konvensiya"},
            {"консервация", "konservatsiya"},
            {"консолидация", "konsolidatsiya"},
            {"консорциум", "konsorsium"},
            {"консорция", "konsorsiya"},
            {"констанца", "konstansa"},
            {"конституция", "konstitutsiya"},
            {"конструкция", "konstruksiya"},
            {"консультация", "konsultatsiya"},
            {"конфедерация", "konfederatsiya"},
            {"конференция", "konferensiya"},
            {"концентрат", "konsentrat"},
            {"концентрация", "konsentratsiya"},
            {"концепт", "konsept"},
            {"концепция", "konsepsiya"},
            {"концерн", "konsern"},
            {"концерт", "konsert"},
            {"концессия", "konsessiya"},
            {"концлагерь", "konslager"},
            {"конъюнкция", "kon’yunksiya"},
            {"координация", "koordinatsiya"},
            {"корпорация", "korporatsiya"},
            {"коррекция", "korreksiya"},
            {"корреспонденция", "korrespondensiya"},
            {"коррупция", "korrupsiya"},
            {"коэффициент", "koeffitsiyent"},
            {"культивация", "kultivatsiya"},
            {"лактация", "laktatsiya"},
            {"Лейпциг", "Leypsig"},
            {"лейцит", "leysit"},
            {"лекция", "leksiya"},
            {"лицей", "litsey"},
            {"лицензия", "litsenziya"},
            {"лиценциат", "litsensiat"},
            {"майнц", "mayns"},
            {"марганец", "marganets"},
            {"марганцовка", "margansovka"},
            {"матрица", "matritsa"},
            {"мелиорация", "melioratsiya"},
            {"менингококкцемия", "meningokokksemiya"},
            {"Мерседес-бенц", "Mersedes-bens"},
            {"механизация", "mexanizatsiya"},
            {"миграция", "migratsiya"},
            {"милиция", "militsiya"},
            {"модернизация", "modernizatsiya"},
            {"модификация", "modifikatsiya"},
            {"модуляция", "modulyatsiya"},
            {"мотоцикл", "motosikl"},
            {"муниципал", "munitsipal"},
            {"муниципалитет", "munitsipalitet"},
            {"мутация", "mutatsiya"},
            {"мцири", "mtsiri"},
            {"навигация", "navigatsiya"},
            {"национализация", "natsionalizatsiya"},
            {"национализм", "natsionalizm"},
            {"нацист", "natsist"},
            {"ницца", "nitssa"},
            {"облигация", "obligatsiya"},
            {"оккупация", "okkupatsiya"},
            {"оксигенация", "oksigenatsiya"},
            {"операция", "operatsiya"},
            {"осциллограф", "ossillograf"},
            {"офицер", "ofitser"},
            {"патриций", "patritsiy"},
            {"плантация", "plantatsiya"},
            {"плацдарм", "platsdarm"},
            {"плацента", "platsenta"},
            {"позиция", "pozitsiya"},
            {"полиция", "politsiya"},
            {"популяция", "populyatsiya"},
            {"потенциал", "potensial"},
            {"принцип", "prinsip"},
            {"провинция", "provinsiya"},
            {"проекция", "proyeksiya"},
            {"пропорционал", "proporsional"},
            {"пропорция", "proporsiya"},
            {"процесс", "protsess"},
            {"публицист", "publitsist"},
            {"публицистик", "publitsistik"},
            {"радиация", "radiatsiya"},
            {"радиолокация", "radiolokatsiya"},
            {"ратификация", "ratifikatsiya"},
            {"рацион", "ratsion"},
            {"рационал", "ratsional"},
            {"реабилитация", "reabilitatsiya"},
            {"реакция", "reaksiya"},
            {"реализация", "realizatsiya"},
            {"реанимация", "reanimatsiya"},
            {"революция", "revolyutsiya"},
            {"регуляция", "regulyatsiya"},
            {"редакция", "redaksiya"},
            {"редукция", "reduksiya"},
            {"резервация", "rezervatsiya"},
            {"рекреация", "rekreatsiya"},
            {"репродукция", "reproduksiya"},
            {"рецепт", "retsept"},
            {"рецептор", "retseptor"},
            {"рецидивист", "retsidivist"},
            {"рицар", "ritsar"},
            {"Сан-франциско", "San-fransisko"},
            {"седиментация", "sedimentatsiya"},
            {"секреция", "sekretsiya"},
            {"секция", "seksiya"},
            {"селекция", "seleksiya"},
            {"сепарация", "separatsiya"},
            {"сигнализация", "signalizatsiya"},
            {"Сицилия", "Sitsiliya"},
            {"сланец", "slanets"},
            {"социализм", "sotsializm"},
            {"социология", "sotsiologiya"},
            {"станция", "stansiya"},
            {"стационар", "statsionar"},
            {"ступица", "stupitsa"},
            {"сукцинат", "suksinat"},
            {"сценарий", "ssenariy"},
            {"сянцзи", "syanszi"},
            {"тенденция", "tendensiya"},
            {"транскрипция", "transkripsiya"},
            {"транснационал", "transnatsional"},
            {"трансформация", "transformatsiya"},
            {"трапеция", "trapetsiya"},
            {"унция", "unsiya"},
            {"фармацевтика", "farmatsevtika"},
            {"федерация", "federatsiya"},
            {"Флоренция", "Florensiya"},
            {"формация", "formatsiya"},
            {"фракция", "fraksiya"},
            {"франций", "fransiy"},
            {"франциск", "fransisk"},
            {"Франция", "Fransiya"},
            {"француз", "fransuz"},
            {"фрикцион", "friksion"},
            {"функция", "funksiya"},
            {"халцедон", "xalsedon"},
            {"холецистит", "xoletsistit"},
            {"цезий", "seziy"},
            {"цейтнот", "seytnot"},
            {"целлофан", "sellofan"},
            {"целлюлоза", "sellyuloza"},
            {"цельсий", "selsiy"},
            {"цемент", "sement"},
            {"цензор", "senzor"},
            {"цензура", "senzura"},
            {"центнер", "sentner"},
            {"цех", "sex"},
            {"цеце", "setse"},
            {"цеце", "setse"},
            {"цивилизация", "sivilizatsiya"},
            {"цикл", "sikl"},
            {"циклон", "siklon"},
            {"циклоп", "siklop"},
            {"цилиндр", "silindr"},
            {"цилиндрик", "silindrik"},
            {"цилиндрсимон", "silindrsimon"},
            {"цирк", "sirk"},
            {"циркуль", "sirkul"},
            {"циркуляция", "sirkulyatsiya"},
            {"цистерна", "sisterna"},
            {"цитрус", "sitrus"},
            {"черепица", "cherepitsa"},
            {"Швейцария", "Shveysariya"},
            {"Швеция", "Shvetsiya"},
            {"шприц", "shprits"},
            {"эволюция", "evolyutsiya"},
            {"эквиваленция", "ekvivalensiya"},
            {"экспедиция", "ekspeditsiya"},
            {"эксплуатация", "ekspluatatsiya"},
            {"экспозиция", "ekspozitsiya"},
            {"экстракция", "ekstraksiya"},
            {"эксцентриситет", "ekssentrisitet"},
            {"электрострикция", "elektrostriksiya"},
            {"эмансипация", "emansipatsiya"},
            {"эмиграция", "emigratsiya"},
            {"эмоция", "emotsiya"},
            {"энциклопедик", "ensiklopedik"},
            {"энциклопедия", "ensiklopediya"},
            {"эпилейцит", "epileysit"},
            {"эпицентр", "epitsentr"},
            {"эссенция", "essensiya"},
            {"юрисдикция", "yurisdiksiya"},
            {"юриспруденция", "yurisprudensiya"},
            {"Янцзи", "Yanszi"},
            {"Сентябрь", "Sentabr"},
            {"Октябрь", "Oktabr"},
            {"Бюджет", "Budjet"}
    };

    static {

        List<String[]> wordsList = new ArrayList<>();
        for (String[] word : WordsLibrary.wordsInitial) {
            if (!word[0].equals(word[0].toLowerCase()) && word[1].equals(word[1].toLowerCase())) {
                String[] wordTemp = new String[2];
                wordTemp[0] = word[0].toLowerCase();
                wordTemp[1] = word[1].toLowerCase();
                wordsList.add(wordTemp);
            }
        }
        int wordsInitialLength = WordsLibrary.wordsInitial.length;
        int len = wordsInitialLength + wordsList.size();
        WordsLibrary.words = new String[len][2];

        System.arraycopy(WordsLibrary.wordsInitial, 0, WordsLibrary.words, 0, wordsInitialLength);

        for (String[] word : wordsList) {
            WordsLibrary.words[wordsInitialLength++] = word;
        }

        var cyrillicLatinWords = new HashMap<Integer, String>();
        var latinCyrillicWords = new HashMap<Integer, String>();
        for (String[] word : WordsLibrary.words) {
            cyrillicLatinWords.put(word[0].hashCode(), word[1]);
            latinCyrillicWords.put(word[1].hashCode(), word[0]);
        }
        WordsLibrary.cyrillicLatinWords = Map.copyOf(cyrillicLatinWords);
        WordsLibrary.latinCyrillicWords = Map.copyOf(latinCyrillicWords);
    }

}


