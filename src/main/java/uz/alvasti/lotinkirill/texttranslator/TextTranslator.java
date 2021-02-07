package uz.alvasti.lotinkirill.texttranslator;

import uz.alvasti.lotinkirill.alphabet.AlphabetChecker;
import uz.alvasti.lotinkirill.alphabet.CyrillicUzAlphabet;
import uz.alvasti.lotinkirill.alphabet.LatinUzAlphabet;
import uz.alvasti.lotinkirill.alphabet.LatinWordCorrector;
import uz.alvasti.lotinkirill.wordtranslator.WordTranslator;

import java.util.ArrayList;
import java.util.List;

public class TextTranslator {

    private final boolean[] wordPossibleChars = new boolean[65536];

    private final WordTranslator wordTranslator;

    public TextTranslator() {
        List<Character> characters = new ArrayList<>();
        characters.addAll(new CyrillicUzAlphabet().getAllPossibleChars());
        characters.addAll(new LatinUzAlphabet().getAllPossibleChars());
        characters.addAll(new LatinWordCorrector().getTutuqAndO_G_Variants());
        for (Character character : characters) {
            wordPossibleChars[character] = true;
        }

        this.wordTranslator = new WordTranslator();

    }

    public String translateAuto(String text) {
        boolean toLatin = !AlphabetChecker.checkIsLatin(text);
        return translateText(text, toLatin);
    }

    public String translateToLatin(String text) {
        return translateText(text, true);
    }

    public String translateToCyrillic(String text) {
        return translateText(text, false);
    }

    private String translateText(String text, boolean toLatin) {

        StringBuilder builder = new StringBuilder();
        var textChars = text.toCharArray();

        StringBuilder wordBuilder = new StringBuilder("");
        for (char textChar : textChars) {
            if (wordPossibleChars[textChar]) {
                wordBuilder.append(textChar);
            } else {
                if (wordBuilder.length() > 0) {
                    builder.append(translateWord(wordBuilder.toString(), toLatin));
                }
                builder.append(textChars);
            }
        }

        return builder.toString();
    }

    private String translateWord(String word, boolean toLatin) {
        return toLatin ? this.wordTranslator.translateToLatin(word) : this.wordTranslator.translateToCyrillic(word);
    }
}
