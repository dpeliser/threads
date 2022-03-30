package br.com.alura.threads.database;

public class BankAccessTask implements Runnable {

    private final ConnectionPool pool;
    private final TransactionManager tx;

    public BankAccessTask(final ConnectionPool pool, final TransactionManager tx) {
        this.pool = pool;
        this.tx = tx;
    }

    @Override
    public void run() {
        synchronized (pool) {
            System.out.println("Getting the connection");
            pool.getConnection();

            synchronized (tx) {
                System.out.println("Starting a tx");
                tx.begin();
            }
        }
    }

}
