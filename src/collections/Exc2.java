package collections;
//2. Napisz implementację książki telefonicznej, która umożliwi wprowadzenie przez użytkownika osoby
//        wraz z numerem telefonu, w sposób pokazany poniżej:
//        • Jan Kowalski +48000192871
//        • Stefan Nawrocki +48000125847
//        • Anna Tomaszewska +48000421458
//        Dodaj te osoby do Mapy w taki sposób, żeby kluczem było nazwisko, a wartością zbiór osób
//        występujących pod takim nazwiskiem, posortowanych w kolejności nazwisko, a potem imię. Po każdej
//        dodanej osobie, wyświetl zawartość mapy na ekranie. Spraw, żeby osoby były posortowane w książce po
//        nazwisku. Dla uproszczenia załóż, że osoby mogą mieć tylko jedno imię i tylko jedno nazwisko.


import java.util.*;

public class Exc2 {
        public static void main(String[] args) {
                List<Person> list = List.of(

                new Person("Marek", "Marecki", +5550),
                new Person("Darek", "Darecki", +5650),
                new Person("Barek", "Barecki", +2550),
                new Person("Marek", "Barecki", +5550),
                new Person("Barek", "Marecki", +1550),
                new Person("Marek", "Darecki", +5550),
                new Person("Darek", "Darecki", +5550),
                new Person("Marek", "Darecki", +5550)
        );
//               Set<Person> surnames = new TreeSet<>();
                Map<String,List<Person>> map = new TreeMap<>();

                for (Person p : list) {
                        List <Person> surnames;
                        if(!map.containsKey(p.surname)){
                                surnames = new ArrayList();

                        } else {
                                surnames= map.get(p.getSurname());
                        }
                        surnames.add(p);
                        surnames.sort(Comparator.comparing(Person::getSurname));
                        surnames.sort(Comparator.comparing(Person::getName));
                        map.put(p.surname,surnames);
                        for (Map.Entry<String, List<Person>> entry : map.entrySet()) {
                                System.out.println(entry);
                        }
                        System.out.println("###");
                }

                           
               
               
//                map1.put(p1.getSurname(),p1);
//                System.out.println(map1);
//                map1.put(p2.getSurname(),p2);
//                System.out.println(map1);
//                map1.put(p3.getSurname(),p3);
//                System.out.println(map1);
//                map1.put(p4.getSurname(),p4);
//                System.out.println(map1);
//                map1.put(p5.getSurname(),p5);
//                System.out.println(map1);
//                map1.put(p6.getSurname(),p6);
//                System.out.println(map1);
//                map1.put(p7.getSurname(),p7);
//                System.out.println(map1);
//                map1.put(p8.getSurname(),p8);
//                System.out.println(map1);

        }

        private static class Person {
                private String name;
                private String surname;
                private int number;

                public String getName() {
                        return name;
                }

                public String getSurname() {
                        return surname;
                }

                public int getNumber() {
                        return number;
                }

                public Person(String name, String surname, int number) {
                        this.name = name;
                        this.surname = surname;
                        this.number = number;
                }

                @Override
                public String toString() {
                        return "Person{" +
                                "name='" + name + '\'' +
                                ", surname='" + surname + '\'' +
                                ", number=" + number +
                                '}';
                }

//                @Override
//                public int compareTo(Person o) {
//                        return 0;
//                }

//                @Override
//                public int compareTo(Person o) {
//                        Comparator<Person> comp1 = Comparator.comparing(o1->o1.name);
//                        Comparator<Person> comp2 = comp1.thenComparing(Comparator.comparing(o1->o1.surname));
//                        return comp2.compare(this,o);
//                }
        }
}
