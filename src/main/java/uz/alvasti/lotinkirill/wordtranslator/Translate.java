package uz.alvasti.lotinkirill.wordtranslator;

public interface Translate {

    /**
     * Translate if Cyrillic to Latin, if word is cyrillic.
     * Translate if Latin to Cyrillic, if word is latin
     * @return Cyrillic or Latin word
     */
    default String translate(Word word){

        if(word.isLatin()){
            return translateToLatin(word.getWord());
        }

        return translateToCyrillic(word.getWord());
    }

    String translateToLatin(String word);

    String translateToCyrillic(String word);

}
