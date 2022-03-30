package br.com.alura.threads.database;

public class TransactionManager {

    public void begin() {
        System.out.println("Starting transaction");

        try {
            Thread.sleep(5000);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }

}