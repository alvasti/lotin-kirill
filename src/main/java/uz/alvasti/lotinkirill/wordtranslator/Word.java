package uz.alvasti.lotinkirill.wordtranslator;

import uz.alvasti.lotinkirill.alphabet.AlphabetChecker;

public class Word extends AlphabetChecker {

    private final String text;


    public Word(String text) {
        this.text = text;
    }


    public String getText() {
        return text;
    }


    @Override
    public boolean isLatin() {
        if(super.isLatin == null){
            this.isLatin = AlphabetChecker.checkIsLatin(text);
        }
        return this.isLatin;
    }
}
