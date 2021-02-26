package uz.alvasti.lotinkirill;

import uz.alvasti.lotinkirill.texttranslator.TextTranslator;
import uz.alvasti.lotinkirill.wordtranslator.Word;
import uz.alvasti.lotinkirill.wordtranslator.WordTranslator;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Example {

    public static void main(String[] args) {


        String text = "YASHNAR Yashnar Yo'ldosh";
        TextTranslator textTranslator = new TextTranslator();

        System.out.println(textTranslator.translateToCyrillic(text));

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
