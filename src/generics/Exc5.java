package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*5. Napisz generyczną metodę statyczną, która znajdzie maksymalną wartość w podanym przedziale
        wartości [start, end) w podanej liście. Elementy listy mogą być zarówno Integer, Long, Double oraz
        Float. Start oraz end również mogą być typu Integer, Long, Double oraz Float.*/
public class Exc5 {
        public static void main(String[] args) {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.addAll(List.of(2, 3, 4, 5, 6, 7, 8, 9));
                List list = List.of(2, 3, 3L, 3.25, 5f, 5.5F, 8.2F);

                Number start = 5;
                Number end = 8.5;
                System.out.println(method(arr, start, end));
                System.out.println(method(list, start, end));
//                System.out.println(method2(arr, start, end));
                System.out.println(method2(list, start, end).orElse(0));//odpakowuje optionala
        }

        //method przepuszcza też ArrayList, a method2 tylko List
        private static <N extends Number> Number method(List<? extends Number> arr, N start, N end) {

                Number max = null;

                for (Number number : arr) {
                        if (number.doubleValue() >= start.doubleValue() && number.doubleValue() < end.doubleValue()) {
                                if (max == null) {
                                        max = number;
                                }
                                if (number.doubleValue() > max.doubleValue()) {
                                        max = number;
                                }
                        }
                }
                return max;
        }

        private static <N extends Number> Optional<N> method2(List<N> arr, N start, N end) {

                N max = null;

                for (N number : arr) {
                        if (number.doubleValue() >= start.doubleValue() && number.doubleValue() < end.doubleValue()) {
                                if (max == null) {
                                        max = number;
                                }
                                if (number.doubleValue() > max.doubleValue()) {
                                        max = number;
                                }
                        }
                }
                return Optional.ofNullable(max);
        }

//                        Integer number1 =null;
//                        Double number2 =null;
//                        Float number3 =null;
//                        Long number4 =null;
//                        if (number.getClass().toString().equals("class java.lang.Integer")){
//                                number1 = number.intValue();
//                        };
//                        if (number.getClass().toString().equals("class java.lang.Double")){
//                                number2= number.doubleValue();
//                        };
//                        if (number.getClass().toString().equals("class java.lang.Float")){
//                                number3 = number.floatValue();
//                        };
//                        if (number.getClass().toString().equals("class java.lang.Long")){
//                                number4 = number.longValue();
//                        };

//                        Integer number1 = number.intValue();
//                        System.out.println(number1 +4);
//                        Class<? extends Number> numberName = switchNumber(number);
//                        if(numberName.toString().equals("class java.lang.Integer")){
//                                number = number.intValue();
//                        };
//                        number = numberName.cast(number);
//                        System.out.println(number.getClass());
//                        if(number.getClass().toString().equals("Integer")){
//                                System.out.println(2);
//                        }
//                        number = (numberName) number;

//                        if (numberName instanceof Integer){
//
//                        }
//                        System.out.println(numberName);
//                        System.out.println(number.getClass());
//
//                        System.out.println(number+4);


//        private static Class<? extends Number> switchNumber(Number number) {
////                String numberName="";
//                Class<? extends Number> numberName;
//                if (number instanceof Integer){
////                        numberName = String.valueOf(number.getClass());
//                        numberName = number.getClass();
//                        return numberName;
//                } else if (number instanceof Double) {
////                        numberName = String.valueOf(number.getClass());
//                        numberName = number.getClass();
//                        return numberName;
//                } else if (number instanceof Float) {
////                        numberName = String.valueOf(number.getClass());
//                        numberName = number.getClass();
//                        return numberName;
//                } else if (number instanceof Long) {
////                        numberName = String.valueOf(number.getClass());
//                        numberName = number.getClass();
//                        return numberName;
//                } else {
//                        throw new RuntimeException("invalid number");
//                }
//                if (number instanceof Integer){
//                        number = (Integer) number;
//                        return number;
//                } else if (number instanceof Double) {
//                        number = (Double) number;
//                        return number;
//                } else if (number instanceof Float) {
//                        number = (Float) number;
//                        return number;
//                } else if (number instanceof Long) {
//                        number = (Long) number;
//                        return number;
//                } else {
//                        throw new RuntimeException("invalid number");
//                }

//                Integer integer = number instanceof Integer ? ((Integer) number) : null;
//                if (integer!=null){
//
//                }
//                Double aDouble = number instanceof Double ? ((Double) number) : null;
//                if (aDouble!=null){
//
//                }
//                Float aFloat = number instanceof Float ? ((Float) number) : null;
//                if (aFloat!=null){
//
//                }
//                Long aLong = number instanceof Long ? ((Long) number) : null;
//                if (aLong!=null){
//
//                }

}
