package br.com.alura.threads.database;

public class DatabaseMain {

    public static void main(String[] args) {
        final TransactionManager tx = new TransactionManager();
        final ConnectionPool pool = new ConnectionPool();

        new Thread(new BankAccessTask(pool, tx)).start();
        new Thread(new BankProcedureAccessTask(pool, tx)).start();
    }

}