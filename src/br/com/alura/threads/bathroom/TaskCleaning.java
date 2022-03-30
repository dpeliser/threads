package br.com.alura.threads.bathroom;

public class TaskCleaning implements Runnable {

    private final Bathroom bathroom;

    public TaskCleaning(final Bathroom bathroom) {
        this.bathroom = bathroom;
    }

    @Override
    public void run() {
        while (true) {
            bathroom.clear();

            try {
                Thread.sleep(15000);
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
