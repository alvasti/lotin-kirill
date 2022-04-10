package uz.alvasti.lotinkirill.wordtranslator;

import uz.alvasti.lotinkirill.alphabet.CyrillicUzAlphabet;
import uz.alvasti.lotinkirill.alphabet.LatinUzAlphabet;
import uz.alvasti.lotinkirill.alphabet.LatinWordCorrector;

import java.util.ArrayList;
import java.util.List;

public class TextSeparatorToWord {

    private final boolean[] wordPossibleChars = new boolean[65536];

    public TextSeparatorToWord() {
        List<Character> characters = new ArrayList<>();
        characters.addAll(new CyrillicUzAlphabet().getAllPossibleChars());
        characters.addAll(new LatinUzAlphabet().getAllPossibleChars());
        characters.addAll(new LatinWordCorrector().getTutuqAndO_G_Variants());
        for (Character character : characters) {
            wordPossibleChars[character] = true;
        }
    }

    public List<FragmentText> splitText(String text) {

        List<FragmentText> fragmentTextList = new ArrayList<>();

        text = text + "!";
        var textChars = text.toCharArray();

        StringBuilder wordBuilder = new StringBuilder("");

        for (char textChar : textChars) {
            if (wordPossibleChars[textChar]) {
                wordBuilder.append(textChar);
            } else {
                if (wordBuilder.length() > 0) {
                    fragmentTextList.add(new FragmentText(true, new Word(wordBuilder.toString())));
                    wordBuilder = new StringBuilder("");
                }
                fragmentTextList.add(new FragmentText(false, new Word(textChar + "")));
            }
        }
        fragmentTextList.remove(fragmentTextList.size() - 1);

        return fragmentTextList;
    }

}
