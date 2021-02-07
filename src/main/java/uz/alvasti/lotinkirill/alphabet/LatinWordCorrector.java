package uz.alvasti.lotinkirill.alphabet;

public class LatinWordCorrector {

    private final LatinUzAlphabet latinUzAlphabet;
    private final Character tutuq = 145;
    //tutuq belgisi va o' ning belgisi variantlari
    private final Character[] tutuqAndO_G_Variants = {145, 39, 96};

    //o' yoki g' belgisi
    private final Character o_g_ = 146;

    private final String[] tutuqSignWords = {
            "ma" + tutuq + "ruza", "a" + tutuq + "lo"
    };

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

        word = correctO_Q_(word);
        word = correctTutuq(word);

        return word;
    }

    private String correctO_Q_(String word) {

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
                    }
                }
                newWord.append(wordsChar);
            }

            if (compatibilityCount == Math.min(tutuqWordLen, tempWordLen)) {
                return newWord.toString();
            }
        }

        return word;

    }


}