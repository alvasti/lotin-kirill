package uz.alvasti.lotinkirill.alphabet;

import java.util.HashMap;
import java.util.Map;

public class LettersCompatibility {

    private final Character[] lat;
    private final Character[] cyr;
    private final String[] latCom;
    private final Character[] latChar;
    private final Character[] cyrChar;

    private final HashMap<String, String> lh = new HashMap<>();

    private final HashMap<String, String> ch = new HashMap<>();

    private final CyrillicUzAlphabet cyrillicUzAlphabet;
    private final LatinUzAlphabet latinUzAlphabet;

    public LettersCompatibility() {

        this.cyrillicUzAlphabet = new CyrillicUzAlphabet();
        this.latinUzAlphabet = new LatinUzAlphabet();

        this.lat = this.latinUzAlphabet.getOnlyLetters();
        this.cyr = this.cyrillicUzAlphabet.getOnlyLetters();
        this.latCom = this.latinUzAlphabet.getCombinedLetters();
        this.latChar = this.latinUzAlphabet.getCharacters();
        this.cyrChar = this.cyrillicUzAlphabet.getCharacters();
        build();
    }

    private void build() {

        int l, c;
        //tutuq
        l = 0;
        c = 0;
        lh.put(asString(latChar[l]), asString(cyrChar[c]));

        //A
        l = 0;
        c = 0;
        lh.put(asString(lat[l]), asString(cyr[c]));
        l = 1;
        c = 1;
        lh.put(asString(lat[l]), asString(cyr[c]));

        //B
        l = 2;
        c = 2;
        lh.put(asString(lat[l]), asString(cyr[c]));
        l = 3;
        c = 3;
        lh.put(asString(lat[l]), asString(cyr[c]));

        //D
        l = 4;
        c = 4;
        lh.put(asString(lat[l]), asString(cyr[c]));
        l = 5;
        c = 5;
        lh.put(asString(lat[l]), asString(cyr[c]));

        //Е kirill
        l = 6;
        c = 8;
        lh.put(asString(lat[44] + "" +
                lat[l]), asString(cyr[c]));
        l = 7;
        c = 9;
        lh.put(asString(lat[45] + "" +
                lat[l]), asString(cyr[c]));

        //F
        l = 8;
        c = 10;
        lh.put(asString(lat[l]), asString(cyr[c]));
        l = 9;
        c = 11;
        lh.put(asString(lat[l]), asString(cyr[c]));
        //G
        l = 10;
        c = 12;
        lh.put(asString(lat[l]), asString(cyr[c]));
        l = 11;
        c = 13;
        lh.put(asString(lat[l]), asString(cyr[c]));
        //H
        l = 12;
        c = 14;
        lh.put(asString(lat[l]), asString(cyr[c]));
        l = 13;
        c = 15;
        lh.put(asString(lat[l]), asString(cyr[c]));
        //I
        l = 14;
        c = 16;
        lh.put(asString(lat[l]), asString(cyr[c]));
        l = 15;
        c = 17;
        lh.put(asString(lat[l]), asString(cyr[c]));
        //J
        l = 16;
        c = 18;
        lh.put(asString(lat[l]), asString(cyr[c]));
        l = 17;
        c = 19;
        lh.put(asString(lat[l]), asString(cyr[c]));
        //K
        l = 18;
        c = 20;
        lh.put(asString(lat[l]), asString(cyr[c]));
        l = 19;
        c = 21;
        lh.put(asString(lat[l]), asString(cyr[c]));
        //L
        l = 20;
        c = 22;
        lh.put(asString(lat[l]), asString(cyr[c]));
        l = 21;
        c = 23;
        lh.put(asString(lat[l]), asString(cyr[c]));
        //M
        l = 22;
        c = 24;
        lh.put(asString(lat[l]), asString(cyr[c]));
        l = 23;
        c = 25;
        lh.put(asString(lat[l]), asString(cyr[c]));
        //N
        l = 24;
        c = 26;
        lh.put(asString(lat[l]), asString(cyr[c]));
        l = 25;
        c = 27;
        lh.put(asString(lat[l]), asString(cyr[c]));
        //O
        l = 26;
        c = 28;
        lh.put(asString(lat[l]), asString(cyr[c]));
        l = 27;
        c = 29;
        lh.put(asString(lat[l]), asString(cyr[c]));
        //P
        l = 28;
        c = 30;
        lh.put(asString(lat[l]), asString(cyr[c]));
        l = 29;
        c = 31;
        lh.put(asString(lat[l]), asString(cyr[c]));
        //Q
        l = 30;
        c = 32;
        lh.put(asString(lat[l]), asString(cyr[c]));
        l = 31;
        c = 33;
        lh.put(asString(lat[l]), asString(cyr[c]));
        //R
        l = 32;
        c = 34;
        lh.put(asString(lat[l]), asString(cyr[c]));
        l = 33;
        c = 35;
        lh.put(asString(lat[l]), asString(cyr[c]));
        //S
        l = 34;
        c = 36;
        lh.put(asString(lat[l]), asString(cyr[c]));
        l = 35;
        c = 37;
        lh.put(asString(lat[l]), asString(cyr[c]));
        //T
        l = 36;
        c = 38;
        lh.put(asString(lat[l]), asString(cyr[c]));
        l = 37;
        c = 39;
        lh.put(asString(lat[l]), asString(cyr[c]));
        //U
        l = 38;
        c = 40;
        lh.put(asString(lat[l]), asString(cyr[c]));
        l = 39;
        c = 41;
        lh.put(asString(lat[l]), asString(cyr[c]));
        //V
        l = 40;
        c = 42;
        lh.put(asString(lat[l]), asString(cyr[c]));
        l = 41;
        c = 43;
        lh.put(asString(lat[l]), asString(cyr[c]));
        //X
        l = 42;
        c = 44;
        lh.put(asString(lat[l]), asString(cyr[c]));
        l = 43;
        c = 45;
        lh.put(asString(lat[l]), asString(cyr[c]));
        //Y
        l = 44;
        c = 46;
        lh.put(asString(lat[l]), asString(cyr[c]));
        l = 45;
        c = 47;
        lh.put(asString(lat[l]), asString(cyr[c]));
        //Z
        l = 46;
        c = 48;
        lh.put(asString(lat[l]), asString(cyr[c]));
        l = 47;
        c = 49;
        lh.put(asString(lat[l]), asString(cyr[c]));


        //        Ў
        l = 0;
        c = 50;
        lh.put(asString(latCom[l]), asString(cyr[c]));
        l = 1;
        c = 51;
        lh.put(asString(latCom[l]), asString(cyr[c]));
        //        Ғ
        l = 2;
        c = 52;
        lh.put(asString(latCom[l]), asString(cyr[c]));
        l = 3;
        c = 53;
        lh.put(asString(latCom[l]), asString(cyr[c]));
        //        Ш
        l = 4;
        c = 54;
        lh.put(asString(latCom[l]), asString(cyr[c]));
        l = 5;
        c = 55;
        lh.put(asString(latCom[l]), asString(cyr[c]));
        //        Ч
        l = 6;
        c = 56;
        lh.put(asString(latCom[l]), asString(cyr[c]));
        l = 7;
        c = 57;
        lh.put(asString(latCom[l]), asString(cyr[c]));

        int l1;
        //Ц
        l = 36;
        l1 = 34;
        c = 58;
        lh.put(asString(lat[l]) + asString(lat[l1]), asString(cyr[c]));
        l = 37;
        l1 = 34;
        c = 59;
        lh.put(asString(lat[l]) + asString(lat[l1]), asString(cyr[c]));

        //ь  Ь
        c = 2;
        lh.put("", asString(cyrChar[c]));
        c = 3;
        lh.put("", asString(cyrChar[c]));

        //Ё
        l = 44;
        l1 = 27;
        c = 60;
        lh.put(asString(lat[l]) + asString(lat[l1]), asString(cyr[c]));
        l = 45;
        l1 = 27;
        c = 61;
        lh.put(asString(lat[l]) + asString(lat[l1]), asString(cyr[c]));

        //Ю
        l = 44;
        l1 = 39;
        c = 62;
        lh.put(asString(lat[l]) + asString(lat[l1]), asString(cyr[c]));
        l = 45;
        l1 = 39;
        c = 63;
        lh.put(asString(lat[l]) + asString(lat[l1]), asString(cyr[c]));

        //Я
        l = 44;
        l1 = 1;
        c = 64;
        lh.put(asString(lat[l]) + asString(lat[l1]), asString(cyr[c]));
        l = 45;
        l1 = 1;
        c = 65;
        lh.put(asString(lat[l]) + asString(lat[l1]), asString(cyr[c]));


        for (Map.Entry<String, String> entry : lh.entrySet()) {
            ch.put(entry.getValue(), entry.getKey());
        }

        //Э cry
        l = 6;
        c = 6;

        ch.put(asString(cyr[c]), asString(lat[l]));
        l = 7;
        c = 7;
        ch.put(asString(cyr[c]), asString(lat[l]));

        //Ъ ga o'zbek tilida bir xil moslik , so'zni upper case ga tekshirib tarjima qilingan so'zni qaytib Uppercase o'tkkaziladi
        c = 0;
        l = 0;
        ch.put(asString(cyrChar[c]), asString(latChar[l]));
        c = 1;
        l = 0;
        ch.put(asString(cyrChar[c]), asString(latChar[l]));


        //ь ga o'zbek tilida bir xil moslik , so'zni upper case ga tekshirib tarjima qilingan so'zni qaytib Uppercase o'tkkaziladi
        c = 2;
        ch.put(asString(cyrChar[c]), "");
        c = 3;
        ch.put(asString(cyrChar[c]), "");

    }


    private String asString(char c) {
        return c + "";
    }

    private String asString(String s) {
        return s;
    }

    /**
     * @param letter cyrillic letter only
     * @return latin letter
     */
    public String toLatin(String letter) {
        return ch.get(letter);
    }

    public String toLatin(Character letter) {
        return toLatin(asString(letter));
    }

    /**
     * @param letter latin letter only
     * @return cyrillic letter
     */
    public String toCyrillic(String letter) {
        return lh.get(letter);
    }

    public boolean[] getOnlyLettersArrCyrillic() {
        return cyrillicUzAlphabet.getOnlyLettersArr();
    }

    public Character[] getCyrChar() {
        return cyrChar;
    }

}
