package uz.alvasti.lotinkirill.alphabet;

public class LatinUzAlphabet implements Alphabet {

    private final Character[] onlyLetters = {'A', 'a', 'B', 'b', 'D', 'd', 'E', 'e', 'F', 'f', 'G', 'g', 'H', 'h', 'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', 'M', 'm', 'N', 'n', 'O', 'o', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't', 'U', 'u', 'V', 'v', 'X', 'x', 'Y', 'y', 'Z', 'z'};

    private final boolean[] onlyLettersArr = new boolean[150];

    /*
     146 -  o' ning belgisi
     145 - tutuq belgisi
     */
    private final String[] combinedLetters = {"O" + 146, "o" + 146, "G" + 146, "g" + 146, "Sh", "sh", "Ch", "Ng", "ng"};

    private final Character[] characters = {145, 45, 146};

    public LatinUzAlphabet() {
        for (Character onlyLetter : onlyLetters) {
            onlyLettersArr[onlyLetter] = true;
        }
    }

    @Override
    public boolean checkLetter(Character c) {
        return onlyLettersArr[c];
    }

    @Override
    public boolean checkLetter(String s) {

        if (s.length() == 1) {
            checkLetter(s.charAt(0));
        }

        for (String combinedLetter : combinedLetters) {
            if (combinedLetter.equals(s)) return true;
        }
        return false;
    }

    @Override
    public boolean checkAnyCharacter(Character c) {

        if (onlyLettersArr[c]) return true;

        for (String combinedLetter : combinedLetters) {
            for (char c1 : combinedLetter.toCharArray()) {
                if (c1 == c) return true;
            }
        }

        for (Character character : characters) {
            if (character == c) return true;
        }

        return false;
    }

    class LatinWordCorrector {

        private final Character tutuq = 145;
        //tutuq belgisi va o' ning belgisi variantlari
        private final Character[] tutuqAndO_G_Variants = {145, 39, 96};

        //o' yoki g' belgisi
        private final Character o_g_ = 146;

        private final String[] tutuqSignWords = {
                "ma" + tutuq + "ruza", "a" + tutuq + "lo"
        };

        public LatinWordCorrector() {
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
                            if (onlyLettersArr[wordsChar] && onlyLettersArr[tutuqWordsChar]) {
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
                        reverse = reverse && !onlyLettersArr[wordsChar];
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
                        isO_g_ = isO_g_ && !onlyLettersArr[wordsChar];
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
}

