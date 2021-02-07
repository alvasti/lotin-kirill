package uz.alvasti.lotinkirill.alphabet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LatinUzAlphabet implements Alphabet {

    private final Character[] onlyLetters = {'A', 'a', 'B', 'b', 'D', 'd', 'E', 'e', 'F', 'f', 'G', 'g', 'H', 'h', 'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', 'M', 'm', 'N', 'n', 'O', 'o', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't', 'U', 'u', 'V', 'v', 'X', 'x', 'Y', 'y', 'Z', 'z'};

    protected final boolean[] onlyLettersArr = new boolean[65536];

    /*
     146 -  o' ning belgisi
     145 - tutuq belgisi
     */
                                                //0         1           2       3           4   5       6    7      8   9
    private final String[] combinedLetters = {"O" + 146, "o" + 146, "G" + 146, "g" + 146, "Sh", "sh", "Ch", "ch", "Ng", "ng"};

    private final Character[] characters = {145, 45, 146};

    private final List<Character> allPossibleChars;
    private final static boolean[] allPossibleCharsArr = new boolean[65536];

    public LatinUzAlphabet() {
        for (Character onlyLetter : onlyLetters) {
            onlyLettersArr[onlyLetter] = true;
        }

        List<Character> list = new ArrayList<>();
        list.addAll(Arrays.asList(onlyLetters));
        list.addAll(Arrays.asList(characters));
        for (String combinedLetter : combinedLetters) {
            for (char c : combinedLetter.toCharArray()) {
                list.add(c);
            }
        }
        this.allPossibleChars = List.copyOf(list);
        for (Character allPossibleChar : this.allPossibleChars) {
            allPossibleCharsArr[allPossibleChar]=true;
        }
    }

    @Override
    public boolean checkLetter(Character c) {
        return onlyLettersArr[c];
    }

    @Override
    public boolean checkLetter(String s) {

        if (s.length() == 1) {
            return checkLetter(s.charAt(0));
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

    @Override
    public List<Character> getAllPossibleChars() {

        return this.allPossibleChars;
    }

    public Character[] getOnlyLetters() {
        return onlyLetters;
    }

    public String[] getCombinedLetters() {
        return combinedLetters;
    }

    public Character[] getCharacters() {
        return characters;
    }

    public static boolean[] getAllPossibleCharsArr() {
        return allPossibleCharsArr;
    }
}

