package uz.alvasti.lotinkirill.wordtranslator;

import uz.alvasti.lotinkirill.alphabet.AlphabetChecker;

public class Word extends AlphabetChecker {

    private final String word;


    public Word(String word) {
        super(word);
        this.word = word;
    }


    public String getWord() {
        return word;
    }


}
