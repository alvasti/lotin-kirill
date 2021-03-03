package uz.alvasti.lotinkirill;

import uz.alvasti.lotinkirill.texttranslator.TextTranslator;
import uz.alvasti.lotinkirill.wordtranslator.Word;
import uz.alvasti.lotinkirill.wordtranslator.WordTranslator;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Example {

    public static void main(String[] args) {


//        String testUpper = "ЪАаБбДsdsdsъwewewe123''';3[12 6 sentyabr ";
//        System.out.println(testUpper.toUpperCase());

        char[] a = {'a','w','e','t','u'};
        System.out.println(String.valueOf(a,1, a.length-1));
        System.out.println("asdf".substring(0, "asdf".length()));
        System.out.println((char)(8217));
        System.out.println((char)(45));
        System.out.println((int)('ʼ'));
        System.out.println(((int)('ʻ')));
        System.out.println(((int)('ʼ')));
        String text = "mo'jaz A'ZAMJON E'LON  sa'as6 sentyabr SYOM";
        String text1 = "аЪзамжондэк эЪлон 6 центябр ўъжаз АДЪЮНКТ СЪЁМ ";
        TextTranslator textTranslator = new TextTranslator();

        System.out.println(textTranslator.translateAuto(text));
        System.out.println();
        System.out.println(textTranslator.translateAuto(text1));

    }

    public static void testing(){
        File in = new File("testin.txt");

        File out = new File("testout.txt");

        WordTranslator wordTranslator = new WordTranslator();

        try (BufferedReader br = new BufferedReader(new FileReader(in));
             PrintWriter writer = new PrintWriter(out, StandardCharsets.UTF_8)){

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
