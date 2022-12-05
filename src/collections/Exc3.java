package collections;
/*3.Napisz program, w którym stworzysz klasę Invoice, zawierającą pola id oraz amount. Wykorzystaj klasę
        Scanner do odczytu danych od użytkownika (wiem, że jeszcze jej nie omawialiśmy, w internecie
        znajdziesz dużo przykładów). Pozwól użytkownikom dodawać faktury, które będą odkładane na stosie
        do przetworzenia. W swoim programie zdefiniuj 2 osoby, jedną która będzie faktury dodawała (Prezes -
        CEO) oraz drugą która będzie te faktury przetwarzała (Księgowy - ACCOUNTANT). CEO korzystając z tego
        programu może dodać nową fakturę, a księgowy fakturę już istniejącą przetworzyć i zdjąć ze stosu.
        Księgowy może zdjąć i przetworzyć tylko pierwszą fakturę z góry stosu. Z racji, że program będzie
        przyjmował od użytkownika komendy tekstowe, musimy ustalić na jakie zachowania ma reagować.
        Załóżmy zatem, że jeżeli wpiszemy:
        Spis treści
        Zadanie 1 . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 1
        Zadanie 2 . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 1
        Zadanie 3 . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 1
        | 1
        • "CEO: ADD INVOICE(190.20)" - oznacza to, że CEO dodaje fakturę na kwotę 190.20 i trafia ona na stos
        do rozliczenia. Identyfikator faktury to może być np. 1/2020, gdzie 1 jest counterem dodawanym
        automatycznie przez program, natomiast rok jest dodawany automatycznie na podstawie obecnego
        roku.
        • "ACCOUNTANT: PROCESS INVOICE" - oznacza to, że księgowy rozlicza fakturę z identyfikatorem
        1/2020 i zostaje ona zdjęta ze stosu do rozliczania.
        Jeżeli program nie rozpoznaje komendy, ma wypisać na ekranie: "O co Ci chodzi?". Zapewnij, aby przy
        każdym kroku na ekranie drukowała się zawartość stosu wraz z sumą kwot faktur jeszcze
        nierozliczonych. Nie narzucam obsługi przypadków skrajnych, czyli np, jak ma się zachować księgowy
        jak wpiszemy mu komendę "rozlicz fakturę", a nie ma żadnych faktur. Pozwalam Ci wymyślić co zrobić
        w takich sytuacjach ὠ. Przykład danych wejściowych:
        CEO: ADD INVOICE(19.20)
        CEO: ADD INVOICE(31.40)
        ACCOUNTANT: PROCESS INVOICE
        CEO: ADD INVOICE(21.20)
        CEO: ADD INVOICE(120.99)
        ACCOUNTANT: PROCESS INVOICE
        ACCOUNTANT: PROCESS INVOICE
        ACCOUNTANT: PROCESS INVOICE*/

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Exc3 {
        InvoiceStack invoiceStack = new InvoiceStack();




        public static void main(String[] args) {
//                Invoice invoice = new Invoice();
                InvoiceStack stack= new InvoiceStack();


                List<String> commands = List.of(
                        "CEO: ADD INVOICE(19.20)",
                        "CEO: ADD INVOICE(31.40)",
                        "ACCOUNTANT: PROCESS INVOICE",
                        "CEO: ADD INVOICE(21.20)",
                        "CEO: ADD INVOICE(120.99)",
                        "ACCOUNTANT: PROCESS INVOICE",
                        "ACCOUNTANT: PROCESS INVOICE",
                        "ACCOUNTANT: PROCESS INVOICE"
                );
                for (String command : commands) {
                        stack.processInput(command);
                }

               Scanner scanner = new Scanner(System.in); //wprowadzanie poleceń w konsoli

                System.out.println("Provide new invoice by entering \"CEO: ADD INVOICE(amount)\" \"or process invoice by entering \\\"ACCOUNTANT: PROCESS INVOICE\\\"\"");
                while (scanner.hasNext()){
                        String command = scanner.nextLine();
                        if("EXIT".equals(command)){
                                break;
                        }
                        stack.processInput(command);
                }
        }

        static class Invoice {
                Integer id;
                BigDecimal amount;

                public Invoice(String id, int amount) {
                        this.id = Integer.valueOf(id);
                        this.amount = BigDecimal.valueOf(amount);
                }

                public Integer getId() {
                        return id;
                }

                public BigDecimal getAmount() {
                        return amount;
                }
        }



}
