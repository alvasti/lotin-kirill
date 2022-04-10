package uz.alvasti.lotinkirill.wordtranslator;

public class Grammar {

    private final Character[] someVowels = {'А', 'а', 'Е', 'е', 'О', 'о', 'У', 'у'};

    private final boolean[] someVowelsArr = new boolean[65536];

    public Grammar() {

        for (int i = 0; i < someVowels.length; i++) {
            someVowelsArr[someVowels[i]] = true;
        }
    }

    public String cyrillicE3wordsCorrector(int beforeCyrillicCharacter, String cyrillicCharacter) {

        if (cyrillicCharacter.isEmpty()) {
            return cyrillicCharacter;
        }

        //rule one
        //В начале слов э и е пишутся в соответствии с произношением


        int c = cyrillicCharacter.charAt(0);


        if (c == 1069 || c == 1101) {

            //rule two
            //После гласных (кроме и) пишется преимущественно
            //'А', 'а', 'Е', 'е', 'О', 'о', 'У', 'у'
            if (!someVowelsArr[beforeCyrillicCharacter]) {
                if (c == 1069) {
                    c = 1045;
                }
                if (c == 1101) {
                    c = 1077;
                }
            }

        }


        return ((char) c) + "";
    }
}
