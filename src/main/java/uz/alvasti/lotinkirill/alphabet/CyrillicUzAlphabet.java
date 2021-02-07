package uz.alvasti.lotinkirill.alphabet;

public class CyrillicUzAlphabet implements Alphabet {

    private final Character[] onlyLetters = {'А','а','Б','б','Д','д','Э','э','Е','е','Ф','ф','Г','г','Ҳ','ҳ','И','и','Ж','ж','К','к','Л','л','М','м','Н','н','О','о','П','п','Қ','қ','Р','р','С','с','Т','т','У','у','В','в','Х','х','Й','й','З','з','Ў','ў','Ғ','ғ','Ш','ш','Ч','ч','Ц','ц'};

    private final boolean[] onlyLettersArr = new boolean[1100];

    /*
     Нг нг
     bu birikma n va g ko'rinishida bo'la olgani tufayli qo'shilmadi
     */
    private final String[] combinedLetters = {};

    private final Character[] characters = {'ъ' , 'Ъ', '-' };

    public CyrillicUzAlphabet() {

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