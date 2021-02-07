package uz.alvasti.lotinkirill.utils;

public class CustomArrayUtil {


    public static char[] concatCharArrays(char[]... arrays) {
        int len = arrays.length;
        int newLen = 0;
        for (int i = 0; i < len; i++) {
            newLen += arrays[i].length;
        }

        char[] newArr = new char[newLen];
        int n = 0;
        for (int i = 0; i < len; i++) {
            int l = arrays[i].length;
            for (int j = 0; j <l; j++) {
                newArr[n++] =arrays[i][j];
            }
        }

        return newArr;
    }
}
