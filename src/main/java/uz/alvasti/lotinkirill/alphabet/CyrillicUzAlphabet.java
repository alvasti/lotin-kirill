package uz.alvasti.lotinkirill.alphabet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CyrillicUzAlphabet implements Alphabet {

    private final Character[] onlyLetters = {'А','а','Б','б','Д','д','Э','э','Е','е','Ф','ф','Г','г','Ҳ','ҳ','И','и','Ж','ж','К','к','Л','л','М','м','Н','н','О','о','П','п','Қ','қ','Р','р','С','с','Т','т','У','у','В','в','Х','х','Й','й','З','з','Ў','ў','Ғ','ғ','Ш','ш','Ч','ч','Ц','ц'};

    private final boolean[] onlyLettersArr = new boolean[1100];

    /*
     Нг нг
     bu birikma n va g ko'rinishida bo'la olgani tufayli qo'shilmadi
     */
    private final String[] combinedLetters = {};

    private final Character[] characters = {'ъ' , 'Ъ', '-' };

    private final List<Character> allPossibleChars;

    private final boolean[] allPossibleCharsArr = new boolean[65536];

    public CyrillicUzAlphabet() {

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
            this.allPossibleCharsArr[allPossibleChar]=true;
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

    public boolean[] getAllPossibleCharsArr() {
        return allPossibleCharsArr;
    }
}
/*
"А а\n" +
"Б б\n" +
"Д д\n" +
"Э э / Е е\n" +
"Ф ф\n" +
"Г г\n" +
"Ҳ ҳ\n" +
"И и\n" +
"Ж ж\n" +
"К к\n" +
"Л л\n" +
"М м\n" +
"Н н\n" +
"О о\n" +
"П п\n" +
"Қ қ\n" +
"Р р\n" +
"С с\n" +
"Т т\n" +
"У у\n" +
"В в\n" +
"Х х\n" +
"Й й\n" +
"З з\n" +
"Ў ў\n" +
"Ғ ғ\n" +
"Ш ш\n" +
"Ч ч\n" +
"Ц ц\n";
 */