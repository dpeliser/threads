package br.com.alura.threads.database;

public class ConnectionPool {

    public String getConnection() {
        System.out.println("Borrowing connection");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "connection";
    }

}