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

    public static boolean checkIsLatin(String text) {

        var textChars = text.toCharArray();

        int cyrCount = 0;
        var cyrArr = new CyrillicUzAlphabet().getAllPossibleCharsArr();
        for (char c : textChars) {
            cyrCount += cyrArr[c] ? 1 : 0;
        }

        int latCount = 0;
        var latArr = new LatinUzAlphabet().getAllPossibleCharsArr();
        for (char c : textChars) {
            latCount += latArr[c] ? 1 : 0;
        }
        return latCount > cyrCount;
    }
}
