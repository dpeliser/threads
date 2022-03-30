package br.com.alura.threads.mylist;

public class AddElementTask implements Runnable {

    private final MyList list;
    private final int threadNumber;

    public AddElementTask(final MyList list, final int threadNumber) {
        this.list = list;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            list.addElement("Thread " + threadNumber + " - " + i);
        }
    }

}
