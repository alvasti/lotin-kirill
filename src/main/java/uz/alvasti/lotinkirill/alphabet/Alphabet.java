package uz.alvasti.lotinkirill.alphabet;

import java.util.List;

public interface Alphabet {

    boolean checkLetter(Character c);

    boolean checkLetter(String c);

    boolean checkAnyCharacter(Character c);

    List<Character> getAllPossibleChars();

    default boolean checkWord(String s) {

        for (char c : s.toCharArray()) {
            if (!checkAnyCharacter(c)) return false;
        }

        return true;
    }
}
