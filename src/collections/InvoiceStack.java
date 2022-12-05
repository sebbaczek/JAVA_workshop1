package collections;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Deque;

public class InvoiceStack {
        private int counter =1;
        private Deque<Invoice> stack = new ArrayDeque<>();

        public void processInput(String command){
                if(command.contains("CEO: ADD INVOICE")){
                        processCEO(command);
                } else if ("ACCOUNTANT: PROCESS INVOICE".equals(command)) {
                        processAccountant(command);
                }else {
                        System.out.println("O co ci chodziło?");
                }
        }

        private void processCEO(String command) {
                BigDecimal amount =  new BigDecimal(command.substring(command.indexOf("(")+1,command.indexOf(
                        ")")));
                int year = LocalDate.now().getYear();
                String id = counter + "/"+year;
                counter++;

            Invoice invoice = new Invoice(id,amount);
                stack.push(invoice);

                System.out.printf("CEO: ADDed INVOICE:%s, amount: %s%n",id,amount );
                System.out.printf("current stack amount:%s, stack: %s%n",getInvoicesSum(),stack );
        }

        private String getInvoicesSum() {
                BigDecimal sum = BigDecimal.ZERO;
                for (Invoice invoice : stack) {
                        sum = sum.add(invoice.getAmount());
                }
                return sum.toString();
        }


        private void processAccountant(String command) {

                if(stack.isEmpty()){
                        System.out.println("no work");
                        return;
                }
                Invoice invoice = stack.pop();
                System.out.printf("Accountant: processed INVOICE:%s",invoice );
                System.out.printf("current stack amount:%s, stack: %s%n",getInvoicesSum(),stack );
        }

}