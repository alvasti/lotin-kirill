package uz.alvasti.lotinkirill.alphabet;

public class LatinUzAlphabet implements Alphabet {

    private final Character[] onlyLetters = {'A', 'a', 'B', 'b', 'D', 'd', 'E', 'e', 'F', 'f', 'G', 'g', 'H', 'h', 'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', 'M', 'm', 'N', 'n', 'O', 'o', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't', 'U', 'u', 'V', 'v', 'X', 'x', 'Y', 'y', 'Z', 'z'};

    protected final boolean[] onlyLettersArr = new boolean[150];

    /*
     146 -  o' ning belgisi
     145 - tutuq belgisi
     */
                                                //0         1           2       3           4   5       6    7      8   9
    private final String[] combinedLetters = {"O" + 146, "o" + 146, "G" + 146, "g" + 146, "Sh", "sh", "Ch", "ch", "Ng", "ng"};

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

    public Character[] getOnlyLetters() {
        return onlyLetters;
    }

    public String[] getCombinedLetters() {
        return combinedLetters;
    }

    public Character[] getCharacters() {
        return characters;
    }
}

