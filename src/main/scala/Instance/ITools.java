package Instance;

import java.util.ArrayList;
import java.util.Arrays;

public class ITools {
    public static <E> void P(E in) {
        System.out.print(in);
    }

    public static <E> void Pn(E in) {
        System.out.println(in);
    }

    public static void Pn() {
        System.out.println();
    }

    public static <E> void Ps(E in) {
        P(in);
        P(" ");
    }

    public static void Pn(int[] it) {
        P(Arrays.toString(it));
        Pn();
    }

    public static void P(int[] it) {
        P(Arrays.toString(it));
    }

    public static void Pn(int[][] its) {
        for (var t : its) {
            Pn(t);
        }
        Pn();
    }

    public static void Pn(ArrayList<Integer> it) {
        P(it);
        Pn();
    }
}
