package uz.alvasti.lotinkirill.utils;

public class CustomArrayUtil {


    public static char[] concatCharArrays(char[]... arrays) {
        int newLen = 0;
        for (char[] array : arrays) {
            newLen += array.length;
        }

        char[] newArr = new char[newLen];
        int n = 0;
        for (char[] array : arrays) {
            for (char c : array) {
                newArr[n++] = c;
            }
        }

        return newArr;
    }
}
