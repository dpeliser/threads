package br.com.alura.threads.mylist;

public class PrintTask implements Runnable {

    private final MyList myList;

    public PrintTask(final MyList myList) {
        this.myList = myList;
    }

    @Override
    public void run() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        synchronized (myList) {

            if (!myList.isFull()) {
                try {
                    System.out.println("Going to sleep, waiting notification...");
                    myList.wait();
                } catch (final InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < myList.size(); i++) {
                System.out.println(i + " - " + myList.getElement(i));
            }
        }
    }

}
