package comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//1. Stwórz klasę Employee, która będzie zawierała pola takie jak, imię, nazwisko, wiek oraz wypłata.
//        Stwórz 10 takich pracowników i dodaj ich do listy. Zaimplementuj metodę compareTo(), która
//        posortuje pracowników odpowiednio po: imieniu rosnąco, nazwisku malejąco, wieku rosnąco,
//        wypłacie malejąco. Następnie zaimplementuj Comparator, który posortuje pracowników
//        odpowiednio po: imieniu malejąco, nazwisku malejąco, wieku rosnąco, wypłacie rosnąco. Na koniec
//        zaimplementuj Comparator, który posortuje pracowników w kolejności odwrotnej niż poprzedni
//        komparator.
public class Exc1 {
        public static void main(String[] args) {


                List list = Arrays.asList(
                        new Employee("Marek", "Kapa", 25, 1300),
                        new Employee("Darek", "Kapa", 95, 1430),
                        new Employee("Darek", "Kapa", 25, 1300),
                        new Employee("Farek", "Capa", 25, 1330),
                        new Employee("Sarek", "Kapa", 24, 1300),
                        new Employee("Arek", "Kapa", 23, 1340),
                        new Employee("Karek", "Kapa", 15, 1300),
                        new Employee("Larek", "Tapa", 55, 3300),
                        new Employee("Barek", "Papa", 75, 1300),
                        new Employee("Warek", "Lapa", 25, 13030)
                );
                Collections.sort(list);
                System.out.println(list);

                Comparator<Employee>comparator1 =  (o1,o2)-> o2.getName().compareTo(o1.getName());
                comparator1 = comparator1.thenComparing((o1,o2)-> o2.getSurname().compareTo(o1.getSurname()));
                comparator1 = comparator1.thenComparing(Comparator.comparingInt(employee1 -> employee1.getAge()));
                comparator1 = comparator1.thenComparing(Comparator.comparingInt(employee -> employee.getSalary()));

                list.sort(comparator1);
                System.out.println(list);
                list.sort(comparator1.reversed());
                System.out.println(list);
        }

        static class Employee implements Comparable<Employee> {
                private String name;
                private String surname;
                private int age;
                private int salary;

                public Employee(String name, String surname, int age, int salary) {
                        this.name = name;
                        this.surname = surname;
                        this.age = age;
                        this.salary = salary;
                }

                public String getName() {
                        return name;
                }

                public String getSurname() {
                        return surname;
                }

                public int getAge() {
                        return age;
                }

                public int getSalary() {
                        return salary;
                }

                @Override
                public String toString() {
                        return "Employee{" +
                                "name='" + name + '\'' +
                                ", surname='" + surname + '\'' +
                                ", age=" + age +
                                ", salary=" + salary +
                                '}';
                }

                @Override
                public int compareTo(Employee o) {
                        int result = this.name.compareTo(o.name);
                        if(result !=0){
                                return result;
                        }
                        int result2 = o.surname.compareTo(this.surname);
                        if(result2 !=0){
                                return result2;
                        }
                        int result3 = this.age - o.age;
                        if(result3 !=0){
                                return result3;
                        }
                        return o.salary-this.salary;
                }
        }
}
