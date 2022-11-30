package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

//3. Napisz metodę generyczną, która zliczy ilość elementów w kolekcji, które mają w sobie coś
//        charakterystycznego, np. liczby są nieparzyste, podane wyrazy są palindromami. Wykorzystaj
//        predykat.
public class Exc3 {
        public static void main(String[] args) {

                ArrayList<Integer> list = new ArrayList<>();
                list.add(2);
                list.add(3);
                list.add(4);
                list.add(5);
                list.add(6);
                list.add(7);
                list.add(8);
                list.add(9);
                list.add(5);
                list.add(6);
                list.add(7);
                list.add(8);
                list.add(9);
                ArrayList<Integer> list2 = new ArrayList<>();
                list2.addAll(List.of(2,3,4,5,6,7,8,9,11,13,2));

                System.out.println(method(list));
                System.out.println(method(list2));

                System.out.println(method2(list, n -> n%2 != 0)); //definicja predykatu w wywołaniu

        }

        private static <N> int method2(Collection<N> list, Predicate<N> predicate) {  // implementacja predykatu w
                // metodzie
                int sum=  0;
                for (N n : list) {
                        if(predicate.test(n)){
                                sum++;
                        }
                }
                return sum;
        }

        public static <N> Integer method(ArrayList<N> list) {
                int sum = 0;
                for ( N n : list) {
                        if ((Integer)n%2==0){
                                sum++;
                        }
                }
                return sum;
        }
}
