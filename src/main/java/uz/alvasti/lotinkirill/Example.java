package uz.alvasti.lotinkirill;

import uz.alvasti.lotinkirill.texttranslator.TextTranslator;
import uz.alvasti.lotinkirill.wordtranslator.Word;
import uz.alvasti.lotinkirill.wordtranslator.WordTranslator;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Example {

    public static void main(String[] args) {


        String testUpper = "ЪАаБбДsdsdsъwewewe123''';3[12 6 sentyabr ";
        System.out.println(testUpper.toUpperCase());
        String text = "a'zam E'LON  sa'as6 sentyabr ";
        String text1 = "аЪзам эЪлон 6 центябр";
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
