package comparator;


import java.util.*;

public class ComperatorExamples {
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
//                Collections.sort(list); //działa tylko na stringach, natural ordered
                Comparator<String> compStrings = Comparator.naturalOrder();
                Comparator<String> compStrings2 = compStrings.reversed();
                Comparator<String> compStrings3 = Comparator.<String>naturalOrder().reversed();
                ;


                //sposób implementacji za pomocą klasy anonimowej przypisanej do zmiennej comparator1
                Comparator<Employee> comparator1 = new Comparator<Employee>() {
                        @Override
                        public int compare(Employee o1, Employee o2) {
                                return o1.age - o2.age; // kolejność rosnąca
//                                return o2.age - o1.age; // kolejność malejąca
                        }
                }. thenComparing(new Comparator<Employee>() {  // dodanie drugiego porównania
                                @Override
                                public int compare(Employee o1, Employee o2) {
                                        return o1.salary - o2.salary;

                        }

                });
                Comparator<Employee> comparator2 = new Comparator<>() {
                        @Override
                        public int compare(Employee o1, Employee o2) {
                                return o1.name.compareTo(o2.name); // kolejność rosnąca na Stringach - metoda compareTo
                        }

                };
                Comparator<Employee> comparator3 = new Comparator<>() {
                        @Override
                        public int compare(Employee o1, Employee o2) {
                                int result = o1.name.compareTo(o2.name);
                                if (result != 0){return result;}
                                return o1.salary-o2.salary; // dodanie drugiego warunku jak w pierwszym jest 0 - są
                                // równe
                        }

                };

                Comparator<Employee> comparator4 = (o1,o2)-> o1.getName().compareTo(o2.getName()); //metoda definicja
                // comparatora lambdą
                comparator4 = comparator4.thenComparing((o1,o2)-> o1.getAge()-o2.getAge());

                Comparator<Employee> comparator5 = Comparator.comparing(Employee::getName);
                comparator5 = comparator5.thenComparing(Comparator.comparingInt(Employee::getAge));

                Comparator<Employee> comparator6 = Comparator.comparing(employee -> employee.getName());
                comparator6 = comparator6.thenComparing(Comparator.comparingInt(employee -> employee.getAge()));

                Comparator<Employee> comparator7;
                comparator7 = Comparator.<Employee, String>comparing(employee1 -> employee1.getName())
                        .thenComparing(Comparator.comparingInt(employee -> employee.getAge()));




                System.out.println(list);

                list.sort(comparator1); //użycie comparator1
                list.sort(comparator2.reversed()); //użycie comparator2 reversed
                System.out.println(list);
        }

        static class Employee {
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
        }
}
