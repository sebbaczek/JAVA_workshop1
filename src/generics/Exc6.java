package generics;

import java.awt.print.Book;
import java.util.*;

//6. Napisz klasę reprezentującą stos różnego rodzaju przedmiotów, np. Książki, Gazety i Smartfony
//        (jednocześnie). Spróbuj zakodować tę klasę przy wykorzystaniu mechanizmu generyków, a
//        następnie zastanów się jak mogłaby wyglądać bez ich użycia. Zwróć Optional celem pokazania, że na
//        tym stosie może nie być żadnych elementów.
public class Exc6 {
        public static void main(String[] args) {
//                LinkedList<T,U,Z> stack = new LinkedList<T,U,Z>();
//                LinkedList stack = new LinkedList<>();
//                method(stack);
                Stack<Item> stack = new Stack<>();
                Cat cat = new Cat("miau");
                Dog dog = new Dog("hau");
                Fox fox = new Fox("wow");
                stack.add(cat);
                stack.add(dog);
                stack.add(fox);
                System.out.println(stack);

        }

        interface Item {

        }

        ;

        static class Stack<T extends Item> {
                private final List<T> stack = new ArrayList<>();
                public void add(T el){
                        stack.add(el);
                }
                public Optional<T> get(){   //ściąganie ze stosu
                        int size = stack.size();
                        if (size>0){
                                return Optional.ofNullable(stack.remove(size-1));
                        }
                        return Optional.empty();
                }

                @Override
                public String toString() {
                        return "Stack{" +
                                "stack=" + stack +
                                '}';
                }
        }

        private static class Fox implements Item {
                String name = "fox";

                public Fox(String name) {
                        this.name = name;
                }

                @Override
                public String toString() {
                        return "Fox{" +
                                "name='" + name + '\'' +
                                '}';
                }
        }

        private static class Dog implements Item {
                String name = "dog";

                public Dog(String name) {
                        this.name = name;
                }

                @Override
                public String toString() {
                        return "Dog{" +
                                "name='" + name + '\'' +
                                '}';
                }
        }

        private static class Cat implements Item {
                String name = "cat";

                public Cat(String name) {
                        this.name = name;
                }

                @Override
                public String toString() {
                        return "Cat{" +
                                "name='" + name + '\'' +
                                '}';
                }

        }
}
