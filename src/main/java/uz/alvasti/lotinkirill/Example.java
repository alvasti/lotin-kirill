package uz.alvasti.lotinkirill;

import uz.alvasti.lotinkirill.texttranslator.TextTranslator;
import uz.alvasti.lotinkirill.wordtranslator.Word;
import uz.alvasti.lotinkirill.wordtranslator.WordTranslator;
import uz.alvasti.lotinkirill.wordtranslator.WordsLibrary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class Example {

    public static void main(String[] args) {


//        String testUpper = "ЪАаБбДsdsdsъwewewe123''';3[12 6 sentyabr ";
//        System.out.println(testUpper.toUpperCase());

        TextTranslator textTranslator = new TextTranslator();

        var ss = "Паскалъ маъюслик етти Польша январ Паскаль фойе қирқ етти маъюслик меъёр абстиненция съёмка аъло ўқувчи";

//        System.out.println(((int)('ъ')));
//        System.out.println(((int)('‘')));
//        System.out.println(((int)('ʻ')));

        System.out.println(
                textTranslator.translateAuto(
                        ss
                )
        );

//        System.out.println(
//                textTranslator.translateAuto(
//                        ss1
//                )
//        );
//
//        System.out.println(
//                textTranslator.translateAuto(
//                        ss2
//                )
//        );
//
//
//        System.out.println(((char)(700)));

//        Э 1069
//        э 1101

//        var arr = WordsLibrary.wordsInitial;
//        for (String[] ar : arr) {
//            for (String[] ar1 : arr) {
//                //                {'ъ', 'Ъ', '-', 'ь', 'Ь'}
//                if (ar[0].equalsIgnoreCase(ar1[0] + "ь")) {
//                    System.out.println(ar1[0]);
//                    break;
//                }
//            }
//        }

//        String s1 = new String("asd");
//        System.out.println("asd".hashCode());
//        System.out.println(s1.hashCode());
//        for (int i = 0; i < ss.length(); i++) {
//            int o = ss.charAt(i);
//            System.out.print(ss.charAt(i) + " " + o + "  ");
//        }
//        System.out.println();

//        System.out.println(
//                textTranslator.translateAuto(
//                        "декабрь масъул масъулиятлиликларининг"
//                )
//        );
//        int k = '’', l = 'ʼ', j = '’';
//        char cc = 699;
//        System.out.println("’ʼ");
//        System.out.println(k);
//        System.out.println(l);
//        System.out.println(j);
//        System.out.println(cc);


//        System.out.println(
//                textTranslator.translateAuto(
//                        "Екатиринбур"
//                )
//        );

//        String text = "sentabr";//"хаvоrаnggаzbo`lib   E'LON ASS"+((char)(700))+"SD ";//""E'LON E'lon e'lon emma'as";
//        String text1 = "аъзамжондэк эЪлон 6 центябр ўъжаз АДЪЮНКТ СЪЁМ ";

//        textTranslator.translateAuto("СЪЁМ");
//        System.out.println(textTranslator.translateAuto(text));
//        System.out.println();
//        System.out.println(textTranslator.translateAuto(text1));

    }

    public static void testing() {
        File in = new File("testin.txt");

        File out = new File("testout.txt");

        WordTranslator wordTranslator = new WordTranslator();

        try (BufferedReader br = new BufferedReader(new FileReader(in));
             PrintWriter writer = new PrintWriter(out, StandardCharsets.UTF_8)) {

            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            for (String s : sb.toString().split(("\\r?\\n"))) {
                for (String s1 : s.split(",")) {
                    Word word = new Word(s1);
                    writer.print(wordTranslator.translate(word) + "\n");
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
