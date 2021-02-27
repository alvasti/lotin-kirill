package uz.alvasti.lotinkirill.wordtranslator;

public class FragmentText {

    private Boolean isWord;

    private Word word;

    public FragmentText(Word word) {
        this.isWord = false;
        this.word = word;
    }
    public FragmentText(Boolean isWord, Word word) {
        this.isWord = isWord;
        this.word = word;
    }

    public Word getWord() {
        return word;
    }

    public Boolean isWord(){
        return this.isWord;
    }
}
