package collections;
//1. Wyobraź sobie, że idziesz do muzeum motoryzacji i wypisujesz sobie samochody, które chcesz tam
//        zobaczyć. Wypisujesz informacje takie jak: marka, model oraz rocznik. Idziesz tam z inną osobą i ona też
//        wypisuje swoje. Przedstaw to co napisaliście w postaci 2 list zawierających obiekty klasy Car. Klasa Car
//        ma posiadać pola brand, model oraz year. Następnie sklej ze sobą te 2 listy, tak aby wyeliminować
//        powtarzające się samochody, które dodaliście i przedstaw zawartość na ekranie posortowaną najpierw
//        po roku rosnąco, potem po marce rosnąco oraz po modelu rosnąco. Załóżmy, że taka byłaby kolejność
//        oglądania eksponatów w muzeum

import comparator.ComperatorExamples;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class Exc1 {
        public static void main(String[] args) {

               List<Car> list1 = new ArrayList();
               List<Car> list2 = new ArrayList();

               list1.add(new Car("fiat","125",1999));
               list1.add(new Car("fiat","126",1998));
               list1.add(new Car("fiat","500",1999));
               list1.add(new Car("opel","vectra",1999));
               list1.add(new Car("opel","vectra",1998));
               list1.add(new Car("opel","corsa",1999));

                list2.add(new Car("fiat","125",1999));
                list2.add(new Car("fiat","126",1998));
                list2.add(new Car("fiat","panda",1999));
                list2.add(new Car("opel","vectra",1998));
                list2.add(new Car("opel","astra",1998));
                list2.add(new Car("opel","corsa",1999));

//                System.out.println(list1);
//                System.out.println(list2);

//                TreeSet<Car> list3 = new TreeSet<>(Comparator.comparing(o -> o.model));
//                Set<Car> list3 = new LinkedHashSet<>();

//                Comparator<Car>comp1 = Comparator.comparingInt(o -> o.year);
//                Set<Car> list3 = new TreeSet<>( Comparator.comparing((o1)-> o1.model));
//                Set<Car> list3 = new HashSet<>();
//
//                list3.addAll(list1);
//                list3.addAll(list2);

                TreeSet<Car> list3 = new TreeSet<>();

                list3.addAll(list1);
                list3.addAll(list2);
//                for (Car car : list1) {
//                        list3.add(car);
//                }
//////                System.out.println(list3);
//                for (Car car : list2) {
//                        list3.add(car);
//                }

                System.out.println(list3);
//                Comparator<Car>comp1 = Comparator.comparingInt(o -> o.year);



        }

        private static class Car implements Comparable<Car>  {
                private String brand;
                private String model;
                private int year;

                public Car(String brand, String model, int year) {
                        this.brand = brand;
                        this.model = model;
                        this.year = year;
                }

                @Override
                public boolean equals(Object o) {
                        if (this == o) return true;
                        if (o == null || getClass() != o.getClass()) return false;

                        Car car = (Car) o;

                        if (year != car.year) return false;
                        if (!Objects.equals(brand, car.brand)) return false;
                        return Objects.equals(model, car.model);
                }

                @Override
                public int hashCode() {
                        int result = brand != null ? brand.hashCode() : 0;
                        result = 31 * result + (model != null ? model.hashCode() : 0);
                        result = 31 * result + year;
                        return result;
                }

                @Override
                public String toString() {
                        return "Car{" +
                                "brand='" + brand + '\'' +
                                ", model='" + model + '\'' +
                                ", year=" + year +
                                '}';
                }


                @Override
                public int compareTo(Car o) {
/*                        int result = this.brand.compareTo(o.brand);
                if(this.year !=o.year) return this.year-o.year;
                if(result !=0) return result;
                return this.model.compareTo(o.model);*/


//                        Comparator<Car> comp1 = (Comparator.comparingInt(o2 -> o2.year));
//                        Comparator<Car> comp2 = comp1.thenComparing(Comparator.comparing(o2 -> o2.brand));
//                        Comparator<Car> comp3 = comp2.thenComparing(Comparator.comparing(o2 -> o2.model));
//                        return comp3.compare(this, o);

                        return (Comparator.<Car>comparingInt(c -> c.year))
                                .thenComparing(c -> c.brand)
                                .thenComparing(c -> c.model)
                                .compare(this, o);
                }
        }
}
