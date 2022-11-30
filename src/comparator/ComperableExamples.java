package comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComperableExamples {


        public static void main(String[] args) {
                List <Employee> list1 = new ArrayList<>();

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
                Collections.sort(list); // używa interfejsu Comparable który jest zaimplementowany przez klasę
                // Employee i w niej zdefiniowana jest metoda sortująca
                System.out.println(list);
        }


       static class Employee implements Comparable<Employee> { //interfejs Comparable nie służy do implementacji
                // lambdą choć ma 1 metodę
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
                public int compareTo(Employee o) {   //definicja metody sortującej 2 razy; jeśli zamienimy kolejność
                        // składników w return to będzie malejąca kolejność;
                        int result = this.name.compareTo(o.name);
                        if(result !=0){
                                return result;
                        }
                        return this.age - o.age;
                }
        }
}
