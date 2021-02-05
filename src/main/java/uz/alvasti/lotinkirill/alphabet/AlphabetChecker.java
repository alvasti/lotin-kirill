package uz.alvasti.lotinkirill.alphabet;

public abstract class AlphabetChecker {

    private final boolean isLatin;

    public AlphabetChecker(String word) {
        this.isLatin = AlphabetChecker.checkIsLatin(word);
    }

    public boolean isLatin() {
        return this.isLatin;
    }

    public boolean isCyrillic() {
        return !this.isLatin;
    }

    public static boolean checkIsLatin(String word) {
        return true;
    }
}
