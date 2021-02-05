package uz.alvasti.lotinkirill.alphabet;

public interface Alphabet {

    boolean checkLetter(Character c);

    boolean checkLetter(String c);

    boolean checkAnyCharacter(Character c);

    default boolean checkWord(String s) {

        for (char c : s.toCharArray()) {
            if (!checkAnyCharacter(c)) return false;
        }

        return true;
    }
}
