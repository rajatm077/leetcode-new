package arena;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        String s = "a1b2";
        char[] chr = s.toCharArray();
        chr[0] = Character.toUpperCase(chr[0]);
        System.out.println(Character.getNumericValue(chr[1]));
//        Character.isAlphabetic()
//        String t = new String(chr);
//        System.out.println(t);
//        for (int i = 0; i < s.length(); i++) {
//            System.out.println(Character.toUpperCase(s.charAt(i)));
//        }



    }
}
