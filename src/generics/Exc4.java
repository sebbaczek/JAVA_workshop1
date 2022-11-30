package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*4. Napisz metodę generyczną, która w podanej tablicy będzie w stanie zamienić ze sobą elementy na
        dwóch podanych pozycjach.*/
public class Exc4 {
        public static void main(String[] args) {
//                int[] arr = {3, 4, 5, 6, 7, 8, 9};
                ArrayList<Integer> arr = new ArrayList<>();
                arr.addAll(List.of(2,3,4,5,6,7,8,9));
                method(arr,2,4);
                System.out.println(arr);
                ArrayList<String> arr2 = new ArrayList<>();
                arr2.addAll(List.of("2","3","4","5","6","7","8","9"));
                method(arr2,2,4);
                System.out.println(arr2);

                String[] arr3 = new String[]{"2","3","4","5","6","7","8"};
               swap(arr3,3,4);
                System.out.println(Arrays.toString(arr3));
        }

        private static <T> void swap(T[] arr3, int pos1, int pos2) {
                if(pos1 > arr3.length || pos2 > arr3.length || pos1 <0 || pos2 <0 || pos2 == pos1){
                        return;
                }
                T tmp = arr3[pos1];
                arr3[pos1] = arr3[pos2];
                arr3[pos2] = tmp;

        }

        private static <E> void method(ArrayList<E> arr, int i1, int i2) {
                for (E e : arr) {
                        if(arr.indexOf(e)==i1){
                                E tmp = arr.get(i1);
                                arr.set(i1,arr.get(i2));
                                arr.set(i2,tmp);
                        }

                }
        }
}
