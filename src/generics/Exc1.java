package generics;/*1. Jak będzie wyglądał poniższy kod po dokonaniu Type Erasure?
public static <T extends List<T>> int method(T[] arg1, T arg2) {
        return 0;
        }*/

import java.util.ArrayList;
import java.util.List;

public class Exc1 {
        public static  int method(List[] arg1, List arg2) {
                return 0;
        }


}
