package uz.alvasti.lotinkirill.wordtranslator;

import uz.alvasti.lotinkirill.alphabet.LatinWordCorrector;
import uz.alvasti.lotinkirill.alphabet.LettersCompatibility;

import java.util.Objects;

public class WordTranslator implements Translate {

    private final WordsLibrary wordsLibrary;
    private final SubWordLibrary subWordLibrary;
    private final LettersCompatibility lettersCompatibility;
    private final LatinWordCorrector latinWordCorrector;
    private final Grammar grammar;

    public WordTranslator() {
        this.wordsLibrary = new WordsLibrary();
        this.subWordLibrary = new SubWordLibrary();
        this.lettersCompatibility = new LettersCompatibility();
        this.latinWordCorrector = new LatinWordCorrector();
        this.grammar = new Grammar();
    }

    /**
     * 1. Words library ichidan kerakli so'zlar tekshirib chiqiladi
     * 2. SubWordsLibrary dan kerakli qo'shimchali so'zlar ko'rib chiqiladi
     * 3. Harflash almashtiriladi
     *
     * @param word any cyrillic word
     * @return translated word
     */
    @Override
    public String translateToLatin(String word) {
        word = wordsLibrary.translateToLatin(word);
        word = subWordLibrary.translateToLatin(word);
        var wordCharSeq = word.toCharArray();
        StringBuilder wordTmp = new StringBuilder();
        for (char c : wordCharSeq) {
            String translated = lettersCompatibility.toLatin(c);
            if (translated != null) {
                wordTmp.append(translated);
            } else {
                wordTmp.append(c);
            }
        }
        word = wordTmp.toString();
        return word;
    }

    /**
     * 1. Corrector orqali so'zning o' va tutuq belgili qismlari to'g'irlanadi
     * 2. WordLibrary ichidan so'z bor yoki yo'qligi qarab chiqiladi
     * 3. SubWordsLibrary ichidan so'zning kerakli qismlari almashtiriladi
     * 4. Harflar almashtiriladi
     *
     * @param word any latin word
     * @return translated word
     */
    @Override
    public String translateToCyrillic(String word) {

        word = this.latinWordCorrector.correctTutuqAndO_Q_(word);
        word = this.wordsLibrary.translateToCyrillic(word);
        word = this.subWordLibrary.translateToCyrillic(word);
        StringBuilder newWord = new StringBuilder();
        var wordChars = word.toCharArray();
        int len = wordChars.length;
        for (int i = 0; i < len; i++) {

            String letter = "" + wordChars[i];
            if (i < len - 1) {
                var reversedLetter = lettersCompatibility.toCyrillic(letter + wordChars[i + 1]);
                if (reversedLetter != null && !reversedLetter.equals(letter)) {
                    i++;
                    newWord.append(reversedLetter);
                    continue;
                }
            }

            var reversedLetter = lettersCompatibility.toCyrillic(letter);

            if (i > 0 && reversedLetter != null) {
                reversedLetter = grammar.cyrillicE3wordsCorrector(
                        newWord.charAt(newWord.length() - 1),
                        reversedLetter);
            }

            newWord.append(Objects.requireNonNullElse(reversedLetter, letter));

        }
        return newWord.toString();
    }
}
