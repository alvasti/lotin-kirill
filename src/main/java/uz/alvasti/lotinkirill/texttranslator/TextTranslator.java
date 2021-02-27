package uz.alvasti.lotinkirill.texttranslator;

import uz.alvasti.lotinkirill.alphabet.AlphabetChecker;
import uz.alvasti.lotinkirill.wordtranslator.FragmentText;
import uz.alvasti.lotinkirill.wordtranslator.TextSeparatorToWord;
import uz.alvasti.lotinkirill.wordtranslator.WordTranslator;

public class TextTranslator {

    private final WordTranslator wordTranslator;

    private final TextSeparatorToWord textSeparatorToWord;

    public TextTranslator() {

        this.textSeparatorToWord = new TextSeparatorToWord();
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

        var splittedTexts = this.textSeparatorToWord.splitText(text);

        StringBuilder builder = new StringBuilder();

        for (FragmentText fragment : splittedTexts) {
            String fragmentText = fragment.getWord().getText();
            builder.append(
                    fragment.isWord() ?
                            translateWord(
                                    fragmentText,
                                    toLatin)
                            : fragmentText);
        }

        return builder.toString();
    }

    private String translateWord(String word, boolean toLatin) {
        var newWord = toLatin ? this.wordTranslator.translateToLatin(word) : this.wordTranslator.translateToCyrillic(word);
        if (word.toUpperCase().equals(word)) {
            newWord = newWord.toUpperCase();
        }
        return newWord;
    }
}
