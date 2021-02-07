package uz.alvasti.lotinkirill;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        char[] a = {'a','b', 'c', 'e','f','j'};
        String s = Arrays.toString(Arrays.copyOfRange(a, 1, 2));
        System.out.println(s);
    }
}
