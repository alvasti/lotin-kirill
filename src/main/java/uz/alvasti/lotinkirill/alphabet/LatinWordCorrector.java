package uz.alvasti.lotinkirill.alphabet;

import uz.alvasti.lotinkirill.wordtranslator.Word;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LatinWordCorrector {

    private final LatinUzAlphabet latinUzAlphabet;
    private final Character tutuq = 700;
    //tutuq belgisi va o' ning belgisi variantlari
    private final Character[] tutuqAndO_G_Variants = {8217, 8216, 700, 699, 39, 96};

    //o' yoki g' belgisi
    private final Character o_g_ = 699;

    private final static String[] tutuqSignWords;

    static {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        var is = classloader.getResourceAsStream("tutuq.txt");

        List<String> list = new ArrayList<>();
        if (is != null) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                for (String s : sb.toString().split(("\\r?\\n"))) {
                    for (String s1 : s.split(",")) {
                        if (s1.length() > 0) {
                            list.add(s1);
                        }
                    }
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            list.add("error");
        }

        tutuqSignWords = list.toArray(new String[0]);

    }

    public LatinWordCorrector() {
        this.latinUzAlphabet = new LatinUzAlphabet();
    }

    /**
     * Tutuq belgisi va o', g' harflarini to'g'ri variantga o'tkazish
     *
     * @param word any uzbek Latin word
     * @return corrected word
     */
    public String correctTutuqAndO_Q_(String word) {

        word = correctTutuq(word);
        word = correctO_Q_(word);

        return word;
    }

    public String correctO_Q_(String word) {

        for (Character tutuqAndO_g_variant : tutuqAndO_G_Variants) {
            word = word.replaceAll("o" + tutuqAndO_g_variant, "o" + o_g_);
            word = word.replaceAll("O" + tutuqAndO_g_variant, "O" + o_g_);
            word = word.replaceAll("g" + tutuqAndO_g_variant, "g" + o_g_);
            word = word.replaceAll("G" + tutuqAndO_g_variant, "G" + o_g_);
        }

        return word;
    }

    private String correctTutuq(String word) {

        char[] tempWord = word.toCharArray();


        for (String tutuqSignWord : tutuqSignWords) {

            StringBuilder newWord = new StringBuilder();

            if (tutuqSignWord.equals("EʼLON")) {
                int in = 0;
            }
            int tutuqWordLen = tutuqSignWord.length();

            int compatibilityCount = 0;
            int tempWordLen = tempWord.length;

            for (int i = 0; i < tempWordLen; i++) {
                Character wordsChar = tempWord[i];
                char tutuqWordsChar = Character.MAX_VALUE;//xar xillik uchun
                if (i < tutuqWordLen) {
                    tutuqWordsChar = tutuqSignWord.charAt(i);
                    if (wordsChar < 150 && tutuqWordsChar < 150) {
                        if (this.latinUzAlphabet.onlyLettersArr[wordsChar] && this.latinUzAlphabet.onlyLettersArr[tutuqWordsChar]) {
                            if (Character.toUpperCase(wordsChar) == Character.toUpperCase(tutuqWordsChar)) {
                                compatibilityCount++;
                            }
                        }
                    }

                }

                if (tutuqWordsChar == tutuq) {
                    boolean reverse = false;
                    for (Character character : tutuqAndO_G_Variants) {
                        reverse = reverse || character == wordsChar;
                    }
                    reverse = reverse && !this.latinUzAlphabet.onlyLettersArr[wordsChar];
                    if (reverse) {
                        compatibilityCount++;
                        wordsChar = tutuq;
                    }
                }
                if (tutuqWordsChar == o_g_) {
                    boolean isO_g_ = false;
                    for (Character character : tutuqAndO_G_Variants) {
                        isO_g_ = isO_g_ || character == wordsChar;
                    }
                    isO_g_ = isO_g_ && !this.latinUzAlphabet.onlyLettersArr[wordsChar];
                    if (isO_g_) {
                        compatibilityCount++;
                        wordsChar = o_g_;
                    }
                }
                newWord.append(wordsChar);
            }

            if (compatibilityCount == tutuqWordLen) {
                return newWord.toString();
            }
        }

        return word;

    }


    public List<Character> getTutuqAndO_G_Variants() {
        return Arrays.asList(tutuqAndO_G_Variants);
    }
}
